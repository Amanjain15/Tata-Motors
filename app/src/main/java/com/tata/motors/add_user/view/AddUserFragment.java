package com.tata.motors.add_user.view;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.tata.motors.R;
import com.tata.motors.add_user.model.AddUserRetrofitProvider;
import com.tata.motors.add_user.model.MockUser;
import com.tata.motors.add_user.model.UserAddedRetrofitProvider;
import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.add_user.model.data.DsmListDetails;
import com.tata.motors.add_user.model.data.UserAddedData;
import com.tata.motors.add_user.presenter.AddUserPresenter;
import com.tata.motors.add_user.presenter.AddUserPresenterImpl;
import com.tata.motors.add_user.presenter.UserAddedPresenter;
import com.tata.motors.add_user.presenter.UserAddedPresenterImpl;
import com.tata.motors.employee.view.EmployeeFragment;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;
import com.tata.motors.targets.view.TargetFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddUserFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUserFragment extends Fragment implements AddUserView {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    //@BindView(R.id.spinner)
    Spinner spinner;

//    @BindView(R.id.input_username)
    TextView editTextUsername;

  //  @BindView(R.id.button_submit)
    Button button_submit;

    //@BindView(R.id.input_name)
    TextView editTextName;

    //@BindView(R.id.add_user_toolbar)
    Toolbar toolbar;


    private SharedPrefs prefs;
    private AddUserPresenter addUserPresenter;
    private UserAddedPresenter userAddedPresenter;
    private DsmListDetails dsmListDetails;
    private DealerListDetails dealerListDetails;
    private String name,username;
    private int dealer_id,dsm_id;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private UserAddedData userAddedData;

    private String mParam1;
    private String mParam2;



    private OnFragmentInteractionListener mListener;

    public AddUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddUserFragment.
     */

    public static AddUserFragment newInstance(String param1, String param2) {
        AddUserFragment fragment = new AddUserFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        //ButterKnife.bind(this, view);
        spinner = (Spinner)view.findViewById(R.id.spinner);
        editTextUsername=(TextView) view.findViewById(R.id.input_username);
        button_submit= (Button) view.findViewById(R.id.button_submit);
        editTextName = (TextView)view.findViewById(R.id.input_name);
        prefs = new SharedPrefs(getContext());
        toolbar = (Toolbar)view.findViewById(R.id.add_user_toolbar);
        addUserPresenter= new AddUserPresenterImpl(this,new AddUserRetrofitProvider());
//        addUserPresenter= new AddUserPresenterImpl(this,new MockUser());
        Log.d("Add User",prefs.getKeyEmployeeType()+"");
        addUserPresenter.requestAddUser(prefs.getAccessToken(),prefs.getUserId(), prefs.getKeyEmployeeType());

        button_submit.setOnClickListener(
                new Button.OnClickListener(){                       /*Interface*/
                    public void onClick(View v){                                               /*Call Baack Method*/

                        submit();
                    }
                }
        );


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

    @Override
    public void showSpinnerDsm(AddUserData addUserData) {

       // spinner.setVisibility(View.VISIBLE);
        List<DsmListDetails> dsmListDetailsList = new ArrayList<DsmListDetails>(addUserData.getDsm_list());
        ArrayAdapter<String> adapter;
        int n= dsmListDetailsList.size();
        final int dsm_id_ar[]=new int[n];
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
        spinner.setAdapter(adapter);

        //OnItemSelected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                //userAddedData.setName(spinner.getItemAtPosition(t).toString());
                //userAddedData.setDsm_id(dsm_id_ar[t]);
                dealer_id=dsm_id_ar[t];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void showSpinnerDealer(AddUserData addUserData)  {

        List<DealerListDetails> dealerListDetailsList = new ArrayList<DealerListDetails>(addUserData.getDealer_list());
        ArrayAdapter<String> adapter;
        int n= dealerListDetailsList.size();
        final int dealer_id_ar[]=new int[n];
        String dealer_name_ar[]=new String[n];

        int i=0;
        while(i < n)
        {
            dealerListDetails = dealerListDetailsList.get(i);
            dealer_id_ar[i] = dealerListDetails.getDealer_id();
            dealer_name_ar[i] = dealerListDetails.getDealer_name();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, dealer_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //OnItemSelected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                //userAddedData.setName(spinner.getItemAtPosition(t).toString());
                //userAddedData.setDsm_id(dsm_id_ar[t]);
                dealer_id=dealer_id_ar[t];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public void submit() {
        name=editTextName.getText().toString();
        username=editTextUsername.getText().toString();
        if (name.isEmpty() || username.isEmpty()) {

            showError("Fields cannot be empty");
        }
        else
        {
            userAddedPresenter = new UserAddedPresenterImpl(this , new UserAddedRetrofitProvider());
            Log.d("submit()",dealer_id+" "+username+" "+name+" "+" "+prefs.getKeyEmployeeType());
            userAddedPresenter.responseAddUser(prefs.getAccessToken(),dealer_id,username,name,prefs.getKeyEmployeeType());

        }
//        prefs.setKeyEmployeeType(prefs.getUserType());

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialog(UserAddedData userAddedData){
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_add_user_dialog);
        TextView password = (TextView)dialog.findViewById(R.id.password);
        dialog.setTitle("PASSWORD");
        Log.d("add_user_showDialog()",userAddedData.getPassword()+"");
        password.setText(userAddedData.getPassword());
//        prefs.setKeyEmployeeType(prefs.getUserType());
        dialog.show();
        Intent i = new Intent(getActivity(),home_page.class);
        startActivity(i);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent i = new Intent(getActivity(),home_page.class);
//                startActivity(i);
                switch(prefs.getKeyEmployeeType())
                {
                    case "1":
                        prefs.setKeyEmployeeType(prefs.getUserType());
                        ((home_page)getContext()).getSupportActionBar().show();
                        EmployeeFragment fragment = EmployeeFragment.newInstance("1",-1);
                        ((home_page)getContext()).setFragment(fragment,"Dsm");
                        break;
                    case "2":
                        prefs.setKeyEmployeeType(prefs.getUserType());
                        ((home_page)getContext()).getSupportActionBar().show();
                        EmployeeFragment fragment2 = EmployeeFragment.newInstance("2",-1);
                        ((home_page)getContext()).setFragment(fragment2,"Dse");
                        break;

                }
            }
        },1000);


    }

    @Override
    public void check(AddUserData addUserData) {
        if(prefs.getKeyEmployeeType().equals("2"))        //adding dse by tsm
        {

            toolbar.setTitle("Add DSE");
            if(prefs.getUserType().equals("0"))

            {
                spinner.setVisibility(View.VISIBLE);
                showSpinnerDsm(addUserData);
            }
            else{
                spinner.setVisibility(View.GONE);
            }

        }

        if(prefs.getKeyEmployeeType().equals("1"))        //adding dsm by tsm
        {

            Log.d("adduserfragmentcheck()","1");
            toolbar.setTitle("Add DSM");
            if(prefs.getUserType().equals("0"))
            showSpinnerDealer(addUserData);
            else{
                spinner.setVisibility(View.GONE);
            }
        }




        //        toolbar.setTitle("Add DSE");
//          showSpinnerDsm(addUserData);

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
}
