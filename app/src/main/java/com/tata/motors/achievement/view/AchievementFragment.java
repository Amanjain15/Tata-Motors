package com.tata.motors.achievement.view;

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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.games.achievement.AchievementBuffer;
import com.tata.motors.R;
import com.tata.motors.achievement.model.RetrofitAchievementProvider;
import com.tata.motors.achievement.model.data.AchievementData;
import com.tata.motors.achievement.presenter.AchievementPresenter;
import com.tata.motors.achievement.presenter.AchievementPresenterImpl;
import com.tata.motors.helper.SharedPrefs;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AchievementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AchievementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AchievementFragment extends Fragment implements AchievementView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    @BindView(R.id.achievementRecyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.achievementToolbar)
    Toolbar toolbar;
    @BindView(R.id.achievementProgressbar)
    ProgressBar progressBar;
    private SharedPrefs sharedPrefs;
    private LinearLayoutManager linearLayoutManager;
    private AchievementAdapter achievementAdapter;
    private AchievementPresenter achievementPresenter;
    private  String access_token;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AchievementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AchievementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AchievementFragment newInstance(String param1, String param2) {
        AchievementFragment fragment = new AchievementFragment();
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
        View view= inflater.inflate(R.layout.fragment_achievement, container, false);
        linearLayoutManager=new LinearLayoutManager(getContext());
        access_token=sharedPrefs.getAccessToken();
        achievementPresenter=new AchievementPresenterImpl(this,new RetrofitAchievementProvider());
        achievementPresenter.requestAchievement(access_token);
        achievementAdapter=new AchievementAdapter(this,getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(achievementAdapter);
        return(view);
    }


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
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onVerified(AchievementData achievementData) {
        achievementAdapter.setData(achievementData.getAchievementDataDetailses());
        achievementAdapter.notifyDataSetChanged();


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
