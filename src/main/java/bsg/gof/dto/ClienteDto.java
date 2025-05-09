package bsg.gof.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto {

    private Long id;
    private String nome;
    private EnderecoDto endereco;
}
