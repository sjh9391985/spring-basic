package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 외부에서 주입(DI: dependency injection)
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    // 회원가입
    @Test
    void join() {
        Member member = new Member();
        member.setName("hello");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();
        System.out.println("findMember : " + findMember);
        Assertions.assertEquals(member.getName() , findMember.getName());

    }

    // 회원가입시 예외발생 사례 test code
    @Test
    public void overlapJoinExcept(){
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //Assertions.assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");

    }

    // 유저찾기
    @Test
    void findMembers() {

    }

    //
    @Test
    void findOne() {

    }
}