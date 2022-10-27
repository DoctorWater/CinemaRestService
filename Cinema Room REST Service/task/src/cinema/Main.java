package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Main {
    private static WholeRoomDTO responseObject;
    private static Room room;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        room = new Room(9,9);
        responseObject = new WholeRoomDTO(room);
    }

    public static WholeRoomDTO getResponseObject(){
        return responseObject;
    }
    public static Room getRoom(){ return room;}
}
