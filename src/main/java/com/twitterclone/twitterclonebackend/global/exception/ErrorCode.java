package com.twitterclone.twitterclonebackend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Default
    INTERNAL_SERVER_ERROR(500, "예상치 못한 서버에러가 발생했습니다."),
    ERROR(400, "요청 처리에 실패했습니다."),

    //user
    USER_NOT_FOUND(404, "존재하지 않는 유저입니다.");

    private final int status;
    private final String message;
}