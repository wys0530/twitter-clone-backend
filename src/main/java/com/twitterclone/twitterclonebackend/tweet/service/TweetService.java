package com.twitterclone.twitterclonebackend.tweet.service;

import com.twitterclone.twitterclonebackend.global.exception.CustomException;
import com.twitterclone.twitterclonebackend.global.exception.ErrorCode;
import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.tweet.dto.request.TweetCreateRequest;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetCreateResponse;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetDetailResponse;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetListResponse;
import com.twitterclone.twitterclonebackend.tweet.repository.TweetRepository;
import com.twitterclone.twitterclonebackend.user.domain.User;
import com.twitterclone.twitterclonebackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    //트윗 작성
    @Transactional
    public TweetCreateResponse createTweet(Long userId, TweetCreateRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Tweet tweet = request.toEntity(user);

        Tweet savedTweet = tweetRepository.save(tweet);

        return TweetCreateResponse.from(savedTweet);
    }

    //트윗 개별 조회
    @Transactional
    public TweetDetailResponse getTweet(Long tweetId) {

        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new CustomException(ErrorCode.TWEET_NOT_FOUND));

        tweet.increaseViewCount();

        return TweetDetailResponse.from(tweet);
    }

    //트윗 전체 조회
    @Transactional(readOnly = true)
    public TweetListResponse getTweets() {
        List<TweetDetailResponse> tweets = tweetRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(TweetDetailResponse::from)
                .toList();

        return new TweetListResponse(tweets);
    }
}