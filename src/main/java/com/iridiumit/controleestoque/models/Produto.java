package com.iridiumit.controleestoque.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String categoria;
  String descricao;
  float qtdEstoque;
  BigDecimal valor;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Produto produto = (Produto) o;
    return id != null && Objects.equals(id, produto.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
