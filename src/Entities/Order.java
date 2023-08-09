package Entities;

import Entities.Enum.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    Client client;
    List<OrderItem> items = new ArrayList<>();

    public Order(){

    }
    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Order(Date moment, String s) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0.00;
        for (OrderItem o : items) {
            sum += o.subtotal();
        }
        return sum;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: ").append(sdf.format(moment)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client).append("\n");
        sb.append("Order itemns:\n");
        for (OrderItem o : items) {
            sb.append(o.product.getName()
                    + ", $" + String.format("%.2f", o.getPrice())
                    + ", Quantity: "
                    + o.getQuantity()
                    + ", Subtotal: $"
                    + String.format("%.2f", o.subtotal())
                    + "\n");
        }
        sb.append("Total price: $").append(String.format("%.2f", total()));
        return sb.toString();
    }
}
