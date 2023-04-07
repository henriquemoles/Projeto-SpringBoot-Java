package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository_old;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository_old produtoRepository;
 
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    public Optional<Produto> obterPorId(Integer id){
       return produtoRepository.obterPorId(id);
    }

    public Produto adicionarProduto(Produto produto){
        return produtoRepository.adicionarProduto(produto);
    }

    public void deletarProduto(Integer id){
        produtoRepository.deletarProduto(id);
    }
    public Produto alterarProduto(Produto produto, Integer id){
        produto.setId(id);
        return produtoRepository.alterarProduto(produto);
     }
}
