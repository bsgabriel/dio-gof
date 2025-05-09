package bsg.gof.service.cliente;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;
import bsg.gof.factory.ClienteFactory;
import bsg.gof.mapper.ClienteMapper;
import bsg.gof.repository.ClienteRepository;
import bsg.gof.service.endereco.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteFactory clienteFactory;
    private final EnderecoService enderecoService;
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDto inserir(ClienteRequestDto request) {
        var endereco = enderecoService.cadastrarEndereco(request.getEndereco());
        var inserted = clienteRepository.save(clienteFactory.criarEntity(request.getNome(), endereco));
        return clienteMapper.toClienteDto(inserted);
    }

}
