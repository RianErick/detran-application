package com.project.detranapi.service;

import com.project.detranapi.model.Motorista;

import java.util.List;

public interface MototristaService {

    Motorista cadastrarMotorista (Motorista data);

    Motorista buscarMotoristaPeloCpf(String cpf);


}
