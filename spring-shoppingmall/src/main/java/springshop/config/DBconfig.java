package springshop.config;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springshop.repository.JpaUserRepository;
import springshop.repository.UserRepository;
import springshop.service.UserService;
@EnableJpaAuditing
@Configuration
public class DBconfig {
	
	 private EntityManager em;
	 
	 @Autowired	
		public DBconfig(EntityManager em) {
			this.em = em;
		}
	
	@Bean
	public UserService userService() { return new UserService(userRepository()); }

	@Bean
	public UserRepository userRepository() {
		return new JpaUserRepository(em);
	}


}