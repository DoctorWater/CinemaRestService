package cinema.DTO;

public class StatisticsDTO {
    Integer current_income;
    Integer number_of_available_seats;
    Integer number_of_purchased_tickets;

    public StatisticsDTO(Integer current_income, Integer number_of_available_seats, Integer number_of_purchased_tickets) {
        this.current_income = current_income;
        this.number_of_available_seats = number_of_available_seats;
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public Integer getCurrent_income() {
        return current_income;
    }

    public Integer getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public Integer getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }
}
