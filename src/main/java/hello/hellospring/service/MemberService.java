package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 순수 자바 클래스

/**
 스프링 빈을 등록하는 2가지 방법
 1. 컴포넌트 스캔과 자동 의존관계 설정
 2. 자바 코드로 직접 스프링 빈 등록하기

 컴포넌트 스캔 원리
 `@Component` 애노테이션이 있으면 스프링 빈으로 자동 등록된다.

 - `@Component` 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다.
 - `@Controller`
 - `@Service`
 - `@Repository`

 */
@Service
public class MemberService {


    // private : 선언된 멤버는 동일한 클래스 내에서만 접근할 수 있습니다. 다른 클래스에서는 직접적으로 접근할 수 없으며, 해당 클래스의 메서드를 통해 간접적으로 접근해야 합니다.
    // final :  변수가 "한 번 초기화되면 변경할 수 없음"을 나타냅니다. 따라서 한 번 값을 할당하면 해당 변수의 값은 변경할 수 없습니다. 이는 변수의 불변성을 보장하므로 안전성과 가독성을 높여줍니다.

    // new MemoryMemberRepository() : MemberService 클래스가 MemberRepository 인터페이스의 구현체에 종속되지 않고, 인터페이스에 대한 참조를 가지고 있으며 실행 시에 어떤 구현 클래스를 사용할 지 결정할 수 있게 합니다.
    // 이것은 코드의 유연성과 테스트 용이성을 높여줍니다.
    private final MemberRepository memberRepository;
    
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
