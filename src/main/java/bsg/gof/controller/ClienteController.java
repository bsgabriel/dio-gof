package bsg.gof.controller;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;
import bsg.gof.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> inserir(@RequestBody ClienteRequestDto cliente) {
        return ResponseEntity.ok(clienteService.inserir(cliente));
    }

}
