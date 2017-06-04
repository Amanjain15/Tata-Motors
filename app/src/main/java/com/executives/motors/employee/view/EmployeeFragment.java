package com.executives.motors.employee.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.executives.motors.R;
import com.executives.motors.add_customer.view.AddCustomerFragment;
import com.executives.motors.add_user.view.AddUserFragment;
import com.executives.motors.employee.model.RetrofitEmployeeProvider;
import com.executives.motors.employee.model.data.EmployeeListDetails;
import com.executives.motors.employee.presenter.EmployeePresenter;
import com.executives.motors.employee.presenter.EmployeePresenterImpl;
import com.executives.motors.helper.SharedPrefs;
import com.executives.motors.home.home_page;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EmployeeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EmployeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeFragment extends Fragment implements EmployeeView {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_C_TYPE = "user_c_type";
    private static final String ID = "id";

    // TODO: Rename and change types of parameters
    private String user_c_type;
    private int choose_id;

    @BindView(R.id.employeeRecyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.employeeToolbar)
    Toolbar toolbar;
    @BindView(R.id.employeeProgressbar)
    ProgressBar progressBar;
    @BindView(R.id.to_date)
    TextView to;
    @BindView(R.id.from_date)
    TextView from;
    @BindView(R.id.spinner_customer)
    Spinner spinner;
    @BindView(R.id.submit)
    Button button;
    @BindView(R.id.linear_layout)
    LinearLayout linearLayout;

    private static int status;
    private EmployeePresenter employeePresenter;
    private Calendar calendar,calendar1;
    private LinearLayoutManager linearLayoutManager;
    private SharedPrefs sharedPrefs;
    private String  access_token;
    private EmployeeAdapter employeeAdapter;
    private String to_date,from_date;

    private DatePickerDialog datePicker;
    private DatePickerDialog.OnDateSetListener datePickerListener;
    private DatePickerDialog datePicker1;
    private  DatePickerDialog.OnDateSetListener datePickerListener1;


    private OnFragmentInteractionListener mListener;

    public EmployeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EmployeeFragment.
     */
    public static EmployeeFragment newInstance(String user_see_type, int id) {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle args = new Bundle();
        args.putString(USER_C_TYPE, user_see_type);
        args.putInt(ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user_c_type = getArguments().getString(USER_C_TYPE);
            choose_id = getArguments().getInt(ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_employee, container, false);
        ButterKnife.bind(this,view);
        sharedPrefs = new SharedPrefs(getContext());
        access_token=sharedPrefs.getAccessToken();
        employeePresenter=new EmployeePresenterImpl(new RetrofitEmployeeProvider(),this);
//        employeePresenter=new EmployeePresenterImpl(new MockEmployee(),this);

        employeeAdapter=new EmployeeAdapter(getContext(),this);
        linearLayoutManager= new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);


        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab_employee);
        fab.setVisibility(View.GONE);
        if(user_c_type.equals("1")||user_c_type.equals("2")||user_c_type.equals("4"))
        {
            fab.setVisibility(View.VISIBLE);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sharedPrefs.setKeyEmployeeType(user_c_type);//Add User Ke Liye Hai
                    if(user_c_type.equals("1"))
                    {

                        ((home_page)getContext()).setFragment(new AddUserFragment(), "Add DSM");
                    }
                    else if(user_c_type.equals("2"))
                    {

                        ((home_page)getContext()).setFragment(new AddUserFragment(), "Add DSE");
                    }
                    else if(user_c_type.equals("4"))
                    {

                        ((home_page)getContext()).setFragment(new AddCustomerFragment(), "Add CUSTOMER");
                    }
                }
        });
                  //dealer ke case me floating button nahi rahegi wo handle karne ke liye
        }


        if(!(choose_id==(-1)))
        {
            ((home_page) getActivity()).getSupportActionBar().hide();
            toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.white));
            toolbar.setNavigationIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_back_white_24dp));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().onBackPressed();
                }
            });
        }
        else
        {
            toolbar.setVisibility(View.GONE);

        }

        if(user_c_type.equals("3")) {
            toolbar.setTitle("DEALERS");
            toolbar.setVisibility(View.GONE);
            to.setVisibility(View.GONE);
            from.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            spinner.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
            ((home_page)getContext()).getSupportActionBar().show();
            ((home_page)getContext()).getSupportActionBar().setTitle("Dealers");

        }
        else if(user_c_type.equals("1"))
        {
            toolbar.setTitle("DSM");
            if((choose_id==(-1)))
            {
                ((home_page)getContext()).getSupportActionBar().show();
                ((home_page)getContext()).getSupportActionBar().setTitle("DSM");
            }

        }
        else if(user_c_type.equals("2"))
        {
            toolbar.setTitle("DSE");
            if((choose_id==(-1)))
            {
                ((home_page)getContext()).getSupportActionBar().show();
                ((home_page)getContext()).getSupportActionBar().setTitle("DSE");
            }
        }
        else if(user_c_type.equals("4"))
        {
            toolbar.setTitle("Customers");
            spinner.setVisibility(View.VISIBLE);
        }

