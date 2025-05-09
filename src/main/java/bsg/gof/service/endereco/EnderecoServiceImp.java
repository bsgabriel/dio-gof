package bsg.gof.service.endereco;

import bsg.gof.dto.ClienteRequestDto.EnderecoClienteRequestDto;
import bsg.gof.factory.EnderecoFactory;
import bsg.gof.model.Endereco;
import bsg.gof.repository.EnderecoRepository;
import bsg.gof.service.infocep.InfoCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImp implements EnderecoService {

    private final InfoCepService infoCepService;
    private final EnderecoFactory enderecoFactory;
    private final EnderecoRepository enderecoRepository;

    @Override
    public Endereco cadastrarEndereco(EnderecoClienteRequestDto enderecoRequest) {
        var infoCep = infoCepService.buscarDadosCep(enderecoRequest.getCep());
        var endereco = enderecoFactory.montarEntidade(enderecoRequest, infoCep);
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco atualizarEndereco(Long enderecoId, EnderecoClienteRequestDto dto) {
        var infoCep = infoCepService.buscarDadosCep(dto.getCep());
        var endereco = enderecoFactory.montarEntidade(dto, infoCep);
        endereco.setEnderecoId(enderecoId);
        return this.enderecoRepository.save(endereco);
    }

}
