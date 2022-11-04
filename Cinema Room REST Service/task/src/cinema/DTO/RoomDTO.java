package cinema.DTO;

import cinema.Enities.Room;
import cinema.Enities.Seat;

import java.util.ArrayList;

public class RoomDTO {
    private final int total_rows; //this notation is required by the task
    private final int total_columns; //this notation is required by the task
    private final ArrayList<Seat> available_seats;

    public RoomDTO(Room room) {
        this.total_rows = room.getRowsNumber();
        this.total_columns = room.getColumnsNumber();
        this.available_seats = room.getAvailableSeats();
    }

    public ArrayList<Seat> getAvailable_seats() {
        return new ArrayList<>(available_seats);
    }
}
