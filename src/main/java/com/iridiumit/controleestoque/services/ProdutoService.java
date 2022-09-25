package com.iridiumit.controleestoque.services;

import com.iridiumit.controleestoque.dtos.ProdutoDTO;
import com.iridiumit.controleestoque.models.Produto;
import com.iridiumit.controleestoque.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

  @Autowired
  ProdutoRepository repository;

  public ProdutoDTO getProdutoById(Long id){
    return new ProdutoDTO(repository.findById(id).get());
  }

  public List<ProdutoDTO> getAll(){
    ArrayList<ProdutoDTO> listaDeProdutosDTO = new ArrayList<>();
    repository.findAll().forEach(produto -> listaDeProdutosDTO.add(new ProdutoDTO(produto)));
    return listaDeProdutosDTO;
  }

  public Map<String, List<ProdutoDTO>> groupedByCategory() {
    ArrayList<ProdutoDTO> listaDeProdutosDTO = new ArrayList<>();
    repository.findAll().forEach(produto -> listaDeProdutosDTO.add(new ProdutoDTO(produto)));

    Map<String, List<Produto>> produtosPorCategoria = repository.findAll()
        .stream()
        .collect(
            Collectors.groupingBy( // faz o agrupamento pelo que definirmos a seguir
                Produto::getCategoria
            )
        );
    Map<String, List<ProdutoDTO>> produtos = new HashMap<>();
    produtosPorCategoria.forEach((chave, valor)-> {
      List<ProdutoDTO> novaLista = new ArrayList<>();
      valor.forEach(produto ->
        novaLista.add(new ProdutoDTO(produto)));
      produtos.put(chave, novaLista);
    });
    return produtos;
  }
}
