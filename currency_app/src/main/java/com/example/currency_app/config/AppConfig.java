package com.example.currency_app.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
@Slf4j
public class AppConfig {

    @Bean
    public Server h2Server() throws SQLException {
        log.info("server h2 start");
        return Server.createTcpServer("-tcp", "-tcpPort", "9092", "-tcpAllowOthers", "-ifNotExists").start();
    }
}