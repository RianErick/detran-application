package com.project.detranapi.repository;


import com.project.detranapi.model.CarteiraHabilitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraRepository extends JpaRepository < CarteiraHabilitacao , Integer > {


   Optional <CarteiraHabilitacao> findByCnh(String cnh);

}
