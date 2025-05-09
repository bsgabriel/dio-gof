package bsg.gof.mapper;

import bsg.gof.dto.CepDto;
import bsg.gof.dto.ViaCepResponseDto;
import bsg.gof.model.InfoCep;
import bsg.gof.util.CepUtil;
import org.springframework.stereotype.Component;

@Component
public class CepMapper {

    public CepDto toDto(InfoCep infoCep) {
        return CepDto.builder()
                .cep(infoCep.getCep())
                .rua(infoCep.getRua())
                .bairro(infoCep.getBairro())
                .cidade(infoCep.getCidade())
                .estado(infoCep.getEstado())
                .siglaEstado(infoCep.getSiglaEstado())
                .build();
    }

    public InfoCep toEntity(ViaCepResponseDto viaCepDto) {
        return InfoCep.builder()
                .cep(CepUtil.cepParaLong(viaCepDto.getCep()))
                .rua(viaCepDto.getLogradouro())
                .bairro(viaCepDto.getBairro())
                .cidade(viaCepDto.getLocalidade())
                .estado(viaCepDto.getEstado())
                .siglaEstado(viaCepDto.getUf())
                .build();
    }

    public InfoCep toEntity(CepDto cepDto) {
        return InfoCep.builder()
                .cep(cepDto.getCep())
                .rua(cepDto.getRua())
                .bairro(cepDto.getBairro())
                .cidade(cepDto.getCidade())
                .estado(cepDto.getEstado())
                .siglaEstado(cepDto.getSiglaEstado())
                .build();
    }

}
