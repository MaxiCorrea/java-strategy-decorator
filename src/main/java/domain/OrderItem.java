package domain;

import java.math.BigDecimal;

public class OrderItem {

	private Money price;
	private int quantity;
	
	public OrderItem(
			final Money price,
			final int quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	
	public Money total() {
		return price.multiply(Money.of(new BigDecimal(quantity)));
	}
	
}
