package Program;

import entities.*;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date orderMoment = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedOrderMoment = sdf2.format(orderMoment);
        List<OrdemItem> orderItems = new ArrayList<>();

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        sc.nextLine(); // Consume the newline character
        System.out.println("Enter order Data: ");
        System.out.print("Status: ");
        String status = sc.nextLine();
        Client client = new Client(name, email, birthDate);
        Order order = new Order(orderMoment, OrderStatus.valueOf(status));

        System.out.print("How many items for this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data: ");
            sc.nextLine(); // Consume the newline character
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrdemItem ordemItem = new OrdemItem(quantity, price, new Product(productName));
            orderItems.add(ordemItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + formattedOrderMoment);
        System.out.println("Order status: " + order.getStatus());
        SimpleDateFormat sdfCliente = new SimpleDateFormat("dd/MM/yyyy");
        String formattedBirthDate = sdfCliente.format(client.getBirthDate());
        System.out.println("Client: " + client.getName() + " (" + formattedBirthDate + ") - " + client.getEmail());
        System.out.println("Order Items: ");
        for (OrdemItem ordemItem : orderItems) {
            String productName = ordemItem.getName().getName();

            System.out.println(String.format("%s, $%.2f, Quantity: %d, Subtotal: $%.2f",
                    productName, ordemItem.getPrice(), ordemItem.getQuantity(), ordemItem.subTotal()));
        }

        double totalOrderPrice = 0.0;

        for (OrdemItem ordemItem : orderItems) {
            totalOrderPrice += ordemItem.subTotal();
        }

        System.out.println("Total price: $" + String.format("%.2f", totalOrderPrice));

        sc.close();
    }
}
