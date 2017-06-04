package com.executives.motors.report_tsm.view;

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

import com.executives.motors.R;
import com.executives.motors.helper.SharedPrefs;

import com.executives.motors.report_tsm.model.RetrofitReportTsmProvider;
import com.executives.motors.report_tsm.model.data.ReportTsmDetails;
import com.executives.motors.report_tsm.presenter.ReportTsmPresenter;
import com.executives.motors.report_tsm.presenter.ReportTsmPresenterImpl;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportTsmFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportTsmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportTsmFragment extends Fragment implements  ReportTsmView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


private ReportTsmAdapter reportTsmAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ReportTsmPresenter reportTsmPresenter;
    private SharedPrefs sharedPrefs;
    private String  access_token,employee,userid,usertype,dsmid,dseid;
    private Toolbar toolbar;
    private OnFragmentInteractionListener mListener;

    //sharedPrefs = new SharedPrefs(getContext());






    public ReportTsmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReportTsmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportTsmFragment newInstance(String param1, String param2) {
        ReportTsmFragment fragment = new ReportTsmFragment();
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
        View view = inflater.inflate(R.layout.report_tsm, container, false);
      //  ButterKnife.bind(this,view);
        sharedPrefs = new SharedPrefs(getContext());
      ///  employee = sharedPrefs.getKeyEmployeeType();
        access_token = sharedPrefs.getAccessToken();
       /// userid = sharedPrefs.getUserId();
///       dsmid = sharedPrefs.getDsmId();
///        dseid = sharedPrefs.getDseId();
 ///       usertype=sharedPrefs.getUserType();
        progressBar=(ProgressBar)view.findViewById(R.id.report_progressBar);
        recyclerView=(RecyclerView)view.findViewById(R.id.report_tsm_RecyclerView);
//        toolbar=(Toolbar)view.findViewById(R.id.report_tsm_Toolbar);
        reportTsmPresenter = new ReportTsmPresenterImpl(new RetrofitReportTsmProvider(), this);
        reportTsmPresenter.requestTsmReport(access_token);
        reportTsmAdapter = new ReportTsmAdapter(getContext(), this);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(reportTsmAdapter);

/*        if (usertype.equals("0")) {
            reportTsmPresenter = new ReportTsmPresenterImpl(new RetrofitReportTsmProvider(), this);
            reportTsmPresenter.requestTsmReport(access_token,userid,dsmid,dseid);

                 if (employee.equals("2"))
                 {

                reportTsmAdapter = new ReportTsmAdapter(getContext(), this);
                linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(reportTsmAdapter);
                ((home_page) getActivity()).getSupportActionBar().hide();
                return (view);
                  }
             else {
                 dseid=sharedPrefs.getUserId();
                 ((home_page)getContext()).setFragment(new ReportFragment(),"report customer list");
                  }
        }
        else if (usertype.equals("1"))
        {
            dsmid=sharedPrefs.getUserId();
            reportTsmPresenter = new ReportTsmPresenterImpl(new RetrofitReportTsmProvider(), this);
            reportTsmPresenter.requestTsmReport(access_token,userid,dsmid,dseid);
            if (employee.equals("2"))
            {

//                reportTsmAdapter = new ReportTsmAdapter(getContext(), this);
                linearLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(reportTsmAdapter);
                ((home_page) getActivity()).getSupportActionBar().hide();
                return (view);
            }
            else
            {

                ((home_page)getContext()).setFragment(new ReportFragment(),"report customer list");
            }
        }
        else if (usertype.equals("2"))
        {
            dseid=sharedPrefs.getUserId();
            ((home_page)getContext()).setFragment(new ReportFragment(),"report customer list");
        }*/

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
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public void message(String message) {
        Toast.makeText(getContext()," "+message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onVerified(List<ReportTsmDetails> reportTsmDetails) {

reportTsmAdapter.setData(reportTsmDetails);
        reportTsmAdapter.notifyDataSetChanged();

    }


    @Override
    public void onSelect() {
        /*if (employee == "0") {//dsmid=selected value

            ((home_page) getContext()).setFragment(new ReportTsmFragment(), "report dse list");
sharedPrefs.setKeyEmployeeType("1");

        } else if (employee == "1") {
            //dseid=selected value

            //keyemployee=2
        }*/
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
