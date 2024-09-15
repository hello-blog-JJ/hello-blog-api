package com.jj.hello_blog.domain.member.exception;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import com.jj.hello_blog.domain.common.exception.ExceptionCode;

@RequiredArgsConstructor
public enum MemberExceptionCode implements ExceptionCode {

    // 이메일 or 비밀번호가 일치하지 않을 시
    SIGN_IN_FAILED("SIGN_IN_FAILED", HttpStatus.BAD_REQUEST);

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public HttpStatus httpStatus() {
        return this.httpStatus;
    }

    private final String code;

    private final HttpStatus httpStatus;

}
