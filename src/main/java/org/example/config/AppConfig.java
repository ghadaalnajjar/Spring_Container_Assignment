package org.example.config;

import org.example.data_access.StudentDao;
import org.example.data_access.StudentDaoListImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.*")
public class AppConfig {

    @Bean("studentDao")
    public StudentDao accountDao() {
        return new StudentDaoListImp();
    }
}
