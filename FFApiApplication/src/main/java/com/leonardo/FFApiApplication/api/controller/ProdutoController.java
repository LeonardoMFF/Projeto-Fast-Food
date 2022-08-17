/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.leonardo.FFApiApplication.api.controller;

import com.leonardo.FFApiApplication.domain.model.Produto;
import com.leonardo.FFApiApplication.domain.repository.ProdutoRepository;
import com.leonardo.FFApiApplication.domain.service.ProdutoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
            
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/produto")
    public List<Produto> showAllProduto() {
        return produtoRepository.findAll();
    }
    
    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<Produto> showPedido(@PathVariable Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addPedido(@RequestBody Produto produto) {
        
        produtoService.salvar(produto);
        
        return produto;
    }
    
    @PutMapping("/produto/{produtoID}")
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoID,
            @RequestBody Produto produto) {
        
        //verificar se o cliente existe
        if(!produtoRepository.existsById(produtoID)) {
            return ResponseEntity.notFound().build();
        }
        
        produto.setId(produtoID);
        produto = produtoService.salvar(produto);
        return ResponseEntity.ok(produto);
        
    }
    
    @DeleteMapping("/produto/{produtoID}")
    public ResponseEntity<Void> excluir (@PathVariable Long clienteID) {
        //verifica se o cliente existe ou não
        
        if (!produtoRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        
        produtoService.excluir(clienteID);
        return ResponseEntity.noContent().build();
        
    }
    // TODO Implementar métodos POST PUT DELET    
    
}
