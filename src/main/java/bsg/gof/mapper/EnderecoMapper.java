package bsg.gof.mapper;

import bsg.gof.dto.EnderecoDto;
import bsg.gof.model.Endereco;
import bsg.gof.util.CepUtil;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public EnderecoDto toDto(Endereco endereco) {
        return EnderecoDto.builder()
                .cep(CepUtil.formatarCep(endereco.getInfoCep().getCep()))
                .rua(endereco.getInfoCep().getRua())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getInfoCep().getBairro())
                .cidade(endereco.getInfoCep().getCidade())
                .estado(endereco.getInfoCep().getEstado())
                .siglaEstado(endereco.getInfoCep().getSiglaEstado())
                .build();
    }
}
