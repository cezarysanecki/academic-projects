package pl.csanecki.AITSI.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_TYPE_ID")
	private long productTypeId;
	
	@Column(name = "NAME")
	@NotEmpty(message = "* Proszę podaj nazwę kategorii")
	@Length(min = 2, max = 50, message = "* Nazwa powinna zawierać od 2 do 50 znaków")
	private String name;

	@Override
	public String toString() {
		return "ProductType{" +
				"productTypeId=" + productTypeId +
				", name='" + name + '\'' +
				'}';
	}

	public long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}















