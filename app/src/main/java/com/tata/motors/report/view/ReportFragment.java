package com.tata.motors.report.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.tata.motors.R;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.report.model.MockReportProvider;
import com.tata.motors.report.model.RetrofitReportProvider;
import com.tata.motors.report.model.data.ReportData;
import com.tata.motors.report.presenter.ReportPresenter;
import com.tata.motors.report.presenter.ReportPresenterImpl;

import java.util.List;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportFragment extends Fragment implements ReportView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    /* @BindView(R.id.tabLayout)
     TabLayout tabLayout;
 */
   private RecyclerView recyclerView;
   private ProgressBar progressBar;
    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;
    private ReportPresenter reportPresenter;
    private ReportAdapter reportAdapter;
    private LinearLayoutManager linearLayoutManager;
    private String token;
    private SharedPrefs sharedPrefs;
    private OnFragmentInteractionListener mListener;

    public ReportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportFragment newInstance(int param1) {
        Log.d("Res","sf");
        ReportFragment fragment = new ReportFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_report, container, false);
        ButterKnife.bind(this, view);
        recyclerView=(RecyclerView)view.findViewById(R.id.report_recycler);
        progressBar=(ProgressBar)view.findViewById(R.id.report_progressBar);
        initialize();
        progressBar.setVisibility(View.INVISIBLE);
        Log.d("Response",mParam1+"");
        reportPresenter.getReport(token);
        return view;

    }

    void initialize() {
//        orderPresenter = new ReportPresenterImpl(this, new RetrofitReportProvider());
        reportPresenter=new ReportPresenterImpl(this,new MockReportProvider());
        reportAdapter = new ReportAdapter(getContext(), this);
        sharedPrefs = new SharedPrefs(getContext());
        token = sharedPrefs.getAccessToken();
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(reportAdapter);
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
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressbar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onDataReceived(ReportData reportData,int i) {
        reportAdapter.setData(reportData,mParam1);
        reportAdapter.notifyDataSetChanged();
    }
    


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
