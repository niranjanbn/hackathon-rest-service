package com.cbre.hackathonrestservice.dao.entities;

public class LeaseSales implements Entity {
	
	private String orderNumber;
	private String salesChannel;
	private String customerId;
	private String customerName;
	private String locationId;
	private String cityName;
	private String productId;
	private String productName;
	private String salesTeamId;
	private String salesName;
	private String region;
	private String orderDate;
	private String shipDate;
	private String deliveryDate;
	private float quantity;
	private String currenctCode;
	private String amount;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getSalesChannel() {
		return salesChannel;
	}
	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSalesTeamId() {
		return salesTeamId;
	}
	public void setSalesTeamId(String salesTeamId) {
		this.salesTeamId = salesTeamId;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getCurrenctCode() {
		return currenctCode;
	}
	public void setCurrenctCode(String currenctCode) {
		this.currenctCode = currenctCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String unitCost) {
		this.amount = unitCost;
	}
	
	@Override
	public String toString() {
		return "LeaseSales [orderNumber=" + orderNumber + ", salesChannel=" + salesChannel + ", customerId="
				+ customerId + ", customerName=" + customerName + ", locationId=" + locationId + ", cityName="
				+ cityName + ", productId=" + productId + ", productName=" + productName + ", salesTeamId="
				+ salesTeamId + ", salesName=" + salesName + ", region=" + region + ", orderDate=" + orderDate
				+ ", shipDate=" + shipDate + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity
				+ ", currenctCode=" + currenctCode + ", amount=" + amount + "]";
	}
	
}
