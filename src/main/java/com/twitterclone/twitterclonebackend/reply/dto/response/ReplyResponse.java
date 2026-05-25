package com.twitterclone.twitterclonebackend.reply.dto.response;

import com.twitterclone.twitterclonebackend.reply.domain.Reply;
import com.twitterclone.twitterclonebackend.user.dto.response.UserSummaryResponse;

import java.time.LocalDateTime;

public record ReplyResponse(
        Long replyId,
        Long tweetId,
        UserSummaryResponse author,
        String content,
        LocalDateTime createdAt
) {
    public static ReplyResponse from(Reply reply) {
        return new ReplyResponse(
                reply.getReplyId(),
                reply.getTweet().getTweetId(),
                UserSummaryResponse.from(reply.getUser()),
                reply.getContent(),
                reply.getCreatedAt()
        );
    }
}