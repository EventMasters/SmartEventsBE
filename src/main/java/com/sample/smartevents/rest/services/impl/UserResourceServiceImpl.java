package com.sample.smartevents.rest.services.impl;

import com.sample.smartevents.rest.mediatypes.User;
import com.sample.smartevents.rest.services.UserResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserResourceServiceImpl implements UserResourceService {

    @Autowired
    private EntityLinks entityLinks;

    @Override
    public Resource<User> getUserResource(UUID userId, User userMediaType, boolean generateBackLink) {
        Resource<User> userResource = new Resource<>(userMediaType);
        LinkBuilder lb = entityLinks.linkFor(User.class, userId, userMediaType.getId());
        userResource.add(lb.slash(userMediaType.getId()).withSelfRel());
        if (generateBackLink) {
            userResource.add(lb.withRel("users"));
        }
        return userResource;
    }

    @Override
    public User getUserMediaType(com.sample.smartevents.domain.User user) {
        User userMediaType = new User();
        BeanUtils.copyProperties(user, userMediaType);

        if (user.getFirstName() != null) {
            userMediaType.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            userMediaType.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            userMediaType.setEmail(user.getEmail());
        }
        if (user.getUserName() != null) {
            userMediaType.setUserName(user.getUserName());
        }
        if (user.getPhoneNo() != null) {
            userMediaType.setPhoneNo(user.getPhoneNo());
        }

        return userMediaType;
    }


}
