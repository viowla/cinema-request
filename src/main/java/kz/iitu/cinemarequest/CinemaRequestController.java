package kz.iitu.cinemarequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cinema/request")
public class CinemaRequestController {
    private final Producer producer;
    private CinemaInformationService cinemaInformationService;

    @Autowired
    public CinemaRequestController(Producer producer, CinemaInformationService cinemaInformationService) {
        this.producer = producer;
        this.cinemaInformationService = cinemaInformationService;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("movieId") String movieId) {

        CinemaRequest cinemaRequest = new CinemaRequest(userId, cinemaInformationService.getMovieById(movieId));
        this.producer.cinemaRequestNotify(cinemaRequest);
        return "Your request sent successful!";
    }
}
