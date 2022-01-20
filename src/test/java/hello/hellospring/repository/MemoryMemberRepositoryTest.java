package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // callback method, 아래의 메소드들이 실행을 할 때 마다 동작이 실행되는 메서드를 의미합니다.
    public void afterEach(){
        // 각각의 메소드 실행 할 때 마다 store를 clear를 해주기때문에 메소드들의 실행순서가 크게 의미가 없습니다.
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findById(){
        // spring 1, 2 회원가입
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        System.out.print("result : "+ result);
        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findAll(){
        // spring 1, 2 회원가입
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        System.out.println("result : " + result);
        System.out.println("result size : " + result.size());

        Assertions.assertEquals(result.size(), 2);

    }

}
