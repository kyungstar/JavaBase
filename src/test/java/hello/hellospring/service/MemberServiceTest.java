package hello.hellospring.service;

import hello.hellospring.domain.Member;


import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;


    // `@BeforeEach` : 각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어준다.
    @BeforeEach
    public void beforeEach() {
        // memberRepository를 새로운 MemoryMemberRepository 객체로 초기화하고, memberService를 이 새로운 memberRepository를 사용하여 초기화합니다.

        // 이렇게 함으로써 각 테스트가 실행될 때마다 새로운 MemoryMemberRepository와 MemberService 객체가 생성되고, 이들 간의 의존 관계도 다시 맺어집니다.
        // 이는 테스트의 독립성을 보장하여 테스트 결과가 예측 가능하고 일관되게 유지되도록 합니다.
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Spring100");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring2");
        Member member2 = new Member();
        member2.setName("spring2");

        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); //예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}