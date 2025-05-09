package bsg.gof.service.cliente;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;

public interface ClienteService {

    ClienteDto inserir(ClienteRequestDto cliente);

}
