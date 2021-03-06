package com.derby;

import com.derby.dao.UserDaoRepo;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDaoRepo.class)
@ComponentScan
@EnableCaching
@EnableScheduling
@EnableDiscoveryClient
public class ProfileMsApplication {

	@Bean(name = "mapper")
	public Mapper dozerBean() {
		return new DozerBeanMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProfileMsApplication.class, args);
	}

}
