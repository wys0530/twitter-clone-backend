package com.twitterclone.twitterclonebackend.tweet.service;

import com.twitterclone.twitterclonebackend.global.exception.CustomException;
import com.twitterclone.twitterclonebackend.global.exception.ErrorCode;
import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.tweet.dto.request.TweetCreateRequest;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetCreateResponse;
import com.twitterclone.twitterclonebackend.tweet.repository.TweetRepository;
import com.twitterclone.twitterclonebackend.user.domain.User;
import com.twitterclone.twitterclonebackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    @Transactional
    public TweetCreateResponse createTweet(Long userId, TweetCreateRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Tweet tweet = request.toEntity(user);

        Tweet savedTweet = tweetRepository.save(tweet);

        return TweetCreateResponse.from(savedTweet);
    }
}