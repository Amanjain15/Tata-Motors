package com.tata.motors.profile.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.change_password.view.ChangePassFragment;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;
import com.tata.motors.profile.model.MockProfileProvider;
import com.tata.motors.profile.model.RetrofitProfileProvider;
import com.tata.motors.profile.model.data.ProfileData;
import com.tata.motors.profile.model.data.ProfileSendData;
import com.tata.motors.profile.presenter.ProfilePresenter;
import com.tata.motors.profile.presenter.ProfilePresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements ProfileView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_ID = "id";
    private EditText name,userName,mobileNo,email,dealers,address,designation;
    private ImageView image;
    private ProgressBar progressBar;
    private ProfilePresenter profilePresenter;
    private SharedPrefs sharedPrefs;
    private String token,check;
    private String name1,userName1,mobileNo1,email1,dealers1,address1,designation1;
    private Button button,button1;






    // TODO: Rename and change types of parameters
    private int user_id;
    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(int id) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(USER_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user_id = getArguments().getInt(USER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        name=(EditText)view.findViewById(R.id.editText1);
        userName=(EditText)view.findViewById(R.id.editText10);
        mobileNo=(EditText)view.findViewById(R.id.editText2);
        email=(EditText)view.findViewById(R.id.editText4);
        address=(EditText)view.findViewById(R.id.editText5);
        designation=(EditText)view.findViewById(R.id.editText6);
      //  dealers=(EditText)view.findViewById(R.id.editText7);
        progressBar=(ProgressBar)view.findViewById(R.id.profileProgressBar);
        button=(Button)view.findViewById(R.id.buttonEdit);
        button1=(Button)view.findViewById(R.id.buttonSubmit);
        //image ka kaam bacha hai
        sharedPrefs=new SharedPrefs(getContext());
        token=sharedPrefs.getAccessToken();
        check=sharedPrefs.getKeyProfileEdit();
       profilePresenter=new ProfilePresenterImpl(this,new RetrofitProfileProvider());
        //profilePresenter=new ProfilePresenterImpl(this,new MockProfileProvider());
      profilePresenter.requestProfile(token,user_id);
        //profilePresenter.requestProfile("abcd");
        if(sharedPrefs.getUserId()==user_id)
       {
           button.setVisibility(View.VISIBLE);   button1.setVisibility(View.VISIBLE);

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setFocusable(true);
                name.setClickable(true);
                name.setFocusableInTouchMode(true);
                userName.setFocusable(true);
                userName.setClickable(true);
                userName.setFocusableInTouchMode(true);
                mobileNo.setFocusable(true);
                mobileNo.setClickable(true);
                mobileNo.setFocusableInTouchMode(true);
                email.setFocusable(true);
                email.setClickable(true);
                email.setFocusableInTouchMode(true);
                address.setFocusable(true);
                address.setClickable(true);
                address.setFocusableInTouchMode(true);
              //  dealers.setFocusable(true);
                //dealers.setClickable(true);
                //dealers.setFocusableInTouchMode(true);
                designation.setFocusable(true);
                designation.setClickable(true);
                designation.setFocusableInTouchMode(true);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1=name.getText().toString();
                userName1=userName.getText().toString();
                mobileNo1=mobileNo.getText().toString();
                email1=email.getText().toString();
                address1=address.getText().toString();
                designation1=designation.getText().toString();
              //  dealers1=dealers.getText().toString();
                profilePresenter.requestSendProfile(token,userName1,name1,mobileNo1,email1,address1,designation1);
              //  profilePresenter.requestSendProfile("sd","sd","fdfc","dd","vv","sdv","dcd","sv");
            }
        });
        return(view);
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

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean show) {

        if(show) {
            progressBar.setVisibility(View.VISIBLE);

        }
        else{
            progressBar.setVisibility(View.GONE);
        }




    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext()," "+message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onReceive(ProfileData profileData) {
        try {

            name.setText(profileData.getName());
        }
        catch(NullPointerException e){
            name.setText("");
            }
        try {

            userName.setText(profileData.getUserName());
        }
        catch(NullPointerException e){
            userName.setText("");
        }
        try {

            email.setText(profileData.getEmail());
        }
        catch(NullPointerException e){
            email.setText("");
        }
        try {

            address.setText(profileData.getAddress());
        }
        catch(NullPointerException e){
            address.setText("");
        }
        try {

            mobileNo.setText(profileData.getMobile_no());
        }
        catch(NullPointerException e){
            mobileNo.setText("");
        }

        try {

            designation.setText(profileData.getDesignation());
        }
        catch(NullPointerException e){
            designation.setText("");
        }

    /*    try {

            dealers.setText(profileData.getName());
        }
        catch(NullPointerException e){
            dealers.setText("");
        }*/
        /*

        userName.setText(profileData.getUserName());
        address.setText(profileData.getAddress());
mobileNo.setText(profileData.getMobile_no());
        email.setText(profileData.getEmail());
        designation.setText(profileData.getDesignation());
        dealers.setText(profileData.getDealer());       */
    }

    @Override
    public void onSend(ProfileSendData profileSendData) {


     //   ((home_page) getContext()).setFragment(new ChangePassFragment(), "Home");

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
