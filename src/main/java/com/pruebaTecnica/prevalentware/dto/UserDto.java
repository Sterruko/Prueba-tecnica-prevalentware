package com.pruebaTecnica.prevalentware.dto;

import java.util.Date;

public class UserDto {

    private String id;
    private String email;
    private Date emailVerified;
    private Date termsAndConditionsAccepted;
    private String name;
    private String image;
    private String position;
    private Date createdAt;
    private Date updatedAt;
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Date emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Date getTermsAndConditionsAccepted() {
        return termsAndConditionsAccepted;
    }

    public void setTermsAndConditionsAccepted(Date termsAndConditionsAccepted) {
        this.termsAndConditionsAccepted = termsAndConditionsAccepted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
