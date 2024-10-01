[//]: # (문제 풀이 템플릿)
# Problem 💻
[K번째수](https://school.programmers.co.kr/learn/courses/30/lessons/42748)

## 문제
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

## 제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

## 입출력 예
array \
[1, 5, 2, 6, 3, 7, 4]	

commands \
[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	

return \
[5, 6, 3]
---

# Approach 1 ❌
- commands[]의 크기 만큼 반복문을 돌며 접근한다.
- commands[i][0]-commands[i][1] 까지의 배열을 자른다.
- 자른 배열에서 commands[i][2]번째-1번째 값을 가져온다.
- 가져온 값을 List에 추가한다.
## 헷갈렸던 점
정렬을 빼먹음...
### case 1.


---

# Approach 2 ⭕
- commands[]의 크기 만큼 반복문을 돌며 접근한다.
- commands[i][0]-commands[i][1] 까지의 배열을 자른다.
- 자른 배열을 정렬한다.
- 정렬된 배열에서 commands[i][2]번째-1번째 값을 가져온다.
- 가져온 값을 answer에 추가한다.

### 결론

# 이것만은 기억하자💡
Arrays.copyOfRange(array, start, end) 를 활용하면 start부터 end까지의 array값을 복사한 array를 얻을 수 있다.

# Reference 📄
https://bgm16.tistory.com/189