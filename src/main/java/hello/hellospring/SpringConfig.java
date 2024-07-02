package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/***
 * 요약
 의존성 주입: DataSource는 스프링 컨테이너에 의해 자동으로 주입됩니다.
 빈 정의: SpringConfig 클래스는 MemberService와 MemberRepository 빈을 정의합니다.
 레포지토리 선택: memberRepository() 메서드에서 JdbcMemberRepository를 사용하여 데이터베이스와 연결된 멤버 레포지토리를 사용합니다. 주석 처리된 MemoryMemberRepository 부분을 해제하면 메모리 기반의 레포지토리를 사용할 수 있습니다.


 동작 과정
 1. 스프링 컨테이너가 SpringConfig 클래스를 읽고 빈을 등록합니다.
 2. DataSource 빈이 스프링에 의해 자동으로 주입됩니다.
 3. memberService() 메서드가 호출되어 MemberService 빈이 생성됩니다.
 4. memberRepository() 메서드가 호출되어 JdbcMemberRepository 빈이 생성됩니다.
 5. MemberService는 JdbcMemberRepository를 주입받아 생성됩니다.
 */
// @Configuration: 이 클래스가 스프링의 설정 클래스로 사용됨을 나타냅니다. 스프링이 이 클래스를 읽어서 빈 정의와 의존성 주입을 설정합니다.
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


    /*@Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository(dataSource);
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }*/
}
