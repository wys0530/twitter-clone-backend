package com.twitterclone.twitterclonebackend.tweet.dto.response;

import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;

public record TweetCreateResponse(
        Long tweetId,
        String content
) {
    public static TweetCreateResponse from(Tweet tweet) {
        return new TweetCreateResponse(
                tweet.getTweetId(),
                tweet.getContent()
        );
    }
}