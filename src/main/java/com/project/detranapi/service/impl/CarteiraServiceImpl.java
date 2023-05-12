package com.project.detranapi.service.impl;

import com.project.detranapi.model.CarteiraHabilitacao;
import com.project.detranapi.repository.CarteiraRepository;
import com.project.detranapi.service.CarteiraService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
@Service
public class CarteiraServiceImpl implements CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public CarteiraServiceImpl(CarteiraRepository carteiraRepository) {
        this.carteiraRepository = carteiraRepository;
    }

    @Transactional
    @Override
    public CarteiraHabilitacao cadastro(CarteiraHabilitacao carteiraHabilitacao) {

        carteiraHabilitacao.setProntuario(40);
        carteiraHabilitacao.setDataEmicao(LocalDate.now());

      return carteiraRepository.save(carteiraHabilitacao);
    }

}
