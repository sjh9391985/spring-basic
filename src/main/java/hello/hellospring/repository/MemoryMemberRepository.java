package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        System.out.println("인원 저장 수 : " + member);
        System.out.println("멤버정보 : " + store.keySet() + "/" + store.values());
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // store에 저장된 id가 없다면 null 반환 점검을 위해서 client에서 작업을 가능합니다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store의 values가 member 입니다.
    }

    public void clearStore(){
        store.clear();
    }
}
