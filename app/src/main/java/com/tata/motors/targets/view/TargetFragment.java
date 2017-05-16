package com.tata.motors.targets.view;

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
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.home.home_page;
import com.tata.motors.targets.model.MockTargetProvider;
import com.tata.motors.targets.model.RetrofitTargetProvider;
import com.tata.motors.targets.model.data.TargetData;
import com.tata.motors.targets.model.data.TargetDataTsm;
import com.tata.motors.targets.presenter.TargetPresenter;
import com.tata.motors.targets.presenter.TargetPresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TargetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TargetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TargetFragment extends Fragment implements TargetView{

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private TabLayout tabLayout;
    private ProgressBar progressBar;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TargetPresenter targetPresenter;
    private SharedPrefs sharedPrefs;

    private OnFragmentInteractionListener mListener;

    public TargetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TargetFragment.
     */

    public static TargetFragment newInstance(String param1, String param2) {
        TargetFragment fragment = new TargetFragment();
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

        View view = inflater.inflate(R.layout.fragment_target, container, false);
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar) ;
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        sharedPrefs = new SharedPrefs(getContext());
//      targetPresenter = new TargetPresenterImpl(this, new RetrofitTargetProvider());
        targetPresenter = new TargetPresenterImpl(this, new MockTargetProvider());
        targetPresenter.requestTarget(sharedPrefs.getUserType(),
                sharedPrefs.getUserId(),sharedPrefs.getUsername());
        Log.d("PrefsCheck", sharedPrefs.getKeyEmployeeType()+" ");

        ((home_page)getContext()).getSupportActionBar().show();
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
        return view;

    }

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
    public void showError(String error) {
        Toast.makeText(getContext() , error , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setData(TargetData targetData) {

        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
        Log.d("targetFragment",targetData.getTargetDaily()+" "+targetData.getTargetMonthly());
        viewPagerAdapter.setData(targetData.getTargetDaily(),targetData.getTargetMonthly());
        viewPagerAdapter.notifyDataSetChanged();

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

        void onFragmentInteraction(Uri uri);
    }
}
