package com.dataart.mapper;

import com.dataart.dto.ClientDto;
import com.dataart.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<Client, ClientDto> {

    @Override
    public Client fromDto(ClientDto clientDto) {
        Client client = new Client();
        client.setLastName(clientDto.getLastName());
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setId(clientDto.getId());

        return client;
    }

    @Override
    public ClientDto toDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setLastName(client.getLastName());
        clientDto.setPhone(client.getPhone());
        clientDto.setId(client.getId());
        return clientDto;
    }
}
