package com.executives.motors.add_customer.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.executives.motors.R;
import com.executives.motors.add_customer.model.RetrofitAddCustomerProvider;
import com.executives.motors.add_customer.model.RetrofitCustomerAddedProvider;
import com.executives.motors.add_customer.model.data.AddCustomerData;
import com.executives.motors.add_customer.model.data.ApplicationListDetails;
import com.executives.motors.add_customer.model.data.DistrictListDetails;
import com.executives.motors.add_customer.model.data.DsmListDetails;
import com.executives.motors.add_customer.model.data.FinancierListDetails;
import com.executives.motors.add_customer.model.data.TownListDetails;
import com.executives.motors.add_customer.presenter.AddCustomerPresenter;
import com.executives.motors.add_customer.presenter.AddCustomerPresenterImpl;
import com.executives.motors.employee.view.EmployeeFragment;
import com.executives.motors.helper.SharedPrefs;
import com.executives.motors.home.home_page;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddCustomerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddCustomerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCustomerFragment extends Fragment implements  AddCustomerView {

    @BindView(R.id.application_spinner)
    Spinner application_spinner;

    @BindView(R.id.dsm_spinner)
    Spinner dsm_spinner;

    @BindView(R.id.district_spinner)
    Spinner district_spinner;

    @BindView(R.id.town_spinner)
    Spinner town_spinner;

//    @BindView(R.id.model_spinner)
//    Spinner model_spinner;
//
//    @BindView(R.id.vehicle_spinner)
//    Spinner vehicle_spinner;

    @BindView(R.id.financier_spinner)
    Spinner financier_spinner;

    @BindView(R.id.location_spinner)
    Spinner location_spinner;

    @BindView(R.id.status_spinner)
    Spinner status_spinner;

    @BindView(R.id.customer_name)
    TextView name;
    @BindView(R.id.address)
    TextView addressTv;

    @BindView(R.id.mobile)
    TextView mobile;

    @BindView(R.id.tehsil)
    TextView tehsil;

    @BindView(R.id.follow_up)
    TextView follow;

//    @BindView(R.id.geo_tag)

//    @BindView(R.id.quantity)
//    TextView quantity_tv;

    @BindView(R.id.submitButton)
    Button submit;

    @BindView(R.id.recycler_customer)
    RecyclerView recyclerView;

    @BindView(R.id.email)
    EditText email;

//    @BindView(R.id.fab_customer)
//    FloatingActionButton fab;
    @BindView(R.id.add_customer_toolbar)
    Toolbar toolbar;

    private ProgressBar progressBar;
    private static AddCustomerData addCustomerData1;

    private static  int dsm_id,application_id,district_id, town_id;
    private int financier_id;

    private DatePickerDialog datePicker;
    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener datePickerListener;

    private static String customer_name, application_name,contact_no, district_name,
            town_name, tehsil_name, financier_name, follow_up,location,address,email_id;
    private static int status;

    private ApplicationListDetails applicationListDetails;
    private DistrictListDetails districtListDetails;
    private TownListDetails townListDetails;
    private FinancierListDetails financierListDetails;
    private SharedPrefs sharedPrefs;
    private AddCustomerPresenter addCustomerPresenter;
    private DsmListDetails dsmListDetails;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    public static String model_id1[] = new String[10],vehicle_id1[] = new String[10];
    private static int quantity1[] = new int[10];
    private static int recyclerSize=1;
    private static int itemCount=0;
    private JSONObject jsonObject=null;
    public static int size=0;





    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddCustomerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCustomerFragment.
     */

    public static AddCustomerFragment newInstance(String param1, String param2) {
        AddCustomerFragment fragment = new AddCustomerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_customer, container, false);
        ButterKnife.bind(this, view);
        initialize();

        toolbar.setVisibility(View.GONE);
        progressBar = (ProgressBar)view.findViewById(R.id.submitBar);
        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 10) {
                    hideKeyboard();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        showSpinnerLocation();showSpinnerStatus();
        addCustomerPresenter.requestAddCustomer(sharedPrefs.getAccessToken());


        calendar = Calendar.getInstance(TimeZone.getDefault()); // Get current date

        datePickerListener = new DatePickerDialog.OnDateSetListener() {

            // when dialog box is closed, below method will be called.
            public void onDateSet(DatePicker view, int selectedYear,
                                  int selectedMonth, int selectedDay) {
                String year1 = String.valueOf(selectedYear);
                String month1 = String.valueOf(selectedMonth + 1);
                String day1 = String.valueOf(selectedDay);

                follow.setText(day1 + "/" + month1 + "/" + year1);

            }
        };

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(getContext(),
                        R.style.AppThemeDatePicker, datePickerListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
//                datePicker.setContentView(R.layout.date_picker_layout);
                datePicker.setCancelable(false);
                datePicker.setTitle("Select the date");


                datePicker.show();
            }
        });


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                itemCount=itemCount+1;
//                recyclerAdapter.setData(itemCount,addCustomerData1);
//                recyclerAdapter.notifyDataSetChanged();
//            }
//        });


        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    void initialize(){
        sharedPrefs = new SharedPrefs(getContext());
        addCustomerPresenter = new AddCustomerPresenterImpl(new RetrofitAddCustomerProvider(),this);
//        addCustomerPresenter = new AddCustomerPresenterImpl(new MockAddCustomerProvider(),this);
        recyclerAdapter = new RecyclerAdapter(getContext(),this);
        linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }



        @Override
    public void showUpdate() {

    }

    @Override
    public void showProgressBar(boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);

        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showSpinners(AddCustomerData addCustomerData)
    {
        addCustomerData1=addCustomerData;
        Log.d("check",addCustomerData1.getMessage()+"");
                        if(sharedPrefs.getUserType().equals("2"))
                        {
                            dsm_spinner.setVisibility(View.GONE);
                            dsm_id=sharedPrefs.getUserId();
                        }
                        else
                        {
                            Log.d("AddCustomer",addCustomerData.getDsmListDetails().get(0).getDsm_name()+"");
                            showSpinnerDsm(addCustomerData);
                        }
        Log.d("AddCustomer",addCustomerData.getApplicationListDetails().get(0).getName()+"");
//                      showSpinnerDsm(addCustomerData);
                        showSpinnerApplication(addCustomerData);
                        showSpinnerDistrict(addCustomerData);
                        showSpinnerTown(addCustomerData);
                        showSpinnerFinancier(addCustomerData);
//                        showSpinnerModel(addCustomerData);
//                        showSpinnerVehicle(addCustomerData);

                        recyclerAdapter.setData(1,addCustomerData);
                        recyclerAdapter.notifyDataSetChanged();
        showAdd();
        addCustomerPresenter = new AddCustomerPresenterImpl(new RetrofitCustomerAddedProvider(),this);

    }

    @Override
    public void showSpinnerDsm(AddCustomerData addCustomerData) {
        try {

            List<DsmListDetails> dsmListDetailsList = new ArrayList<DsmListDetails>(addCustomerData.getDsmListDetails());
            ArrayAdapter<String> adapter;
            int n = dsmListDetailsList.size();
            final int dsm_id_ar[] = new int[n];
            String dsm_name_ar[] = new String[n];

            int i = 0;
            while (i < n) {
                dsmListDetails = dsmListDetailsList.get(i);
                dsm_id_ar[i] = dsmListDetails.getDsm_id();
                dsm_name_ar[i] = dsmListDetails.getDsm_name();
                i++;
            }

            adapter = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, dsm_name_ar);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dsm_spinner.setAdapter(adapter);

            //OnItemSelected
            dsm_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                    //userAddedData.setName(spinner.getItemAtPosition(t).toString());
                    //userAddedData.setDsm_id(dsm_id_ar[t]);
                    dsm_id = dsm_id_ar[t];

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public int showSpinnerApplication(AddCustomerData addCustomerData) {
        try{
            List<ApplicationListDetails> applicationListDetailsList = new ArrayList<ApplicationListDetails>(addCustomerData.getApplicationListDetails());


        ArrayAdapter<String>    adapter;
        int n= applicationListDetailsList.size();
        final String application_name_ar[] = new String[n];
        final int application_id_ar[] = new int[n];
        int i=0;
        while(i<n)
        {
            applicationListDetails = applicationListDetailsList.get(i);
            application_name_ar[i] = applicationListDetails.getName();
            application_id_ar[i] = applicationListDetails.getId();
            i++;
        }
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, application_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        application_spinner.setAdapter(adapter);

        //OnItemSelected
        application_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                application_id= application_id_ar[t];
                application_name = application_name_ar[t];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }


        return application_id;
    }

    @Override
    public int showSpinnerDistrict(AddCustomerData addCustomerData) {
        try {
            List<DistrictListDetails> districtListDetailsList = new ArrayList<DistrictListDetails>(addCustomerData.getDistrictListDetails());
            ArrayAdapter<String> adapter;
            int n = districtListDetailsList.size();
            final String district_name_ar[] = new String[n];
            final int district_id_ar[] = new int[n];
            int i = 0;
            while (i < n) {
                districtListDetails = districtListDetailsList.get(i);
                district_name_ar[i] = districtListDetails.getName();
                district_id_ar[i] = districtListDetails.getId();
                i++;
            }
            adapter = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_spinner_item, district_name_ar);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            district_spinner.setAdapter(adapter);

            //OnItemSelected
            district_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                    district_id = district_id_ar[t];
                    district_name = district_name_ar[t];
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        return district_id;
    }

    @Override
    public int showSpinnerTown(AddCustomerData addCustomerData) {
        try{
        List<TownListDetails> townListDetailsList = new ArrayList<TownListDetails>(addCustomerData.getTownListDetails());
        ArrayAdapter<String> adapter;
        int n= townListDetailsList.size();
        final String town_name_ar[] = new String[n];
        final int town_id_ar[] = new int[n];
        int i=0;
        while(i<n){
            townListDetails = townListDetailsList.get(i);
            town_id_ar[i]= townListDetails.getId();
            town_name_ar[i]= townListDetails.getName();
            i++;
        }
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, town_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        town_spinner.setAdapter(adapter);

        town_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                town_id = town_id_ar[t];
                town_name = town_name_ar[t];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });}catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        return town_id;

    }


    @Override
    public int showSpinnerFinancier(AddCustomerData addCustomerData) {
        try{
        List<FinancierListDetails> financierListDetailsList = new ArrayList<FinancierListDetails>(addCustomerData.getFinancierListDetails());
        ArrayAdapter<String> adapter;
        int n = financierListDetailsList.size();
        int i=0;
        final int financier_id_ar[] = new int[n];
        final String financier_name_ar[] = new String [n];
        while(i<n){
            financierListDetails = financierListDetailsList.get(i);
            financier_id_ar[i] = financierListDetails.getId();
            financier_name_ar[i]= financierListDetails.getName();
            i++;
            }
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, financier_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        financier_spinner.setAdapter(adapter);
        financier_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                financier_id =  financier_id_ar[t];
                financier_name = financier_name_ar[t];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        return financier_id;

    }

    public void showSpinnerLocation() {


        final String locationDetails[] = new String[4];
        locationDetails[0] = "Met in Person";
        locationDetails[1] = "Walk in";
        locationDetails[2] = "Tele in";
        locationDetails[3] = "Fixed a meeting";
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,locationDetails);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location_spinner.setAdapter(adapter);
        location_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                location=locationDetails[t];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void showSpinnerStatus() {
        final String statusDetails[] = new String[3];
        statusDetails[0] = "Pending";
        statusDetails[1] = "Confirmed";
        statusDetails[2] = "Rejected";
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,statusDetails);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status_spinner.setAdapter(adapter);
        status_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                status=t;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void setValues(int i,String vehicle,String model,int quantity)
    {
        Log.d("AddCustomerSetValues",i+" "+vehicle+" "+model+" "+quantity);
        vehicle_id1[i]=vehicle;
        model_id1[i]=model;
        quantity1[i]=quantity;
        if(i+1>size)
            size=i+1;
        else if(size==0)
        {
            size=1;
        }
        //size=size+1;
        Log.d("AddCustomerJson",size+" "+vehicle_id1[0]+" "+model_id1[1]+" "+quantity1[1]);
    }

    @Override
    public void notifyChange(int itemCount) {
        recyclerAdapter=new RecyclerAdapter(getContext(),this);
        linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.notifyItemInserted(itemCount);
    }

    @Override
    public void intent() {
        hideKeyboard();
        ((home_page)getContext()).getSupportActionBar().show();
        if(sharedPrefs.getUserType().equals("0"))
        {
            EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",-1);
            ((home_page)getContext()).setFragment(customer_fragment,"Customers");
        }
        else if(sharedPrefs.getUserType().equals("1"))
        {
            EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",-1);
            ((home_page)getContext()).setFragment(customer_fragment,"Customers");
        }
        else if(sharedPrefs.getUserType().equals("2"))
        {
            EmployeeFragment customer_fragment=EmployeeFragment.newInstance("4",sharedPrefs.getUserId());
            ((home_page)getContext()).setFragment(customer_fragment,"Customers");
        }
//        EmployeeFragment employeeFragment = EmployeeFragment.newInstance("4",sharedPrefs.getUserId());
//        ((home_page)getContext()).setFragment(employeeFragment,"Customers");
    }

//    @Override
//    public void notifyChange(int itemCount) {
//
//        recyclerAdapter.setData(itemCount,addCustomerData1);
//        recyclerAdapter.notifyDataSetChanged();
//    }

    public JSONObject makeJsonObject(int n,String vehicle[],String model[],int quantity[]) throws JSONException
    {
            JSONObject obj = null;
            JSONArray jsonArray = new JSONArray();
            for(int i=0;i<n;i++)
            {

                obj = new JSONObject();
                try{
                    Log.d("fromarray",vehicle[i]);

                    obj.put("vehicle",vehicle[i]);
                    obj.put("model",model[i]);
                    obj.put("quantity",quantity[i]);

                }catch (JSONException e){
                    e.printStackTrace();
                }
                jsonArray.put(obj);
            }
            JSONObject finalObj = new JSONObject();
            finalObj.put("item",jsonArray);
        return finalObj;

    }

    @Override
    public void showAdd() {
        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
//                jsonObject=new JSONObject()
                hideKeyboard();
                Log.d("AddCustomerJson1",size+" "+vehicle_id1[0]+" "+model_id1[1]+" "+quantity1[1]);
                try
                {
                    jsonObject = makeJsonObject(size,vehicle_id1,model_id1,quantity1);
                    Log.d("AddCustomerJson2",size+" "+vehicle_id1[0]+" "+model_id1[1]+" "+quantity1[1]);

                }catch (JSONException e){
                    e.printStackTrace();
                }
                String json = new String(jsonObject.toString());
                Log.d("AddCustomerJson",json+"");
                customer_name = name.getText().toString();
                contact_no = mobile.getText().toString();
                tehsil_name = tehsil.getText().toString();
                address=addressTv.getText().toString();
                email_id = email.getText().toString();
//                quantity =  Integer.parseInt(quantity_tv.getText().toString());
                follow_up = follow.getText().toString();

                if(customer_name.equals("") || customer_name.equals(null) )
                {
                    name.setError("Please Fill Customer's Name");
                    name.requestFocus();
                }
                else if(contact_no.equals("") || contact_no.equals(null))
                {
                    mobile.setError("Please Fill Mobile No.");
                    mobile.requestFocus();
                }else if(address.equals("") || address.equals(null))
                {
                    addressTv.setError("Please Fill Address.");
                    addressTv.requestFocus();
                }
                else if (contact_no.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.requestFocus();
                }
                else if (follow_up.equals("") || follow.equals(null) ) {
                    follow.setError("Please Enter Next Follow Up Date");
                    follow.requestFocus();
                }
                else if (email_id.equals("") || email_id.equals(null) ) {
                    email.setError("Please Enter Email Id");
                    email.requestFocus();
                }
                else{

                    Log.d("call",dsm_id+" "+customer_name+" "+application_name+" "+contact_no+" "+district_name
                                    +" "+town_name+" "+json+" "+financier_name+" "+follow_up+" "+status+" "+location);


                    addCustomerPresenter.responseAddCustomer(sharedPrefs.getAccessToken(),dsm_id,customer_name,
                            address,email_id,application_name,contact_no, district_name,
                            town_name, tehsil_name,json, financier_name, follow_up,
                            status,location);
                }
            }
        });
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
