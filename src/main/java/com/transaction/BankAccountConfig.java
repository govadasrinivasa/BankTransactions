package com.transaction;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountConfig {

	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
