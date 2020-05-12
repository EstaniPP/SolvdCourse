ackage com.solvd.deliveryCenter.models;

public class Address {

	private Long id;
	private Long costumerId;
	private String address;
	private String city;
	private String estate;
	private String postalCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEstate(String estate) {
		this.estate = estate;
	}
	
	public void setCostumerId(Long costumerId) {
		this.costumerId = costumerId;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getEstate() {
		return estate;
	}
	
	public Long getCostumerId() {
		return costumerId;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getAddress() {
		return address;
	}
}
