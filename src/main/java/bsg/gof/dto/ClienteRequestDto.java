package bsg.gof.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDto {

    // TODO gabriel: colocar @NotNull e @NotEmpty
    private String nome;
    private EnderecoClienteRequestDto endereco;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EnderecoClienteRequestDto {
        private Long cep;
        private Integer numero;
        private String complemento;
    }
}
