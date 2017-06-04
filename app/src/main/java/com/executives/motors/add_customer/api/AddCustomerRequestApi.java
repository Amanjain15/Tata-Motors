package com.executives.motors.add_customer.api;

import com.executives.motors.add_customer.model.data.AddCustomerData;
import com.executives.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 27/1/17.
 */

public interface AddCustomerRequestApi {

    @GET(Urls.REQUEST_ADD_CUSTOMER)
    Call<AddCustomerData> requestAddCustomer(@Query("access_token") String access_token);

}
