package com.twitterclone.twitterclonebackend.reply.service;

import com.twitterclone.twitterclonebackend.global.exception.CustomException;
import com.twitterclone.twitterclonebackend.global.exception.ErrorCode;
import com.twitterclone.twitterclonebackend.reply.domain.Reply;
import com.twitterclone.twitterclonebackend.reply.dto.request.ReplyCreateRequest;
import com.twitterclone.twitterclonebackend.reply.dto.response.ReplyCreateResponse;
import com.twitterclone.twitterclonebackend.reply.repository.ReplyRepository;
import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.tweet.repository.TweetRepository;
import com.twitterclone.twitterclonebackend.user.domain.User;
import com.twitterclone.twitterclonebackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    @Transactional
    public ReplyCreateResponse createReply(
            Long tweetId,
            Long userId,
            ReplyCreateRequest request
    ) {

        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new CustomException(ErrorCode.TWEET_NOT_FOUND));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Reply reply = request.toEntity(tweet, user);

        Reply savedReply = replyRepository.save(reply);

        return ReplyCreateResponse.from(savedReply);
    }
}