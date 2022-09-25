package com.iridiumit.controleestoque.dtos;

import com.iridiumit.controleestoque.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDTO {
  Long id;
  String descricao;
  float qtdEstoque;
  BigDecimal valor;


  public ProdutoDTO(Produto produto) {
    this.id = produto.getId();
    this.descricao = produto.getDescricao();
    this.qtdEstoque = produto.getQtdEstoque();
    this.valor = produto.getValor();
  }

}
