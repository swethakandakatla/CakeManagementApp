package uk.task.waracle.CakeManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cakes")
public class Cake {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="cake_name")
	private String CakeName;
	@Column(name="cake_type")
	private String CakeType;
	@Column(name="price")
	private long price;
	
	public Cake(Long id, String cakeName, String cakeType, long price) {
		super();
		this.id = id;
		CakeName = cakeName;
		CakeType = cakeType;
		this.price = price;
	}
	
	public Cake() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCakeName() {
		return CakeName;
	}
	public void setCakeName(String cakeName) {
		CakeName = cakeName;
	}
	public String getCakeType() {
		return CakeType;
	}
	public void setCakeType(String cakeType) {
		CakeType = cakeType;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	

}
