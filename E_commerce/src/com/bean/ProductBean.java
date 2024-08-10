package com.bean;

public class ProductBean {
	private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private byte[] imageData;
    private String imageName;
	
    public int getProductId() {
		return productId;
	}
	
    public void setProductId(int productId) {
		this.productId = productId;
	}
	
    public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public byte[] getImageData() {
		return imageData;
	}
	
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
