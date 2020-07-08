package com.derby;

import com.derby.dao.ImageDaoRepo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ImageDaoRepo.class)
@ComponentScan
public class ImagerMsApplication {
	@Bean(name = "mapper")
	public Mapper dozerBean() {
		return new DozerBeanMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(ImagerMsApplication.class, args);
	}

}
