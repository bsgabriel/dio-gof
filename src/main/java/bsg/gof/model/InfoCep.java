package bsg.gof.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "info_cep")
public class InfoCep {

    @Id
    private Long cep;

    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String siglaEstado;
}
