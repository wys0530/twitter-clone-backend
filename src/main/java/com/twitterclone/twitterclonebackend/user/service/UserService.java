package com.twitterclone.twitterclonebackend.user.service;

import com.twitterclone.twitterclonebackend.global.exception.CustomException;
import com.twitterclone.twitterclonebackend.global.exception.ErrorCode;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetDetailResponse;
import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetUserListResponse;
import com.twitterclone.twitterclonebackend.tweet.repository.TweetRepository;
import com.twitterclone.twitterclonebackend.user.domain.User;
import com.twitterclone.twitterclonebackend.user.dto.UserResponse;
import com.twitterclone.twitterclonebackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    @Transactional(readOnly = true)
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return UserResponse.from(user);
    }

    // 사용자별 트윗 조회
    @Transactional(readOnly = true)
    public TweetUserListResponse getUserTweets(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        List<TweetDetailResponse> tweets = tweetRepository.findAllByUser_UserIdOrderByCreatedAtDesc(user.getUserId())
                .stream()
                .map(TweetDetailResponse::from)
                .toList();

        return new TweetUserListResponse(tweets, tweets.size());
    }
}