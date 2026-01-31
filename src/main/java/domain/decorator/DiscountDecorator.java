package domain.decorator;

import java.math.BigDecimal;

import domain.Money;
import domain.Order;
import domain.PriceCalculator;

public class DiscountDecorator extends PriceCalculatorDecorator {

	private final BigDecimal discount;
	
	public DiscountDecorator(
			final PriceCalculator delegate,
			final BigDecimal discount) {
		super(delegate);
		this.discount = discount;
	}

	@Override
	public Money calculate(
			final Order order) {
		Money base = deledate.calculate(order);
		return  base.subtract(Money.of(discount));
	}

}
