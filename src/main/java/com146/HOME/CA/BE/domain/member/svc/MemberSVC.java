package com146.HOME.CA.BE.domain.member.svc;

import com146.HOME.CA.BE.domain.member.Member;

import java.util.List;

public interface MemberSVC {

  /**
   * 가입
   * @param member
   * @return
   * @return
   */
  Member joinMember(Member member);

  /**
   * 수정
   * @param member
   * @return
   *
   */
  Member editMember(Member member);

  /**
   * 조회 by id
   * @param id
   * @return
   */
  Member findById(String id);

  /**
   * 조회 by memberNum
   * @param memberNum
   * @return
   */
  Member findByMemberNum(Long memberNum);

  /**
   * 조회 by email
   * @param email
   * @return
   */
  Member findByEmail(String email);

  /**
   * 조회 by nickname
   * @param nickname
   * @return
   */
  Member findByNickname(String nickname);

  /**
   * 전체조회
   * @return
   */
  List<Member> findAll();

  /**
   * 탈퇴
   * @param memberNum
   */
  void outMember(Long memberNum);

  /**
   * 회원유무 체크
   * @param id
   * @return
   */
  boolean existId(String id);

  boolean existEmail(String email);

  boolean existNickname(String nickname);

  /**
   * 로그인 인증
   * @param id
   * @param pw
   * @return
   */
  Member login(String id, String pw);

  /**
   * 비밀번호 일치여부 체크
   * @param id
   * @param pw
   * @return
   */
  boolean isMember(String id, String pw);

  /**
   * 아이디 찾기
   * @param nickname
   * @return
   */
  String findIdByNickname(String nickname);

}
