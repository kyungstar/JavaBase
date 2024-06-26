package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    // 주의 : @Autowired를 통한, DI는 helloController, MemberService 등과 같이 스프링이 관리하는 객체에서만 동작한다.
    // -> 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }


    /**
     1. model
     - Model은 Spring MVC(Model-View-Controller) 패턴에서 사용되는 객체입니다. 이 객체는 컨트롤러에서 뷰로 데이터를 전달할 때 사용됩니다. 컨트롤러에서 데이터를 Model 객체에 추가하면, 그 데이터는 뷰에서 접근할 수 있게 됩니다.
     - 예를 들어, 컨트롤러에서 model.addAttribute("members", members);와 같이 데이터를 Model 객체에 추가하면, 뷰(JSP, Thymeleaf 등)에서 "members"라는 이름으로 데이터를 참조할 수 있게 됩니다.

     2. addAttribute
     - addAttribute 메서드는 Model 객체에 데이터를 추가하는 데 사용됩니다. 이 메서드는 두 개의 인자를 받습니다.

     첫 번째 인자는 데이터의 이름(키)입니다. 이 이름을 통해 뷰에서 데이터를 참조할 수 있습니다.
     두 번째 인자는 데이터의 값입니다. 이 값은 실제로 뷰에 전달되는 데이터입니다.
     */

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
