<h1>TidyHome 🧼</h1>

<h4>이 프로젝트는 FLUTTER MVVM과 SPRING MVC 패턴으로 APP을 구현하였습니다.</h4>
<br>

<div align="center"> 
  <img src="https://github.com/sji8562/Tidyhome-back/assets/94952331/85f395f4-e806-4215-8ee2-4efdd2adc0d1" width=300>
  <p><strong></strong></p>  
</div>
<br>




## 목차
1. [팀 소개](#팀-소개)
2. [프로젝트 소개](#프로젝트-소개)
3. [STACKS](#STACKS)
4. [API 명세서](#API-명세서)
5. [ERD](#ERD)
6. [Directory Tree](#Directory-Tree)
<br>

## 팀 소개
- **개발 기간** 🗓  :  2024-01-03 ~ 2024-01-19(총 17일)
<div>
  <img src="https://github.com/sji8562/Tidyhome-back/assets/94952331/dbe69b19-f2b0-41dd-b583-d3712cec9c41" width=800>
</div>
<br>

- **멤버** 🙋‍♀️
<div>
<details>
  <summary>송재익(<a href="https://github.com/sji8562">@sji8562</a>) [팀장]</summary>
    <ul>
        <li>노션 일정 관리 적용 및 역할 분배</li>
        <li>[관리자] 로그인/로그아웃 및 로그인 interceptor 처리</li>
        <li>[관리자] 결제 관리 페이지 HTML, CSS 작업, 데이터 바인딩, 페이징 기능 구현</li>
        <li>[관리자] 물품 관리 페이지 HTML, CRUD 기능, 검색 및 페이징 기능 구현</li>
        <li>[관리자] 1, 2차 카테고리 관리 HTML, CRD 기능 구현</li>
        <li>[관리자] 후기 관리 HTML, 조회 및 삭제, 검색 및 페이징 기능 구현</li>
        <li>[관리자] 1:1 문의 HTML, RUD 기능, 조회 및 삭제, 검색 및 페이징 기능 구현</li>
        <li>[관리자] FAQ HTML, CRUD 기능, 검색 및 페이징 기능 구현</li>
        <li>[관리자] 이용 수칙, 소독 과정, 회사 소개 CUD 기능 구현</li>
        <li>[사용자] 이용 수칙 페이지, 소독 과정 페이지, 회사 소개 페이지 HTML 및 데이터 바인딩</li>
        <li>[사용자] 메인 페이지</li>
        <li>[사용자] 오시는 길 페이지 일부</li>
        <li>[사용자] footer 작업</li>
        <li>[관리자/사용자단] 페이지 텍스트 에디터(summernote) 적용</li>
        <li>사이트맵, 기능명세서 작성, 간트 차트, 관리자 페이지 프로토타입, 시연영상 제작</li>
        <li>전체 QA</li>
    </ul>
</details>
<details>
  <summary>권보미(<a href="https://github.com/aSpring712">@aSpring712</a>) [팀원]</summary>
  <ul>
    <strong>FE(Flutter UI) 및 통신 담당</strong>
    <li> 캘린더, 서비스 약관 페이지, 햄버거 메뉴, 주소 관리 페이지 일부, 예약 완료 페이지, 예약하기 페이지, 기타 요청사항 및 출입 방법 입력 페이지, 주의사항 페이지, 서비스 상세정보 페이지 UI 담당</li>
    <li>완료된 서비스 내역, 예약 내역 및 상세, 완료된 서비스 페이지, 회원 탈퇴 페이지 UI 및 통신 담당</li>
    <li>공지사항 리스트 및 상세 페이지, 자주 묻는 질문 페이지 UI 및 통신 담당</li>
    <li>노션 일정 관리 및 간트 차트 담당</li>
    <li>PPT 제작, 영상 편집</li>    
  </ul>
</details>
<details>
  <summary>김하율(<a href="https://github.com/m40ro">@m40ro</a>) [팀원]</summary>
  <ul>
    <li>[관리자] 상품 질문 페이지 HTML 및 CRUD 기능, 검색 및 페이징 기능 구현</li>
    <li>사용자단 사이트 맵 작성</li>
    <li>PPT 작성 및 발표</li>
  </ul>
</details>
<details>
  <summary>오다정(<a href="https://github.com/DJ0H)">@DJ0H</a>) [팀원]</summary>
  <ul>
    <li>회사 소개 프로토타입, 플로우 차트 작성</li>
    <li>[사용자] 판매 상품 상세페이지 화면 및 기능 구현</li>
    <li>[사용자] 대여 상품 상세페이지 화면 및 기능 구현</li>
    <li>[사용자] 장바구니 화면 및 기능 구현</li>
    <li>[사용자] 위시리스트 화면 및 기능 구현</li>
    <li>[사용자] 결제 화면 및 기능 구현 (카카오페이 api, daum 주소 api, coolsms 문자 전송 api 활용)</li>
    <li>[사용자] 주문 내역 화면 및 기능 구현</li>
    <li>[사용자] 주문 상세 보기 화면 및 기능 구현</li>
    <li>[사용자] 취소(환불) 내역 화면 및 기능 구현</li>
    <li>[사용자] 대여 내역 화면 및 기능 구현</li>
    <li>[사용자] 로그인 화면 구현</li>
    <li>[사용자] review 화면 및 기능 구현</li>
    <li>git README 작성</li>
    <li>API 명세서 작성</li>
  </ul>
</details>
<details>
  <summary>정유수(<a href="https://github.com/wjs1kk">@wjs1kk</a>) [팀원]</summary>
  <ul>
    <li>[사용자] 로그인, 회원가입 기능 구현</li>
    <li>[사용자] 아이디찾기, 비밀번호 찾기 구현, 이메일인증 api, 문자인증 api 활용</li>
    <li>[사용자] 공지사항 HTML 및  CRUD, 페이징 구현</li>
    <li>[사용자] 1:1문의 HTML 및  CRU, 페이징 구현</li>
    <li>[사용자] FAQ HTML 및  CRU, 페이징 구현</li>
    <li>[사용자] 상품문의 HTML 및  CRU, 페이징 구현</li>
    <li>[사용자] 상품 검색 기능 구현</li>
    <li>[사용자] 검색페이지 무한 스크롤 구현</li>
    <li>[사용자] 오시는 길 페이지 일부, 카카오 map api 활용</li>
    <li>[사용자] 마이페이지 일부 HTML</li>
    <li>[사용자] 오시는 길 페이지 일부</li>
    <li>[사용자] 헤더 HTML, CSS</li>
  </ul>
</details>  
</div>


<br>


## 프로젝트 소개
- **이름** : TidyHome
- **목적** : 국내 No.1 라이프스타일 서비스 O2O 플랫폼인 <img src="https://github.com/sji8562/Tidyhome-back/assets/94952331/fa3c2606-bdd8-499e-b6bb-cef2668d13dc" width=80> 를 클론 코딩 하였습니다.


- **수익모델** :
- **주요 기능** ✏

  `* 사용자 *`
  + 전화번호 인증으로 로그인, 회원가입
  + 홈 클리닝 서비스 예약하기
  + 주소 관리(+ 대표 주소 설정)
  + 예약 내역(+ 요청사항 입력)
  + 예약 취소
  + 자주 묻는 질문 / 서비스 상세정보 / 서비스 약관
  + 계정 탈퇴
  + 파트너(청소업체) 가입
 
  `* 관리자 *`
  + 대시보드
  + 회원 관리
  + 결제 관리
  + 카테고리 관리
  + 게시판 관리(공지사항, 자주묻는 질문)

- **사이트맵** 🗺

  `* 사용자 *`
<div align="center">
    <img src="https://github.com/sji8562/KinderLend/assets/94952331/f447c9fb-d1c4-47c6-b32b-77245d1ddaa3" width=850>
</div>

  `* 관리자 *`
<div align="center">
    <img src="https://github.com/sji8562/KinderLend/assets/94952331/85dc7cd3-21ff-49a1-92ac-ee20b547630f" width=850>
</div>
    
- **화면 구성** 💻
  
  `* 사용자 *`
  
<div align="center"> 
  
|<img src="https://github.com/sji8562/KenderRent/assets/94952331/46368217-01ad-45a7-ae12-36298a394854/" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/e279dd9d-3593-40d5-b7cd-2b077873607d" width=400>|
|:---:|:---:|
|메인 화면|로그인|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/0c0e99ba-caa6-4d81-9abf-1560c922e9bd" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/f98ecd43-b8e6-471a-a79c-7bbfdaf2391b" width=400>|
|아이디 찾기|비밀번호 찾기|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/ff6d344a-5257-4134-8e5b-183d26e52b08" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/ff311784-b759-431f-92ef-b99ce68bce36" width=400>|
|대여하기|구매하기|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/bfc5da9a-8e49-4819-b00f-1bcf8291549b" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/8cb2910a-b7fc-4215-b686-0bb500870674" width=400>|
|결제 화면|장바구니|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/4d0889db-9e52-4d68-9524-57b306de8f1a" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/e246be60-23ae-4770-b9b8-d6beae166ece" width=400>|
|주문 내역|주문 상세|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/1f8a7141-f190-450e-904b-f65b9619643c" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/5474fc30-9d15-4aa7-a125-9cf0c4571a27" width=400>|
|대여 내역|위시리스트|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/145d3cad-2da6-4ffc-8947-0773f14e5263" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/a9754af3-30b9-4bb4-a554-53476c50708c" width=400>|
|취소(환불) 내역|마이페이지|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/0c5239b4-b94d-43c3-b02b-d088232a86f0" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/fa6e6c26-cafc-4b04-95e4-00ea81ebca49" width=400>|
|공지사항|1:1문의|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/b5b25a0f-b671-4aef-b031-7be14fd4d759" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/ece2f29c-1c76-459c-acd1-9200ed9b0800" width=400>|
|FAQ|상품문의|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/2104a69f-b009-4501-bca8-1942c7a5f9fe" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/447808b8-b103-4acb-b24b-9c424faea612" width=400>|
|회사소개|이용안내|
|<img src="https://github.com/sji8562/KinderLend/assets/94952331/a9e31511-77db-4b91-a8c4-cf8471e2ef8e" width=400>|<img src="https://github.com/sji8562/KinderLend/assets/94952331/b6538ab4-09ad-4ade-a1de-412249034812" width=400>|
|소독과정|오시는길|



</div>
<br>

  `* 관리자 *`

<div align="center"> 
  
|<img src="https://github.com/sji8562/KenderRent/assets/94952331/83914283-2415-425b-bb70-4f2e9b61c27b" width=400> |<img src="https://github.com/sji8562/KenderRent/assets/94952331/b1d8df02-cc90-40a3-acb5-64e15c41b35d" width=400>| 
|:---:|:---:|
|메인 화면(대시보드)|회원 관리|
| <img src="https://github.com/sji8562/KenderRent/assets/94952331/35695195-8d69-4fdc-89ba-e37a1ed4a970" width=400> | <img src="https://github.com/sji8562/KinderLend/assets/94952331/8d896d0e-7b2c-4550-b42d-c9955eda60e4" width=400> |
|물품 관리|결제 관리|
| <img src="https://github.com/sji8562/KinderLend/assets/94952331/bfa97cf4-38c0-4d44-b13b-7c5a423d6b99" width=400> | <img src="https://github.com/sji8562/KinderLend/assets/94952331/ccfc8cf6-c04a-4838-ae6f-6449dfcf7da7" width=400> |
|회사소개 관리|카테고리 관리|
| <img src="https://github.com/sji8562/KinderLend/assets/94952331/4d8d4ff3-af5e-4ead-823d-0e075ae852b7" width=400> | <img src="https://github.com/sji8562/KinderLend/assets/94952331/faebfe50-b004-4455-a6da-fa2d93e9004b" width=400> |
|대여신청 관리|게시판 관리|

</div>
<br>

- **시연 영상** 🎬

<div align="center">
  
[![Video Label](http://img.youtube.com/vi/VUfh422nqlQ/0.jpg)](https://youtu.be/VUfh422nqlQ)

</div>

<br><br>

## API 명세서

API 명세서 : https://plume-hardboard-263.notion.site/ffb45515453d49a7b88858de227da757?v=8ee6e86d303747c8a9b70340db28d83f&pvs=4

<details>
  <summary>장바구니 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/a6b842f0-7622-4f78-b75e-a4fab9757971">
</details>
<details>  
  <summary>고객센터 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/78004d14-84fa-40c6-838f-d040273df1d9">
</details>
<details>
  <summary>회사소개 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/754650d9-cf44-4334-b7b3-7d3de3e6b3b3">
</details>
<details>
  <summary>문자 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/ab3af50d-b8dc-4c37-9dd7-6dba34949467">
</details>
<details>
  <summary>마이페이지 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/61d6ffcd-8fdd-447a-b9a8-708b6815abcc">
</details>
<details>
  <summary>상품 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/3838e984-c99a-4efb-971e-4de1b09dc943">
</details>
<details>
<summary>사용자 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/bafc5fcd-eab8-4893-8dff-e4c6b9f388d8">
</details>
<details>
<summary>신청관리 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/1db3fd56-0e1c-495e-a330-7d96fe69c186">
</details>
<details>
<summary>고객센터관리 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/e43d8eca-4b96-4301-8fd9-b2ce324a63cf">
</details>
<details>
<summary>회사소개관리 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/bd1737de-1ea5-47f3-aa0c-5c5b339c42aa">
</details>
<details>
<summary>관리자 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/ae61ff04-3d5f-41c3-8327-b5680d74d0b9">
</details>
<details>
<summary>결제관리 API</summary>
  <img src="https://github.com/sji8562/KinderLend/assets/94952331/faeb812c-633b-419d-bb47-bb80a9292bb6">
</details>







<br>

## STACKS
<details open>
  <summary><strong>Frontend</strong></summary>
  <ul>
    <li>Flutter 3.2.0</li>
    <li>Dart</li>
  </ul>
</details>

[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1705887704835?alt=media&token=3bf0ad75-6207-4247-bb30-9623455c6874)](https://github.com/msdio/stackticon)
<br>

<details open>
  <summary><strong>Backend</strong></summary>
  <ul>
    <li>SpringBoot: 3.1.6</li>
    <li>Java: 17</li>
    <li>Spring Data JPA</li>
  </ul>
</details>
  
[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1705887847527?alt=media&token=824fe904-ee49-45a2-a0bc-888de01c093c)](https://github.com/msdio/stackticon)
<br>

<details open>
  <summary><strong>DataBase</strong></summary>
  <ul>
    <li>MySQL: 8.0.31</li>    
  </ul>
</details>

[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1704180293126?alt=media&token=99aedd38-0935-4373-b2af-6586650cf88f)](https://github.com/msdio/stackticon)
<br>

<details open>
  <summary><strong>IDE</strong></summary>
  <ul>
    <li>IntelliJ IDEA</li>
    <li>Android Studio</li>
  </ul>
</details>

[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1705887983746?alt=media&token=45d8226b-7991-463c-a79d-139a820928b0)](https://github.com/msdio/stackticon)
<br>

<details>
  <summary><strong>Collaboration</strong></summary>
  <ul>
    <li>Notion</li>
    <li>Discord</li>
    <li>GitHub</li>
  </ul>
</details>

[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1705888116246?alt=media&token=12b8ec61-b542-41b8-88e8-2a15f5bc9806)](https://github.com/msdio/stackticon)
<br>


<details open>
  <summary><strong>외부 API</strong></summary>
  <ul>
     <li>카카오페이 API</li>   
    <li>DAUM 주소 API</li>
    <li>coolSMS API (문자 전송)</li>    
  </ul>
</details>

<br>

<details open>
  <summary><strong>Dependencies</strong></summary>
  <br>
  
```java
implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3'
compileOnly 'org.projectlombok:lombok'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
runtimeOnly 'com.h2database:h2'
runtimeOnly 'com.mysql:mysql-connector-j'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3'
implementation group: 'org.glassfish.web', name: 'jakarta.servlet.jsp.jstl', version: '2.0.0'
implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
implementation 'org.springframework.boot:spring-boot-starter-aop'
implementation 'org.springframework.boot:spring-boot-starter-security:3.1.6'
implementation 'org.springframework.boot:spring-boot-starter-oauth2-client:3.1.6'
implementation 'org.springframework.security:spring-security-taglibs:5.7.2'
implementation group: 'com.auth0', name: 'java-jwt', version: '4.4.0'
implementation 'net.nurigo:sdk:4.3.0'
implementation 'org.springframework.cloud:spring-cloud-starter-aws:2.2.1.RELEASE'
implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'
implementation 'org.springframework.boot:spring-boot-starter-mail'
implementation group: 'net.nurigo', name: 'sdk', version: '4.3.0'
```
</details>

<br>

## ERD

<div align="center">
    <img src="https://github.com/sji8562/Tidyhome-back/assets/94952331/7e59400e-6c0e-4119-9cfd-312bd7a2a79d">
</div>
<br>

## Directory Tree

```
📦Tidyhome-back
├─📁main
│  ├─📁java
│  │  └─📁com
│  │      └─📁tenco
│  │          └─📁projectinit
│  │              ├─📁controller
│  │              │  ├─📁api               // API와 관련된 컨트롤러 클래스
│  │              │  └─📁mng               // 관리자 페이지와 관련된 컨트롤러 클래스 
│  │              ├─📁dto                  // Data Transfer Object (DTO) 클래스
│  │              ├─📁repository
│  │              │  ├─📁entity            // 엔티티 클래스
│  │              │  └─📁inteface          // 리포지토리 인터페이스
│  │              ├─📁service              // 비즈니스 로직을 처리하는 서비스 클래스
│  │              └─📁_core
│  │                  ├─📁advice           // 어드바이스 클래스
│  │                  ├─📁config           // 설정과 관련된 클래스
│  │                  ├─📁errors           
│  │                  │  └─📁exception     // 에러 처리와 관련된 예외 클래스 
│  │                  ├─📁filter           // 요청 및 응답을 처리하는 필터 클래스
│  │                  └─📁utils            // 유틸리티 클래스
│  ├─📁resources
│  │  ├─📁db                               // 데이터베이스 설정 파일
│  │  ├─📁mapper
│  │  └─📁static                           // 정적 자원들 위치
│  │      ├─📁assets
│  │      │  ├─📁extra-libs
│  │      │  │  └─📁sparkline
│  │      │  ├─📁images
│  │      │  │  └─📁users
│  │      │  └─📁libs
│  │      │      ├─📁bootstrap             // Bootstrap 라이브러리와 관련된 파일들
│  │      │      │  └─📁dist
│  │      │      │      ├─📁css
│  │      │      │      └─📁js
│  │      │      ├─📁chartist
│  │      │      │  └─📁dist
│  │      │      ├─📁chartist-plugin-tooltips
│  │      │      │  └─📁dist
│  │      │      ├─📁jquery
│  │      │      │  └─📁dist
│  │      │      ├─📁moment
│  │      │      │  ├─📁locale
│  │      │      │  └─📁min
│  │      │      └─📁popper.js
│  │      │          └─📁dist
│  │      │              ├─📁esm
│  │      │              └─📁umd
│  │      ├─📁css                           // 스타일시트 파일들
│  │      │  ├─📁icons
│  │      │  │  ├─📁material-design-iconic-font
│  │      │  │  │  ├─📁css
│  │      │  │  │  └─📁fonts
│  │      │  │  ├─📁themify-icons
│  │      │  │  │  ├─📁fonts
│  │      │  │  │  └─📁ie7
│  │      │  │  └─📁weather-icons
│  │      │  │      ├─📁css
│  │      │  │      ├─📁fonts
│  │      │  │      ├─📁less
│  │      │  │      │  ├─📁css
│  │      │  │      │  ├─📁icon-classes
│  │      │  │      │  ├─📁icon-variables
│  │      │  │      │  └─📁mappings
│  │      │  │      └─📁sass
│  │      │  │          ├─📁icon-classes
│  │      │  │          ├─📁icon-variables
│  │      │  │          └─📁mappings
│  │      │  └─📁styles
│  │      │      └─📁bootstrap4
│  │      ├─📁dist
│  │      │  ├─📁css
│  │      │  │  └─📁icons
│  │      │  │      ├─📁material-design-iconic-font
│  │      │  │      │  ├─📁css
│  │      │  │      │  └─📁fonts
│  │      │  │      ├─📁themify-icons
│  │      │  │      │  ├─📁fonts
│  │      │  │      │  └─📁ie7
│  │      │  │      └─📁weather-icons
│  │      │  │          ├─📁css
│  │      │  │          ├─📁fonts
│  │      │  │          ├─📁less
│  │      │  │          │  ├─📁css
│  │      │  │          │  ├─📁icon-classes
│  │      │  │          │  ├─📁icon-variables
│  │      │  │          │  └─📁mappings
│  │      │  │          └─📁sass
│  │      │  │              ├─📁icon-classes
│  │      │  │              ├─📁icon-variables
│  │      │  │              └─📁mappings
│  │      │  └─📁js                         // JavaScript 파일들
│  │      │      └─📁pages
│  │      │          └─📁dashboards
│  │      ├─📁images
│  │      ├─📁js
│  │      ├─📁plugins
│  │      │  ├─📁easing
│  │      │  ├─📁font-awesome-4.7.0
│  │      │  │  ├─📁css
│  │      │  │  ├─📁fonts
│  │      │  │  ├─📁less
│  │      │  │  └─📁scss
│  │      │  ├─📁Isotope
│  │      │  ├─📁jquery-ui-1.12.1.custom
│  │      │  ├─📁OwlCarousel2-2.2.1
│  │      │  └─📁themify-icons
│  │      │      └─📁fonts
│  │      └─📁scss
│  │          ├─📁bootstrap
│  │          │  ├─📁forms
│  │          │  ├─📁helpers
│  │          │  ├─📁mixins
│  │          │  ├─📁utilities
│  │          │  └─📁vendor
│  │          ├─📁core
│  │          │  ├─📁animation
│  │          │  ├─📁breadcrumb
│  │          │  ├─📁buttons
│  │          │  ├─📁extra
│  │          │  ├─📁layout
│  │          │  ├─📁loader
│  │          │  ├─📁scafholdings
│  │          │  ├─📁sidebar
│  │          │  ├─📁tables
│  │          │  ├─📁topbar
│  │          │  └─📁wave-effects
│  │          ├─📁mixins
│  │          ├─📁pages
│  │          │  └─📁dashboards
│  │          ├─📁theme-colors
│  │          └─📁widgets
│  └─📁webapp                               // JSP 파일들
│      └─📁WEB-INF
│          └─📁view
│              └─📁mng
│                  ├─📁board
│                  │  ├─📁faq
│                  │  ├─📁notice
│                  │  ├─📁productqna
│                  │  └─📁qna
│                  ├─📁content
│                  ├─📁layout
│                  ├─📁pay
│                  ├─📁product
│                  └─📁user
└─📁test
    └─📁java
        └─📁com
            └─📁tenco
                └─📁projectinit
```
```
📦Tidyhome-back\lib
├─📁data
│  ├─📁dto                                  // 데이터 교환을 위한 클래스들
│  │  ├─📁request_dto                       // 클라이언트에서 서버로 요청할 때 사용하는 DTO 클래스들
│  │  │  ├─📁address
│  │  │  ├─📁payment
│  │  │  ├─📁reservation
│  │  │  └─📁user
│  │  └─📁response_dto                      // 서버에서 클라이언트로 응답할 때 사용하는 DTO 클래스들
│  │      └─📁reservation_result
│  ├─📁mock
│  ├─📁model
│  ├─📁repository
│  └─📁store                                // 세션 유저 정보 가지고 있는 클래스
├─📁ui                                      // 어플리케이션의 각 페이지에 대한 구성요소들
│  ├─📁pages
│  │  ├─📁company_update_info_page
│  │  │  ├─📁company_code_table
│  │  │  └─📁widget
│  │  ├─📁customer_page
│  │  │  ├─📁account_closure_page
│  │  │  │  └─📁widget
│  │  │  ├─📁customer_main_page
│  │  │  │  └─📁widget
│  │  │  ├─📁faq_page
│  │  │  │  └─📁widget
│  │  │  ├─📁live_chat_page
│  │  │  │  └─📁widget
│  │  │  ├─📁notice_detail_page
│  │  │  │  └─📁widget
│  │  │  ├─📁notice_page
│  │  │  │  └─📁widget
│  │  │  ├─📁privacy_policy_page
│  │  │  │  └─📁widget
│  │  │  ├─📁sharing_personal_Information_page
│  │  │  │  └─📁widget
│  │  │  ├─📁term_and_conditions_page
│  │  │  │  └─📁widget
│  │  │  ├─📁term_of_service_page
│  │  │  │  └─📁widget
│  │  │  └─📁widget
│  │  ├─📁home_page
│  │  │  └─📁widget
│  │  ├─📁join_page
│  │  │  └─📁widget
│  │  ├─📁main_page
│  │  │  ├─📁home
│  │  │  └─📁widget
│  │  ├─📁pay_ment_page
│  │  │  └─📁widget
│  │  ├─📁reservation_page
│  │  │  ├─📁caution_page
│  │  │  │  └─📁widget
│  │  │  ├─📁choice_address_page
│  │  │  │  └─📁widget
│  │  │  ├─📁completed_service_list_page
│  │  │  │  └─📁widget
│  │  │  ├─📁enter_access_methods_page
│  │  │  │  └─📁widget
│  │  │  ├─📁enter_other_requests_page
│  │  │  │  └─📁widget
│  │  │  ├─📁find_address_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_apply_page
│  │  │  │  ├─📁home_work_apply_page
│  │  │  │  │  └─📁widget
│  │  │  │  ├─📁moving_cleaning_apply_page
│  │  │  │  │  └─📁widget
│  │  │  │  └─📁office_cleaning_apply_page
│  │  │  │      └─📁widget
│  │  │  ├─📁reservation_cancle_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_change_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_confirm_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_detail_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_list_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_page
│  │  │  │  └─📁widget
│  │  │  ├─📁reservation_result_page
│  │  │  │  └─📁widget
│  │  │  └─📁widget
│  │  ├─📁service_detail_page
│  │  │  ├─📁applience_page
│  │  │  │  └─📁widget
│  │  │  ├─📁housekeeper_page
│  │  │  │  └─📁widget
│  │  │  ├─📁movement_page
│  │  │  │  └─📁widget
│  │  │  ├─📁office_page
│  │  │  │  └─📁widget
│  │  │  └─📁widget
│  │  ├─📁splash_page
│  │  │  └─📁widget
│  │  └─📁start_page
│  │      └─📁widget
│  └─📁widget
│      ├─📁app_bar
│      ├─📁arrow_board
│      ├─📁button
│      ├─📁check_box
│      ├─📁custom_modal
│      ├─📁divider
│      └─📁text_form_field
│          └─📁text
└─📁_core
    ├─📁constants
    └─📁utils
```

