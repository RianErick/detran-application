package com.project.detranapi.repository;

import com.project.detranapi.model.Multa;
import com.project.detranapi.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultaRepository extends JpaRepository<Multa, Long> {

    List <Multa> findMultaByRenavamVeiculo (Veiculo renavamVeiculo);
}
