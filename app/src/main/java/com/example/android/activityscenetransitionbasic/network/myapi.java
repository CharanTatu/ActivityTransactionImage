package com.example.android.activityscenetransitionbasic.network;

import com.example.android.activityscenetransitionbasic.model.Job;
import com.example.android.activityscenetransitionbasic.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;

public interface myapi {

    @GET("getall")
    Call<List<Student>> getmodels();

//    @GET("save")
//    Call<List<Student>>getsavedata(
//            @Body Student student
//    );

//    @HTTP(method = "GET", path = "save", hasBody = true)
//    Call<List<Student>>getsavedata(
//         @Body Student student
//    );
    //  @Field("name") String name,@Field("marks") String marks,@Field("phone") String phone,@Field("email") String email, @Field("address")String address

      @POST("users")
    Call<Job>getsavedata(
            @Body Job job
      );

}
