package com.tata.motors.employee.api;


import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 24/1/17.
 */
public interface EmployeeApi {

    @GET(Urls.REQUEST_EMPLOYEE)
    Call<EmployeeData> getemployee(@Query("accesstoken") String token,
                                   @Query("employee_type")String employee );

}
