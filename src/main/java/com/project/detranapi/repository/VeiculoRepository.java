package com.project.detranapi.repository;

import com.project.detranapi.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo,String> {

    Optional<String> findByPlaca(String placa);

    Optional<String> findByCrv(String crv);

    Optional<String> findByCrlv(String crvl);

    <T> Optional <T> findByRenavam(String renavan);




}
