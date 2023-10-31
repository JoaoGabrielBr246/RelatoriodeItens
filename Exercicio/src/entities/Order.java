package entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrdemItem> ordemItems = new ArrayList<>();

    public Order(Date moment,OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrdemItem> getOrdemItems() {
        return ordemItems;
    }

    public void addContract(OrdemItem ordemItem) {
        ordemItems.add(ordemItem);
    }

    public void removeContract(OrdemItem ordemItem) {
        ordemItems.remove(ordemItem);
    }

    public Order() {

    }
}
