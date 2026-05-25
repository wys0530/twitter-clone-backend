package com.twitterclone.twitterclonebackend.tweet.controller;

import com.twitterclone.twitterclonebackend.tweet.dto.request.TweetCreateRequest;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetCreateResponse;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetDetailResponse;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetListResponse;
import com.twitterclone.twitterclonebackend.tweet.service.TweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService tweetService;

    //트윗 작성
    @PostMapping
    public ResponseEntity<TweetCreateResponse> createTweet(
            @RequestHeader("Auth-id") Long userId,
            @Valid @RequestBody TweetCreateRequest request
    ) {
        TweetCreateResponse response = tweetService.createTweet(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //트윗 개별 조회
    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetDetailResponse> getTweet(@PathVariable Long tweetId) {
        return ResponseEntity.ok(tweetService.getTweet(tweetId));
    }


    //트윗 전체 조회
    @GetMapping
    public ResponseEntity<TweetListResponse> getTweets() {
        return ResponseEntity.ok(tweetService.getTweets());
    }

    //트윗 삭제
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(
            @PathVariable Long tweetId,
            @RequestHeader("Auth-id") Long userId
    ) {
        tweetService.deleteTweet(tweetId, userId);
        return ResponseEntity.noContent().build();
    }
}