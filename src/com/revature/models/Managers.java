package com.revature.models;

import java.sql.Date;

public class Managers {

	private double refundAmount;
	private Date refundRequestedDate;
	private Date refundResolvedDate;
	private String refundDescription;
	private String refundAuthor;
	private String refundResolver;
	private String refundStatusId;
	private String refundType;
	private int refundId;
	
	public Managers(int refundId, double refundAmount, Date refundRequestedDate, Date refundResolvedDate, String refundAuthor, String refundResolver, String refundStatusId,
			String refundType, String refundDescription) {
		this.refundId = refundId;
		this.refundAmount = refundAmount;
		this.refundResolvedDate = refundResolvedDate;
		this.refundAuthor = refundAuthor;
		this.refundResolver = refundResolver;
		this.refundRequestedDate = refundRequestedDate;
		this.refundStatusId = refundStatusId;
		this.refundType = refundType;
		this.refundDescription = refundDescription;
	}

	public Managers() {
		
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Date getRefundRequestedDate() {
		return refundRequestedDate;
	}

	public void setRefundRequestedDate(Date refundRequestedDate) {
		this.refundRequestedDate = refundRequestedDate;
	}

	public Date getRefundResolvedDate() {
		return refundResolvedDate;
	}

	public void setRefundResolvedDate(Date refundResolvedDate) {
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