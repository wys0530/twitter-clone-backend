package com.twitterclone.twitterclonebackend.tweet.dto.response;

import java.util.List;

public record TweetUserListResponse(
        List<TweetDetailResponse> tweets,
        int count
) {
}