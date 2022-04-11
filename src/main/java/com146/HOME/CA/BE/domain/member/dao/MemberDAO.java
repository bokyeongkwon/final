package com146.HOME.CA.BE.domain.member.dao;



import com146.HOME.CA.BE.domain.member.Member;

import java.util.List;

public interface MemberDAO {

  /**
   * 가입
   * @param member
   * @return
   */
  Member insertMember(Member member);

  /**
   * 수정
   * @param member
   * @return
   */
  Member updateMember(Member member);

  /**
   * 조회 by id
   * @param id
   * @return
   */
  Member selectMemberById(String id);

  /**
   * 조회 by memberNum
   * @param memberNum
   * @return
   */
  Member selectMemberByMemberNum(Long memberNum);

  /**
   * 조회 by email
   * @param email
   * @return
   */
  Member selectMemberByEmail(String email);

  /**
   * 조회 by nickname
   * @param nickname
   * @return
   */
  Member selectMemberByNickname(String nickname);

  /**
   * 전체조회
   * @return
   */
  List<Member> selectAll();

  /**
   * 탈퇴
   * @param memberNum
   */
  void deleteMember(Long memberNum);

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
