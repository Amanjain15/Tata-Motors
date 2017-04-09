package com.tata.motors.add_customer.api;

import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerRequestApi {

    @GET(Urls.REQUEST_ADD_CUSTOMER)
    Call<AddCustomerData> requestAddCustomer(@Query("access_token") String access_token,
                                             @Query("user_id") int user_id,
                                             @Query("user_type") String user_type);

}
