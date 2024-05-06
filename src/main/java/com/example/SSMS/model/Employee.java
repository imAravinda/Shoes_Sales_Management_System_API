package com.example.SSMS.model;

import com.example.SSMS.model.enums.Gender;
import com.example.SSMS.model.enums.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.sql.Date;

public class Employee{
    private String employeeCode;
    private String employeeName;
    private String employeePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String status;
    private String designation;
    private Roles accessRole;
    private Date dob;
    private Date dateOfJoin;
    private String attachedBranch;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String contactNo;
    private String emergancyInformer;
    private String emergancyContactDetails;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePic() {
        return employeePic;
    }

    public void setEmployeePic(String employeePic) {
        this.employeePic = employeePic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Roles getAccessRole() {
        return accessRole;
    }

    public void setAccessRole(Roles accessRole) {
        this.accessRole = accessRole;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getAttachedBranch() {
        return attachedBranch;
    }

    public void setAttachedBranch(String attachedBranch) {
        this.attachedBranch = attachedBranch;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmergancyInformer() {
        return emergancyInformer;
    }

    public void setEmergancyInformer(String emergancyInformer) {
        this.emergancyInformer = emergancyInformer;
    }

    public String getEmergancyContactDetails() {
        return emergancyContactDetails;
    }

    public void setEmergancyContactDetails(String emergancyContactDetails) {
        this.emergancyContactDetails = emergancyContactDetails;
    }
}
