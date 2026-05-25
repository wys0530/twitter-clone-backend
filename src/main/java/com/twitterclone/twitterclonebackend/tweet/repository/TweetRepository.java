package com.twitterclone.twitterclonebackend.tweet.repository;

import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByOrderByCreatedAtDesc();

    List<Tweet> findAllByUser_UserIdOrderByCreatedAtDesc(Long userId);
}