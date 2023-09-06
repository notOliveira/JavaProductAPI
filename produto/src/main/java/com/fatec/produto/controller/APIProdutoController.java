package com.fatec.produto.controller;

import com.fatec.produto.services.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIProdutoController {
    @Autowired
    IProdutoService produtoServico;

    @CrossOrigin
    @GetMapping("api/v1/produtos")
    public ResponseEntity <Object> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoServico.consultaCatalogo());
    }
}
