package com.example.interviewtask.infrastructure.security;

import com.example.interviewtask.domain.user.UserRepository;
import com.example.interviewtask.infrastructure.database.user.UserDataMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    public UserDetailsServiceImpl(
            @Qualifier("createUserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserDataMapper user = userRepository.findByUsername(username)
                .get();
        if (user == null) {
            throw new UsernameNotFoundException("UserNotFound");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getId(), user.getPassword(), user.getAuthorities());
    }
}