package com.sr.colleges.lms.config;

import com.sr.colleges.lms.service.AdminService;
import com.sr.colleges.lms.service.AdminServiceImpl;
import com.sr.colleges.lms.service.UserService;
import com.sr.colleges.lms.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfiguration {

    @Bean
    @Primary
    public AdminService getAdminService() {
        return new AdminServiceImpl();
    }

    @Bean
    @Primary
    public UserService getUserService() {
        return new UserServiceImpl();
    }


}
