package domain.decorator;

import java.math.BigDecimal;

import domain.Money;
import domain.Order;
import domain.PriceCalculator;

public class TaxDecorator extends PriceCalculatorDecorator {

	private final BigDecimal taxRate;
	
	public TaxDecorator(
			final PriceCalculator delegate,
			final BigDecimal taxRate) {
		super(delegate);
		this.taxRate = taxRate;
	}

	@Override
	public Money calculate(
			final Order order) {
		Money base = deledate.calculate(order);
		return base.add(base.multiply(Money.of(taxRate)));
	}
}
