package cinema;

import java.util.ArrayList;

public class WholeRoomDTO {
    private final int total_rows;
    private final int total_columns;
    private final ArrayList<Seat> available_seats;

    public WholeRoomDTO(Room room) {
        this.total_rows = room.getRowsNumber();
        this.total_columns = room.getColumnsNumber();
        this.available_seats = room.getAvailableSeats();
    }

    public ArrayList<Seat> getAvailable_seats() {
        return new ArrayList<>(available_seats);
    }
}
