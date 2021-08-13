package entities;

import java.util.Objects;

public class Product implements Comparable<Product> {
	private String name;
	private Double value;

	public Product(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name + ", $" + String.format("%.2f", value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}

	@Override
	public int compareTo(Product other) {
		return value.compareTo(other.getValue());
	}

}
