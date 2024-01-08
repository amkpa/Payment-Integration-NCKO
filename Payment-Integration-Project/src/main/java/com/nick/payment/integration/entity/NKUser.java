package com.nick.payment.integration.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nick.payment.integration.user.Cnst;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "NK_USER")
public class NKUser {
	// User identification
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nk_user_id")
	private Long nkUserId;

	// Authentication
	private String nkUsername;
	@JsonIgnore
	private String nkPassword;

	// Personal Information
	private String nkFullName;

	@Temporal(TemporalType.DATE)
	private Date nkDateOfBirth;

	// Contact Information
	private String nkEmailAddress;
	private String nkPhoneNumber;

	// Address Information
	private String nkBillingAddress;
	private String nkShippingAddress;

	// Payment Method Management
	private String nkCreditCardNumber;
	private String nkUpiId;
	private String nkPaytmDetails;
	@OneToMany(mappedBy = "nkUser", cascade = CascadeType.ALL)
	private List<NKPayment> payments;

	// Preferences
	@JsonIgnore
	private boolean nkEmailNotifications;
	@JsonIgnore
	private boolean nkSmsNotifications;
	@JsonIgnore
	private String nkLanguagePreference;

	// Security Settings
	@JsonIgnore
	private boolean nkTwoFactorAuthentication;
	@JsonIgnore
	private String nkSecurityQuestion;

	// Account Status
	@JsonIgnore
	private boolean nkAccountActivated = Cnst.NO;
	@JsonIgnore
	private boolean nkAccountLocked;

	// Role and Permissions
	@JsonIgnore
	private String nkUserRole = Cnst.Default;

	// Social Media Integration
	@JsonIgnore
	private String nkSocialMediaLink;

	// Account History

	@Temporal(TemporalType.TIMESTAMP)
	private Date nkCreationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date nkLastLoginDate;

	// Constructors, getters, setters, and other methods can be added here.

	public NKUser() {
		super();
	}

	public NKUser(Long nkUserId, String nkUsername, String nkPassword, String nkFullName, Date nkDateOfBirth,
			String nkEmailAddress, String nkPhoneNumber, String nkBillingAddress, String nkShippingAddress,
			String nkCreditCardNumber, String nkUpiId, String nkPaytmDetails, boolean nkEmailNotifications,
			boolean nkSmsNotifications, String nkLanguagePreference, boolean nkTwoFactorAuthentication,
			String nkSecurityQuestion, boolean nkAccountActivated, boolean nkAccountLocked, String nkUserRole,
			String nkSocialMediaLink, Date nkCreationDate, Date nkLastLoginDate) {
		super();
		this.nkUserId = nkUserId;
		this.nkUsername = nkUsername;
		this.nkPassword = nkPassword;
		this.nkFullName = nkFullName;
		this.nkDateOfBirth = nkDateOfBirth;
		this.nkEmailAddress = nkEmailAddress;
		this.nkPhoneNumber = nkPhoneNumber;
		this.nkBillingAddress = nkBillingAddress;
		this.nkShippingAddress = nkShippingAddress;
		this.nkCreditCardNumber = nkCreditCardNumber;
		this.nkUpiId = nkUpiId;
		this.nkPaytmDetails = nkPaytmDetails;
		this.nkEmailNotifications = nkEmailNotifications;
		this.nkSmsNotifications = nkSmsNotifications;
		this.nkLanguagePreference = nkLanguagePreference;
		this.nkTwoFactorAuthentication = nkTwoFactorAuthentication;
		this.nkSecurityQuestion = nkSecurityQuestion;
		this.nkAccountActivated = nkAccountActivated;
		this.nkAccountLocked = nkAccountLocked;
		this.nkUserRole = nkUserRole;
		this.nkSocialMediaLink = nkSocialMediaLink;
		this.nkCreationDate = nkCreationDate;
		this.nkLastLoginDate = nkLastLoginDate;
	}

	public Long getNkUserId() {
		return nkUserId;
	}

	public void setNkUserId(Long nkUserId) {
		this.nkUserId = nkUserId;
	}

	public String getNkUsername() {
		return nkUsername;
	}

	public void setNkUsername(String nkUsername) {
		this.nkUsername = nkUsername;
	}

	public String getNkPassword() {
		return nkPassword;
	}

