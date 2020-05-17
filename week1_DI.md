## 0. 스프링 개요

### 스프링 프레임워크

스프링 프레임워크는 주요기능으로 DI, AOP, MVC, JDBC 등을 제공한다.

``` 
DI : Dependency Injection
AOP : Aspect Oriented Programming
MVC : model-view-controller
JDBC : 
```

프레임워크? 업무를 정해놓은 추상적인 틀

어시스턴스없이 일을 진행 VS 있이 진행은 큰 차이 --> 네비없이 운전 VS 네비갖고 운전



### 스프링 프레임워크 모듈

| 스프링 모듈   | 기능                                                         |
| ------------- | ------------------------------------------------------------ |
| spring-core   | 스프링의 **핵심**인 DI(Dependency Injection) 와 IoC(Inversion of Control)를 제공 |
| spring-aop    | AOP구현 기능 제공                                            |
| spring-jdbc   | 데이터베이스를 쉽게 (적은 양의 코드) 다룰 수 있는 기능 제공  |
| spring-tx     | 스프링에서 제공하는 트랜젝션 관련 기능 제공                  |
| spring-webmvc | 스프링에서 제공하는 컨트롤러(Controller)와 뷰(View)를 이용한 스프링 MVC 구현 기능 제공 |



- 스프일 프레임워크에서 제공하고 있는 모듈을 사용하려면❓ 
  - 모듈에 대한 의존설정을 개발 프로젝트에 XML파일등을 이용해서 개발자가 직접하면 된다.
  - 모듈화되어 제공되니 필요한 것만 사용하자 〰️ 



### 스프링 컨테이너 (IoC -Inversion of Control)

스프링에서 객체를 생성하고 조립하는 객체를 컨테이너(Container)로, 컨테이너를 통해 생성된 객체를 빈(Bean)이라고 부른다.

![스크린샷 2020-05-17 오후 7.39.12](/Users/gyeongseon/Desktop/스크린샷 2020-05-17 오후 7.39.12.png)



외부에서 생성한 객체를 내부 객체에 포함시켜 의존성을 더한다.

제어의 역전, 컨테이너는 개발자 대신 객체의 생성부터 소멸까지 책임진다.

자바에서 Contrainer == IoC 〰️ 



## 3-1. DI (Dependency Injection)

배터리 일체형 : 배터리가 떨어지면 제품을 다시 구매

배터리 분리형 : 배터리가 떨어지면 배터리만 교체

--> 객체지향프로그램의 **유연성**

``` java
// 일체형 ~
public class DI1 { 
  private Battery battery; 
  public ElectronicCarToy() { 
    battery = new NormalBattery(); 
  } 
}
```

``` java
// 분리형 ~
public class DI2 { 
  private Battery battery; 
  public ElectronicRobotToy() {
  } 
  public void setBattery(Battery battery) { 
    this.battery = battery; 
  } 
}
```

``` java
// 분리형 ~
public class ElectronicRadioToy {
  private Battery battery; 
  public ElectronicRadioToy(Battery battery) {
    this.battery = battery; 
  } 
  public void setBattery(Battery battery) {
    this.battery = battery; 
  } 
}
```

외부에서 생성해 의존성을 더하는 것





## 3-2. 다양한 의존 객체 주입

1. 생성자를 이용한 의존 객체 주입

   ``` java
   public StudentResgisterService(StudentDao studentDao) {
     this.studentDao = studentDao;
   }
   👇🏻
   <bean id="registerService" class="ems.member.service.StudentRegisterService">
     <constructor-arg ref="studentDao" ></constructor-arg> </bean>
   ```

   

2. Setter를 이용한 의존 객체 주입

   ``` java
   public void setJdbcUrl(String jdbcUrl) { 
     this.jdbcUrl = jdbcUrl; 
   } 
   public void setUserId(String userId) {
     this.userId = userId; 
   } 
   public void setUserPw(String userPw) {
     this.userPw = userPw;
   }
   👇🏻 property 생성 (set 없애고 앞글자 소문자로 ~ )
   <bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
     <property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
     <property name="userId" value="scott" /> 
     <property name="userPw" value="tiger" />
   </bean>
   ```

   

3. List타입 의존 객체 주입

   ``` java
   public void setDevelopers(List<String> developers) { 
     this.developers = developers; 
   }
   👇🏻 
   <property name="developers">
   <list> 
     <value>Cheney.</value> 
     <value>Eloy.</value> 
     <value>Jasper.</value> 
     <value>Dillon.</value> 
     <value>Kian.</value> 
   </list> 
   </property>
   ```

   

4. Map타입 객체 주입

``` java
public void setAdministrators(Map<String, String> administrators) {
  this.administrators = administrators; 
}
👇🏻 
<property name="administrators">
  <map>
    <entry> 
      <key> 
        <value>Cheney</value> 
      </key>
        <value>cheney@springPjt.org</value> 
    </entry> 
    <entry> 
  		<key>
  			<value>Jasper</value>
  		</key> 
  			<value>jasper@springPjt.org</value> 
  	</entry> 
  </map>
</property>
```
