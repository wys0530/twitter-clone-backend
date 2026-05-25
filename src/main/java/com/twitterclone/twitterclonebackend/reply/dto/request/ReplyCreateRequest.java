package com.twitterclone.twitterclonebackend.reply.dto.request;

import com.twitterclone.twitterclonebackend.reply.domain.Reply;
import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReplyCreateRequest {

    @NotBlank(message = "답글 내용은 필수입니다.")
    private String content;

    public Reply toEntity(Tweet tweet, User user) {
        return new Reply(content, tweet, user);
    }
}