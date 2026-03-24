package com.fumagalli.gerenciamento_fornecedores.services;

import com.fumagalli.gerenciamento_fornecedores.models.FornecedorModel;
import com.fumagalli.gerenciamento_fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorModel> findAll(){
        return fornecedorRepository.findAll();
    }

    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    public Optional<FornecedorModel> buscarPorId(Long id){
        return fornecedorRepository.findById(id);
    }

    public FornecedorModel atualizar(long id, FornecedorModel fornecedorModel){
        FornecedorModel model = fornecedorRepository.findById(id).get();
        model.setNomeFantasia(fornecedorModel.getNomeFantasia());
        model.setCnpj(fornecedorModel.getCnpj());
        model.setContato(fornecedorModel.getContato());

        return fornecedorRepository.save(model);
    }

    public void deletar(Long id){
        fornecedorRepository.deleteById(id);
    }
}
