package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Felipe M. Simões
 */
public class Program {
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        System.out.println("----------------------------------------");        
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date bithDate = sdf.parse(sc.nextLine());
        
        Client client = new Client(name, email, bithDate);
        
        System.out.println("----------------------------------------");
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        
        Order order = new Order(new Date(), status, client);
        
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product Name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product Price: ");
            double price = sc.nextDouble();

            Product product = new Product(nameProduct, price);
            
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();           

            OrderItem orderItem = new OrderItem(quantity, price, product);
            
            order.addItem(orderItem);
        }
        
        System.out.println();
        System.out.println(order);
        
        sc.close();
    }
}
