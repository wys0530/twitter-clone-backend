package com.twitterclone.twitterclonebackend.reply.dto.response;

import java.util.List;

public record ReplyListResponse(
        List<ReplyResponse> replies,
        int count
) {
}