package com.halilkrkn.springboottutorials.security.jwt;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Log4j2
public class _8_JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private _3_UserRepository  userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //database böyle bir kullanıcı var mı?
        _2_UserEntity user = (_2_UserEntity) userDao.findByUsername(username);

        if (user == null) {
            log.error("Böyle bir kullanıcı Yoktur");
            throw new UsernameNotFoundException("Böyle bir kullanıcı yoktur " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    //Database Username ve Passwordu set
    //password: maskelenmiş ==> maskeyi kaldırmak bcryptEncoder
    public _2_UserEntity save(_1_UserDto user) {
        _2_UserEntity newUser = new _2_UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }
}
