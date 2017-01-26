package com.tata.motors.add_user.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.add_user.model.AddUserRetrofitProvider;
import com.tata.motors.add_user.model.UserAddedRetrofitProvider;
import com.tata.motors.add_user.model.data.AddUserData;
import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.add_user.model.data.DsmListDetails;
import com.tata.motors.add_user.model.data.UserAddedData;
import com.tata.motors.add_user.presenter.AddUserPresenter;
import com.tata.motors.add_user.presenter.AddUserPresenterImpl;
import com.tata.motors.add_user.presenter.UserAddedPresenter;
import com.tata.motors.add_user.presenter.UserAddedPresenterImpl;
import com.tata.motors.helper.SharedPrefs;

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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.input_username)
    TextView editTextUsername;

    @BindView(R.id.button_submit)
    Button button_submit;

    @BindView(R.id.input_name)
    TextView editTextName;


    private SharedPrefs prefs;
    private AddUserPresenter addUserPresenter;
    private UserAddedPresenter userAddedPresenter;
    private DsmListDetails dsmListDetails;
    private DealerListDetails dealerListDetails;
    private String dealer_id,dsm_id,name,username;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private UserAddedData userAddedData;


    // TODO: Rename and change types of parameters
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
    // TODO: Rename and change types and number of parameters
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

        ButterKnife.bind(this, view);


        addUserPresenter= new AddUserPresenterImpl(this,new AddUserRetrofitProvider());
        addUserPresenter.requestAddUser(prefs.getAccessToken(),prefs.getUserId(),
                prefs.getUserType() , prefs.getKeyEmployeeType());



        if(prefs.getKeyEmployeeType().equals("2"))
        {
            showSpinnerDsm(dsmListDetails);
        }

        if(prefs.getKeyEmployeeType().equals("1"))
        {
            showSpinnerDealer(dealerListDetails);
        }
        button_submit.setOnClickListener(
                new Button.OnClickListener(){                       /*Interface*/
                    public void onClick(View v){                                               /*Call Baack Method*/

                        submit();


                    }

                }
        );








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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showSpinnerDsm(DsmListDetails dsmListDetails) {

       // spinner.setVisibility(View.VISIBLE);
        List<DsmListDetails> dsmListDetailsList = new ArrayList<DsmListDetails>();
        ArrayAdapter<String> adapter;
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
        spinner.setAdapter(adapter);

        //OnItemSelected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                //userAddedData.setName(spinner.getItemAtPosition(t).toString());
                //userAddedData.setDsm_id(dsm_id_ar[t]);
                dsm_id=dsm_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void showSpinnerDealer(DealerListDetails dealerListDetails) {

        List<DealerListDetails> dealerListDetailsList = new ArrayList<DealerListDetails>();
        ArrayAdapter<String> adapter;
        int n= dealerListDetailsList.size();
        final String dealer_id_ar[]=new String[n];
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
                dealer_id=dealer_id_ar[t].toString();
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
            userAddedPresenter.responseAddUser(dealer_id,dsm_id,username,name);

        }
        prefs.setKeyEmployeeType(prefs.getUserType());

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialog(){
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_add_user_dialog);
        TextView password = (TextView)dialog.findViewById(R.id.password);
        dialog.setTitle("PASSWORD");
        password.setText(userAddedData.getPassword());


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
