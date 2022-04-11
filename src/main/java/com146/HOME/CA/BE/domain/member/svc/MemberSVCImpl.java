package com146.HOME.CA.BE.domain.member.svc;


import com146.HOME.CA.BE.domain.member.Member;
import com146.HOME.CA.BE.domain.member.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberSVCImpl implements MemberSVC {

    private final MemberDAO memberDAO;

    //가입
    @Override
    public Member joinMember(Member member) {
        return memberDAO.insertMember(member);
    }

    //수정
    @Override
    public Member editMember(Member member) {
        return memberDAO.updateMember(member);
    }

    //조회 by id
    @Override
    public Member findById(String id) {
        return memberDAO.selectMemberById(id);
    }

    //조회 by memberNum
    @Override
    public Member findByMemberNum(Long memberNum) {
        return memberDAO.selectMemberByMemberNum(memberNum);
    }

    //조회 by email
    @Override
    public Member findByEmail(String email) {
        return memberDAO.selectMemberByEmail(email);
    }

    //조회 by nickname
    @Override
    public Member findByNickname(String nickname) {
        return memberDAO.selectMemberByNickname(nickname);
    }


    //전체조회
    @Override
    public List<Member> findAll() {
        return memberDAO.selectAll();
    }

    //탈퇴
    @Override
    public void outMember(Long memberNum) {
        memberDAO.deleteMember(memberNum);
    }

    //회원유무 체크
    @Override
    public boolean existId(String id) {
        return memberDAO.existId(id);
    }

    @Override
    public boolean existEmail(String email) {
        return memberDAO.existEmail(email);
    }

    @Override
    public boolean existNickname(String nickname) {
        return memberDAO.existNickname(nickname);
    }

    //로그인 인증
    @Override
    public Member login(String id, String pw) {
        return memberDAO.login(id,pw);
    }

    //비밀번호 일치여부 체크
    @Override
    public boolean isMember(String id, String pw) {
        return memberDAO.isMember(id,pw);
    }

    //아이디 찾기
    @Override
    public String findIdByNickname(String nickname) {
        return memberDAO.findIdByNickname(nickname);
    }
}
