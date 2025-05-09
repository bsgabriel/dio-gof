package bsg.gof.service.cliente;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;
import bsg.gof.model.Cliente;

public interface ClienteService {
    ClienteDto inserir(ClienteRequestDto cliente);

}
