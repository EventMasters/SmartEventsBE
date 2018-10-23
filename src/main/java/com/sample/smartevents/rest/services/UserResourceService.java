package com.sample.smartevents.rest.services;

import com.sample.smartevents.rest.mediatypes.User;
import org.springframework.hateoas.Resource;

import java.util.UUID;

public interface UserResourceService {

    Resource<User> getUserResource(UUID userId, User contactMediaType, boolean generateBackLink);

    User getUserMediaType(com.sample.smartevents.domain.User user);

}
