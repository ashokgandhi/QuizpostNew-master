package com.example.india.quizpost.Api_Interface;

import com.example.india.quizpost.Api_Response.CompanyResponse;
import com.example.india.quizpost.Api_Response.ForgetPasswordReset;
import com.example.india.quizpost.Api_Response.Form_register;
import com.example.india.quizpost.Api_Response.GalleryInsertResponse;
import com.example.india.quizpost.Api_Response.GroupDInterview;
import com.example.india.quizpost.Api_Response.InterviewQuestionResponse;
import com.example.india.quizpost.Api_Response.InterviewResumeResponse;
import com.example.india.quizpost.Api_Response.LoginResponse;
import com.example.india.quizpost.Api_Response.NormalQuizResponse;
import com.example.india.quizpost.Api_Response.ProfileResponse;
import com.example.india.quizpost.Api_Response.QuizPlayResponse;
import com.example.india.quizpost.Api_Response.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

//login
    @FormUrlEncoded
    @POST("login_controller.php")//file name in htdocs
    Call<LoginResponse> LoginResponse(//response class name
            @Field("login") String tag,
            @Field("phoneno") String name,
            @Field("password") String password) ;

//register
    @FormUrlEncoded
    @POST("register_controller.php")//file name in htdocs
    Call<RegisterResponse> RegisterResponse(
            //response class name
            @Field("register") String tag,
            @Field("name") String name,
            @Field("password") String password,
            @Field("phoneno") String phoneno,
            @Field("college") String college,
            @Field("email") String email,
            @Field("dob") String dob,
            @Field("location")String location,
            @Field("gender") String gender);



    @FormUrlEncoded
    @POST("updatequerry.php")//file name in htdocs
    Call<ForgetPasswordReset> ForgetPasswordReset(
            //response class name
    @Field("update") String tag,
    @Field("email") String email,
    @Field("password") String password) ;

    @FormUrlEncoded
    @POST("userviewapi.php")
    Call<ProfileResponse> demodata(
            @Field("view") String tag);

//companyrecruitment interface
    @FormUrlEncoded
    @POST("companyrecruitment.php")
    Call<CompanyResponse> company(
            @Field("view1") String tag);


    @FormUrlEncoded
    @POST("gallerydata_controller.php")
    Call<GalleryInsertResponse> galleryinsert(
            @Field("addimage") String tag,
            @Field("gallery_name") String galleryname,
            @Field("gallery_image") String galleryimage);



  //interviewTipsQuestion interface
    @FormUrlEncoded
    @POST("interviewtips.php")
    Call<InterviewQuestionResponse> ques(
            @Field("view1") String tag);


    //interviewGD interface
    @FormUrlEncoded
    @POST("interviewgd.php")
    Call<GroupDInterview> gd(
            @Field("discuss") String tag);



    //interviewResumeTIps interface
    @FormUrlEncoded
    @POST("resumetips.php")
    Call<InterviewResumeResponse> resume(
            @Field("keyresume1") String tag);





    //normalquiz

    @FormUrlEncoded
    @POST("normalquizquestion.php")
    Call<QuizPlayResponse>onlineresponse(
            @Field("quiz")int tag
    );

//companyapply

    @FormUrlEncoded
    @POST("companyapply.php")
    Call<Form_register>form(
            @Field("form1")String tag,
            @Field("name")String name,
            @Field("phone_number")String phone_number,
            @Field("email_address")String email_address,
            @Field("college_name")String college_name,
            @Field("company_applied")String company_applied,
            @Field("qualification")String qualification);


    //NormalquizInterace

    @FormUrlEncoded
    @POST("quiztypeApi.php")
    Call<NormalQuizResponse>normalquiz(
            @Field("view1")String tag);
}
