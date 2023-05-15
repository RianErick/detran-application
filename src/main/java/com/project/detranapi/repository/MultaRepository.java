package com.project.detranapi.repository;

import com.project.detranapi.model.Multa;
import com.project.detranapi.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MultaRepository extends JpaRepository<Multa, Long> {

    @Query(value = " SELECT * FROM multa WHERE renavam_multa = :renavam ", nativeQuery = true)
    Multa findMultaByRenavamVeiculo (@Param("renavam") String renavam);
}
