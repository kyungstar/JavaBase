package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 스프링 데이터 JPA 기본 제공기능
// - 인터페이스를 통한 기본적인 CRUD
// - findByName(), findByEmail 처럼 메서드 이름만으로 조회 기능 제공


public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    Optional<Member> findByName(String name);
}