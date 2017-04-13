package com.tata.motors.add_customer.api;


import com.tata.motors.add_customer.model.data.CustomerAddedData;
import com.tata.motors.add_customer.model.data.EditCustomerData;
import com.tata.motors.helper.Urls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aman on 12/4/17.
 */

public interface EditCustomerApi {

    @GET(Urls.REQUEST_EDIT_CUSTOMER)
    Call<EditCustomerData> requestEditCustomer(@Query("access_token") String access_token,
                                               @Query("choose_id") int customer_id);

    @FormUrlEncoded
    @POST(Urls.REQUEST_EDIT_CUSTOMER)
    Call<CustomerAddedData> responseEditCustomer(@Field("access_token")String access_token,
                                                 @Field("user_id") int dsm_id,
                                                 @Field("choose_id") int choose_id,
                                                @Field("customer_name") String customer_name,
                                                @Field("address") String address,
                                                 @Field("email")  String email,
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
