package com.twitterclone.twitterclonebackend.user.repository;

import com.twitterclone.twitterclonebackend.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}