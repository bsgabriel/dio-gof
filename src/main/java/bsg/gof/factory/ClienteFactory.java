package bsg.gof.factory;

import bsg.gof.model.Cliente;
import bsg.gof.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ClienteFactory {

    public Cliente criarEntity(String nome, Endereco endereco) {
        return Cliente.builder()
                .nome(nome)
                .endereco(endereco)
                .build();
    }

}
