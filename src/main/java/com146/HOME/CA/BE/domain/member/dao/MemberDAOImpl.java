package com146.HOME.CA.BE.domain.member.dao;


import com146.HOME.CA.BE.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

    private final JdbcTemplate jdbcTemplate;

    //가입
    @Override
    public Member insertMember(Member member) {
        //SQL문작성
        StringBuffer sql = new StringBuffer();
        sql.append(" insert into member ");
        sql.append(" values(member_member_num_seq.nextval, ?, ?, ? , ?, ?, ?, ?, ?, systimestamp, systimestamp) ");

        //SQL실행
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(
                        sql.toString(),
                        new String[] {"member_num"}    // keyHolder에 담을 테이블의 컬럼명을 지정
                );
                pstmt.setString(1,member.getId());
                pstmt.setString(2,member.getName());
                pstmt.setString(3,member.getPw());
                pstmt.setString(4,member.getTel());
                pstmt.setString(5,member.getEmail());
                pstmt.setString(6,member.getBirth());
                pstmt.setString(7,member.getGender());
                pstmt.setString(8,member.getNickname());

                return pstmt;
            }
        },keyHolder);

        long memberNum = keyHolder.getKey().longValue();
        return selectMemberByMemberNum(memberNum);
    }

    //수정
    @Override
    public Member updateMember(Member member) {


        StringBuffer sql = new StringBuffer();
        sql.append("update member ");
        sql.append("   set pw = ?, ");
        sql.append("       tel = ?, ");
        sql.append("       email = ?, ");
        sql.append("       birth = ?, ");
        sql.append("       gender = ?, ");
        sql.append("       nickname = ?, ");
        sql.append("       udate = systimestamp ");
        sql.append(" where member_num = ? ");

        jdbcTemplate.update(
                sql.toString(),
                member.getPw(),
                member.getTel(),
                member.getEmail(),
                member.getBirth(),
                member.getGender(),
                member.getNickname(),
                member.getMemberNum());

        return selectMemberByMemberNum(member.getMemberNum());
    }

    //ID로찾기
    @Override
    public Member selectMemberById(String id) {

        StringBuffer sql = new StringBuffer();
        sql.append("select member_num, ");
        sql.append("       id, ");
        sql.append("       name, ");
        sql.append("       pw, ");
        sql.append("       tel, ");
        sql.append("       email, ");
        sql.append("       birth, ");
        sql.append("       gender, ");
        sql.append("       nickname, ");
        sql.append("       cdate, ");
        sql.append("       udate ");
        sql.append("  from member ");
        sql.append(" where id = ? ");

        Member member = jdbcTemplate.queryForObject(
                sql.toString(),
                new BeanPropertyRowMapper<>(Member.class),
                id
        );
        return member;
    }

    //멤버넘버로 찾기
    @Override
    public Member selectMemberByMemberNum(Long memberNum) {

        StringBuffer sql = new StringBuffer();
        sql.append("select member_num, ");
        sql.append("       id, ");
        sql.append("       name, ");
        sql.append("       pw, ");
        sql.append("       tel, ");
        sql.append("       email, ");
        sql.append("       birth, ");
        sql.append("       gender, ");
        sql.append("       nickname, ");
        sql.append("       cdate, ");
        sql.append("       udate ");
        sql.append("  from member ");
        sql.append(" where member_num = ? ");

        Member member = jdbcTemplate.queryForObject(
                sql.toString(),
                new BeanPropertyRowMapper<>(Member.class),
                memberNum
        );
        return member;
    }

    //이메일로 찾기
    @Override
    public Member selectMemberByEmail(String email) {

        StringBuffer sql = new StringBuffer();
        sql.append("select member_num, ");
        sql.append("       id, ");
        sql.append("       name, ");
        sql.append("       pw, ");
        sql.append("       tel, ");
        sql.append("       email, ");
        sql.append("       birth, ");
        sql.append("       gender, ");
        sql.append("       nickname, ");
        sql.append("       cdate, ");
        sql.append("       udate ");
        sql.append("  from member ");
        sql.append(" where email = ? ");

        Member member = jdbcTemplate.queryForObject(
                sql.toString(),
                new BeanPropertyRowMapper<>(Member.class),
                email
        );
        return member;
    }

    //닉네임으로 찾기
    @Override
    public Member selectMemberByNickname(String nickname) {

        StringBuffer sql = new StringBuffer();
        sql.append("select member_num, ");
        sql.append("       id, ");
        sql.append("       name, ");
        sql.append("       pw, ");
        sql.append("       tel, ");
        sql.append("       email, ");
        sql.append("       birth, ");
        sql.append("       gender, ");
        sql.append("       nickname, ");
        sql.append("       cdate, ");
        sql.append("       udate ");
        sql.append("  from member ");
        sql.append(" where nickname = ? ");

        Member member = jdbcTemplate.queryForObject(
                sql.toString(),
                new BeanPropertyRowMapper<>(Member.class),
                nickname
        );
        return member;
    }

    //전체조회
    @Override
    public List<Member> selectAll() {
        StringBuffer sql = new StringBuffer();

        sql.append("select member_num, ");
        sql.append("       id, ");
        sql.append("       name, ");
        sql.append("       pw, ");
        sql.append("       tel, ");
        sql.append("       email, ");
        sql.append("       birth, ");
        sql.append("       gender, ");
        sql.append("       nickname, ");
        sql.append("       cdate, ");
        sql.append("       udate ");
        sql.append("  from member ");
        sql.append(" order by member_num desc ");

        List<Member> list = jdbcTemplate.query(
                sql.toString(),
                new BeanPropertyRowMapper<>(Member.class)
        );

        return list;
    }

    //탈퇴
    @Override
    public void deleteMember(Long memberNum) {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from member ");
        sql.append(" where member_num = ? ");

        jdbcTemplate.update(sql.toString(), memberNum);
    }

    //회원유무 체크
    //회원유무 체크
    @Override
    public boolean existId(String id) {

        String sql = "select count(id) from member where id = ? ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return (count==1) ? true : false;

    }

    @Override
    public boolean existEmail(String email) {

        String sql = "select count(email) from member where email= ? ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);

        return (count==1) ? true : false;
    }

    @Override
    public boolean existNickname(String nickname) {

        String sql = "select count(nickname) from member where nickname= ? ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, nickname);

        return (count==1) ? true : false;
    }

    //로그인 인증
    @Override
    public Member login(String id, String pw) {

        StringBuffer sql = new StringBuffer();
        sql.append(" select member_num as member, id, nickname ");
        sql.append("  from member ");
        sql.append(" where id = ? and pw = ? ");

        // 레코드1개를 반환할경우 query로 list를 반환받고 list.size() == 1 ? list.get(0) : null 처리하자!!
        List<Member> list = jdbcTemplate.query(
                sql.toString(),
                new BeanPropertyRowMapper<>(Member.class),  //자바객체 <=> 테이블 레코드 자동 매핑
                id, pw
        );

        return list.size() == 1 ? list.get(0) : null;
    }

    //비밀번호 일치여부 체크
    @Override
    public boolean isMember(String id, String pw) {

        StringBuffer sql = new StringBuffer();
        sql.append("select count(*) ");
        sql.append("  from member ");
        sql.append(" where id = ? and pw = ? ");

        Integer count = jdbcTemplate.queryForObject(
                sql.toString(), Integer.class, id, pw
        );

        return (count == 1) ? true : false;
    }

    //아이디찾기
    @Override
    public String findIdByNickname(String nickname) {
        StringBuffer sql = new StringBuffer();
        sql.append("select id ");
        sql.append("  from member ");
        sql.append(" where nickname = ? ");

        List<String> result = jdbcTemplate.query(
                sql.toString(),
                new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getNString("id");
                    }
                },
                nickname
        );

        return (result.size() == 1) ? result.get(0) : null;
    }
}
