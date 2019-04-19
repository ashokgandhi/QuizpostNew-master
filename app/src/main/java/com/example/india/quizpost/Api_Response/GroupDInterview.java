package com.example.india.quizpost.Api_Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupDInterview {

    //Group DisscussionResponse

    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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


    public class User {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("quesno")
        @Expose
        private String quesno;
        @SerializedName("gdquestion")
        @Expose
        private String gdquestion;
        @SerializedName("gddescription")
        @Expose
        private String gddescription;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuesno() {
            return quesno;
        }

        public void setQuesno(String quesno) {
            this.quesno = quesno;
        }

        public String getGdquestion() {
            return gdquestion;
        }

        public void setGdquestion(String gdquestion) {
            this.gdquestion = gdquestion;
        }

        public String getGddescription() {
            return gddescription;
        }

        public void setGddescription(String gddescription) {
            this.gddescription = gddescription;
        }
    }
    }
