package pojoclass;

public class Resturent {
	private int resturentId;
	private String name;
	private String cussionType;
	private String address;
	private String rating;
	private String isActive;
	Resturent(){
		
	}
	public Resturent(int resturentId, String name, String cussionType, String address, String rating, String isActive) {
		super();
		this.resturentId = resturentId;
		this.name = name;
		this.cussionType = cussionType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
	}
	
	public int getResturentId() {
		return resturentId;
	}
	public void setResturentId(int resturentId) {
		this.resturentId = resturentId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCussionType() {
		return cussionType;
	}
	public void setCussionType(String cussionType) {
		this.cussionType = cussionType;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	@Override
	public String toString() {
		return "Resturent [resturentId=" + resturentId + ", name=" + name + ", cussionType=" + cussionType
				+ ", address=" + address + ", rating=" + rating + ", isActive=" + isActive + "]";
	}
	
	
}
