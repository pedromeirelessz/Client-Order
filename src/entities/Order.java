package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	OrderItem item = new OrderItem();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

//----------------------------------------------------------------------------------------

	private Client client;
	private Date moment;
	private OrderStatus status;

	private List<OrderItem> items = new ArrayList<>();

//----------------------------------------------------------------------------------------

	public Order() {
	}

	public Order(Client client, Date moment, OrderStatus status) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}

//---------------------------------------------------------------------------------------

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

//----------------------------------------------------------------------------------------

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.add(item);
	}

	public double total() {

		double sum = 0.0;

		for (OrderItem it : items) {
			sum += it.subTotal();
		}

		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("ORDER SUMMAY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append("Client: " + client + "\n");

		for (OrderItem item : items) {
			sb.append(item + "\n");
		}

		sb.append("Total price: $" + String.format("%.2f", total()));

		return sb.toString();
	}
}
