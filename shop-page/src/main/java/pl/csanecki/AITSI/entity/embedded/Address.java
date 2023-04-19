package pl.csanecki.AITSI.entity.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Embeddable
public class Address {
    @Column(name = "STREET")
	@Length(min = 2, max = 50, message = "* Proszę podaj nazwę ulicy zawierającą od 2 do 50 znaków")
	@NotEmpty(message = "* Proszę podaj nazwę ulicy")
    private String street;

    @Column(name = "NUMBER_OF_HOUSE")
	@Pattern(regexp = "[1-9][0-9a-zA-Z]*", message = "* Proszę podaj poprawny numer domu")
	@NotEmpty(message = "* Proszę podaj numer domu")
    private String numberOfHouse;

    @Column(name = "NUMBER_OF_FLAT")
	@Pattern(regexp = "[0-9][0-9a-zA-Z]*", message = "* Proszę podaj poprawny numer mieszkania")
    private String numberOfFlat;

    @Column(name = "CITY")
	@Length(min = 2, max = 50, message = "* Proszę podaj nazwę miasta zawierającą od 2 do 50 znaków")
	@NotEmpty(message = "* Proszę podaj nazwę miasta")
    private String city;

    @Column(name = "POST_CODE")
	@Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "* Proszę podaj poprawny kod pocztowy")
	@NotEmpty(message = "* Proszę podaj kod pocztowy")
    private String postCode;

    public Address(String street, String numberOfHouse, String numberOfFlat, String city, String postCode) {
    	super();
    	this.street = street;
        this.numberOfHouse = numberOfHouse;
        this.numberOfFlat = numberOfFlat;
        this.city = city;
        this.postCode = postCode;
    }

    public Address() {
		super();
	}

	@Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", numberOfHouse='" + numberOfHouse + '\'' +
                ", numberOfFlat='" + numberOfFlat + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public String getNumberOfFlat() {
        return numberOfFlat;
    }

    public void setNumberOfFlat(String numberOfFlat) {
        this.numberOfFlat = numberOfFlat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
