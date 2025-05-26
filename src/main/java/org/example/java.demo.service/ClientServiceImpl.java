package org.example.java.demo.service;

import org.example.Model.Client;
import org.example.repository.ClientRepository;
import org.example.aop.annotation.LogExecution.LogExecution;
import org.example.aop.annotation.LogExecution.LogDataSourceError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @LogExecution
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @LogDataSourceError
    @Override
    public Client getClientById(Long id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("Invalid client ID: " + id);
        }
        return clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client not found with ID: " + id));
    }

    @LogDataSourceError
    @Override
    public void testError() throws Exception {
        throw new Exception("Database connection failed");
    }
}