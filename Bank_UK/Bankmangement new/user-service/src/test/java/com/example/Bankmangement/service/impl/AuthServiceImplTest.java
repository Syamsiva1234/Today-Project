import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Bankmangement.controller.AuthController;
import com.example.Bankmangement.payload.JwtAuthResponse;
import com.example.Bankmangement.payload.LoginDto;
import com.example.Bankmangement.service.AuthService;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private LoginDto loginDto;
    private String token;

    @Before
    public void setUp() {
        loginDto = new LoginDto();
        loginDto.setUsername("username");
        loginDto.setPassword("password");
        token = "token";
    }

    @Test
    public void testLogin() {
        when(authService.login(any(LoginDto.class))).thenReturn(token);
        ResponseEntity<JwtAuthResponse> response = authController.login(loginDto);
        JwtAuthResponse jwtAuthResponse = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(token, jwtAuthResponse.getAccessToken());
    }
}
