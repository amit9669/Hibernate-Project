package hibernate_onetoone_uni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private int id ;
	private String name ;
	private Long phone ;
	private String address ;
	@OneToOne(cascade = CascadeType.ALL)
	private AdharCard adharCard ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AdharCard getAdharCard() {
		return adharCard;
	}
	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", adharCard="
				+ adharCard + "]"; }
}
