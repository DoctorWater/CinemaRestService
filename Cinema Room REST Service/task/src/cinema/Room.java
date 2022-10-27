package cinema;

import java.util.ArrayList;

public class Room {
    private final ArrayList<Seat> availableSeats = new ArrayList<>();
    private int columnsNumber;
    private int rowsNumber;

    public Room(int columnsNumber, int rowsNumber) {
        this.columnsNumber = columnsNumber;
        this.rowsNumber = rowsNumber;
        for (int i = 1; i<=rowsNumber;i++){
            for (int j = 1; j<=columnsNumber;j++){
                addSeat(new Seat(i,j));
            }
        }
    }

    public ArrayList<Seat> getAvailableSeats() {
        return new ArrayList<>(availableSeats);
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public void addSeat(Seat seat){
        availableSeats.add(seat);
    }

    public boolean removeSeat(Seat seat){ return availableSeats.remove(seat);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getColumnsNumber() != room.getColumnsNumber()) return false;
        if (getRowsNumber() != room.getRowsNumber()) return false;
        return getAvailableSeats() != null ? getAvailableSeats().equals(room.getAvailableSeats()) : room.getAvailableSeats() == null;
    }

    @Override
    public int hashCode() {
        int result = getAvailableSeats() != null ? getAvailableSeats().hashCode() : 0;
        result = 31 * result + getColumnsNumber();
        result = 31 * result + getRowsNumber();
        return result;
    }
}
