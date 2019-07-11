## 1장 깨끗한 코드

* 제대로 명시한 요구사항
* 코드는 요구사항을 표현하는 언어
    * 요구사항에 적합한 언어를 만들기도
    * 요구사항에서 정형 구조를 뽑아내는 도구를 만들기도
* 하지만 결국 어느 순간에는 정밀한 표현이 필요하다
    * 읽기 좋은 코드의 필요성은 사라지지 않는다
* **빨리 가는 유일한 방법은 코드를 최대한 깨끗하게 유지하는 `습관`**
* 깨끗한 코드란 세세한 사항까지 꼼꼼하게 처리하는 코드
    * **의존성을 최대한 줄여라**
    * **오류는 명백한 전략에 의거해 처리**
    * **성능 최적화 고려**
* **명쾌한 추상화**
    * `문제의 긴장`은 명확히 드러내며
    * 동시에 `명쾌한 해법`을 제시
* **테스트 케이스의 뒷받침**
* **객체, 메서드가 한 가지 기능만 하도록**
* **중복을 없애라**
* **표현력을 높여라**
    * 집합 데이터에서 항목 찾는 케이스의 경우, 추상 메서드나 추상 클래스를 만들어 실제 구현을 감싸본다 (작게 추상화하라)
* **읽으면서 짐작한 대로 기능하는, 예측 가능한 코드**

## 2장 의미 있는 이름

* **의도를 분명히 밝혀라**
    * 변수의 존재이유
    * 수행하는 기능
    * 사용하는 방법
* **그릇된, 부정확한 정보의 제공을 피하라**
    * 널리 쓰이는 의미를 다른 특정 의미로 사용하지 마라
* **의미없는 구분을 덧대지마라**
    * ProductInfo, ProductData 등에서 Info, Data는 a, an, the와 같이 불용어(큰 역할을 하지 않는)
    * 불용어는 곧 중복이라고 봐도 무방
* **검색하기 쉬운, 발음하기 쉬운 이름을 사용하라**
* **불필요 접두어 제거**
    * 헝가리식 표기법
    * 멤버변수 구분
* **한 개념에는 한 단어 사용**
* **기술영역에서 차용하고, 차선으로 도메인영역에서 차용한다**

--- 

* 맥락이 불분명한 케이스
``` java
// Bad
private void printGuessStatistics(char candidate, int count) {
    String number;
    String verb;
    String pluralModifier;
    if (count == 0) {  
        number = "no";  
        verb = "are";  
        pluralModifier = "s";  
    }  else if (count == 1) {
        number = "1";  
        verb = "is";  
        pluralModifier = "";  
    }  else {
        number = Integer.toString(count);  
        verb = "are";  
        pluralModifier = "s";  
    }
    String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier );

    print(guessMessage);
}
```

* 맥락이 분명한 케이스
``` java
public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier );
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoLetters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }
}
```


## Q.
1. 31p, 인터페이스 클래스와 구현 클래스, 클래스 이름의 인코딩
2. 32p, 적절한 클래스 이름에서 Customer는 적절하고, Manager는 부적절한 이유
    * [Naming Java Classes Without a 'Manager'](http://www.bright-green.com/blog/2003_02_25/naming_java_classes_without_a.html)
        * 흔히들 뒤에 Manager를 붙여서 사용하곤 한다
        * 사전에서 manager, manage를 찾아보면 적어도 10개 이상의 각기 다른 뜻을 볼 수 있다
        * 모호하며 막연한 의미를 지니는 단어로 클래스 네이밍에 적합하지 않다
        * Manager, Object, The, A, An 의 사용은 지양하라
            * 대체어
            * Herder, Shepherd, Wrangler : Policy domain 을 가진다고 했을 때, find, store, delete policies across various data sources
            * Bucket, Pool : is a place to stick stuff when you don't need to hold it.
            * Supervisor : implies allocating work or checking its progress.