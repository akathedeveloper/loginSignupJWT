package com.loginSignupJWT;

import com.loginSignupJWT.entities.Role;
import com.loginSignupJWT.entities.User;
import com.loginSignupJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginSignupJwtApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoginSignupJwtApplication.class, args);
	}


	public void run(String... args) {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null==adminAccount){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstname("admin");
			user.setSecondname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);

		}
	}
}
