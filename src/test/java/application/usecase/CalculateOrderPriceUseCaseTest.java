package application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.BasePriceCalculator;
import domain.Money;
import domain.Order;
import domain.OrderItem;
import domain.PriceCalculator;
import domain.decorator.TaxDecorator;
import infrastructure.PriceCalculatorFactory;

class CalculateOrderPriceUseCaseTest {

	@Test
	void basePriceCalculation() {
		PriceCalculator base = new BasePriceCalculator();
		Order order = new Order(List.of(new OrderItem(Money.of(new BigDecimal("1000")), 1)));
		CalculateOrderPriceUseCase usecase = new CalculateOrderPriceUseCase(base);
		Money result = usecase.execute(order);
		assertEquals(Money.of(new BigDecimal("1000")),result);
	}

	@Test
	void taxIsApplied() {
		PriceCalculator base = new BasePriceCalculator();
		base = new TaxDecorator(base, new BigDecimal("0.21"));
		Order order = new Order(List.of(new OrderItem(Money.of(new BigDecimal("500")), 2)));
		CalculateOrderPriceUseCase usecase = new CalculateOrderPriceUseCase(base);
		Money result = usecase.execute(order);
		assertEquals(Money.of(new BigDecimal("1210.00")), result);
	}
	
	@Test
	void fullPriceCalculation() {
		PriceCalculator base = PriceCalculatorFactory.create();
		Order order = new Order(List.of(new OrderItem(Money.of(new BigDecimal("1000")), 1)));
		CalculateOrderPriceUseCase usecase = new CalculateOrderPriceUseCase(base);
		Money result = usecase.execute(order);
		assertEquals(Money.of(new BigDecimal("1110.00")), result);
	}
	
}
