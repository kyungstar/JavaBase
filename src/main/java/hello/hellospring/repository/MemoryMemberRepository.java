package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    /**
     * @Override 어노테이션은 메소드가 부모 클래스나 인터페이스로부터 상속받은 메소드를 오버라이딩(재정의) 한다는 것을 명시적으로 표시하는데 사용됩니다.
     * 이는 컴파일러에게 해당 메소드가 실제로 상속된 메소드를 오버라이딩 하는 것이라고 알려줍니다.
     * 만약 해당 어노테이션을 사용하지 않고 메소드를 선언하면, 부모 클래스나 인터페이스에 정의된 메소드와 이름이 같은 새로운 메소드를 만들게 됩니다.
     */
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }


    /***
     * HashMap 클래스는 키-값 쌍을 저장하는 해시맵을 구현한 클래스입니다.
     *  stream() 메소드 : HashMap의 키-값 쌍을 스트림으로 변환하여 다양한 작업을 수행할 수 있도록 합니다.
     */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
