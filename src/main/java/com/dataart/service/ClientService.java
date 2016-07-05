package com.dataart.service;

import com.dataart.entity.Client;

public interface ClientService {

    Client create(String name, String lastName, String phone);

}
