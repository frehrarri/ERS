package com.revature.models;

import java.sql.Date;

public class Reimbursement {

	private double refundAmount;
	private Date refundRequestedDate;
	private Date refundResolvedDate;
	private String refundDescription;
	private int refundAuthor;
	private int refundResolver;
	private static int refundStatusId;
	private int refundType;
	private int refundId;
	
	public Reimbursement(double refundAmount, Date refundRequestedDate, Date refundResolvedDate,
			String refundDescription, int refundAuthor, int refundResolver, int refundStatusId, int refundType,
			int refundId) {
		super();
		this.refundAmount = refundAmount;
		this.refundRequestedDate = refundRequestedDate;
		this.refundResolvedDate = refundResolvedDate;
		this.refundDescription = refundDescription;
		this.refundAuthor = refundAuthor;
		this.refundResolver = refundResolver;
		Reimbursement.refundStatusId = refundStatusId;
		this.refundType = refundType;
		this.refundId = refundId;
	}
	
	

	public Reimbursement(double refundAmount, Date refundRequestedDate, Date refundResolvedDate,
			String refundDescription, int refundAuthor, int refundResolver, int refundStatusId, int refundType) {
		super();
		this.refundAmount = refundAmount;
		this.refundRequestedDate = refundRequestedDate;
		this.refundResolvedDate = refundResolvedDate;
		this.refundDescription = refundDescription;
		this.refundAuthor = refundAuthor;
		this.refundResolver = refundResolver;
		Reimbursement.refundStatusId = refundStatusId;
		this.refundType = refundType;
	}



	public Reimbursement(int refundStatusId) {
		Reimbursement.refundStatusId = refundStatusId;
	}
	
	public Reimbursement() {
	}
	
	
	public int getRefundId() {
		return refundId;
	}

	public void setRefundId(int refundId) {
		this.refundId = refundId;
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

	public int getRefundAuthor() {
		return refundAuthor;
	}

	public void setRefundAuthor(int refundAuthor) {
		this.refundAuthor = refundAuthor;
	}

	public int getRefundResolver() {
		return refundResolver;
	}

	public void setRefundResolver(int refundResolver) {
		this.refundResolver = refundResolver;
	}

	public static int getRefundStatusId() {
		return refundStatusId;
	}

	public void setRefundStatusId(int refundStatusId) {
		Reimbursement.refundStatusId = refundStatusId;
	}

	public int getRefundType() {
		return refundType;
	}

	public void setRefundType(int refundType) {
		this.refundType = refundType;
	}

	

}
