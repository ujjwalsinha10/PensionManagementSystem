package com.cts.authorization.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cts.authorization.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Test class to test all the repository functionality
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
@SpringBootTest
@Slf4j
class UserRepositoryTests {
	private static final Logger log = LogManager.getLogger(UserRepositoryTests.class);
	@Autowired
	private UserRepository userRepository;

	@Test
	@DisplayName("This method is responsible to test findById() method when user exists in database")
	void testFindUserById_userExists() {
		log.info("START - testFindUserById_userExists()");
		final String username = "admin1";
		Optional<User> userOptional = userRepository.findById(username);
		assertTrue(userOptional.isPresent());
		assertEquals(username, userOptional.get().getUsername());
		log.info("END - testFindUserById_userExists()");
	}

	@Test
	@DisplayName("This method is responsible to test findById() method when user doesn not exists in database")
	void testFindUserById_userDoesNotExists() {
		log.info("START - testFindUserById_userDoesNotExists()");
		final String id = "adminDoesNotExist";
		Optional<User> userOptional = userRepository.findById(id);
		assertTrue(userOptional.isEmpty());
		log.info("END - testFindUserById_userDoesNotExists()");
	}
}
