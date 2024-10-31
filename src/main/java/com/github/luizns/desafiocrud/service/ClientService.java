package com.github.luizns.desafiocrud.service;

import com.github.luizns.desafiocrud.DTO.ClientDTO;
import com.github.luizns.desafiocrud.entities.Client;
import com.github.luizns.desafiocrud.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow();
        return new ClientDTO(client);
    }
}
