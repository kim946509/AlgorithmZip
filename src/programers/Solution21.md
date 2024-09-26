[//]: # (문제 풀이 템플릿)
# Problem 💻
[소수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/42839)

## 문제
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
## 제한사항
- numbers는 길이 1 이상 7 이하인 문자열입니다.
- numbers는 0~9까지 숫자만으로 이루어져 있습니다.
- "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
---

# Approach 1 ❌
- 모든 경우의 숫자 조합을 재귀함수를 통해 구한다.
- 해당 숫자가 소수인지 확인한다.
- 소수라면 answer를 증가시킨다.

## 헷갈렸던 점
재귀함수를 구현하는것은 항상 헷갈린다. 특히나 재귀함수의 응답 type을 어떻게 설정해야할지 항상 고민이 된다.

ConcurrentModificationException 발생
```java
List<String> remainNumbers = numbers; //깊은 복사가 이루어짐. 이후 반복문을 통해 remainNumbers를 수정하여 ConcurrentModificationException 발생
```
```java
List<String> remainNumbers = new ArrayList<>(numbers); //깊은 복사로 수정하여 문제 해결
````

List<List<String>> 모든 조합을 저장한느 리스트에 리스트가 모두 비어있음
```java
// 모든 경우의 숫자 조합을 재귀함수를 통해 구한다.
private void pickedNumber(List<String> numbers, List<String> pickedNumber, List<List<String>> pickedNumbers){
    List<String> remainNumbers = new ArrayList<>(numbers);
    if(numbers.isEmpty()){
        return;
    }
    for (String number : numbers) {
        pickedNumber.add(number);
        remainNumbers.remove(number);
        pickedNumber.add(pickedNumber); // 값을 저장하는 것이 아닌 주소값을 저장하고 있어서 모든 경우의 수가 비어있음. 
        pickedNumber(remainNumbers, pickedNumber, pickedNumbers);
        pickedNumber.remove(number);
        remainNumbers.add(number);
    }
}
```

### case 1.


---

# Approach 2 ⭕


### 결론

# 이것만은 기억하자💡
없음

# Reference 📄