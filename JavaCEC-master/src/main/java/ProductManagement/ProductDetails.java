package ProductManagement;

public class ProductDetails {
	int productID;
	String productName;
	String productDes;
	int productPrice;
	int productQuntity=1;
	
	public int getProductID() {
		return productID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getProductDes() {
		return productDes;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public int getproductQuntity() {
		return productQuntity; 
	}
	
	public void setProductID(int productID) {
		this.productID = productID; 
	}
	
	public void setProductName(String productName) {
		this.productName = productName; 
	}
	
	public void setProductDes(String productDes) {
		this.productDes = productDes; 
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice; 
	}
	
	public void setproductQuntity(int productQuntity) {
		this.productQuntity = productQuntity; 
	}
}
