package com.example.demo.web.controller;

import com.example.demo.model.Data;
import com.example.demo.model.test.DataTestOptions;
import com.example.demo.service.KafkaDataService;
import com.example.demo.service.TestDataService;
import com.example.demo.web.dto.DataDTO;
import com.example.demo.web.dto.DataTestOptionsDto;
import com.example.demo.web.mapper.DataMapper;
import com.example.demo.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;
    private final TestDataService testDataService;




    @PostMapping("/send")

    public void send(@RequestBody DataDTO dto) {
        Data data = dataMapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto dataTestOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(dataTestOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
//# Переход в каталог Kafka
//        cd D:\kafka_2.13-3.6.1
//
//        # Запуск Zookeeper
//        .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
//.\bin\windows\kafka-server-start.bat .\config\server.properties
//PS .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic data-temperature --from-beginning
// .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic data-voltage --from-beginning
