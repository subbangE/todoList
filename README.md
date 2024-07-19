# 투두 리스트 제작
+ 개발 기간 : 2024.07.16 ~ 2024.07.17(총 2일)
+ 개발 인원 : 1명

## 개발 환경 및 적용 기술
- Spring Boot
- JPA
- mariaDB
- 사용 언어 : JAVA

## 구현 기능
+ 투두 리스트 CRUD

## 제작후 개선 필요한 점
+ @Autowired로 의존성을 주입하는 대신 @RequiredArgsConstructor을 이용하여 사용해야함
+ @RequiredArgsConstructor은 초기화 되지않은 final 필드 및 @NonNull 이 붙은 필드에 대해 생성자를 생성해줌
+ 불변성 보장을 해주고 코드도 간결해짐