	public void setNkPassword(String nkPassword) {
		this.nkPassword = nkPassword;
	}

	public String getNkFullName() {
		return nkFullName;
	}

	public void setNkFullName(String nkFullName) {
		this.nkFullName = nkFullName;
	}

	public Date getNkDateOfBirth() {
		return nkDateOfBirth;
	}

	public void setNkDateOfBirth(Date nkDateOfBirth) {
		this.nkDateOfBirth = nkDateOfBirth;
	}

	public String getNkEmailAddress() {
		return nkEmailAddress;
	}

	public void setNkEmailAddress(String nkEmailAddress) {
		this.nkEmailAddress = nkEmailAddress;
	}

	public String getNkPhoneNumber() {
		return nkPhoneNumber;
	}

	public void setNkPhoneNumber(String nkPhoneNumber) {
		this.nkPhoneNumber = nkPhoneNumber;
	}

	public String getNkBillingAddress() {
		return nkBillingAddress;
	}

	public void setNkBillingAddress(String nkBillingAddress) {
		this.nkBillingAddress = nkBillingAddress;
	}

	public String getNkShippingAddress() {
		return nkShippingAddress;
	}

	public void setNkShippingAddress(String nkShippingAddress) {
		this.nkShippingAddress = nkShippingAddress;
	}

	public String getNkCreditCardNumber() {
		return nkCreditCardNumber;
	}

	public void setNkCreditCardNumber(String nkCreditCardNumber) {
		this.nkCreditCardNumber = nkCreditCardNumber;
	}

	public String getNkUpiId() {
		return nkUpiId;
	}

	public void setNkUpiId(String nkUpiId) {
		this.nkUpiId = nkUpiId;
	}

	public String getNkPaytmDetails() {
		return nkPaytmDetails;
	}

	public void setNkPaytmDetails(String nkPaytmDetails) {
		this.nkPaytmDetails = nkPaytmDetails;
	}

	public boolean isNkEmailNotifications() {
		return nkEmailNotifications;
	}

	public void setNkEmailNotifications(boolean nkEmailNotifications) {
		this.nkEmailNotifications = nkEmailNotifications;
	}

	public boolean isNkSmsNotifications() {
		return nkSmsNotifications;
	}

	public void setNkSmsNotifications(boolean nkSmsNotifications) {
		this.nkSmsNotifications = nkSmsNotifications;
	}

	public String getNkLanguagePreference() {
		return nkLanguagePreference;
	}

	public void setNkLanguagePreference(String nkLanguagePreference) {
		this.nkLanguagePreference = nkLanguagePreference;
	}

	public boolean isNkTwoFactorAuthentication() {
		return nkTwoFactorAuthentication;
	}

	public void setNkTwoFactorAuthentication(boolean nkTwoFactorAuthentication) {
		this.nkTwoFactorAuthentication = nkTwoFactorAuthentication;
	}

	public String getNkSecurityQuestion() {
		return nkSecurityQuestion;
	}

	public void setNkSecurityQuestion(String nkSecurityQuestion) {
		this.nkSecurityQuestion = nkSecurityQuestion;
	}

	public boolean isNkAccountActivated() {
		return nkAccountActivated;
	}

	public void setNkAccountActivated(boolean nkAccountActivated) {
		this.nkAccountActivated = nkAccountActivated;
	}

	public boolean isNkAccountLocked() {
		return nkAccountLocked;
	}

	public void setNkAccountLocked(boolean nkAccountLocked) {
		this.nkAccountLocked = nkAccountLocked;
	}

	public String getNkUserRole() {
		return nkUserRole;
	}

	public void setNkUserRole(String nkUserRole) {
		this.nkUserRole = nkUserRole;
	}

	public String getNkSocialMediaLink() {
		return nkSocialMediaLink;
	}

	public void setNkSocialMediaLink(String nkSocialMediaLink) {
		this.nkSocialMediaLink = nkSocialMediaLink;
	}

	public Date getNkCreationDate() {
		return nkCreationDate;
	}

	public void setNkCreationDate(Date nkCreationDate) {
		this.nkCreationDate = nkCreationDate;
	}

	public Date getNkLastLoginDate() {
		return nkLastLoginDate;
	}

	public void setNkLastLoginDate(Date nkLastLoginDate) {
		this.nkLastLoginDate = nkLastLoginDate;
	}

}
