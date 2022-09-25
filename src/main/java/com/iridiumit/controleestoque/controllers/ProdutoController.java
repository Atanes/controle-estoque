package com.iridiumit.controleestoque.controllers;

import com.iridiumit.controleestoque.dtos.ProdutoDTO;
import com.iridiumit.controleestoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

  @Autowired
  ProdutoService service;

  @GetMapping(value = "/{id}")
  public ProdutoDTO findById(@PathVariable Long id){
    return service.getProdutoById(id);
  }

  @GetMapping(value = "/listar-todos")
  public List<ProdutoDTO> findAll(){
    return service.getAll();
  }

  @GetMapping(value = "/por-categoria")
  public Map<String, List<ProdutoDTO>> orderByCategory(){
    return service.groupedByCategory();
  }

}
