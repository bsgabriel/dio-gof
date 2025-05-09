package bsg.gof.controller;

import bsg.gof.dto.ClienteDto;
import bsg.gof.dto.ClienteRequestDto;
import bsg.gof.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> buscarClientes() {
        return ResponseEntity.ok(this.clienteService.buscarClientes());
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> buscarCliente(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.ok(this.clienteService.buscarCliente(clienteId));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> inserir(@RequestBody ClienteRequestDto cliente) {
        return ResponseEntity.ok(clienteService.inserir(cliente));
    }

}
