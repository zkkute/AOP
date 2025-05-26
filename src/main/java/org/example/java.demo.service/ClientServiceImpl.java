package org.example.java.demo.service;

import org.example.aop.annotation.LogExecution.LogExecution;
import org.example.Model.Client;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    @LogExecution
    public List<Client> getAllClients() {
        return Arrays.asList(
                new Client(),
                new Client()
        );
    }
}