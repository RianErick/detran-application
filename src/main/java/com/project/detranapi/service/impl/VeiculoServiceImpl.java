package com.project.detranapi.service.impl;

import com.project.detranapi.handler.exception.VeiculoException;
import com.project.detranapi.model.Veiculo;
import com.project.detranapi.repository.VeiculoRepository;
import com.project.detranapi.service.VeiculoService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    public Veiculo salvarVeiculo(Veiculo data) {

        validarVeiculo(data);
        return veiculoRepository.save(data);

    }

    public Veiculo validarVeiculo(Veiculo data) {

        boolean renavanExistente = veiculoRepository
                .findByRenavam(data.getRenavam())
                .isPresent();
        if (renavanExistente)
            throw new VeiculoException("Renavan Existente" );

        boolean placaExistente = veiculoRepository
                .findByPlaca(data.getPlaca())
                .isPresent();
        if (placaExistente)
            throw new RuntimeException("Error");

        boolean crvExistente = veiculoRepository
                .findByCrv(data.getCrv())
                .isPresent();
        if (crvExistente)
            throw new RuntimeException("Error");

        boolean crlvExistente = veiculoRepository
                .findByCrlv(data.getCrlv())
                .isPresent();
        if (crlvExistente)
            throw new RuntimeException("Error");

        return data;

    }

    @Transactional
    @Override
    public Veiculo buscarVeiculoPeloRenavam(String renavam) {
        return (Veiculo) veiculoRepository.findByRenavam(renavam)
                .orElseThrow(() -> new RuntimeException());
    }


}
