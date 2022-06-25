package com.users.app.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String identification;

    private String name;

    private String email;
}
