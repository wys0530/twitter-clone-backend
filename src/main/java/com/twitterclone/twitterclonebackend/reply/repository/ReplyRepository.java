package com.twitterclone.twitterclonebackend.reply.repository;

import com.twitterclone.twitterclonebackend.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    int countByTweet_TweetId(Long tweetId);
}