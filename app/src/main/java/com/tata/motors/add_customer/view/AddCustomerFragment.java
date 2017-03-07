package com.tata.motors.add_customer.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.add_customer.model.AddCustomerProvider;
import com.tata.motors.add_customer.model.CustomerAddedProvider;
import com.tata.motors.add_customer.model.MockAddCustomerProvider;
import com.tata.motors.add_customer.model.RetrofitAddCustomerProvider;
import com.tata.motors.add_customer.model.data.AddCustomerData;
import com.tata.motors.add_customer.model.data.ApplicationListDetails;
import com.tata.motors.add_customer.model.data.DistrictListDetails;
import com.tata.motors.add_customer.model.data.DseListDetails;
import com.tata.motors.add_customer.model.data.DsmListDetails;
import com.tata.motors.add_customer.model.data.FinancierListDetails;
import com.tata.motors.add_customer.model.data.ModelListDetails;
import com.tata.motors.add_customer.model.data.TownListDetails;
import com.tata.motors.add_customer.model.data.VehicleListDetails;
import com.tata.motors.add_customer.presenter.AddCustomerPresenter;
import com.tata.motors.add_customer.presenter.AddCustomerPresenterImpl;
import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.helper.SharedPrefs;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tata.motors.R.id.dse_spinner;

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

    @BindView(R.id.dse_spinner)
    Spinner dse_spinner;

    @BindView(R.id.district_spinner)
    Spinner district_spinner;

    @BindView(R.id.town_spinner)
    Spinner town_spinner;

    @BindView(R.id.model_spinner)
    Spinner model_spinner;

    @BindView(R.id.vehicle_spinner)
    Spinner vehicle_spinner;

    @BindView(R.id.financier_spinner)
    Spinner financier_spinner;

    @BindView(R.id.customer_name)
    TextView name;

    @BindView(R.id.mobile)
    TextView mobile;

    @BindView(R.id.tehsil)
    TextView tehsil;

    @BindView(R.id.follow_up)
    TextView follow;

//    @BindView(R.id.geo_tag)

    @BindView(R.id.quantity)
    TextView quantity_tv;

    @BindView(R.id.submitButton)
    Button submit;

    private String dsm_id,dse_id,application_id,customer_name,contact_no,district_id, town_id;
    private String tehsil_id,model_id,quantity,vehicle_id,financier_id,geo_tag;
    private int follow_up;
    private ApplicationListDetails applicationListDetails;
    private DistrictListDetails districtListDetails;
    private TownListDetails townListDetails;
    private ModelListDetails modelListDetails;
    private VehicleListDetails vehicleListDetails;
    private FinancierListDetails financierListDetails;
    private SharedPrefs sharedPrefs;
    private AddCustomerPresenter addCustomerPresenter;
    private DsmListDetails dsmListDetails;

    private ProgressBar progressBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
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
    // TODO: Rename and change types and number of parameters
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
        progressBar = (ProgressBar)view.findViewById(R.id.submitBar);
        addCustomerPresenter.requestAddCustomer(sharedPrefs.getAccessToken(),sharedPrefs.getUserId(),
                                                sharedPrefs.getUserType());

        showAdd();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
//        addCustomerPresenter = new AddCustomerPresenterImpl(new RetrofitAddCustomerProvider(),this);
        addCustomerPresenter = new AddCustomerPresenterImpl(new MockAddCustomerProvider(),this);

    }



    @Override
    public void showAdd() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                customer_name = name.getText().toString();
                contact_no = mobile.getText().toString();
                tehsil_id = tehsil.getText().toString();
                quantity = quantity_tv.getText().toString();
                try
                {
                    follow_up = Integer.parseInt(follow.getText().toString());
                }catch(NumberFormatException nfe){}

                if(customer_name.equals("") || customer_name.equals(null) )
                {
                    name.setError("Please Fill Customer's Name");
                    name.requestFocus();
                }
                else if(contact_no.equals("") || contact_no.equals(null))
                {
                    mobile.setError("Please Fill Mobile No.");
                    mobile.requestFocus();
                }
                else if (contact_no.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.requestFocus();
                }
                else if (follow_up == 0 ) {
                    follow.setError("Please Enter Follow Up");
                    follow.requestFocus();
                }
                else{
                    addCustomerPresenter.responseAddCustomer(dsm_id,dse_id,customer_name,
                            application_id,contact_no, district_id, town_id, tehsil_id, model_id,
                            quantity,vehicle_id, financier_id, follow_up, geo_tag);
                }
            }
        });
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
//                        sharedPrefs.setUserType("1");


                        if (sharedPrefs.getUserType().equals("0"))
                        {
                            showSpinnerDsm(addCustomerData);
                            showSpinnerDse(addCustomerData);
                        }
                        else if (sharedPrefs.getUserType().equals("1"))
                        {
                            showSpinnerDse(addCustomerData);
                            dsm_id = sharedPrefs.getUserId();
                        }
                        else if(sharedPrefs.getUserType().equals("2"))
                        {
                            dse_id=sharedPrefs.getUserId();
                        }

