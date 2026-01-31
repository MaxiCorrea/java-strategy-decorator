package domain;

import java.util.List;

public class Order {

	private final List<OrderItem> items;
	
	public Order(
			final List<OrderItem> items){
		this.items = List.copyOf(items);
	}
	
	public Money calculateTotal() {
		Money total = Money.zero();
		for(OrderItem item : this.items) 
			total = total.add(item.total());
		return total;
	}
	
}
