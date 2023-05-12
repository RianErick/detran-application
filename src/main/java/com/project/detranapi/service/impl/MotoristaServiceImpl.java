package com.project.detranapi.service.impl;

import com.project.detranapi.model.Motorista;
import com.project.detranapi.repository.MotoristaRepository;
import com.project.detranapi.service.MototristaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MotoristaServiceImpl implements MototristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaServiceImpl(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @Transactional
    @Override
    public Motorista cadastrarMotorista(Motorista data) {

       validarMotorista(data);
        return motoristaRepository.save(data);
    }


    public Motorista validarMotorista(Motorista motorista){

        boolean motoristaExistente = motoristaRepository
                .findByCpf(motorista.getCpf()).isPresent();
                     if (motoristaExistente){
                         throw new RuntimeException("cpf");
                     }

        boolean rgExistente = motoristaRepository
                .findByRg(motorista.getRg()).isPresent();
                     if (rgExistente ){
                         throw new RuntimeException("rg");
                     }

                     return motorista;
    }

    @Override
    public Motorista buscarMotoristaPeloCpf(String cpf) {
        return (Motorista) motoristaRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException());

    }



}
