package cinema;

import cinema.Enities.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    public Room createRoom(){
        return new Room(9,9);
    }

    @Bean
    public CinemaService cinemaService(){
        return new CinemaService(createRoom());
    }
}
