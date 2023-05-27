package com.project.detranapi.service.impl;

import com.project.detranapi.handler.Messege;
import com.project.detranapi.handler.exception.VeiculoException;
import com.project.detranapi.model.Veiculo;
import com.project.detranapi.repository.VeiculoRepository;
import com.project.detranapi.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    @Override
    public Veiculo salvarVeiculo(Veiculo data) {

       // validarVeiculoExistente(data);

        return veiculoRepository.save(data);

    }
    public Veiculo validarVeiculoExistente(Veiculo data) {

        boolean renavanExistente = veiculoRepository
                .findByRenavam(data.getRenavam())
                .isPresent();
        if (renavanExistente)
            throw new VeiculoException(Messege.RENAVAM_BAD);

        boolean placaExistente = veiculoRepository
                .findByPlaca(data.getPlaca())
                .isPresent();
        if (placaExistente)
            throw new VeiculoException(Messege.PLACA_BAD);

        boolean crvExistente = veiculoRepository
                .findByCrv(data.getCrv())
                .isPresent();
        if (crvExistente)
            throw new VeiculoException(Messege.CRV_BAD);

        boolean crlvExistente = veiculoRepository
                .findByCrlv(data.getCrlv())
                .isPresent();
        if (crlvExistente)
            throw new VeiculoException(Messege.CRLV_BAD);

        return data;

    }

    @Transactional
    @Override
    public Veiculo buscarVeiculoPeloRenavam(String renavam) {
        return (Veiculo) veiculoRepository.findByRenavam(renavam)
                .orElseThrow(() -> new VeiculoException(Messege.RENAVAM_404));
    }
    @Transactional
    @Override
    public ResponseEntity <Veiculo> editarVeiculo(String renavam, Veiculo veiculo) {

        if(!veiculoRepository.existsById(renavam)){
            return ResponseEntity.notFound().build();
        }
        veiculo.setRenavam(renavam);
        veiculoRepository.save(veiculo);

       return ResponseEntity.noContent().build();
    }

    @Transactional
    @Override
    public ResponseEntity<Void> deletarVeiculo(String renavam) {

        if (!veiculoRepository.existsById(renavam)){
            return ResponseEntity.notFound().build();
        }
        veiculoRepository.deleteById(renavam);
        return ResponseEntity.noContent().build();
    }

}
