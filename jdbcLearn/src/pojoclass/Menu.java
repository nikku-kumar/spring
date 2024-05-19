package pojoclass;

public class Menu {
	private int menuId;
	private int resturentId;
	private String itemNmae;
	private String desciption;
	private float price;
	private String isActive;
	
	Menu(){
		
	}

	public Menu(int menuId, int resturentId, String itemNmae, String desciption, float price, String isActive) {
		super();
		this.menuId = menuId;
		this.resturentId = resturentId;
		this.itemNmae = itemNmae;
		this.desciption = desciption;
		this.price = price;
		this.isActive = isActive;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	
	public int getResturentId() {
		return resturentId;
	}

	public void setResturentId(int resturentId) {
		this.resturentId = resturentId;
	}
	

	public String getItemNmae() {
		return itemNmae;
	}

	public void setItemNmae(String itemNmae) {
		this.itemNmae = itemNmae;
	}
	

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", resturentId=" + resturentId + ", itemNmae=" + itemNmae + ", desciption="
				+ desciption + ", price=" + price + ", isActive=" + isActive + "]";
	}
	
	

}
