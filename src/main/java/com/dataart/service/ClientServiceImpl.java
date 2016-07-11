package com.dataart.service;

import com.dataart.dao.ClientDaoImpl;
import com.dataart.dto.ClientDto;
import com.dataart.entity.Client;
import com.dataart.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDaoImpl clientDao;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDto create(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setPhone(clientDto.getPhone());
        clientDao.create(client);

        return clientMapper.toDto(client);
    }
}
