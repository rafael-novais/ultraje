package ultraje.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ultraje.config.security.TokenService;
import ultraje.domain.dto.client.ClientLogin;

@RequestMapping("/auth")
@RestController()
public class AuthController {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody @Valid ClientLogin login){
		
		try {
			Authentication auth =
					authManager.authenticate(login.getUPAT());	
			
			String token = tokenService.generateToken(auth);
			
			return ResponseEntity.ok().body(token);
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
