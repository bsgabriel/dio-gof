package bsg.gof.service.endereco;

import bsg.gof.dto.ClienteRequestDto.EnderecoClienteRequestDto;
import bsg.gof.model.Endereco;

public interface EnderecoService {

    Endereco cadastrarEndereco(EnderecoClienteRequestDto enderecoRequest);

    Endereco atualizarEndereco(Long enderecoId, EnderecoClienteRequestDto dto);
}
