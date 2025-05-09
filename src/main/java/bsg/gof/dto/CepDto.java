package bsg.gof.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CepDto {

    private Long cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String siglaEstado;

}
