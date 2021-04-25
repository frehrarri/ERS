package com.revature.models;

public class Managers {

	private double refundAmount;
	private String refundRequestedDate;
	private String refundResolvedDate;
	private String refundDescription;
	private String refundAuthor;
	private String refundResolver;
	private String refundStatusId;
	private String refundType;
	
	public Managers(String refundDescription, String refundRequestedDate, String refundStatusId, String refundType,
			double refundAmount, String refundResolvedDate, String refundResolver, String refundAuthor) {
		super();
		this.refundDescription = refundDescription;
		this.refundRequestedDate = refundRequestedDate;
		this.refundStatusId = refundStatusId;
		this.refundType = refundType;
		this.refundAmount = refundAmount;
		this.refundResolvedDate = refundResolvedDate;
		this.refundResolver = refundResolver;
		this.refundAuthor = refundAuthor;
	}

	public Managers() {
		
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundRequestedDate() {
		return refundRequestedDate;
	}

	public void setRefundRequestedDate(String refundRequestedDate) {
		this.refundRequestedDate = refundRequestedDate;
	}

	public String getRefundResolvedDate() {
		return refundResolvedDate;
	}

	public void setRefundResolvedDate(String refundResolvedDate) {
		this.refundResolvedDate = refundResolvedDate;
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

	public String getRefundStatusId() {
		return refundStatusId;
	}

	public void setRefundStatusId(String refundStatusId) {
		this.refundStatusId = refundStatusId;
	}

	public String getRefundType() {
		return refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}
	
	

}