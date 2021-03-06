package br.com.bandtec.bora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.bandtec.bora.model.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Usuario findByIdUsuario(String usuario);
	
	Usuario findByApelido(String usuario); 
	
}

