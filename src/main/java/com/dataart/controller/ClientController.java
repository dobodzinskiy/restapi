package com.dataart.controller;

import com.dataart.dto.ClientDto;
import com.dataart.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1.0/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ClientDto createClient(@RequestBody @Valid ClientDto clientDto) {
        return clientService.create(clientDto);
    }
}
