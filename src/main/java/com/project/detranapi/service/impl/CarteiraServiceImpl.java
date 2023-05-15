package com.project.detranapi.service.impl;

import com.project.detranapi.model.CarteiraHabilitacao;
import com.project.detranapi.model.Veiculo;
import com.project.detranapi.repository.CarteiraRepository;
import com.project.detranapi.repository.MultaRepository;
import com.project.detranapi.representation.CarteiraDTO;
import com.project.detranapi.service.CarteiraService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class CarteiraServiceImpl implements CarteiraService {

    private final CarteiraRepository carteiraRepository;

    private final MultaRepository multaRepository;

    public CarteiraServiceImpl(CarteiraRepository carteiraRepository, MultaRepository multaRepository) {
        this.carteiraRepository = carteiraRepository;
        this.multaRepository = multaRepository;
    }

    @Transactional
    @Override
    public CarteiraHabilitacao cadastro(CarteiraHabilitacao carteiraHabilitacao) {

        carteiraHabilitacao.setProntuario(40);
        carteiraHabilitacao.setDataEmicao(LocalDate.now());

      return carteiraRepository.save(carteiraHabilitacao);
    }

    public CarteiraDTO atualizarProntuario(String cnh , Long id){

        CarteiraDTO carteiraDTO = new CarteiraDTO();

        var multa = multaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Multa"));

        var carteira = carteiraRepository.findByCnh(cnh)
                .orElseThrow( () -> new RuntimeException("CNH"));

             var data = (carteira.getProntuario() - multa.getPontosRemovidos());

              carteira.setProntuario(data);

              carteiraRepository.save(carteira);
              return carteiraDTO.atualizarProntuario(carteira);


    }


}
