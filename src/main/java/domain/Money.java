package domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {

	public static Money of(
			final BigDecimal value) {
		return new Money(value);
	}
		
	public static Money zero() {
		return new Money(BigDecimal.ZERO);
	}
	
	private final BigDecimal value;
	
	private Money(
			final BigDecimal value) {
		this.value = value;
	}

	public Money add(
			final Money other) {
		return new Money(value.add(other.value));
	}
	
	public Money subtract(
			final Money other) {
		return new Money(value.subtract(other.value)); 
	}

	public Money multiply(
			final Money other) {
		return new Money(value.multiply(other.value)); 
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}
