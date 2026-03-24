package com.fumagalli.gerenciamento_fornecedores.repositories;

import com.fumagalli.gerenciamento_fornecedores.models.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
