[//]: # (문제 풀이 템플릿)
# Problem 💻
[두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644)

# 문제
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
## 제한사항
- numbers의 길이는 2 이상 100 이하입니다.
- numbers의 모든 수는 0 이상 100 이하입니다.

## 입출력 예
numbers	result\
[2,1,3,4,1]	[2,3,4,5,6,7]\
ㄴ[5,0,2,7]	[2,5,7,9,12]

---

# Approach 1 ⭕
- numbers에 중첩 반복문을 통해 합해서 나올 수 있는 모든 숫자를 구한다.
- 합한 숫자를 set에 저장한다.
- 저장된 set을 배열로 변환한다.
- 배열을 오름차순 정렬한다.
- return 한다.
## 헷갈렸던 점
정렬을 빼먹음...
### case 1.


---

[//]: # ()
[//]: # (# Approach 2 ⭕)

[//]: # ()
[//]: # (### 결론)

# 이것만은 기억하자💡
set을 array로 변환하는 방법 \
.stream().mapToInt(Integer::intValue).toArray();
# Reference 📄