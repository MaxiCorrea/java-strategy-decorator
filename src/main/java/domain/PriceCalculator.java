package domain;

public interface PriceCalculator { // Strategy

	Money calculate(Order order);
	
}
