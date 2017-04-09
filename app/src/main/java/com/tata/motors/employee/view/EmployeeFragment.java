package com.tata.motors.employee.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.add_user.view.AddUserFragment;
import com.tata.motors.employee.model.RetrofitEmployeeProvider;
import com.tata.motors.employee.model.data.EmployeeData;
import com.tata.motors.employee.model.data.EmployeeListDetails;
import com.tata.motors.employee.presenter.EmployeePresenter;
import com.tata.motors.employee.presenter.EmployeePresenterImpl;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EmployeeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EmployeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeFragment extends Fragment implements EmployeeView {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_C_TYPE = "user_c_type";
    private static final String ID = "id";

    // TODO: Rename and change types of parameters
    private String user_c_type;
    private int choose_id;

    @BindView(R.id.employeeRecyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.employeeToolbar)
    Toolbar toolbar;
    @BindView(R.id.employeeProgressbar)
    ProgressBar progressBar;

    private EmployeePresenter employeePresenter;

    private LinearLayoutManager linearLayoutManager;
    private SharedPrefs sharedPrefs;
    private String  access_token;
    private EmployeeAdapter employeeAdapter;

    private OnFragmentInteractionListener mListener;

    public EmployeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EmployeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeFragment newInstance(String user_see_type, int id) {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle args = new Bundle();
        args.putString(USER_C_TYPE, user_see_type);
        args.putInt(ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user_c_type = getArguments().getString(USER_C_TYPE);
            choose_id = getArguments().getInt(ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_employee, container, false);
        sharedPrefs = new SharedPrefs(getContext());
       // employee=sharedPrefs.getKeyEmployeeType();
        access_token=sharedPrefs.getAccessToken();
        employeePresenter=new EmployeePresenterImpl(new RetrofitEmployeeProvider(),this);
        employeeAdapter=new EmployeeAdapter(getContext(),this);
        linearLayoutManager= new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab_employee);
        fab.setVisibility(View.GONE);
        if(user_c_type.equals("1")||user_c_type.equals("2"))
        {
            fab.setVisibility(View.VISIBLE);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sharedPrefs.setKeyEmployeeType(user_c_type);
                    if(user_c_type.equals("1"))
                    {
                        ((home_page)getContext()).setFragment(new AddUserFragment(), "Add DSM");
                    }
                    else if(user_c_type.equals("2"))
                    {
                        ((home_page)getContext()).setFragment(new AddUserFragment(), "Add DSE");
                    }

                }
        });
                            //dealer ke case me floating button nahi rahegi wo handle karne ke liye
        }


        if(user_c_type.equals("3")) {
            toolbar.setTitle("DEALERS");
        }
        else if(user_c_type.equals("1"))
        {
            toolbar.setTitle("DSM");
        }
        else if(user_c_type.equals("2"))
        {
            toolbar.setTitle("DSE");
        }

        employeePresenter.requestEmployee(access_token,choose_id,user_c_type);
//        if(user_c_type)
//        ((home_page)getActivity()).getSupportActionBar().hide();
        return view;



    }
    @Override
    public void showProgressbar(boolean show) {
        if(show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
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
    public void dataReceived(List<EmployeeListDetails> employeeListDetailsList) {
        employeeAdapter.setData(employeeListDetailsList,user_c_type);
        employeeAdapter.notifyDataSetChanged();
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
