package programers;

import java.util.Arrays;

public class Solution30x2 {
    private static class Person {
        String language;
        String job;
        String career;
        String food;
        int score;

        public Person(String language, String job, String career, String food, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("language : " + this.language + "\n");
            stringBuilder.append("job : " + this.job + "\n");
            stringBuilder.append("career : " + this.career + "\n");
            stringBuilder.append("food : " + this.food + "\n");
            stringBuilder.append("score : " + this.score + "\n");
            return stringBuilder.toString();
        }
    }
//    Solution1
    public int[] solution(String[] info, String[] query) {
        int answer[] = new int[query.length];
        int numberOfPeople = info.length;
        Person[] people = new Person[numberOfPeople];
        for (int i = 0; i < info.length; i++) {
            // 1. info 배열을 순회하며 String을 분리한다.
            String[] split = info[i].split(" ");
            // 2. 각 분리한 문자열을 Person 객체로 만들어 저장한다.
            Person person = new Person(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
            people[i] = person;
        }
        // 3. query 배열을 순회하며 4가지 조건으로 분리한다.
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll("and ", "");
            String[] split = query[i].split(" ");
            // 4. Comparator를 만들어 Person을 조건에 맞게 정렬한다.(언어, 직군, 경력, 소울푸드순으로 정렬)
            Arrays.sort(people, (o1, o2) -> {
                if (o1.language.equals(o2.language)) {
                    if (o1.job.equals(o2.job)) {
                        if (o1.career.equals(o2.career)) {
                            if (o1.food.equals(o2.food)) {
                                return o1.score - o2.score;
                            }
                            return o1.food.equals(split[3]) ? -1 : 1;
                        }
                        return o1.career.equals(split[2]) ? -1 : 1;
                    }
                    return o1.job.equals(split[1]) ? -1 : 1;
                }
                return o1.language.equals(split[0]) ? -1 : 1;
            });
            // 5. 이진탐색을 통해 조건에 맞는 사람을 찾는다.(쿼리에서 점수를 만족하면 나머지는 다 만족한다.)
            int left = 0;
            int right = numberOfPeople;
            int index = 0;
            while (left < right) {
                int mid = (left + right) / 2;
                if (people[mid].score < Integer.parseInt(split[4])) {
                    left = mid + 1;
                } else if (people[mid].score >= Integer.parseInt(split[4])) {
                    index = mid;
                    right = mid;
                }
            }
            // 6. 이진탐색을 통해 찾은 인덱스부터 끝까지의 사람 수를 센다.
            int count = numberOfPeople - index;
            System.out.println("count = " + count);
            answer[i] = count;
        }

        return null;
    }
}