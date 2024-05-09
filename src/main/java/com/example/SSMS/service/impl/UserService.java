package com.example.SSMS.service.impl;

import com.example.SSMS.model.AppUser;
import com.example.SSMS.model.enums.Roles;
import com.example.SSMS.repository.UserDAO;
import com.example.SSMS.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceI {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userDAO.findByEmail(username)
                        .orElseThrow(()->new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public void createSuperAdminIfNotExists() {
        AppUser super_admin = userDAO.findByRole(Roles.SUPER_ADMIN);
        AppUser user = new AppUser();
        if(super_admin == null){
            user.setRole(Roles.SUPER_ADMIN);
            user.setEmail("admin@mail.com");
            user.setPassword(new BCryptPasswordEncoder().encode("admin1234"));
            user.setEmployee(null);
            userDAO.save(user);
        }
    }
}
