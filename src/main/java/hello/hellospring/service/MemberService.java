package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입 서비스
    public Long join(Member member){

        // 같은 이름이 있는 중복회원은 가입불가
        /*
        Optional<Member> result =  memberRepository.findByName(member.getName());
        // null이 아니라 값이 있으면 except 발생시켜줍니다.
        result.ifPresent(m -> {
            throw new IllegalAccessException("이미 존재하는 회원입니다.")
        });
        */

        // null이 아니라 값이 있으면 except 발생시켜줍니다. (위의 코드와 동일한 결과를 나타냅니다.)
        validateDuplicateMember(member); // 메소드로 따로 뽑아내서 사용합니다.
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원입니다.");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    // 전체회원 조회기능
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // memberId 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
