package com.ttpl.asd.drukairagentwebportal.dto;

import java.util.Date;

public class UserDataDTO {
    private String documentNumber;
    private Date date;
    private String userData;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }
}
