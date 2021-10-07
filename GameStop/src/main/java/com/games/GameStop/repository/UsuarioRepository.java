package com.games.GameStop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.GameStop.model.Usuario;



public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);

}
	
