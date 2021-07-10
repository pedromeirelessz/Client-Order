package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import entities.Order;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter client data: ");

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String Email = sc.next();

		System.out.print("Birh data (DD/MM/YYYY): ");
		Date clientDate = sdf.parse(sc.next());

		Client client = new Client(name, Email, clientDate);
		
		
		
		System.out.println("Enter order data: ");

		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(client, new Date(), status);

		System.out.print("How many item to this order?: ");
		int N = sc.nextInt();

		for (int cont = 0; cont < N; cont++) {

			System.out.println("Enter #" + (cont + 1) + " item data: ");

			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();

			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			System.out.print("Quantity?: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, productPrice);

			OrderItem item = new OrderItem(quantity, productPrice, product);
			order.addItem(item);
		}

		
		
		System.out.println();
		System.out.println(order);

		sc.close();
	}

}
