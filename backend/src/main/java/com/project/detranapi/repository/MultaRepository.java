package com.project.detranapi.repository;

import com.project.detranapi.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MultaRepository extends JpaRepository<Multa, Long> {

    @Query(value = " SELECT * FROM multa WHERE renavam_multa = :renavam ", nativeQuery = true)
    Multa findMultaByRenavamVeiculo (@Param("renavam") String renavam);

    @Query(value = "SELECT sum(pontos_removidos) FROM multa WHERE renavam_multa = :renavam ", nativeQuery = true)
    Integer findBySumMultasByRenavam (@Param("renavam") String renavam);

}