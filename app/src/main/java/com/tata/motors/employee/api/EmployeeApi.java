package com.tata.motors.employee.api;


import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.StatusData;
import com.tata.motors.helper.Urls;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeApi {

    @GET(Urls.REQUEST_EMPLOYEE)
    Call<EmployeeData> getemployee(@Query("access_token") String token,
                                   @Query("choose_id")int choose_id,@Query("user_see_type") String user_c_type,
                                   @Query("to_date") String to_date,@Query("from_date") String from_date,
                                   @Query("choice")int choice);
    @FormUrlEncoded
    @POST(Urls.SEND_STATUS)
    Call<StatusData> sendStatus(@Field("access_token") String token, @Field("id") int id);

}