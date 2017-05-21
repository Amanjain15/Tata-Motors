package com.tata.motors.view_customer.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.add_customer.view.EditCustomerFragment;
import com.tata.motors.add_customer.view.RecyclerAdapter;
import com.tata.motors.follow_up.view.FollowUpFragment;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;
import com.tata.motors.view_customer.model.RetrofitViewCustomerProvider;
import com.tata.motors.view_customer.model.data.ViewCustomerData;
import com.tata.motors.view_customer.presenter.ViewCustomerPresenter;
import com.tata.motors.view_customer.presenter.ViewCustomerPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewCustomerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewCustomerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewCustomerFragment extends Fragment implements ViewCustomer {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CHOOSE_ID = "choose_id";

    private int choose_id;
    private String mParam2;

    @BindView(R.id.customer_name)
    TextView name;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.application)
    TextView application;
    @BindView(R.id.district)
    TextView district;
    @BindView(R.id.town)
    TextView town;
    @BindView(R.id.tehsil)
    TextView tehsil;
    @BindView(R.id.financier)
    TextView financier;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.status)
    TextView status;
    @BindView(R.id.follow_up)
    TextView follow_up;
    @BindView(R.id.submitBar)
    ProgressBar progressBar;
    @BindView(R.id.button_edit)
    Button edit;
    @BindView(R.id.button_follow_up)
    Button button_follow_up;
    @BindView(R.id.recycler_view_customer)
    RecyclerView recyclerView;

    @BindView(R.id.viewToolbar)
    Toolbar toolbar;
    private ViewCustomerAdapter viewCustomerAdapter;
    private LinearLayoutManager linearLayoutManager;


    private SharedPrefs sharedPrefs;
    private ViewCustomerPresenter viewCustomerPresenter;


    private OnFragmentInteractionListener mListener;

    public ViewCustomerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ViewCustomerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewCustomerFragment newInstance(int choose_id) {
        ViewCustomerFragment fragment = new ViewCustomerFragment();
        Bundle args = new Bundle();
        args.putInt(CHOOSE_ID, choose_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            choose_id = getArguments().getInt(CHOOSE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_view_customer, container, false);
        ButterKnife.bind(this,view);
        initialize();
        viewCustomerPresenter.requestViewCustomer(sharedPrefs.getAccessToken(),choose_id);
        ((home_page) getActivity()).getSupportActionBar().hide();
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_back_white_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 11/4/17 EditCustomerFragment
                EditCustomerFragment editCustomerFragment = EditCustomerFragment.newInstance(choose_id);
                ((home_page)getContext()).setFragment(editCustomerFragment,"Edit Customer");
            }
        });

        button_follow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 11/4/17 FollowUpFragment
                FollowUpFragment followUpFragment = FollowUpFragment.newInstance(choose_id);
                ((home_page)getContext()).setFragment(followUpFragment,"Edit Customer");

            }
        });
        return view;
    }

    private void initialize() {
        sharedPrefs = new SharedPrefs(getContext());
        viewCustomerPresenter = new ViewCustomerPresenterImpl(this, new RetrofitViewCustomerProvider());
        viewCustomerAdapter = new ViewCustomerAdapter(getContext(),this);
        linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(viewCustomerAdapter);
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
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(ViewCustomerData viewCustomerData) {
        name.setText(viewCustomerData.getCustomer_name());
        address.setText(viewCustomerData.getAddress());
        mobile.setText(viewCustomerData.getContact_no());
        email.setText(viewCustomerData.getEmail());
        application.setText(viewCustomerData.getApplication());
        district.setText(viewCustomerData.getDistrict());
        town.setText(viewCustomerData.getTown());
        tehsil.setText(viewCustomerData.getTehsil());
        financier.setText(viewCustomerData.getFinancier());
        location.setText(viewCustomerData.getLocation());
        switch(viewCustomerData.getStatus())
        {
            case 0:
                status.setText("Pending");
                break;
            case 1:
                status.setText("Confirmed");
                break;
            case 2:
                status.setText("Rejected");
                break;
            default :
                status.setText("Invalid Data");
        }
        follow_up.setText(viewCustomerData.getFollow_up());
        viewCustomerAdapter.setData(viewCustomerData.getVehicle_data_list());
        viewCustomerAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroy() {
        ((home_page)getContext()).getSupportActionBar().show();
        super.onDestroy();
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
