package com.jj.hello_blog.domain.member.service;

import com.jj.hello_blog.domain.member.dto.Member;
import com.jj.hello_blog.domain.member.dto.MemberSignInDto;
import com.jj.hello_blog.domain.member.dto.MemberSignUpDto;
import com.jj.hello_blog.domain.member.exception.MemberExceptionCode;
import com.jj.hello_blog.domain.member.repository.MemberRepository;
import com.jj.hello_blog.domain.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * signIn, 로그인
     */
    public Member signIn(MemberSignInDto memberSignInDto) {
        Optional<Member> member = memberRepository.findMemberByEmail(memberSignInDto.getEmail());

        if (member.isPresent() && member.get().getPassword().equals(memberSignInDto.getPassword())) {
            return member.get();
        }

        throw new CustomException(MemberExceptionCode.SIGN_IN_FAILED);
    }

    /**
     * signUp, 회원가입
     */
    public Member signUp(MemberSignUpDto memberSignUpDto) {
        Member member = new Member(null, memberSignUpDto.getEmail(), memberSignUpDto.getPassword());

        memberRepository.saveMember(member);

        return member;
    }

    /**
     * signOut, 회원탈퇴
     */
    public boolean deleteMember(int id) {
        memberRepository.deleteMember(id);
        return true;
    }

    /**
     * checkDuplicatedEmail, 회원가입 전 중복 이메일 확인
     */
    public boolean checkDuplicatedEmail(String email) {
        return memberRepository.findMemberByEmail(email).isPresent();
    }

}
