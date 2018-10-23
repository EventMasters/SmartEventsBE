package com.sample.smartevents.controller;

import com.sample.smartevents.rest.mediatypes.User;
import com.sample.smartevents.rest.services.UserResourceService;
import com.sample.smartevents.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users", produces = {MediaTypes.HAL_JSON_VALUE})
@ExposesResourceFor(User.class)
@Slf4j
public class UserController {

    private EntityLinks entityLinks;

    private UserService userService;

    private UserResourceService userResourceService;

    //Constructor based dependency injection
    @Autowired
    public UserController(EntityLinks entityLinks, UserService userService, UserResourceService userResourceService) {
        this.entityLinks = entityLinks;
        this.userService = userService;
        this.userResourceService = userResourceService;
    }

    @GetMapping
    HttpEntity<Resources<Resource<User>>> getUsers() {
        List<com.sample.smartevents.domain.User> userList = userService.getUsers();
        List<Resource<User>> temp = new ArrayList<>();

        for (com.sample.smartevents.domain.User user : userList) {
            Resource<User> userResource = userResourceService.getUserResource(user.getId(), userResourceService.getUserMediaType(user), false);
            temp.add(userResource);
        }
        LinkBuilder lb = entityLinks.linkFor(User.class);
        return new ResponseEntity<>(new Resources<>(temp, lb.withSelfRel()), HttpStatus.OK);
    }


}
