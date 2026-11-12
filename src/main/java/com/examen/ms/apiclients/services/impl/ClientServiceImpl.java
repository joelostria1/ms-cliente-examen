package com.examen.ms.apiclients.services.impl;

import com.examen.ms.apiclients.entities.ClientEntity;
import com.examen.ms.apiclients.exception.ClientNotFoundException;
import com.examen.ms.apiclients.mapper.ClientMapper;
import com.examen.ms.apiclients.models.ClientDto;
import com.examen.ms.apiclients.repositories.ClientRepository;
import com.examen.ms.apiclients.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto getClient(Long id) {
        ClientEntity cliente = clientRepository.findById(id).orElseThrow(()->new ClientNotFoundException("Cliente no encontrado"));

        return clientMapper.toDTO(cliente);

    }

    @Override
    public Long saveClient(ClientDto cliente) {
        try {
            ClientEntity client = clientRepository.save(clientMapper.toEntity(cliente));
            return client.getId();
        }catch (Exception e){
            return 0L;
        }
    }

    @Override
    public void updateClient(ClientDto cliente) {
        clientRepository.save(clientMapper.toEntity(cliente));
    }

    @Override
    public void deleteClient(Long id) {
        ClientEntity cliente = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(cliente);
    }
}
