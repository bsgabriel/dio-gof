package bsg.gof.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    private String cep;
    private String cidade;
    private String rua;
    private String bairro;
    private String complemento;
    private String estado;
    private String siglaEstado;

}
