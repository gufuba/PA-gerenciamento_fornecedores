package com.fumagalli.gerenciamento_fornecedores.controllers;

import com.fumagalli.gerenciamento_fornecedores.models.FornecedorModel;
import com.fumagalli.gerenciamento_fornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> requeste = fornecedorService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel novo = fornecedorService.criarFornecedor(fornecedorModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor (@PathVariable Long id){
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorModel> buscarPorIdFornecedor(@PathVariable Long id){
        Optional<FornecedorModel> fornecedor = fornecedorService.buscarPorId(id);

        if(fornecedor.isPresent()){
            return ResponseEntity.ok(fornecedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel){
        FornecedorModel atualizado = fornecedorService.atualizar(id, fornecedorModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
