package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    /**
     * HTTP의 BODY에 문자 내용을 직접 반환
     * `viewResolver` 대신에 `HttpMessageConverter` 가 동작
     * 기본 문자처리: `StringHttpMessageConverter`
     * 기본 객체처리: `MappingJackson2HttpMessageConverter`
     * byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
     */
    public String helloString(@RequestParam(value = "name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // 외부 클래스의 인스턴스를 먼저 생성한 후 내부 클래스의 인스턴스 생성안해도됨
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
