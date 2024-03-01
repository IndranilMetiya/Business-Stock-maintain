package com.Business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
	@Id
	@Column(name = "stock_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	
	@Column(name = "quantity_available")
	private int quantityAvailable;
	
	@JoinColumn(name = "property_id")
	@OneToOne
	private Property property;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", quantityAvailable=" + quantityAvailable + ", property=" + property
				+ "]";
	}
	
	

}
