package com.examen.ms.apiclients.controllers;

import com.examen.ms.apiclients.models.ClientDto;
import com.examen.ms.apiclients.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("retrieve/{id}")
    public ClientDto retrieveClient(@PathVariable Long id){
        return clientService.getClient(id);
    };

    @PostMapping("save/")
    public Long retrieveClient(@RequestBody ClientDto cliente){
        return clientService.saveClient(cliente);
    };

    @DeleteMapping("delete/{id}")
    public void removeClient(@PathVariable Long id){
        clientService.deleteClient(id);
    };

    @PutMapping("update/")
    public void removeClient(@RequestBody ClientDto cliente){
        clientService.updateClient(cliente);
    };
}
