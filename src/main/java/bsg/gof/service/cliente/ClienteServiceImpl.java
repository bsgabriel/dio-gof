package bsg.gof.service.cliente;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;
import bsg.gof.factory.ClienteFactory;
import bsg.gof.mapper.ClienteMapper;
import bsg.gof.repository.ClienteRepository;
import bsg.gof.service.endereco.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ClienteDto> buscarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toClienteDto)
                .toList();
    }

    @Override
    public ClienteDto buscarCliente(Long cliented) {
        return this.clienteRepository.findById(cliented)
                .map(clienteMapper::toClienteDto)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public void deletarCliente(Long clienteId) {
        boolean exists = this.clienteRepository.existsById(clienteId);
        if (!exists) {
            throw new RuntimeException("Cliente não encotrado");
        }

        clienteRepository.deleteById(clienteId);

    }

    @Override
    public ClienteDto atualizarCliente(Long clienteId, ClienteRequestDto clienteRequestDto) {
        var clienteCadastrado = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        var novoEndereco = enderecoService.atualizarEndereco(
                clienteCadastrado.getEndereco().getEnderecoId(),
                clienteRequestDto.getEndereco()
        );

        clienteCadastrado.setNome(clienteRequestDto.getNome());
        clienteCadastrado.setEndereco(novoEndereco);

        clienteCadastrado = clienteRepository.save(clienteCadastrado);
        return clienteMapper.toClienteDto(clienteCadastrado);
    }


}
