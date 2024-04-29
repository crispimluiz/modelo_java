package com.crud.modelo.controller;

import com.crud.modelo.model.ProdutoModel;
import com.crud.modelo.model.valoresProdutos.CalculoDesconto;
import com.crud.modelo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtosService;

    @GetMapping(path = "/produtos")
    public List<ProdutoModel> buscarTodosProdutos(){
        return produtosService.buscarTodos();
    }

    @GetMapping(path = "/produtos/{codigo}")
    public Optional<ProdutoModel> buscarPorId(@PathVariable Long codigo){
        return produtosService.buscarId(codigo);
    }

    @PostMapping(path = "/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel cadastrarProdutos(@RequestBody ProdutoModel produtosModel, CalculoDesconto calculoDesconto){
        return produtosService.cadastrar(produtosModel, calculoDesconto);
    }

    @PutMapping(path = "/produtos/{codigo}")
    public ProdutoModel alterarProdutos(@RequestBody ProdutoModel produtos){
        return produtosService.alterar(produtos);
    }

    @DeleteMapping(path = "/produtos/{codigo}")
    public void deletarProdutos(@PathVariable Long codigo){
        produtosService.deletar(codigo);
    }
}
