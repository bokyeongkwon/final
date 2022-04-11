package com146.HOME.CA.BE.domain.member.dao;

import com146.HOME.CA.BE.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberDAOImplTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    @DisplayName("등록")
    void insertMember() {
        Member member = new Member("test1", "테스터1", "1234", "010-1234-1234", "test1@kh.com", "20220401", "테스터1");
        Member savedMember = memberDAO.insertMember(member);
        savedMember.setMemberNum(null);
        Assertions.assertThat(savedMember).usingRecursiveComparison().isEqualTo(member);
    }
}