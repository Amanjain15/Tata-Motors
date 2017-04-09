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
    Call<CustomerAddedData> responseAddCustomer(@Field("dsm_id") int dsm_id,
                                                @Field("dse_id") int dse_id,
                                                @Field("customer_name") String customer_name,
                                                @Field("application_id") int application_id,
                                                @Field("contact_no") String contact_no,
                                                @Field("district_id") int district_id,
                                                @Field("town_id") int town_id,
                                                @Field("tehsil")String tehsil,
                                                @Field("model_id") int model_id,
                                                @Field("quantity")int quantity,
                                                @Field("vehicle_id")int vehicle_id,
                                                @Field("financier_id")int financier_id,
                                                @Field("follow_up")int follow_up,
                                                @Field("geo_tag") int geo_tag
                                                );

}
