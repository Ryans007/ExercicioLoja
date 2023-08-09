import Entities.Client;
import Entities.Enum.OrderStatus;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name,email,birthDate);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        String status = sc.next();

        Order order = new Order(new Date(),OrderStatus.valueOf(status),client);

        System.out.print("How many itemns to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data: ");

            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println(order);
        sc.close();
    }
}
