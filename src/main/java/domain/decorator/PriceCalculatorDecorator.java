package domain.decorator;

import domain.PriceCalculator;

public abstract class PriceCalculatorDecorator implements PriceCalculator { 

	final PriceCalculator deledate;
	
	public PriceCalculatorDecorator(
			final PriceCalculator delegate) {
		this.deledate = delegate;
	}

}
