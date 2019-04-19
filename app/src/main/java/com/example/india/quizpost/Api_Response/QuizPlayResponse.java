package com.example.india.quizpost.Api_Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class QuizPlayResponse {



    @SerializedName("users")
    @Expose
    private ArrayList<User> users = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
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

    @SerializedName("q_id")
    @Expose
    private String qId;
    @SerializedName("questionno")
    @Expose
    private String questionno;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("option_a")
    @Expose
    private String optionA;
    @SerializedName("option_b")
    @Expose
    private String optionB;
    @SerializedName("option_c")
    @Expose
    private String optionC;
    @SerializedName("option_d")
    @Expose
    private String optionD;
    @SerializedName("correctans")
    @Expose
    private String correctans;
    @SerializedName("c_id")
    @Expose
    private String cId;
    @SerializedName("u_id")
    @Expose
    private String uId;

    public String getQId() {
        return qId;
    }

    public void setQId(String qId) {
        this.qId = qId;
    }

    public String getQuestionno() {
        return questionno;
    }

    public void setQuestionno(String questionno) {
        this.questionno = questionno;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectans() {
        return correctans;
    }

    public void setCorrectans(String correctans) {
        this.correctans = correctans;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

}

}
