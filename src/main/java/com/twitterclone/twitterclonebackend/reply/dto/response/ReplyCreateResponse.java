package com.twitterclone.twitterclonebackend.reply.dto.response;

import com.twitterclone.twitterclonebackend.reply.domain.Reply;

public record ReplyCreateResponse(
        Long replyId,
        String content
) {
    public static ReplyCreateResponse from(Reply reply) {
        return new ReplyCreateResponse(
                reply.getReplyId(),
                reply.getContent()
        );
    }
}