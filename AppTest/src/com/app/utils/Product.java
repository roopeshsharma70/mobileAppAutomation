package com.app.utils;

import java.util.Objects;

/**
 * @author roopesh.sharma
 *
 */
public class Product {
	String productName;
	String price;
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}
