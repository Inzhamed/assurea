package com.assurea.pcm.service;

import com.assurea.pcm.model.Client;
import com.assurea.pcm.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public List<Client> getAll() {
        return repo.findAll();
    }

    public Client getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Client save(Client client) {
        return repo.save(client);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}