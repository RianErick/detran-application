package com.project.detranapi.service.impl;

import com.project.detranapi.handler.exception.MotoristaException;
import com.project.detranapi.model.Motorista;
import com.project.detranapi.repository.MotoristaRepository;
import com.project.detranapi.service.MototristaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

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
                         throw new MotoristaException("CPF EXISTENTE");
                     }

        boolean rgExistente = motoristaRepository
                .findByRg(motorista.getRg()).isPresent();
                     if (rgExistente ){
                         throw new MotoristaException("RG EXISTENTE");
                     }

                     return motorista;
    }
    @Override
    public Motorista buscarMotoristaPeloCpf(String cpf) {
        return (Motorista) motoristaRepository.findByCpf(cpf)
                .orElseThrow(() -> new MotoristaException("Cpf Inexistente"));
    }

}
