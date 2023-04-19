package pl.csanecki.AITSI.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "PRODUCER")
	@Length(min = 2, max = 50, message = "* Proszę podaj nazwę producenta zawierającą od 2 do 50 znaków")
	@NotEmpty(message = "* Proszę podaj nazwę producenta")
	private String producer;

	@Column(name = "MODEL")
	@Length(min = 2, max = 100, message = "* Proszę podaj model zawierający od 2 do 100 znaków")
	@NotEmpty(message = "* Proszę podaj nazwę producenta")
	private String model;

	@Column(name = "DESCRIPTION")
	@Length(max = 1000, message = "* Opis nie może być dłuższy niż 1000 znaków")
	private String description;

	@Column(name = "PRIZE")
	@Digits(integer = 10, fraction = 2,
			message = "* Proszę wprowadź cenę do 2 miejsc po przecinku i o 10 przed przecinkiem")
	@DecimalMin(value = "0.01", message = "* Proszę wprowadź cenę produktu")
	@NotNull(message = "* Proszę podaj cenę")
	private Double prize;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productTypeId")
	private ProductType productType;

	@Valid
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productCountId")
	private ProductCount productCount;

	public Product() {
		productCount = new ProductCount();
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", producer='" + producer + '\'' +
				", model='" + model + '\'' +
				", description='" + description + '\'' +
				", prize=" + prize +
				", productType=" + productType +
				", productCount=" + productCount +
				'}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
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
		Product other = (Product) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductCount getProductCount() {
		return productCount;
	}

	public void setProductCount(ProductCount productCount) {
		this.productCount = productCount;
	}
}













