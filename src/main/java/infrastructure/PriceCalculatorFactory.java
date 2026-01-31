package infrastructure;

import java.math.BigDecimal;

import domain.BasePriceCalculator;
import domain.PriceCalculator;
import domain.decorator.DiscountDecorator;
import domain.decorator.TaxDecorator;

public class PriceCalculatorFactory {

	public static PriceCalculator create() { 
		PriceCalculator strategy = new BasePriceCalculator();
		strategy = new TaxDecorator(strategy, new BigDecimal("0.21"));
		strategy = new DiscountDecorator(strategy, new BigDecimal("100"));
		return strategy;
	}
	
}
