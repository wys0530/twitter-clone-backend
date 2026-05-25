package com.twitterclone.twitterclonebackend.tweet.controller;

import com.twitterclone.twitterclonebackend.tweet.dto.request.TweetCreateRequest;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetCreateResponse;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetDetailResponse;
import com.twitterclone.twitterclonebackend.tweet.service.TweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService tweetService;

    //트윗 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetCreateResponse createTweet(
            @RequestHeader("Auth-id") Long userId,
            @Valid @RequestBody TweetCreateRequest request
    ) {
        return tweetService.createTweet(userId, request);
    }

    //트윗 개별 조회
    @GetMapping("/{tweetId}")
    public TweetDetailResponse getTweet(@PathVariable Long tweetId) {
        return tweetService.getTweet(tweetId);
    }
}