package cinema;

import cinema.DTO.ResponseDTO;
import cinema.DTO.RoomDTO;
import cinema.DTO.StatisticsDTO;
import cinema.DTO.TicketReturnResponseDTO;
import cinema.Enities.Room;
import cinema.Enities.Seat;
import cinema.Enities.Ticket;
import cinema.Exceptions.MethodArgumentNullException;
import cinema.Exceptions.OrderWasNotFoundException;
import cinema.Exceptions.TicketBuyingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.UUID;

public class CinemaService {

    private Room room;
    private final HashMap<String, Ticket> orders;
    private Integer income = 0;
    private Integer numberOfPurchasedTickets =0;


    public CinemaService(@Autowired Room room) {
        this.room = room;
        orders = new HashMap<>();
    }

    public void addOrder(String id, Ticket ticket) throws MethodArgumentNullException {
        if (id == null || ticket == null) {
            throw new MethodArgumentNullException("The pair 'UUID/ticket' you try to create has null.");
        }
        orders.put(id, ticket);
    }

    public void deleteOrder(String id) throws MethodArgumentNullException {
        if (id == null) {
            throw new MethodArgumentNullException("The id you try to find is null.");
        }
        Ticket ticket = orders.get(id);
        orders.remove(id);
        room.addSeat(new Seat(ticket.getRow(), ticket.getColumn()));
    }

    public void addAvailableSeat(int row, int column) {
        room.addSeat(new Seat(row, column));
    }

    public ResponseDTO bookSeat(int row, int column) throws MethodArgumentNullException {
        Seat bookingSeat = new Seat(row, column);
        if (room.getAvailableSeats().contains(bookingSeat)) {
            room.removeSeat(bookingSeat);
            UUID id = UUID.randomUUID();
            Ticket ticket = new Ticket(row, column);
            income+= ticket.getPrice();
            numberOfPurchasedTickets++;
            addOrder(id.toString(), ticket);
            return new ResponseDTO(row, column, id.toString());
        }
        if (row > room.getRowsNumber() | column > room.getColumnsNumber() | row < 1 | column < 1) {
            throw new TicketBuyingException("The number of a row or a column is out of bounds!");
        }

        throw new TicketBuyingException("The ticket has been already purchased!");
    }

    public TicketReturnResponseDTO unbookSeat(String id) throws OrderWasNotFoundException {
        if (!orders.containsKey(id)) {
            throw new OrderWasNotFoundException();
        }
        TicketReturnResponseDTO response = new TicketReturnResponseDTO(orders.get(id));
        income-=response.getReturned_ticket().getPrice();
        numberOfPurchasedTickets--;
        Seat seat = new Seat(response.getReturned_ticket().getRow(), response.getReturned_ticket().getColumn());
        room.addSeat(seat);
        return response;
    }

    public RoomDTO getRoomDTO() {
        return new RoomDTO(room);
    }

    public HashMap<String, Ticket> getTicketIDs() {
        return new HashMap<>(orders);
    }

    public StatisticsDTO getStatisticsDTO() {
        return new StatisticsDTO(income, room.getAvailableSeats().size(),numberOfPurchasedTickets);
    }
}

