package com.apex.copilotapi.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    // add same fields as Users entity
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String status;
    private String username;

}
