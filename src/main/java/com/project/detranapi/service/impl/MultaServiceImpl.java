package com.project.detranapi.service.impl;

import com.project.detranapi.model.Enum.Grau;
import com.project.detranapi.model.Multa;
import com.project.detranapi.repository.MultaRepository;
import com.project.detranapi.service.MultaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class MultaServiceImpl implements MultaService {

    private final MultaRepository multaRepository;

    public MultaServiceImpl(MultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }

    @Transactional
    @Override
    public Multa atribuirMulta(Multa multa) {

        if (multa.getGrau() == Grau.LEVE){
            multa.setPontosRemovidos(3);
        }

        multa.setDataVencimento(LocalDate.now());

      return multaRepository.save(multa);

    }
}
