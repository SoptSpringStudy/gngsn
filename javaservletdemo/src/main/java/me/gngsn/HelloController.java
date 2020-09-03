package me.gngsn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    // Bean으로 등록되어있는 HelloService을 가져
    @Autowired
    HelloService helloService;

    // 어떤 요청을 처리하는 Handler를 아래와 같이 만들어주고 싶다 ~
    // 어떤 요청을 처리하는 Handler를 아래와 같이 만들어주고 싶다 ~
    @GetMapping("/hello")
    @ResponseBody
    public String Hello() {
        return "hello, "+ helloService.getName();
    }

    // 아래와 동일. 반환값에 붙이는 Annotation? 은 없다. 그냥 method에 붙인 것
//   @GetMapping("/hello")
//    public @ResponseBody String Hello() { return "hello, "+ helloService.getName(); }

    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }
}
