package com.apiTest.service;

import com.apiTest.User.model.User;
import com.apiTest.authentication.model.UserPrincipal;
import com.apiTest.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class QuizUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user==null)
            throw new UsernameNotFoundException("That e-mail is not registered");

        return new UserPrincipal(user);
    }

}
