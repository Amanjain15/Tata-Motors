package com.executives.motors.targets.view;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.executives.motors.R;
import com.executives.motors.helper.SharedPrefs;
import com.executives.motors.targets.model.MockTargetProvider;
import com.executives.motors.targets.model.data.TargetDataTsm;
import com.executives.motors.targets.model.data.TargetListDetails;
import com.executives.motors.targets.presenter.TargetPresenter;
import com.executives.motors.targets.presenter.TargetPresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetTargets.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetTargets#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetTargets extends Fragment implements SetTargetView{

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private SharedPrefs sharedPrefs;
    LinearLayoutManager linearLayoutManager;
    private SetTargetAdapter setTargetAdapter;
    private TargetPresenter targetPresenter;


    private OnFragmentInteractionListener mListener;

    public SetTargets() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetTargets.
     */

    public static SetTargets newInstance(String param1, String param2) {
        SetTargets fragment = new SetTargets();
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
        View view=inflater.inflate(R.layout.fragment_set_targets, container, false);
        Log.d("setTarget","1");
        progressBar=(ProgressBar)view.findViewById(R.id.target_bar);
        recyclerView = (RecyclerView)view.findViewById(R.id.setTargetRecycler);
        initialize();
        Log.d("setTarget","2");
        targetPresenter.requestSetTarget(sharedPrefs.getUserId(),sharedPrefs.getUsername());
        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    void initialize() {

        sharedPrefs = new SharedPrefs(getContext());
//        targetPresenter = new TargetPresenterImpl(new RetrofitTargetProvider(),this);
        targetPresenter = new TargetPresenterImpl(new MockTargetProvider(),this);
        setTargetAdapter= new SetTargetAdapter(getContext(),this);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(setTargetAdapter);
        Log.d("setTarget","3");

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
    public void setData(TargetDataTsm targetDataTsm) {
        setTargetAdapter.setData(targetDataTsm.getTargetListDetails());
        setTargetAdapter.notifyDataSetChanged();
    }

    @Override
    public void dialog(final TargetListDetails targetListDetails)
    {
        final String target_monthly,target_daily;
//        final DialogFragment dialogFragment = new DialogFragment();

        //// TODO: 5/4/17 Dialog Error to be corrected
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_target_response);
        dialog.setTitle(targetListDetails.getUsername());
        final EditText monthly = (EditText)dialog.findViewById(R.id.monthly_target);
        final EditText daily = (EditText)dialog.findViewById(R.id.daily_target);
        Button okButton = (Button)dialog.findViewById(R.id.ok);
        target_monthly = monthly.getText().toString();
        target_daily = daily.getText().toString();
        dialog.show();
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (target_monthly.equals("") || target_monthly.equals(null))
                {
                    monthly.setError("Please fill it");
                    monthly.requestFocus();

                }
                else if (target_daily.equals("") || target_daily.equals(null))
                {
                    daily.setError("Please fill it");
                    daily.requestFocus();
                }
                else
                {
                        targetPresenter.responseSetTarget(sharedPrefs.getAccessToken(),
                        targetListDetails.getUser_id(),targetListDetails.getUsername(),
                        target_monthly,target_daily);
                }
            }
        });
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
