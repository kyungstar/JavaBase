package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class MemberController {

    private final MemberService memberService;


    // 주의 : @Autowired를 통한, DI는 helloController, MemberService 등과 같이 스프링이 관리하는 객체에서만 동작한다.
    // -> 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
