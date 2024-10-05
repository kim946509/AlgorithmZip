[//]: # (문제 풀이 템플릿)
# Problem 💻
[문자열 내 마음대로 정렬하기](https://school.programmers.co.kr/learn/courses/30/lessons/12915)

# 문제
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
## 제한사항
- strings는 길이 1 이상, 50이하인 배열입니다.
- strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
- strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
- 모든 strings의 원소의 길이는 n보다 큽니다.
- 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
## 입출력 예
strings	n	return
["sun", "bed", "car"]	1	["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
---

# Approach 1 ⭕
- Comparator<String> 생성하여 내가 원하는 비교 익명 클래스를 생성한다
  - 인자로는 String s1, Strings2, n을 전달한다.
  - 각 문자열에서 n 인덱스의 문자를 기준으로 비교한다. s1.get(n)-s2.get(n) 
- Arrays.sort 함수를 호출할 때 생성한 익명클래스 Comporator를 전달한다.
## 헷갈렸던 점
```java
Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2, int n) { // 오류 발생
                return 0;
            }
        };
```
Override한 함수이기 때문제 추가적인 인자 int n을 사용할 수 없음. 오류 발생
```java
 public String[] solution(String[] strings, int n) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)!=o2.charAt(n))
                    return o1.charAt(n)-o2.charAt(n);
                else
                    return o1.compareTo(o2);
            }
        };

        Arrays.sort(strings, comp);
        for (int i = 0; i < strings.length; i++) {
            System.out.println("strings[i] = " + strings[i]);
        }
        return strings;
    }
```
근데 생각해보면 어차피 solution함수에 인자 n을 익명 클래스에서 그대로 사용할 수 았음.
### case 1.


---

[//]: # ()
[//]: # (# Approach 2 ⭕)

[//]: # ()
[//]: # (### 결론)

# 이것만은 기억하자💡
문자열에서 chars() 메서드를 호출하면 IntStream이 반한됨. \
char도 정수형이기 때문에 IntStream으로 통합해서 다룰 수 있음.
IntStream으로 변환해주고, boxed()로 Stream<Integer>로 변환.
# Reference 📄
https://st-lab.tistory.com/243 : Comparable과 Comparator 차이