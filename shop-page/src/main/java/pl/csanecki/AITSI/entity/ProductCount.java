package pl.csanecki.AITSI.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT_COUNT")
public class ProductCount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_COUNT_ID")
	private long productCountId;

	@Column(name = "AVAILABLE_AMOUNT")
	@NotNull(message = "* Proszę podaj dostępną ilość produktu")
	@Min(value = 0, message = "* Proszę wprowadź liczbę nieujemną dostępnej ilości produktu")
	private Integer availableAmount;
	
	@Column(name = "PEOPLE_BOUGHT")
	private Integer peopleBought;
	
	@Column(name = "ITEM_BOUGHT")
	private Integer itemBought;

	public ProductCount() {
		this.peopleBought = 0;
		this.itemBought = 0;
	}

	public void subtractAmountOfProduct(int amountToSubtract) {
		availableAmount -= amountToSubtract;
	}

	public void increaseSoldRating(int amount) {
		itemBought += amount;
		peopleBought++;
	}

	@Override
	public String toString() {
		return "ProductCount{" +
				"productCountId=" + productCountId +
				", availableAmount=" + availableAmount +
				", peopleBought=" + peopleBought +
				", itemBought=" + itemBought +
				'}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableAmount == null) ? 0 : availableAmount.hashCode());
		result = prime * result + ((itemBought == null) ? 0 : itemBought.hashCode());
		result = prime * result + ((peopleBought == null) ? 0 : peopleBought.hashCode());
		result = prime * result + (int) (productCountId ^ (productCountId >>> 32));
		return result;
	}

	public long getProductCountId() {
		return productCountId;
	}

	public void setProductCountId(long productCountId) {
		this.productCountId = productCountId;
	}

	public Integer getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(Integer availableAmount) {
		this.availableAmount = availableAmount;
	}

	public Integer getPeopleBought() {
		return peopleBought;
	}

	public void setPeopleBought(Integer peopleBought) {
		this.peopleBought = peopleBought;
	}

	public Integer getItemBought() {
		return itemBought;
	}

	public void setItemBought(Integer itemBought) {
		this.itemBought = itemBought;
	}
}
