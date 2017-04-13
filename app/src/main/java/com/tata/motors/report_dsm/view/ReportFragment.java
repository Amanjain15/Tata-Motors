package com.tata.motors.report_dsm.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.tata.motors.R;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.report_dsm.presenter.Report_dsmPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID= "1";
    private static final String TYPE = "1";

    // TODO: Rename and change types of parameters
    private static  int dealer_id=1;
    private static int c=1;

    private OnFragmentInteractionListener mListener;

    public ReportFragment() {
        // Required empty public constructor
    }
    private ProgressBar progressBar;
    private Report_dsmPresenter report_dsmPresenter;
    private SharedPrefs sharedPrefs;
    private String  access_token,employee,userid,usertype,dsmid,dseid;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter1 viewPagerAdapter;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment ReportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportFragment newInstance(int id1,int id2) {
        ReportFragment fragment = new ReportFragment();
        Bundle args = new Bundle();
        args.putInt(ID, id1);
        args.putInt(TYPE, id2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dealer_id = getArguments().getInt(ID);
            c= getArguments().getInt(TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_report_dsm, container, false);
        ButterKnife.bind(this,view);
        Log.d("PARENT",dealer_id+" "+c);
        sharedPrefs=new SharedPrefs(getContext());
        access_token=sharedPrefs.getAccessToken();
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar_report);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager_report);
        viewPagerAdapter= new ViewPagerAdapter1(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        List<Fragment> fragmentList= new ArrayList<>();
//        for(int i=0;i<2;i++){
//            Report_dsmFragment report_dsmFragment = Report_dsmFragment.newInstance(dealer_id,c);
//            fragmentList.add(report_dsmFragment);
//        }

        viewPagerAdapter.setTabData(dealer_id,c);
        viewPagerAdapter.notifyDataSetChanged();
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
