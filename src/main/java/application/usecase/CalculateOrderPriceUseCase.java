package application.usecase;

import domain.Money;
import domain.Order;
import domain.PriceCalculator;

public class CalculateOrderPriceUseCase {

	private final PriceCalculator calculator; 
	
	public CalculateOrderPriceUseCase(
			final PriceCalculator calculator) {
		this.calculator = calculator;
	}
	
	public Money execute(
			final Order order) {
		return calculator.calculate(order);
	}
	
}
