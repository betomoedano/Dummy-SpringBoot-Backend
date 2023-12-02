package dev.cwb.myBackend;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MyBackendApplicationTests {

	private static final Logger LOGGER = Logger.getLogger(MyBackendApplicationTests.class.getName());

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserController userController;

	@Test
		void contextLoads() {
	}

 @Test
    public void testFindById_UserExists() {
        UUID userId = UUID.fromString("34a8651e-da01-409e-a941-0007b4dc9ed3");
        LOGGER.info("Testing findById with user ID: " + userId);

        UserEntity mockUser = new UserEntity();
        mockUser.setId(userId);
        LOGGER.info("Mock user created: " + mockUser);

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        LOGGER.info("userRepository.findById() mocked");

        ResponseEntity<UserEntity> response = userController.findById(userId);
        LOGGER.info("Response received: " + response);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        LOGGER.info("Status code is 2xx successful");

        assertEquals(userId, response.getBody().getId());
        LOGGER.info("User ID in the response matches the expected ID");
    }
}
