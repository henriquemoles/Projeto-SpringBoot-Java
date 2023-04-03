package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;

@Repository
public class ProdutoRepository {
    
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    public List<Produto> obterTodos(){
      produtos.sort(Comparator.comparing(Produto::getId));
        return produtos;
    }
    
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream()
        .filter(produto -> Objects.equals(produto.getId(), id))
        .findFirst();
    }

    public Produto adicionarProduto(Produto produto){
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    public void deletarProduto(Integer id){
        produtos.removeIf(produto -> Objects.equals(produto.getId(), id));
    }

    public Produto alterarProduto(Produto produto){
       Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
       if(produtoEncontrado.isEmpty()){
        throw new InputMismatchException("Produto não encontrado!");
       }
       deletarProduto(produto.getId());

       produtos.add(produto);
       return produto;
    }
}