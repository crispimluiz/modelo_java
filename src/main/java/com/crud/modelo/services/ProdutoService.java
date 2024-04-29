package com.crud.modelo.services;

import com.crud.modelo.model.ProdutoModel;
import com.crud.modelo.model.valoresProdutos.CalculoDesconto;
import com.crud.modelo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtosRepository;

    public List<ProdutoModel> buscarTodos(){
        return produtosRepository.findAll();
    }

    public Optional<ProdutoModel> buscarId(Long codigo){
        return produtosRepository.findById(codigo);
    }

    public ProdutoModel cadastrar(ProdutoModel produtosModel, CalculoDesconto calculoDesconto){
        Double resultado = calculoDesconto.descontoProduto(produtosModel.getValor(), produtosModel.getDescontoPorcentagem());
        Double resultadoFinal = calculoDesconto.valorFinal(produtosModel.getValor(), resultado);
        produtosModel.getCodigo();
        produtosModel.getNome();
        produtosModel.getValor();
        produtosModel.getDescontoPorcentagem();
        produtosModel.setValorDoDesconto(resultado);
        produtosModel.setValorFinal(resultadoFinal);
        return produtosRepository.save(produtosModel);
    }

    public ProdutoModel alterar(ProdutoModel produtos){

        produtos.getCodigo();
        produtos.getNome();
        produtos.getValor();

        return produtosRepository.save(produtos);
    }

    public void deletar(Long codigo){
        produtosRepository.deleteById(codigo);
    }
}
