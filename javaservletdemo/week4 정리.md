13-1 웹 프로그래밍을 구축하기 위한 설계 모델 

13-2 스프링 MVC플레임워크 설계 구조 

13-3 DispatcherServlet 설정

13-4 Controller 객체 - @Controller 

13-5 Controller 객체 - @RequestMapping 

13-6 Controller 객체 – Model 타입의 파라미터 

13-7 View 객체 13-8 전체적인 웹프로그래밍 구조

---



웹프로그래밍을 구축하기 위한 설계 모델

model1 VS model2



## Model 1

WAS : web Application Server 내부에 **JSP <->Service & DAO** 의 형식으로 설정

문서 = HTML + JAVA + <Tag>

유지보수 차원-> 첫 단계

장점 : HTML 내부에 java코드나 태그등을 같이 넣기 때문에 개발 시간이 빠름

단점 : 여러 언어를 한 파일에 넣기 때문에 유지보수가 어려워 수정 시 개발자가 스트레스를 받을 수 있음



## Model 2

was에 request하는 건 똑같음

**Browser <-> (view) <-> Controller <-> Service <-> DAO <-> Model <-> DATABASE** 의 형식으로 설정

모듈화함 -> 기능은 서비스에 전부 넣어줌

기본적으로 MVC를 구분해서 개발

장점 : 유지보수가 수월해짐

대부분 Model 2를 사용해서 개발함





![스크린샷 2020-06-07 오후 4.05.06](/Users/gyeongseon/Library/Application Support/typora-user-images/스크린샷 2020-06-07 오후 4.05.06.png)

매우 중요 항상 머릿속에 담고 있어야 함

DispatcherServlet라는 클래스가 있는데 이 객체가 요청을 받음

HandlerMapping에게 던져줌.

HandlerMapping은 controller가 여러개 있을 수 있는데, 가장 적합한 controller를 매칭해준다.

DispatcherServlet에게 다시 돌아와서 HandlerAdapter에게 또 요청함

HandlerAdapter은 controller  내부의 가장 적합한 **메소드**를 찾아줌



controller를 다 찾고 그 다음은 DispatcherServlet가 그 다음으로 ViewResolver를 찾음

 ViewResolver는 우리가 알고있는 View입니다. 



conrtoller 뒤에는 Service, DAO, Database등이 잇겠죠

ViewResolver는 controller를 찾아서 결과가 나왔는데 그 결과와 적합한 가장 적합한 JSP페이지를 찾아달라고 요청을 하고

View를 찾으면 응답을 함.

그 이후 HTTP 프로토콜이 끊어지겠죠

중요중요 〰️ 브라우저



DispatcherServlet는 사거리와 같음



DispatcherServlet 설정

web.xml (JSP Servlet 을 찾아서 더 자세히 알아보기)



``` xml
<servlet>

<servlet-name>서블릿 별칭</servlet-name>
<servlet-class>서블릿명(패키지 이름을 포함한 전체서블릿명)</servlet-class> 
</servlet> 

<servlet-mapping> 
  <servlet-name>서블릿별칭</servlet-name> 
  <url-pattern>/맵핑명</url-pattern> 
</servlet-mapping>
```



예시)

``` xml
<servlet> 
  <servlet-name>appServlet</servlet-name> 
  <!-- DispatcherServlet 의 닉네임을 appServlet으로 지정해주겠디-->
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class> 
  
  <!-- init-param 정의하지 않으면 어떻게 할래? 스프링컨테이너가 알아서 자동으로 설정- 아래그림 참조-->
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <!-- servlet-context.xml? 스프링 설정 파일 : 스프링 컨테이너 생성 -->
    <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value> 
  </init-param>
  
  <load-on-startup>1</load-on-startup> 
</servlet>

<servlet-mapping> 
  <servlet-name>appServlet</servlet-name> 
  <!-- 왜 루트(/)일까? 첫 관문은 무조건 DispatcherServlet을 통해야 하기 때문 -->
  <url-pattern>/</url-pattern> 
</servlet-mapping>
```





init-param을 설정하지 않은 경우에는 스프링 컨테이너가 appServlet-contect찾아서 를 알아서 설정해 주게 됨

필수적으로 필요한 빈 객체들을 설정

물론 명시적인 방법이 대부분





### Controller 객체 

Controller 는 model and View 

controller 어떻게 생성? 

<annotation-driven>만 추가하고 @Controller만 달아주면 Controller 로 작동을 한다



### Controller 객체의 RequestMapping

