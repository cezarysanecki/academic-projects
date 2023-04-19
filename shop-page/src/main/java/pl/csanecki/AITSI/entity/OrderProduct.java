package pl.csanecki.AITSI.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_PRODUCT_ID")
	private long orderProductId;
	
	@OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

	@ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

	@Column(name = "AMOUNT")
    private int amount;

    public OrderProduct() {
    }

    public OrderProduct(Product product, int amount) {
        this.orderProductId = product.getProductId();
        this.product = product;
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderProductId=" + orderProductId +
                ", product=" + product +
                ", order=" + order +
                ", amount=" + amount +
                '}';
    }

    public long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProduct other = (OrderProduct) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}
