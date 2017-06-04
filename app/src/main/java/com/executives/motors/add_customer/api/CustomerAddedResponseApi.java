package com.executives.motors.add_customer.api;

import com.executives.motors.add_customer.model.data.CustomerAddedData;
import com.executives.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aman on 29/1/17.
 */

public interface CustomerAddedResponseApi {

    @FormUrlEncoded
    @POST(Urls.RESPONSE_ADD_CUSTOMER)
    Call<CustomerAddedData> responseAddCustomer(@Field("access_token")String access_token,
                                                @Field("user_id") int dsm_id,
                                                @Field("customer_name") String customer_name,
                                                @Field("address") String address,
                                                @Field("email") String email,
                                                @Field("application") String application_name,
                                                @Field("contact_no") String contact_no,
                                                @Field("district") String district_name,
                                                @Field("town") String town_name,
                                                @Field("tehsil")String tehsil,
                                                @Field("vehicle_data_list") String json,
//                                                @Field("quantity")int quantity,
//                                                @Field("vehicle")String vehicle_name,
                                                @Field("financier")String financier_name,
                                                @Field("followup")String follow_up,
                                                @Field("status")int status,
                                                @Field("location")String location
                                                );

}
