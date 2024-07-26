package com.jj.hello_blog.domain.member.repository;

import com.jj.hello_blog.domain.member.dto.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        // Given
        Member member = getMember();

        // When
        memberRepository.signUp(member);

        // Then
        Assertions.assertThat(member.getId()).isNotNull();
    }

    @Test
    @DisplayName("이메일로 멤버 조회 테스트")
    void findMemberByEmail() {
        // Given
        Member member = getMember();
        memberRepository.signUp(member);

        // When
        Optional<Member> existMember = memberRepository.findMemberByEmail(member.getEmail());

        // Then
        Assertions.assertThat(existMember.get().getId().equals(member.getId())).isTrue();
    }

    /**
     * getMember, 멤버 데이터 생성 유틸
     *
     * @return 멤버
     */
    public static Member getMember() {
        return new Member(null, "test@test.com", "123456");
    }

}