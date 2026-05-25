package com.twitterclone.twitterclonebackend.tweet.dto.response;

import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.user.dto.response.UserSummaryResponse;

import java.time.LocalDateTime;

public record TweetDetailResponse(
        Long tweetId,
        UserSummaryResponse author,
        String content,
        LocalDateTime createdAt,
        int likeCount,
        int replyCount,
        int retweetCount,
        int viewCount
) {
    public static TweetDetailResponse from(Tweet tweet, int replyCount) {
        return new TweetDetailResponse(
                tweet.getTweetId(),
                UserSummaryResponse.from(tweet.getUser()),
                tweet.getContent(),
                tweet.getCreatedAt(),
                0,
                replyCount,
                0,
                tweet.getViewCount()
        );
    }
}