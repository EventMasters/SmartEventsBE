package com.sample.smartevents.service.impl;

import com.google.common.collect.Lists;
import com.sample.smartevents.domain.User;
import com.sample.smartevents.repository.UserRepository;
import com.sample.smartevents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }
}
