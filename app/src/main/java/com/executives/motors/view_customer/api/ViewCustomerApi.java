package com.executives.motors.view_customer.api;

import com.executives.motors.helper.Urls;
import com.executives.motors.view_customer.model.data.ViewCustomerData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aman on 11/4/17.
 */

public interface ViewCustomerApi {

    @GET(Urls.REQUEST_VIEW_CUSTOMER)
    Call<ViewCustomerData> requestViewCustomer(@Query("access_token") String access_token,
                                               @Query("choose_id") int customer_id);

}
