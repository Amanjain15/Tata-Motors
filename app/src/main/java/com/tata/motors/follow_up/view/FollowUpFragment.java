package com.tata.motors.follow_up.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
import com.tata.motors.add_customer.view.RecyclerAdapter;
import com.tata.motors.follow_up.model.RerofitFollowUpProvider;
import com.tata.motors.follow_up.model.data.FollowUpListDetails;
import com.tata.motors.follow_up.presenter.FollowUpPresenter;
import com.tata.motors.follow_up.presenter.FollowUpPresenterImpl;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FollowUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FollowUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FollowUpFragment extends Fragment implements  FollowUpView{

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String CHOOSE_ID = "choose_id";



    private int choose_id;

    @BindView(R.id.followToolbar)
    Toolbar toolbar;
    @BindView(R.id.followRecyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private FollowUpAdapter followUpAdapter;
    private LinearLayoutManager linearLayoutManager;
    private FollowUpPresenter followUpPresenter;
    private SharedPrefs sharedPrefs;


    private OnFragmentInteractionListener mListener;

    public FollowUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FollowUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FollowUpFragment newInstance(int choose_id) {
        FollowUpFragment fragment = new FollowUpFragment();
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
        View view= inflater.inflate(R.layout.fragment_follow_up, container, false);
        ButterKnife.bind(this,view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        if (getActivity() instanceof home_page) {

            ((home_page) getContext()).getSupportActionBar().hide();

        }
        initialize();

        followUpPresenter.requestFollow(sharedPrefs.getAccessToken(),choose_id);


        return view;
    }

    private void initialize() {
        sharedPrefs = new SharedPrefs(getContext());

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        followUpPresenter = new FollowUpPresenterImpl(this,new RerofitFollowUpProvider());
        followUpAdapter = new FollowUpAdapter(getContext(),this);
        recyclerView.setAdapter(followUpAdapter);
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
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setDataValues(List<FollowUpListDetails> followUpListDetailses) {
        followUpAdapter.setData(followUpListDetailses);
        followUpAdapter.notifyDataSetChanged();
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
