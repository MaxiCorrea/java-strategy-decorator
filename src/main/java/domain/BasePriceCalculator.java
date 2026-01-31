package domain;

public class BasePriceCalculator implements PriceCalculator { // Strategy

	@Override
	public Money calculate(
			final Order order) {
		return order.calculateTotal();
	}

}
