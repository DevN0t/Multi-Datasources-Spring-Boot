package org.devnot.multidatabase;

import org.devnot.multidatabase.modules.main.dto.MainDTO;
import org.devnot.multidatabase.modules.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
public class MultidatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultidatabaseApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(JdbcClient postJdbcClient,
	@Qualifier("mainJdbcClient") JdbcClient mainJdbcClient){
		return args -> {
			System.out.println(postJdbcClient.sql("SELECT * FROM users").query(UserDTO.class).list());
			System.out.println(mainJdbcClient.sql("SELECT * FROM maincontent").query(MainDTO.class).list());
		};
	}
}
