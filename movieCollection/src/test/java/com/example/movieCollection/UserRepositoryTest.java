package com.example.movieCollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.movieCollection.domain.User;
import com.example.movieCollection.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void createNewUser() {
		User admin = new User("admin", "passwordhash", "ADMIN");
		repository.save(admin);
		assertThat(admin.getId()).isNotNull();
		assertThat(admin.getUsername()).isEqualTo("admin");
		assertThat(admin.getRole()).isEqualTo("ADMIN");
	}
	

}
