package org.example.java.demo.service;

package org.example.java.demo.service;

import org.example.aop.annotation.LogExecution.LogDataSourceError;
import org.example.aop.annotation.LogExecution.LogExecution;
import org.example.Model.Client;
import java.util.List;

public interface ClientService {
    @LogExecution
    List<Client> getAllClients();

    @LogDataSourceError
    Client getClientById(Long id) throws Exception;

    @LogDataSourceError
    void testError() throws Exception;
}

