package bsg.gof.service.cliente;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;

import java.util.List;

public interface ClienteService {

    ClienteDto inserir(ClienteRequestDto cliente);

    List<ClienteDto> buscarClientes();

    ClienteDto buscarCliente(Long cliented);
}
