package com.example.demo.service;

import com.example.demo.model.Data;

public interface KafkaDataService {

    void send(Data data);
}
