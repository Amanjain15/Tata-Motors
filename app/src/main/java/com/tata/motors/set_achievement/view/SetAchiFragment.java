package com.tata.motors.set_achievement.view;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tata.motors.R;
import com.tata.motors.add_user.model.data.DealerListDetails;
import com.tata.motors.add_user.model.data.UserAddedData;
import com.tata.motors.helper.SharedPrefs;
import com.tata.motors.set_achievement.model.RetrofitSetAchiProvider;
import com.tata.motors.set_achievement.model.data.EmployeeList;
import com.tata.motors.set_achievement.model.data.SetAchiData;
import com.tata.motors.set_achievement.presenter.SetAchiPresenter;
import com.tata.motors.set_achievement.presenter.SetAchiPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetAchiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetAchiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetAchiFragment extends Fragment implements SetAchiView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Spinner spinner;
    private ProgressBar progressBar,progressBar2;
    private SharedPrefs sharedPrefs;
    private String token;
private SetAchiPresenter setAchiPresenter;
    private EmployeeList employeeList;
    private String employee_name,achi;
    private int employee_id;
    private OnFragmentInteractionListener mListener;

    public SetAchiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetAchiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetAchiFragment newInstance(String param1, String param2) {
        SetAchiFragment fragment = new SetAchiFragment();
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
        View view= inflater.inflate(R.layout.fragment_set_achi, container, false);
        progressBar=(ProgressBar)view.findViewById(R.id.set_achi_progressBar);
        spinner=(Spinner)view.findViewById(R.id.set_achi_spinner);
        sharedPrefs=new SharedPrefs(getContext());
        token=sharedPrefs.getAccessToken();
        setAchiPresenter=new SetAchiPresenterImpl(new RetrofitSetAchiProvider(),this);
        setAchiPresenter.requestSpinner(token);



        return(view);
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
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onVerified(SetAchiData setAchiData) {

        List<EmployeeList> employeeLists = new ArrayList<EmployeeList>(setAchiData.getEmployeeLists());
        ArrayAdapter<String> adapter;
        int n= employeeLists.size();
        final int employee_id_ar[]=new int[n];
        final String employee_name_ar[]=new String[n];

        int i=0;
        while(i < n)
        {
             employeeList= employeeLists.get(i);
            employee_id_ar[i] = employeeList.getId();
            employee_name_ar[i] = employeeList.getName();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,employee_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //OnItemSelected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                employee_id = employee_id_ar[t];
                employee_name = employee_name_ar[t];
                showDialog();

            }
        });
    }


    public void showDialog(){
        final Dialog dialog= new Dialog(getContext());
        dialog.setContentView(R.layout.fragment_set_achivement_dialog);
        TextView name = (TextView)dialog.findViewById(R.id.achivement_name);
        EditText achivement=(EditText)dialog.findViewById(R.id.achivement);
        progressBar2=(ProgressBar)dialog.findViewById(R.id.achivement_dialog_progressBar);
        dialog.setTitle("ACHIEVEMENT");

        name.setText(employee_name);
achi=achivement.getText().toString();
        dialog.show();

setAchiPresenter.sendAchi(token,employee_id,achi);
    }


    @Override
    public void onSend() {
        Toast.makeText(getContext(), "ACHIEVEMENT SEND", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showProgreebar(boolean show) {
        if(show) {
            progressBar2.setVisibility(View.VISIBLE);

        }
        else{
            progressBar2.setVisibility(View.GONE);
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
