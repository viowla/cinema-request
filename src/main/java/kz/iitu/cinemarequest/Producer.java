package kz.iitu.cinemarequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class Producer {
    private static final String TOPIC = "cinema_request";

    @Autowired
    private KafkaTemplate<String, CinemaRequest> kafkaTemplate;

    public String cinemaRequestNotify(CinemaRequest cinemaRequest) {
        System.out.println(String.format("#### -> Producing movie request to notification service -> %s", cinemaRequest));
        this.kafkaTemplate.send(TOPIC, cinemaRequest);
        return "Successfully";
    }
}
