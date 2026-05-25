package com.twitterclone.twitterclonebackend.tweet.dto.response;

import java.util.List;

public record TweetListResponse(
        List<TweetDetailResponse> tweets
) {
}