package com.examen.ms.apiclients.services;

import com.examen.ms.apiclients.models.ClientDto;


public interface ClientService {

    ClientDto getClient(Long id);

    Long saveClient(ClientDto cliente);

    void updateClient(ClientDto cliente);

    void deleteClient(Long id);

}
