package com.twitterclone.twitterclonebackend.tweet.repository;

import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}