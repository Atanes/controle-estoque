package com.iridiumit.controleestoque.repositories;

import com.iridiumit.controleestoque.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
