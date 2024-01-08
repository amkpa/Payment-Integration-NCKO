package com.nick.payment.integration.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NK_PAYMENT")
public class NKPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nkPaymentId;

	private Double nkPaymentAmount;

	private String nkPaymentMethod;

	private String nkTransactionStatus;

	private String nkAdditionalDetails;

	// Many payments can be associated with one user
	@ManyToOne(fetch = FetchType.LAZY) // Change FetchType.LAZY
	@JoinColumn(name = "nkUserId", nullable = false)
	private NKUser nkUser; // Reference to the user who made the payment

	@Override
	public String toString() {
	    return "NKPayment{" +
	            "nkPaymentId=" + nkPaymentId +
	            ", nkPaymentAmount=" + nkPaymentAmount +
	            ", nkPaymentMethod='" + nkPaymentMethod +
	            ", nkUser=" + nkUser +
	            ", nkPaymentDate=" + nkPaymentDate +
	            '}';
	}


	private Date nkPaymentDate;

	public NKPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NKPayment(Long nkPaymentId, Double nkPaymentAmount, String nkPaymentMethod, String nkTransactionStatus,
			String nkAdditionalDetails, NKUser nkUser, Date nkPaymentDate) {
		super();
		this.nkPaymentId = nkPaymentId;
		this.nkPaymentAmount = nkPaymentAmount;
		this.nkPaymentMethod = nkPaymentMethod;
		this.nkTransactionStatus = nkTransactionStatus;
		this.nkAdditionalDetails = nkAdditionalDetails;
		this.nkUser = nkUser;
		this.nkPaymentDate = nkPaymentDate;
	}

	public Long getNkPaymentId() {
		return nkPaymentId;
	}

	public void setNkPaymentId(Long nkPaymentId) {
		this.nkPaymentId = nkPaymentId;
	}

	public Double getNkPaymentAmount() {
		return nkPaymentAmount;
	}

	public void setNkPaymentAmount(Double nkPaymentAmount) {
		this.nkPaymentAmount = nkPaymentAmount;
	}

	public String getNkPaymentMethod() {
		return nkPaymentMethod;
	}

	public void setNkPaymentMethod(String nkPaymentMethod) {
		this.nkPaymentMethod = nkPaymentMethod;
	}

	public String getNkTransactionStatus() {
		return nkTransactionStatus;
	}

	public void setNkTransactionStatus(String nkTransactionStatus) {
		this.nkTransactionStatus = nkTransactionStatus;
	}

	public String getNkAdditionalDetails() {
		return nkAdditionalDetails;
	}

	public void setNkAdditionalDetails(String nkAdditionalDetails) {
		this.nkAdditionalDetails = nkAdditionalDetails;
	}

	public NKUser getNkUser() {
		return nkUser;
	}

	public void setNkUser(NKUser nkUser) {
		this.nkUser = nkUser;
	}

	public Date getNkPaymentDate() {
		return nkPaymentDate;
	}

	public void setNkPaymentDate(Date nkPaymentDate) {
		this.nkPaymentDate = nkPaymentDate;
	}

}