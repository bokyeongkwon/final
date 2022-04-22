package com146.HOME.CA.BE.web.controller;


import com146.HOME.CA.BE.domain.member.Member;
import com146.HOME.CA.BE.domain.member.svc.MemberSVC;
import com146.HOME.CA.BE.web.form.member.DetailForm;
import com146.HOME.CA.BE.web.form.member.EditForm;
import com146.HOME.CA.BE.web.form.member.JoinForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberSVC memberSVC;

    //회원가입
    @GetMapping("/add")
    public String joinForm(@ModelAttribute JoinForm joinForm){
        return "member/joinMember";
    }

    //회원가입처리
    @PostMapping("/add")
    public String join(
            @Valid @ModelAttribute JoinForm joinForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){

        log.info("join() 호출됨!",joinForm);
        log.info("id={} ,email={}, passwd={}, passwdChk={}, nickname={}",
                joinForm.getId(),joinForm.getEmail(),joinForm.getPw(),
                joinForm.getPw2(),joinForm.getNickname());

        //1)유효성체크 - 필드오류
        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            return "member/joinMember";
        }
        //2)아이디 중복체크
        if(memberSVC.existId(joinForm.getId())){
            bindingResult.rejectValue("id","joinForm.id.dup");
            log.info("error={}", bindingResult);
            return "member/joinMember";
        }
        //3)유효성체크 - global 오류 (2개이상의 필드체크, 백앤드로직 수행시 발생오류)
        //비밀번호 != 비빌번호체크
        if(!joinForm.getPw().equals(joinForm.getPw2()))   {
            bindingResult.reject("member.passwdchk");
            return "member/joinMember";
        }

        //4)정상처리로직
        log.info("joinForm={}", joinForm);
        Member member = new Member();
        BeanUtils.copyProperties(joinForm, member);
        member.setTel(joinForm.getTel1()+joinForm.getTel2()+joinForm.getTel3());

        Member joinedMember = memberSVC.joinMember(member);
        log.info("email={}, passwd={}, nickname={}",
                joinedMember.getEmail(),joinedMember.getPw(),joinedMember.getNickname());

        //return "member/joinSuccess";
        return "redirect:/login";
    }

    //문자열 리스트를 ','를 구분자로하는 문자열 변환
    private String makeListToString(List<String> hobby) {
        StringBuffer str = new StringBuffer();
        for (int i=0; i<hobby.size(); i++) {
            str.append(hobby.get(i));
            if(i == hobby.size()-1) break;
            str.append(",");
        }
        return str.toString();
    }

    //가입성공
    @GetMapping("/joinSuccess")
    public String joinSuccess(){
        return "member/joinSuccess";
    }

    //수정 페이지
    @GetMapping("/{memberNum}/edit")
    public String editMember(
            @PathVariable Long memberNum,
            Model model
    ){
        Member member = memberSVC.findByMemberNum(memberNum);
        DetailForm detailForm = new DetailForm();
        BeanUtils.copyProperties(member, detailForm);
        model.addAttribute("detailForm", detailForm);
        return "member/editMember";
    }

    //수정처리
    @PostMapping("/{memberNum}/edit")
    public String edit(@PathVariable Long memberNum,
                       @ModelAttribute EditForm editForm,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes
    ) {

        if(bindingResult.hasErrors()){
            return "member/editMember";
        }

        Member member = memberSVC.findByMemberNum(memberNum);
        BeanUtils.copyProperties(editForm,member);

        memberSVC.editMember(member);

        redirectAttributes.addAttribute("memberNum",memberNum);
        return "redirect:/member/{memberNum}/edit";
    }

    //회원탈퇴
    @GetMapping("/{memberNum}/del")
    public String delete(@PathVariable Long memberNum){
        memberSVC.outMember(memberNum);
        return "redirect:/";
    }
    //마이페이지
    @GetMapping("/{memberNum}/mypage")
    public String mypage(){
        log.info("mypage() 호출됨");
        return "member/mypage";
    }

    //아이디 찾기
    @GetMapping("/findEmail")
    public String findEmail(){

        return "member/findEmail";
    }

    //프로파일
    @GetMapping("/{memberId}/profile")
    public String profile(@PathVariable Long memberId){
        return "member/profileEditForm";
    }

}