# Regular Expression (정규식)
  - 정규식 몇가지
  - 예시

---

## 정규식
  ### 1. 정규식이란
  - 특정한 규칙을 가진 문자열의 집합을 표현하는데 사용하는 형식 언어

  ### 2. 사용되는 표

  표현식 | 설명
  :----: | :----
  ^ | 문자열의 시작 ([] 안에 있을경우 not을 뜻함)
  & | 문자열의 종료
  . | 임의의 한 문자 (문자의 종류 가리지 않음) 단, \\ 는 넣을 수 없음
  \* | 앞 문자가 없을 수도 무한정 많을 수도 있음
  \+ | 앞 문자가 하나 이상
  ? | 앞 문자가 없거나 하나있음
  [] | 문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타낸다.
  {} | 횟수 또는 범위를 나타낸다.
  () | 소괄호 안의 문자를 하나의 문자로 인식
  \| | 패턴 안에서 or 연산을 수행할 때 사용
  \\s | 공백 문자
  \\S | 공백 문자가 아닌 나머지 문자
  \\w | 알파벳이나 숫자
  \\W | 알파벳이나 숫자를 제외한 문자
  \\\\w+| 영문자 전체
  \\d | 숫자 [0-9]와 동일
  \\D | 숫자를 제외한 모든 문자
  \\ | 확장 문자 , 역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미
  (?!) | 앞 부분에 (?i) 라는 옵션을 넣어주면 대소문자를 구분하지 않음

  ### 3. 몇가지 예시
  - [\_A-Za-z0-9-]
  ```
  " _, A~Z, a~z, 0~9, - " 를 허용
  ```

  - \\\\w+ → 영문자 전체를 의미
  ```
  abdace, ADSFdsf, djknME 등 가능
  ```

  - a?c → a가 삭제될 수 있음    
  ```
  abc, bc, cc 가능
  ```

  - ab. → .에 임의의 문자가 들어감
  ```
  abc, abd, abe 등 가능
  ```

  - [\_A-Za-z0-9-]  [.\_A-Za-z0-9-] \*@ → * 앞의 문자가 있거나 없음
  ```
  michael.go @ samaung.com
  michael@samaung.com 과 같이 “.go” 가 나올수도 있고 아닐수도 있음
  ```

  - ^[A-Za-z0-9]{8,} $ → 8글자 이상만 허용
  ```
  abcdef123 가능, 123abc 불가능
  ```

  ### 4. 사용 예
  - 이메일 형식 체크
  ```
  ^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$ 혹은

  ^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z0-9]{2,})$
  ```

  - 이미지 파일을 찾아내는 패턴
  ```
  ([^\s]+(\.(?!)(jpg|png|gif|bmp))&)
  ```

---

## 참고 자료
  ### 1. [UroA개발 블로그_정규표현식이란](http://uroa.tistory.com/56)
  ### 2. [nextree](http://www.nextree.co.kr/p4327/)
  ### 3. [[TIP] 정규표현식(Pattern Matching) 완전 정리!](http://highcode.tistory.com/6)