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
    Call<CustomerAddedData> responseAddCustomer(@Field("customer_name") String customer_name,
                                                @Field("application_id") String application_id,
                                                @Field("contact_no") String contact_no,
                                                @Field("district_id") String district_id,
                                                @Field("town_id") String town_id,
                                                @Field("tehsil")String tehsil,
                                                @Field("model_id") String model_id,
                                                @Field("quantity")String quantity,
                                                @Field("vehicle_id")String vehicle_id,
                                                @Field("financier_id")String financier_id,
                                                @Field("follow_up")int follow_up,
                                                @Field("geo_tag") String geo_tag
                                                );

}
