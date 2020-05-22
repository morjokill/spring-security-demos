package spring.security.in_memory_auth_with_entry_point.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void gettingSecuredUrlWithoutAuthShouldReturn401() throws Exception {
        ResponseEntity<String> result = template.getForEntity("/secured/hello", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    @Test
    public void gettingSecuredUrlWithoutAuthShouldReturn401AndResponseBody() throws Exception {
        ResponseEntity<String> result = template.getForEntity("/secured/hello", String.class);
        assertEquals("HTTP Status 401 - YOU NEED TO HAVE POWER TO ENTER MY KINGDOM!", result.getBody());
    }

    @Test
    public void gettingSecuredUrlWithAuthShouldReturn200() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("obi_wan", "kenobi")
                .getForEntity("/secured/hello", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void gettingUnsecuredUrlShouldReturn200() throws Exception {
        ResponseEntity<String> result = template.getForEntity("/public/hello", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}