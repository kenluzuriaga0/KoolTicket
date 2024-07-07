package nek.koolticket;

import java.security.SecureRandom;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KoolTicketApplicationTests {

	@Test
	void contextLoads() {
		
        SecureRandom secureRandom = new SecureRandom();

        byte[] secretKeyBytes = new byte[32];
        secureRandom.nextBytes(secretKeyBytes);

        String SECRET_KEY = Base64.getEncoder().encodeToString(secretKeyBytes);

        System.out.println(SECRET_KEY);
	}

}
