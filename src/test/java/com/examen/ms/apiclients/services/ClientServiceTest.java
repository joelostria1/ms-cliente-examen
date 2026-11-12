package com.examen.ms.apiclients.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.examen.ms.apiclients.entities.ClientEntity;
import com.examen.ms.apiclients.exception.ClientNotFoundException;
import com.examen.ms.apiclients.mapper.ClientMapper;
import com.examen.ms.apiclients.models.ClientDto;
import com.examen.ms.apiclients.repositories.ClientRepository;
import com.examen.ms.apiclients.services.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void getClient_WhenClientExists_ReturnsClientDto() {
        Long clientId = 1L;
        ClientEntity mockEntity = new ClientEntity();
        ClientDto expectedDto = new ClientDto();

        when(clientRepository.findById(clientId)).thenReturn(Optional.of(mockEntity));
        when(clientMapper.toDTO(mockEntity)).thenReturn(expectedDto);

        ClientDto result = clientService.getClient(clientId);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(clientRepository).findById(clientId);
        verify(clientMapper).toDTO(mockEntity);
    }

    @Test
    void getClient_WhenClientDoesNotExist_ThrowsException() {
        Long clientId = 99L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        assertThrows(ClientNotFoundException.class, () -> clientService.getClient(clientId));
        verify(clientRepository).findById(clientId);
        verifyNoInteractions(clientMapper);
    }

    @Test
    void saveClient_ValidClient_CallsRepositorySave() {
        ClientDto inputDto = new ClientDto();
        ClientEntity mappedEntity = new ClientEntity();

        when(clientMapper.toEntity(inputDto)).thenReturn(mappedEntity);

        clientService.saveClient(inputDto);

        verify(clientMapper).toEntity(inputDto);
        verify(clientRepository).save(mappedEntity);
    }
}

