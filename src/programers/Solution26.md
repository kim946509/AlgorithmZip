[//]: # (문제 풀이 템플릿)
# Problem 💻
[문자열 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12917)

# 문제
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

## 제한사항
- str은 길이 1 이상인 문자열입니다.
## 입출력 예
입출력 예
s = "Zbcdefg"


return = "gfedcbZ"

---

# Approach 1 ⭕
- 문자열을 charArray로 변환한다.
- sorted (c1,c2)->c2,c1; 으로 내림차순 정렬한다.
## 헷갈렸던 점
정렬을 빼먹음...
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