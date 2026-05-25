package com.twitterclone.twitterclonebackend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Default
    INTERNAL_SERVER_ERROR(500, "예상치 못한 서버에러가 발생했습니다."),
    ERROR(400, "잘못된 요청입니다."),

    //user
    USER_NOT_FOUND(404, "존재하지 않는 유저입니다."),

    //tweet
    TWEET_FORBIDDEN(403, "권한이 없는 사용자입니다."),
    TWEET_NOT_FOUND(404, "존재하지 않는 트윗입니다."),

    //reply
    REPLY_NOT_FOUND(404, "존재하지 않는 답글입니다.");

    private final int status;
    private final String message;
}