# Service & Dao 객체 구현



#### Service 객체를 생성하는 방법 1

new 연산자를 이용한 service 객체 생성 및 참조 - 순수 자바 No 지향

``` Java
MemberService service = new MemberService();
```



#### Service 객체를 생성하는 방법 2

스프링 설정파일을 이용한 서비스 객체 생성 및 의존 객체 자동 주입

``` Java
<beans:bean id="service" class="com.bs.lec17.member.service.MemberService"></beans:bean>
                       👇🏻
@Autowired MemberService service;
```



#### ✨ Service 객체를 생성하는 방법 3 ✨

어노테이션을 이용해서 서비스 객체 생성 및 의존 객체 자동 주입

```Java
// @Service  <-- 추천 ~
// @Component
// @Repository
@Repository("memService") 
public class MemberService implements IMemberService {
                       👇🏻
@Resource(name="memService") 
MemberService service;
```



#### Dao 객체를 생성하는 방법 

어노테이션을 이용해서 DAO 객체 생성 및 의존 객체 자동 주입

``` Java
@Repository public class MemberDao implements IMemberDao {
                         👇🏻
@Autowired MemberDao dao;
```



# Controller 객체 구현 1

@RequestMapping을 이용한 URL 매핑

``` Java
public class MemberController {
  // ...
  
	@RequestMapping(value="/memJoin")
	==  @RequestMapping("/memJoin")
  // OR
 	@RequestMapping(value="/memJoin", method=RequestMethod.GET)
}
```



만약 반복된 공통된 path를 갖는 controller라면❓ 

``` Java
@RequestMapping(value="/member")
public class MemberController {
  // ...
  
  // {{url}}/member/memJoin 으로 접근
 	@RequestMapping(value="/memJoin", method=RequestMethod.GET)
}
```



### 요청 데이터는 어떻게 받아❓ 

#### 첫 번째 방법 

HttpServletRequest 객체를 이용한 HTTP 전송 정보 얻기

``` Java
@RequestMapping(value="/member")
public class MemberController {
  // ...
  
 	@RequestMapping(value="/memJoin", method=RequestMethod.POST) {
    String memId = request.getParameter("memId");
    String memPw = request.getParameter("memPw");
  }
}
```



#### 두 번째 방법

@RequestParam 어노테이션을 이용한 HTTP 전송 정보 얻기

``` Java
@RequestMapping(value="/member")
public class MemberController {
  // ...
  
 	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
  public String memLogin(Model model, @RequestParam("memId") String memId, @RequestParam("memPw") String memPw) {}
  
  // 알아만 두자 - 거의 안씀
  @RequestMapping(value="/memJoin", method=RequestMethod.POST)
  public String memLogin(Model model, @RequestParam(value="memId") String memId, @RequestParam(value="memPw", required=false, defaultValue="1234") String memPw) {}
 // required : 값이 필수로 필요? 
 // defaultValue : 값이 없으면 default로 넣어질 데이터
}
```



#### ✨ 세번째 방법 ✨ 

커멘드 객체를 이용한 HTTP전송 정보 얻기   -->  getter, setter가 전부 있는 객체를 연결

jsp 에서 변수로 사용하면 setter로 사용하면됨 



# Controller 객체 구현 2



### @ModelAttribute

@ModelAttribute를 이용하면 커멘드 객체의 이름을 변경할 수 있고, 이렇게 변경된 이름은 뷰에서 커멘드 객체를 참조할 때 사용된다.

``` Java
public String memJoin(Member member)           -->        ID: {member.memId}

public String memRemove(@ModelAttribute("mem") Member member)  --> ID: {mem.memId}
```



#### Model & ModelAndView

컨트롤러에서 뷰에 데이터를 전달하기 위해 사용되는 객체로 Model과 ModelAndView가 있다.두 객체의 차이점은 Model은 뷰에 데이터만을 전달하기 위한 객체이고, ModelAndView는 데이터와 뷰의 이름을 함께 전달하는 객체이다.











