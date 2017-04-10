package com.tata.motors.add_customer.api;

import com.tata.motors.add_customer.model.data.CustomerAddedData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 29/1/17.
 */

public interface CustomerAddedResponseApi {

    @FormUrlEncoded
    @POST(Urls.RESPONSE_ADD_CUSTOMER)
    Call<CustomerAddedData> responseAddCustomer(@Field("user_id") int dsm_id,
                                                @Field("customer_name") String customer_name,
                                                @Field("application") String application_name,
                                                @Field("contact_no") String contact_no,
                                                @Field("district_id") String district_name,
                                                @Field("town") String town_name,
                                                @Field("tehsil")String tehsil,
                                                @Field("json_item") String json,
//                                                @Field("quantity")int quantity,
//                                                @Field("vehicle")String vehicle_name,
                                                @Field("financier")String financier_name,
                                                @Field("followup")String follow_up,
                                                @Field("status")int status,
                                                @Field("location")String location
                                                );

}
