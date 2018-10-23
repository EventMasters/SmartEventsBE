package com.sample.smartevents.rest.mediatypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.core.Relation;

import java.util.UUID;

@Relation
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private UUID id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String phoneNo;
}
