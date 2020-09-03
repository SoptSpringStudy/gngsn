### 생명주기 

#### 스프링 컨테이너 생명주기

스프링 설정파일의 리소스를 넣어줬죠.

GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("class path:appCtx.xml");

 -> 스프링 컨테이너의 생성



이후엔 생성한 context들로 내부에 정의된 빈들을 이용

이 때, 빈 객체는 스프링 컨테이너 생명주기와 같다.



마지막으로, close();를 이용해서 context를 닫아주었으며 이로인해 스프링 컨테이너가 소멸 -> 메모리에서 제거됨. 더 이상의 효력이 없어짐



### 빈 객체의 생명주기

빈 (Bean)객체의 생명주기는 스프링 컨테이너의 생명주기와 같이 한다

InitializingBean -> afterPropertiesSet() : 시작하는 시점에 특정 기능을 실행할 수 있음

DisposableBean -> destroy() : 소멸되는 시점에 특정 기능을 실행할 수 있음



## 어노테이션을 이용한 스프링 설정

Java 파일로 생성

![스크린샷 2020-06-01 오전 1.42.10](/Users/gyeongseon/Library/Application Support/typora-user-images/스크린샷 2020-06-01 오전 1.42.10.png)



우리가 기존에 xml을 사용한 서비스 및 빈 객체 생성을 어노테이션을 사용해서 Java 파일만으로 생성하는 게 목표



``` xml
<bean id="studentDao" class="ems.emeber.dao.StudentDao"></bean>
```

위의 코드를 아래의 코드와 같이 사용할 수 있다.

``` java
import org.springframework.context.annotation.Configuation;

@configuration
public class MemberConfig {
  @Bean
  public StudentDao studentDao() {
    return new StudentDao();
  }
} 
```



``` xml
<bean id="registerService" class="ems.member.service.StudentRegisterService">
  <constructor-arg ref="studentDao"></constructor-arg>
</bean>
```



위의 코드는 아래와 같이 바꿔 사용할 수 있다.

``` java
import org.springframework.context.annotation.Configuation;

@configuration
public class MemberConfig {
  @Bean
  public StudentDao studentDao() {
    return new StudentDao();
  }
  @Bean
  public StudentRegisterservice registerservice() {
    return StudentRegisterservice(studentDao());
  }
} 
```



import annotaion --> 하나의 config 파일이 만들어진 것 마냥,,,

여러개의 자바 파일로 분리를 해서 관리 

Dao, Service, config 쯤으로 나누곤 함.









