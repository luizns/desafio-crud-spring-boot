package com.github.luizns.desafiocrud.service;

import com.github.luizns.desafiocrud.DTO.ClientDTO;
import com.github.luizns.desafiocrud.entities.Client;
import com.github.luizns.desafiocrud.repository.ClientRepository;
import com.github.luizns.desafiocrud.service.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(ClientDTO::new);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }


    private void copyDtoToEntity(Client entity, ClientDTO dto) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
