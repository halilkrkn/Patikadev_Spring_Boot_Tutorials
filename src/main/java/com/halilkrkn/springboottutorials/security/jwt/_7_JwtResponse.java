package com.halilkrkn.springboottutorials.security.jwt;

import java.io.Serializable;

public class _7_JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    //parametreli constructor
    public _7_JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    //getter
    public String getToken() {
        return this.jwttoken;
    }
}