;
                        showSpinnerApplication(addCustomerData);
                        showSpinnerDistrict(addCustomerData);
                        showSpinnerTown(addCustomerData);
                        showSpinnerModel(addCustomerData);
                        showSpinnerVehicle(addCustomerData);
                        showSpinnerFinancier(addCustomerData);

    }

    @Override
    public String showSpinnerDsm(AddCustomerData addCustomerData) {

        List<DsmListDetails> dsmListDetailsList= new ArrayList<DsmListDetails>(addCustomerData.getDsmListDetails());
        ArrayAdapter<String>    adapter;
        int n= dsmListDetailsList.size();
        final String dsm_id_ar[]=new String[n];
        String dsm_name_ar[]=new String[n];

        int i=0;
        while(i < n)
        {
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
                dsm_id= dsm_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return dsm_id;
    }


    @Override
    public String showSpinnerDse(AddCustomerData addCustomerData) {
        DseListDetails dseListDetails;
        List<DseListDetails> dseListDetailsList= new ArrayList<DseListDetails>(addCustomerData.getDseListDetails());
        ArrayAdapter<String>    adapter;
        int n= dseListDetailsList.size();
        final String dse_id_ar[]=new String[n];
        String dse_name_ar[]=new String[n];

        int i=0;
        while(i < n)
        {
            dseListDetails = dseListDetailsList.get(i);
            dse_id_ar[i] = dseListDetails.getDse_id();
            dse_name_ar[i] = dseListDetails.getDse_name();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, dse_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dse_spinner.setAdapter(adapter);

        //OnItemSelected
        dse_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                //userAddedData.setName(spinner.getItemAtPosition(t).toString());
                //userAddedData.setDsm_id(dsm_id_ar[t]);
                dse_id=dse_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return dse_id;
    }

    @Override
    public String showSpinnerApplication(AddCustomerData addCustomerData) {
        List<ApplicationListDetails> applicationListDetailsList = new ArrayList<ApplicationListDetails>(addCustomerData.getApplicationListDetails());
        ArrayAdapter<String>    adapter;
        int n= applicationListDetailsList.size();
        String application_name_ar[] = new String[n];
        final String application_id_ar[] = new String[n];
        int i=0;
        while(i<n)
        {
            applicationListDetails = applicationListDetailsList.get(i);
            application_name_ar[i] = applicationListDetails.getApplication_name();
            application_id_ar[i] = applicationListDetails.getApplication_id();
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
                application_id= application_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return application_id;
    }

    @Override
    public String showSpinnerDistrict(AddCustomerData addCustomerData) {
        List<DistrictListDetails> districtListDetailsList = new ArrayList<DistrictListDetails>(addCustomerData.getDistrictListDetails());
        ArrayAdapter<String> adapter;
        int n= districtListDetailsList.size();
        String district_name_ar[] = new String[n];
        final String district_id_ar[] = new String[n];
        int i=0;
        while(i<n){
            districtListDetails = districtListDetailsList.get(i);
            district_name_ar[i] = districtListDetails.getDistrict_name();
            district_id_ar[i] = districtListDetails.getDistrict_id();
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
                district_id = district_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return district_id;
    }

    @Override
    public String showSpinnerTown(AddCustomerData addCustomerData) {
        List<TownListDetails> townListDetailsList = new ArrayList<TownListDetails>(addCustomerData.getTownListDetails());
        ArrayAdapter<String> adapter;
        int n= townListDetailsList.size();
        String town_name_ar[] = new String[n];
        final String town_id_ar[] = new String[n];
        int i=0;
        while(i<n){
            townListDetails = townListDetailsList.get(i);
            town_id_ar[i]= townListDetails.getTown_id();
            town_name_ar[i]= townListDetails.getTown_name();
            i++;
        }
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, town_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        town_spinner.setAdapter(adapter);

        town_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                town_id = town_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return town_id;

    }

    @Override
    public String showSpinnerModel(AddCustomerData addCustomerData) {
        List<ModelListDetails> modelListDetailsList = new ArrayList<ModelListDetails>(addCustomerData.getModelListDetails());
        ArrayAdapter<String> adapter;
        int n= modelListDetailsList.size();
        final String model_id_ar[] = new String [n];
        String model_name_ar[] = new String [n];

        int i=0;
        while(i<n)
        {
            modelListDetails = modelListDetailsList.get(i);
            model_id_ar[i] = modelListDetails.getModel_id();
            model_name_ar[i] = modelListDetails.getModel_name();
            i++;
        }
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, model_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        model_spinner.setAdapter(adapter);

        model_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                model_id = model_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return model_id;

    }

    @Override
    public String showSpinnerVehicle(AddCustomerData addCustomerData) {
        List<VehicleListDetails> vehicleListDetailsList = new ArrayList<VehicleListDetails>(addCustomerData.getVehicleListDetails());
        ArrayAdapter<String> adapter;
        int n= vehicleListDetailsList.size();
        final String vehicle_id_ar[] = new String[n];
        final String  vehicle_name_ar[] =  new String[n];
        int i=0;
        while(i<n)
        {
            vehicleListDetails = vehicleListDetailsList.get(i);
            vehicle_id_ar[i]= vehicleListDetails.getVehicle_id();
            vehicle_name_ar[i] =vehicleListDetails.getVehicle_name();
            i++;
        }
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, vehicle_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicle_spinner.setAdapter(adapter);
        vehicle_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                vehicle_id = vehicle_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return vehicle_id;
    }

    @Override
    public String showSpinnerFinancier(AddCustomerData addCustomerData) {
        List<FinancierListDetails> financierListDetailsList = new ArrayList<FinancierListDetails>(addCustomerData.getFinancierListDetails());
        ArrayAdapter<String> adapter;
        int n = financierListDetailsList.size();
        int i=0;
        final String financier_id_ar[] = new String[n];
        String financier_name_ar[] = new String [n];
        while(i<n){
            financierListDetails = financierListDetailsList.get(i);
            financier_id_ar[i] = financierListDetails.getFinancier_id();
            financier_name_ar[i]= financierListDetails.getFinancier_name();
            i++;
            }
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, financier_name_ar);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        financier_spinner.setAdapter(adapter);
        financier_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                financier_id =  financier_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return financier_id;

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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
