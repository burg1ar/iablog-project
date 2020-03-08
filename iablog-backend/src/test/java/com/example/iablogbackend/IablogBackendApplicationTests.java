package com.example.iablogbackend;

import com.example.iablogbackend.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@EnableConfigurationProperties(IablogBackendApplicationTests.class)
@ConfigurationProperties(prefix = "jwt.config")
class IablogBackendApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("11235"));
        // 结果记录：$2a$10$04ugCMXvDhGYWAmo2uUJqeMefVCUfpkF581M.r/xgZ8HTJx.4oSnW
    }

    @Autowired
    UserRepository userRepository;

    @Test
    void userRepoTest() throws JsonProcessingException {
        String userInfoJson=new ObjectMapper().writeValueAsString(userRepository.findUserByUserName("ai"));
        System.out.println(userInfoJson);
    }

    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Test
    void readYmlTest(){
        // 必须要设置secret的get和set方法，才能读取到yml的属性
        System.out.println(secret);
    }

}
