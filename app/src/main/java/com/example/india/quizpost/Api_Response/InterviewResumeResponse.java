package com.example.india.quizpost.Api_Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InterviewResumeResponse {

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
        @SerializedName("resume_qno")
        @Expose
        private String resumeQno;
        @SerializedName("resume_question")
        @Expose
        private String resumeQuestion;
        @SerializedName("resume_answer")
        @Expose
        private String resumeAnswer;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getResumeQno() {
            return resumeQno;
        }

        public void setResumeQno(String resumeQno) {
            this.resumeQno = resumeQno;
        }

        public String getResumeQuestion() {
            return resumeQuestion;
        }

        public void setResumeQuestion(String resumeQuestion) {
            this.resumeQuestion = resumeQuestion;
        }

        public String getResumeAnswer() {
            return resumeAnswer;
        }

        public void setResumeAnswer(String resumeAnswer) {
            this.resumeAnswer = resumeAnswer;
        }

    }
}