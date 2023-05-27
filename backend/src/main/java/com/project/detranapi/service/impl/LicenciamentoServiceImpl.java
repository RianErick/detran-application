package com.project.detranapi.service.impl;

import com.project.detranapi.model.Licenciamento;
import com.project.detranapi.repository.LicenciamentoRepository;
import com.project.detranapi.service.LicenciamentoService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class LicenciamentoServiceImpl implements LicenciamentoService {

    private final LicenciamentoRepository licenciamentoRepository;

    public LicenciamentoServiceImpl(LicenciamentoRepository licenciamentoRepository) {
        this.licenciamentoRepository = licenciamentoRepository;
    }

    @Transactional
    @Override
    public Licenciamento atribuir(Licenciamento licenciamento) {

        licenciamento.setData(LocalDate.now().plus(2, ChronoUnit.MONTHS));

        return licenciamentoRepository.save(licenciamento);
    }

}
