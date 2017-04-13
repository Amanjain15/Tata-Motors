package com.tata.motors.report_dsm.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.tata.motors.report_dsm.model.MockReportProvider;
import com.tata.motors.report_dsm.model.RetrofitReport_dsm;
import com.tata.motors.report_dsm.model.data.ReportDaily;
import com.tata.motors.report_dsm.model.data.Report_dsmData;
import com.tata.motors.report_dsm.presenter.Report_dsmPresenter;
import com.tata.motors.report_dsm.presenter.Report_dsmPresenterImpl;
import com.tata.motors.targets.view.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Report_dsmFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Report_dsmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Report_dsmFragment extends Fragment implements Report_dsmView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID= "1";
    private static final String TYPE = "1";
    private static final String POSITION = "1";
    //private Report_dsmAdapter report_dsmsmAdapter;
    //private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private Report_dsmPresenter report_dsmPresenter;
    private SharedPrefs sharedPrefs;
    private String  access_token,employee,userid,usertype,dsmid,dseid;
    private Report_dsmAdapter report_dsmAdapter;
    private LinearLayoutManager linearLayoutManager;




    // TODO: Rename and change types of parameters
    private int dealer_id;
    private int c,pos;

    private OnFragmentInteractionListener mListener;

    public Report_dsmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Report_dsmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Report_dsmFragment newInstance(int id1,int id2,int i) {
        Report_dsmFragment fragment = new Report_dsmFragment();
        Bundle args = new Bundle();
        args.putInt(ID, id1);
        args.putInt(TYPE, id2);
        args.putInt(POSITION, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dealer_id = getArguments().getInt(ID);//user_id
            c= getArguments().getInt(TYPE);//dsm/dse
            pos=getArguments().getInt(POSITION);//daily/monthly
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.view_pager_report_dsm, container, false);
        ButterKnife.bind(this,view);
        sharedPrefs=new SharedPrefs(getContext());
        access_token=sharedPrefs.getAccessToken();
        progressBar=(ProgressBar)view.findViewById(R.id.report_dsm_Progressbar);

        recyclerView=(RecyclerView)view.findViewById(R.id.report_dsm_RecyclerView);
        //        report_dsmPresenter=new Report_dsmPresenterImpl(new RetrofitReport_dsm(),this);
        report_dsmPresenter=new Report_dsmPresenterImpl(new MockReportProvider(),this);


        Log.d("presenter","a");
        report_dsmAdapter=new Report_dsmAdapter(getContext(),this);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(report_dsmAdapter);
        report_dsmPresenter.requestDsm(access_token,dealer_id,c);
        return  view;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
    public void onVerified(Report_dsmData report_dsmData) {
Log.d("fragment_dsm","c"+c+"pos"+pos);
        report_dsmAdapter.setData(report_dsmData,c,pos);//c = dsm/dse  and pos = monthly or daily
        report_dsmAdapter.notifyDataSetChanged();
    }

    @Override
    public void statusCal(int id) {
        report_dsmPresenter.sendStatus(sharedPrefs.getAccessToken(),id);
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
