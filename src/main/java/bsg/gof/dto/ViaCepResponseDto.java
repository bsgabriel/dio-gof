package bsg.gof.dto;

import lombok.Data;

@Data
public class ViaCepResponseDto {

    private String logradouro;
    private String cep;
    private String bairro;
    private String complemento;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String estado;
}
