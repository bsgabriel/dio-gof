package bsg.gof.mapper;

import bsg.gof.dto.ClienteDto;
import bsg.gof.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final EnderecoMapper enderecoMapper;

    public ClienteDto toClienteDto(Cliente cliente) {
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .endereco(enderecoMapper.toDto(cliente.getEndereco()))
                .build();
    }

}
