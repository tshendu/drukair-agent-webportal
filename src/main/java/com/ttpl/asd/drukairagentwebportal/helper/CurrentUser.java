package com.ttpl.asd.drukairagentwebportal.helper;

import java.util.Date;

public class CurrentUser {
    private String agentCode;
    private String username;
    private String agentName;
    private Date createdDate;
    private Boolean status;
    //endregion

    //region empty constructor
    public CurrentUser() {
    }
    //endregion

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
}
