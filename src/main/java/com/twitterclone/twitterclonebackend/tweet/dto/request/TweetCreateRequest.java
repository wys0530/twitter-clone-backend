package com.twitterclone.twitterclonebackend.tweet.dto.request;

import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TweetCreateRequest {

    @NotBlank(message = "트윗 내용은 필수입니다.")
    private String content;

    public Tweet toEntity(User user) {
        return new Tweet(content, user);
    }
}