package com.irgek.Treydit;

import com.irgek.Treydit.domain.ERole;
import com.irgek.Treydit.domain.Gender;
import com.irgek.Treydit.domain.Role;
import com.irgek.Treydit.domain.Treyder;
import com.irgek.Treydit.service.TreyderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TreyditApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreyditApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(TreyderService treyderService){
		return args -> {
			/*treyderService.saveRole(new Role(null, "ROLE_TREYDR"));
			treyderService.saveRole(new Role(null, "ROLE_ADMIN"));
			treyderService.saveRole(new Role(null, "ROLE_MODERATOR"));

			treyderService.saveTreyder(new Treyder(null,"arschloch","aslanemil09@gmail.com","asdsadsdsdasd","Cemil","Aslan",Gender.MALE,"436641840791"));

			treyderService.addRoleToTreyder("arschloch","ROLE_TREYDR");

			treyderService.saveTreyder(new Treyder(null, "turkikaze", "aslancemil09@gmail.com", "asdsadsdsdasd", "Cemil", "Aslan", Gender.MALE, "436641840791"));
			treyderService.addRoleToTreyder("turkikaze","ROLE_TREYDR");
			*/

		};
	}

}
