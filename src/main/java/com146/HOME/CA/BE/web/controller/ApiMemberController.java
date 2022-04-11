package com146.HOME.CA.BE.web.controller;


import com146.HOME.CA.BE.domain.member.Member;
import com146.HOME.CA.BE.domain.member.svc.MemberSVC;
import com146.HOME.CA.BE.web.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
public class ApiMemberController {
    private final MemberSVC memberSVC;

    //멤버전체 조회
    @ResponseBody //http응답 메세지 바디에 직접 쓰기
    //(반환타입이 객체이면 java객체=>json포맷 문자열로 변환후)
    @GetMapping("/api/members")
    public ApiResult<List<Member>> members(){
        List<Member> list = memberSVC.findAll();
        ApiResult<List<Member>> result = new ApiResult<>("00","success",list);
        return result;
    }

    //멤버 아이디로 조회
    @ResponseBody
    @GetMapping("/api/member/{id}/exist")
    public ApiResult<Member> existId(@PathVariable String id){

        boolean existMember = memberSVC.existId(id);

        if(existMember){
            return new ApiResult("00","success","OK");
        }else{
            return new ApiResult("99","fail","NOK");
        }
    }


    //멤버 이메일로 조회
    @ResponseBody
    @GetMapping("/api/member/email/{email}/exist")
    public ApiResult<Member> existEmail(@PathVariable String email){

        boolean existMember = memberSVC.existEmail(email);

        if(existMember){
            return new ApiResult("00","success","OK");
        }else{
            return new ApiResult("99","fail","NOK");
        }
    }
    //멤버 닉네임으로 조회
    @ResponseBody
    @GetMapping("/api/member/nickname/{nickname}/exist")
    public ApiResult<Member> existNickname(@PathVariable String nickname){

        boolean existMember = memberSVC.existNickname(nickname);

        if(existMember){
            return new ApiResult("00","success","OK");
        }else{
            return new ApiResult("99","fail","NOK");
        }
    }

    //멤버수정
    @ResponseBody
    @PatchMapping("/api/member/{id}")
    public ApiResult<Member> update(@PathVariable Long id, @RequestBody Member member){

        memberSVC.editMember(member);

        ApiResult<Member> result = new ApiResult<>("00","success",member);
        return result;
    }

    //회원탈퇴
    @ResponseBody
    @DeleteMapping("/api/member/{memberNum}")
    public void delete(@PathVariable Long member_num){
        memberSVC.outMember(member_num);
    }

}