package com.project.detranapi.repository;

import com.project.detranapi.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MotoristaRepository extends JpaRepository <Motorista,String> {

      <T> Optional <T> findByCpf(String cpf);
      Optional <String> findByRg (String rg);
      Optional <String> findByNome (String nome);
      <T>Optional<T> findByEnderecoCep(String cep);





}
