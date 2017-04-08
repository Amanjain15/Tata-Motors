package com.tata.motors.change_password.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.change_password.model.RetrofitChangePassProvider;
import com.tata.motors.change_password.presenter.ChangePassPresenter;
import com.tata.motors.change_password.presenter.ChangePassPresenterImpl;
import com.tata.motors.employee.model.RetrofitEmployeeProvider;
import com.tata.motors.employee.presenter.EmployeePresenter;
import com.tata.motors.employee.presenter.EmployeePresenterImpl;
import com.tata.motors.employee.view.EmployeeAdapter;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;
import com.tata.motors.login.view.LoginScreenActivity;
import com.tata.motors.targets.view.TargetFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChangePassFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChangePassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChangePassFragment extends Fragment implements ChangePassView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    @BindView(R.id.passProgressbar)
    ProgressBar progressBar;
    @BindView(R.id.editText1)
    EditText oldpassword;
    @BindView(R.id.editText2)
    EditText newpassword;
    @BindView(R.id.editText3)
    EditText confirmpassword;
    @BindView(R.id.button)
    Button submit;
    String oldpassword1;
    String newpassword1;
    String confirmpassword1;

    private ChangePassPresenter changePassPresenter;
    private SharedPrefs sharedPrefs;
    private String  access_token;








    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ChangePassFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChangePassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChangePassFragment newInstance(String param1, String param2) {
        ChangePassFragment fragment = new ChangePassFragment();
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_change_pass, container, false);
        ButterKnife.bind(this,view);
        sharedPrefs = new SharedPrefs(getContext());
        access_token=sharedPrefs.getAccessToken();
        changePassPresenter = new ChangePassPresenterImpl(new RetrofitChangePassProvider(),this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldpassword1 = oldpassword.getText().toString();
                newpassword1 = newpassword.getText().toString();
                confirmpassword1 = confirmpassword.getText().toString();


                if(!(confirmpassword1.equals("") && newpassword1.equals("")))
                {
                if (confirmpassword1.equals(newpassword1)) {

                    changePassPresenter.requestChangePass(access_token, oldpassword1, newpassword1);
                } else {

                    Toast.makeText(getContext(), "Confirm Password is not same as New Password", Toast.LENGTH_SHORT).show();
                }
            }
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
    public void showLoading(boolean show) {
        if(show) {
            progressBar.setVisibility(View.VISIBLE);

        }
        else{
            progressBar.setVisibility(View.GONE);
        }




    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onVerified() {

        Toast.makeText(getContext(),"Your Password has changed",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onDestroy();
            }
        },15000);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
