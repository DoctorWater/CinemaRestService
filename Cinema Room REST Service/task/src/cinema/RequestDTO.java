package cinema;

public class RequestDTO {
    private Integer row;
    private Integer column;
    private Integer price;

    public RequestDTO(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        if (row <= 4) {
            this.price = 10;
        }
        else {
            this.price = 8;
        }
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
