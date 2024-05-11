package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;



// MemberRepository 인터페이스를 구현하는 MemoryMemberRepository 클래스
@Repository
public class MemoryMemberRepository implements MemberRepository {

    // Map을 사용하여 데이터를 저장하는 저장소
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    /**
     * @Override 어노테이션은 메소드가 부모 클래스나 인터페이스로부터 상속받은 메소드를 오버라이딩(재정의) 한다는 것을 명시적으로 표시하는데 사용됩니다.
     * 이는 컴파일러에게 해당 메소드가 실제로 상속된 메소드를 오버라이딩 하는 것이라고 알려줍니다.
     * 만약 해당 어노테이션을 사용하지 않고 메소드를 선언하면, 부모 클래스나 인터페이스에 정의된 메소드와 이름이 같은 새로운 메소드를 만들게 됩니다.
     */
    // MemberRepository 인터페이스의 save 메서드를 구현
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // MemberRepository 인터페이스의 findById 메서드를 구현
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }


    /***
     * HashMap 클래스는 키-값 쌍을 저장하는 해시맵을 구현한 클래스입니다.
     *  stream() 메소드 : HashMap의 키-값 쌍을 스트림으로 변환하여 다양한 작업을 수행할 수 있도록 합니다.
     */
    // MemberRepository 인터페이스의 findByName 메서드를 구현
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    // MemberRepository 인터페이스의 findAll 메서드를 구현
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    // 저장소를 비우는 메서드
    //  MemoryMemberRepository 클래스의 고유한 기능을 추가하는 데 사용됩니다.
    //  인터페이스의 기본 목적을 따르는 것이 아니라, 클래스의 특수한 동작이나 상태 관리를 위한 추가적인 메서드입니다.
    public void clearStore() {
        store.clear();
    }
}
