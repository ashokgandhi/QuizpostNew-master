package com.example.india.quizpost.Api_Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CompanyResponse {

    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("company_name")
    @Expose
    private String companyName;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

        @SerializedName("c_id")
        @Expose
        private String c_id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("company_name")
        @Expose
        private String companyName;
        @SerializedName("company_description")
        @Expose
        private String companyDescription;
        @SerializedName("skills")
        @Expose
        private String skills;
        @SerializedName("job_type")
        @Expose
        private String jobType;
        @SerializedName("salary")
        @Expose
        private String salary;

        public String getId() {
            return c_id;
        }

        public void setId(String c_id) {
            this.c_id = c_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyDescription() {
            return companyDescription;
        }

        public void setCompanyDescription(String companyDescription) {
            this.companyDescription = companyDescription;
        }

        public String getSkills() {
            return skills;
        }

        public void setSkills(String skills) {
            this.skills = skills;
        }

        public String getJobType() {
            return jobType;
        }

        public void setJobType(String jobType) {
            this.jobType = jobType;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }
    }
}