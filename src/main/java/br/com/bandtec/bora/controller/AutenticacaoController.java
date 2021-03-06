package br.com.bandtec.bora.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.bora.model.dto.TokenDTO;
import br.com.bandtec.bora.model.form.LoginForm;
import br.com.bandtec.bora.security.TokenService;


@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm loginForm) {
		UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
		try {
			Authentication auth = authManager.authenticate(dadosLogin);
			String token = tokenService.geraToken(auth);
			System.out.println("token usuario: "+ token);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));	
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
