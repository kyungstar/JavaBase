package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


// Java에서 인터페이스를 구현하는 클래스는 해당 인터페이스에 정의된 모든 메서드를 구현해야 합니다.
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