요청 받기

어떤 메소드가 설정할지 찾아야 겠죠?

요청한 값을 명시해줌



Controller 객체 - Model 타입의 파라미터

``` java
model.setAttributte("속성 명", "속성 값");
```



### View 객체

``` xml
// servlet-context.xml
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <beans:property name="prefix" value="/WEB-INF/views/" />
    <beans:property name="suffix" value=".jsp" />
</beans:bean>
```

InternalResourceViewResolver : 이 녀석이 바로 적합한 뷰를 찾아주는 녀석

어떻게 찾음? 리턴값과 InternalResourceViewResolver가 만들어준 value의 파일을 찾아줌

리턴값(String)+value





# 스프링 MVC 웹서비스

14-1 웹 서버(Tomcat) 다운로드 

14-2 웹 서버(Tomcat) 와 이클립스 연동 

14-3 이클립스에 STS(Spring Tool Suit) 설치 

14-4 STS를 이용한 웹프로젝트 생성 

**14-5 스프링 MVC프레임워크를 이용한 웹프로젝트 분석** 중요





웹서버 다운로드

아파치 내부적으로 8080을 사용



Sprin tool Suit







# 스프링 MVC 웹서비스 2

15-1 프로젝트 전체 구조

 15-2 web.xml 

15-3 DispatcherServlet 

15-4 servlet-context.xml 

15-5 Controller(컨트롤러) 

15-6 View(뷰)



``` 
.
├── src/
│   ├── www/
│   │   └── main/
│   │       ├── java/                                     // 자바 파일
│   │       │   └── com/                                  // 여기부터 패키지
│   │       │       └── bs/
│   │       │           └── elc14/
│   │       │               └── HomeController.java
│   │       ├── resources/
│   │       └── webapp/                                  // 웹관련 폴더 html, css, js 등
│   │          ├── resources/
│   │          └── WEB-INF/
│   │              ├── classes/
│   │              ├── spring/                            // 스프링 설정 파일 (스프링 컨테이너 생성)
│   │              │   ├── appServlet/
│   │              │   │   └── servlet-context.xml       // 스프링 설정 파일
│   │              │   └── root-context.xml
│   │              ├── views/
│   │              │   ├── home.jsp                     // 응답에 필요한 jsp파일
│   │              └── web.xml                          // 웹 설정 파일
│   └── test/
├── target/
└── pom.xml                                             // 메이븐 설정 파일
```



1. java파일 : java파일들이 위치한다. 주로 패키지로 묶어서 관리한다. 웹 애플리 케이션에서 사용되는 Controller, Service, DAO객체들이 위치한다.

2. webapp : 웹과 관련된 파일들(스프링 설정파일, JSP파일, HTML파일 등..)이 위치한다.

3. resources : JSP파일을 제외한 html, css, js파일등이 위치한다.spring폴더 : 스프링 컨테이너를 생성하기 위한 스프링 설정파일이 위치한다.

5. views 폴더 : View로 사용될 JSP파일이 위치한다.

6. pom.xml파일 : 메인 레파지토리에서 프로젝트에 필요한 라이브러리를 내려받 기 위한 메이븐 설정 파일





요청이 들어오면 web.xml에 있는 DispatcherSevlet을 등록

![스크린샷 2020-06-07 오후 5.44.32](/Users/gyeongseon/Desktop/스크린샷 2020-06-07 오후 5.44.32.png)

사용자의 모든 요청을 DispatcherServlet이 받은 후 HandlerMapping 객체에 Controller 객체 검색을 요청한다. 

그러면 HandlerMapping 객체는 프로젝트 에 존재하는 모든 Controller 객체를 검색한다.

HandlerMapping 객체가 Controller 객체를 검색해서 DispatcherServlet 객체에 알려주면 DispatcherServlet 객체는 다시 HandlerAdapter 객체에 사용자의 요청에 부합하는 메소드 검색을 요청한다. 

그러면 HandlerAdapter 객체는 사용자의 요청 에 부합하는 메소드를 찾아서 해당 Controller 객체의 메소드를 실행한다.

 Controller 객체의 메소드가 실행된 후 Controller 객체는 HandlerAdapter 객체에 ModelAndView 객체를 반환하는데 ModelAndView 객체에는 사용자 응답에 필요한 데이터정보와 뷰정보(JSP파일)가 담겨있다. 

다음으로 HandlerAdapter 객체는 ModelAndView 객체를 다시 DispatcherServlet 객체에 반환한다.









