package com.revature.models;

public class Employees {

	private double refundAmount;
	private boolean refundResolved;
	private String refundType;
	private String refundDescription;
	private String refundAuthor;
	private String refundResolver;
	
	public Employees() {
		
	}
	
	public Employees(double refundAmount, boolean refundResolved, string refundType, String refundDescription, String refundAuthor, String refundResolver) {
		this.refundAmount = refundAmount;
		this.refundResolved = refundResolved;
		this.refundType = refundType;
		this.refundDescription = refundDescription;
		this.refundAuthor = refundAuthor;
		this.refundResolver = refundResolver;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public boolean isRefundResolved() {
		return refundResolved;
	}

	public void setRefundResolved(boolean refundResolved) {
		this.refundResolved = refundResolved;
	}

	public String getRefundType() {
		return refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	public String getRefundDescription() {
		return refundDescription;
	}

	public void setRefundDescription(String refundDescription) {
		this.refundDescription = refundDescription;
	}

	public String getRefundAuthor() {
		return refundAuthor;
	}

	public void setRefundAuthor(String refundAuthor) {
		this.refundAuthor = refundAuthor;
	}

	public String getRefundResolver() {
		return refundResolver;
	}

	public void setRefundResolver(String refundResolver) {
		this.refundResolver = refundResolver;
	}
}
