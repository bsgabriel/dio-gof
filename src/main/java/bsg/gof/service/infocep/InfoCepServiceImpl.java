package bsg.gof.service.infocep;

import bsg.gof.client.ViaCepClient;
import bsg.gof.dto.CepDto;
import bsg.gof.mapper.CepMapper;
import bsg.gof.repository.InfoCepRepository;
import bsg.gof.util.CepUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InfoCepServiceImpl implements InfoCepService {

    private final CepMapper cepMapper;
    private final ViaCepClient viaCepClient;
    private final InfoCepRepository infoCepRepository;

    @Override
    public CepDto buscarDadosCep(Long cep) {
        return this.infoCepRepository.findById(cep)
                .map(cepMapper::toDto)
                .orElseGet(() -> this.cadastrarCep(cep));
    }

    private CepDto cadastrarCep(Long cep) {
        // TODO gabriel: criar exception
        var entidade = Optional.ofNullable(viaCepClient.consultarCep(CepUtil.formatarCep(cep)))
                .map(cepMapper::toEntity)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar dados para o CEP informado"));

        return cepMapper.toDto(infoCepRepository.save(entidade));
    }


}
