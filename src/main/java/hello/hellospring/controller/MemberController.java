package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.List;

// controller anotation을 지정하면 spring 뜰 때 anotation을 보고 객체를 생성해서 들고 있습니다.
@Controller
public class MemberController {

    private final MemberService memberService;

    // controller 에서 spring이 객체를 생성 및 실행을 해줍니다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        System.out.println(member);
        return "redirect:/";

    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        System.out.println("모든 멤버 : " + members);
        model.addAttribute("members" , members);
        return "members/memberList";
    }
}
