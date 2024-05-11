package com.fcfm.backend.utils;

import com.fcfm.backend.model.Alumno;
import com.fcfm.backend.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;

public class UserMapper {

    public static com.fcfm.backend.model.User userEntityToUserModel(User user){
        com.fcfm.backend.model.User model = new com.fcfm.backend.model.User();
        model.setUsername(user.getUsername());
        model.setPass(user.getPassword());

        return model;
    }

    public static User userModelToUserEntity(com.fcfm.backend.model.User user){
        User entity = new User();
        entity.setUsername(user.getUsername());
        entity.setPass(user.getPass());

        return entity;
    }
}
