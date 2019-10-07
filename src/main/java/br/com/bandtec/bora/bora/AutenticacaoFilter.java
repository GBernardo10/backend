package br.com.bandtec.bora.bora;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.bandtec.bora.model.entity.Usuario;
import br.com.bandtec.bora.repository.UsuarioRepositorio;

public class AutenticacaoFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;
	private UsuarioRepositorio usuarioRepositorio;

	public AutenticacaoFilter(TokenService tokenService, UsuarioRepositorio usuarioRepositorio) {
		this.tokenService = tokenService;
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean tokenValido = tokenService.isTokenValido(token);
		
		if(tokenValido) {
			autenticarCliente(token);
		}
				
		filterChain.doFilter(request, response);
	
	}

	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;	
		}
		return token.substring(7, token.length());
		
	}

}
