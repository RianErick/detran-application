package com.project.detranapi.service.impl;


import com.project.detranapi.model.Multa;
import com.project.detranapi.repository.MultaRepository;
import com.project.detranapi.representation.MultaDTO;
import com.project.detranapi.service.MultaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class MultaServiceImpl implements MultaService {

    private final MultaRepository multaRepository;

    public MultaServiceImpl(MultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }

    @Transactional
    @Override
    public Multa atribuirMulta(Multa multa) {

        switch (multa.getGrau()) {

            case LEVE -> multa.setPontosRemovidos(3);

            case MEDIA -> multa.setPontosRemovidos(4);

            case GRAVE -> multa.setPontosRemovidos(5);

            case GRAVISSIMA ->  multa.setPontosRemovidos(7);
        }

        multa.setAtribuido(0);

        multa.setDataVencimento(LocalDate.now());

        return multaRepository.save(multa);
    }

    @Transactional
    @Override
    public List<MultaDTO> buscarMultaPeloRenavam(String renavam) {

        MultaDTO multaDTO = new MultaDTO();

        List<Multa> multas = multaRepository.findMultaByRenavamVeiculo(renavam);

        return multaDTO.converterLista(multas);
    }

}
