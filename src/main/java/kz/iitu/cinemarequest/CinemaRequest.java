package kz.iitu.cinemarequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CinemaRequest {

    private String userId;
    private Movie movie;

    public CinemaRequest() {
    }

    public CinemaRequest(String userId, Movie movie) {
        this.userId = userId;
        this.movie = movie;
    }
}
