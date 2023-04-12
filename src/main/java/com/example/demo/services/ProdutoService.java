package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
 
    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id){
       return produtoRepository.findById(id);
    }

    public Produto adicionarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }
    public Produto alterarProduto(Produto produto, Integer id){
        produto.setId(id);
        return produtoRepository.save(produto);
     }
}
