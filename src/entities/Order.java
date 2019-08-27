package entities;

import enums.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Felipe M. Simões
 */
public class Order {

    private Date moment;
    private OrderStatus status;
    private Client client;
    
  

    List<OrderItem> orderitem = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {

    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public List<OrderItem> getOrderitem() {
        return orderitem;
    }

    public void addItem(OrderItem item) {
        orderitem.add(item);
    }

    public void removeItem(OrderItem item) {
        orderitem.remove(item);
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

    public double total() {
        double c = 0;
        
        for(OrderItem o : orderitem){
            c += o.subTotal();
        }
        return c;
    }
    
    @Override
    public String toString(){
        
       StringBuilder sb = new StringBuilder();
       sb.append("\n");
       sb.append("ORDER SUMMARY").append("\n");
       sb.append("Order moment: ");
       sb.append(sdf.format(moment)).append("\n");
       sb.append("Order status: ").append(status).append("\n");
       sb.append("Client: ");
       sb.append(client.getName());
       sb.append(" (").append(sdf.format(client.getBirthDate())).append(") - ");
       sb.append(client.getEmail()).append("\n");
       sb.append("\n");
       sb.append("Order items: ").append("\n");
       
       for (OrderItem o : orderitem){
           sb.append(o).append("\n");
       }
       
       sb.append("Total price: ");
       sb.append(String.format("$ %.2f%n",total()));
       
       return sb.toString();     
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
