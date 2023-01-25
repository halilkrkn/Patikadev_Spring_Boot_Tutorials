package com.halilkrkn.springboottutorials.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class _6_JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    //need default constructor for JSON Parsing
    private String username;
    private String password;
}