//        calendar_func(calendar,to);
//        calendar_func(calendar,from);
        calendar1 = Calendar.getInstance(TimeZone.getDefault());

        from_date = calendar1.get(Calendar.DAY_OF_MONTH)+"/"+calendar1.get(Calendar.MONTH)+"/"+calendar1.get(Calendar.YEAR);
        Log.d("Employee",from_date+" ");
        calendar1.add(Calendar.DAY_OF_YEAR,1);
        to_date=calendar1.get(Calendar.DAY_OF_MONTH)+"/"+calendar1.get(Calendar.MONTH)+"/"+calendar1.get(Calendar.YEAR);
        Log.d("Employeeto",to_date+" ");


        calendar = Calendar.getInstance(TimeZone.getDefault());  ///from start
        datePickerListener = new DatePickerDialog.OnDateSetListener() {

            // when dialog box is closed, below method will be called.
            public void onDateSet(DatePicker view, int selectedYear,
                                  int selectedMonth, int selectedDay) {
                String year1 = String.valueOf(selectedYear);
                String month1 = String.valueOf(selectedMonth + 1);
                String day1 = String.valueOf(selectedDay);

                from.setText(day1 + "/" + month1 + "/" + year1);
                from_date=from.getText().toString();

            }
        };


        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(getContext(),
                        R.style.AppThemeDatePicker, datePickerListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
//                datePicker.setContentView(R.layout.date_picker_layout);
                datePicker.setCancelable(false);
                datePicker.setTitle("Select the date");


                datePicker.show();
            }
        });///from-end

        final Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());///to-start
        datePickerListener1 = new DatePickerDialog.OnDateSetListener() {

            // when dialog box is closed, below method will be called.
            public void onDateSet(DatePicker view, int selectedYear,
                                  int selectedMonth, int selectedDay) {
                String year1 = String.valueOf(selectedYear);
                String month1 = String.valueOf(selectedMonth + 1);
                String day1 = String.valueOf(selectedDay);

                to.setText(day1 + "/" + month1 + "/" + year1);
                to_date=to.getText().toString();

            }
        };

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1 = new DatePickerDialog(getContext(),
                        R.style.AppThemeDatePicker, datePickerListener1,
                        calendar2.get(Calendar.YEAR),
                        calendar2.get(Calendar.MONTH),
                        calendar2.get(Calendar.DAY_OF_MONTH));
//                datePicker.setContentView(R.layout.date_picker_layout);
                datePicker1.setCancelable(false);
                datePicker1.setTitle("Select the date");


                datePicker1.show();
            }
        });///to end
        showSpinnerStatus();

        employeePresenter.requestEmployee(access_token,choose_id,user_c_type,to_date,from_date,status);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("EmployeeCall",from_date+" ");Log.d("EmployeetoCall",to_date+" ");
                employeePresenter.requestEmployee(access_token,choose_id,user_c_type,to_date,from_date,status);
            }
        });

        return view;
    }


    public void calendar_func(final Calendar calendar,TextView follow)
    {
        // Get current date


    }


    @Override
    public void showProgressbar(boolean show) {
        if(show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {

        try{
            Toast.makeText(getContext()," "+message,Toast.LENGTH_SHORT).show();
        }
        catch (java.lang.NullPointerException e)
        {
            Toast.makeText(getContext()," "+null,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void dataReceived(List<EmployeeListDetails> employeeListDetailsList) {
        employeeAdapter.setData(employeeListDetailsList,user_c_type);
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public void safe(int id) {

        employeePresenter.sendStatus(sharedPrefs.getAccessToken(),id);
        Log.d("safecall","shared"+sharedPrefs.getAccessToken()+" "+id);
    }

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


    public void showSpinnerStatus() {
        final String statusDetails[] = new String[7];
        statusDetails[1] = "Customer Met";
        statusDetails[2] = "Sold";
        statusDetails[3] = "Lost";
        statusDetails[4] = "Pending";
        statusDetails[5] = "ETU";
        statusDetails[6] = "FTU";
        statusDetails[0] = "ALL";

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,statusDetails);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {
                status=t;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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

        void onFragmentInteraction(Uri uri);
    }
}
