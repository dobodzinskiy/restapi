package com.dataart.service;

import com.dataart.dao.ClientDaoImpl;
import com.dataart.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDaoImpl clientDao;

    @Override
    public Client create(String name, String lastName, String phone) {
        Client client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setPhone(phone);
        clientDao.create(client);

        return client;
    }
}
