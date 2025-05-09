package bsg.gof.factory;

import bsg.gof.dto.CepDto;
import bsg.gof.dto.ClienteRequestDto;
import bsg.gof.mapper.CepMapper;
import bsg.gof.model.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoFactory {

    private final CepMapper cepMapper;

    public Endereco montarEntidade(ClienteRequestDto.EnderecoClienteRequestDto enderecoRequest, CepDto infoCep) {
        return Endereco.builder()
                .complemento(enderecoRequest.getComplemento())
                .numero(enderecoRequest.getNumero())
                .infoCep(cepMapper.toEntity(infoCep))
                .build();
    }
}
