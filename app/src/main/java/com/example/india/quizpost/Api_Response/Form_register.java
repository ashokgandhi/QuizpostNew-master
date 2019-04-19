package com.example.india.quizpost.Api_Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Form_register {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("college_name")
    @Expose
    private String collegeName;
    @SerializedName("company_applied")
    @Expose
    private String companyapplied;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCompanyapplied() {
        return companyapplied;
    }

    public void setAppliedFor(String appliedFor) {
        this.companyapplied = companyapplied;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
