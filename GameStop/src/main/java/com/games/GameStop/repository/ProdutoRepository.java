package com.games.GameStop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.games.GameStop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByPlataformaContainingIgnoreCase(String plataforma);

}
