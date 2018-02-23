package com.studentmanagementapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.studentmanagementapplication.Models.StudentModel;
import com.studentmanagementapplication.database.MyDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.edtName_AddStudentActivity)
    EditText edtName;

    @BindView(R.id.edtStd_AddStudentActivity)
    EditText edtStd;

    @BindView(R.id.edtDiv_AddStudentActivity)
    EditText edtDiv;

    @BindView(R.id.edtRollNumber_AddStudentActivity)
    EditText edtRollNumber;

    @BindView(R.id.edtMaths_AddStudentActivity)
    EditText edtMaths;

    @BindView(R.id.edtEnglish_AddStudentActivity)
    EditText edtEnglish;

    @BindView(R.id.edtScience_AddStudentActivity)
    EditText edtScience;

    @BindView(R.id.edtHistory_AddStudentActivity)
    EditText edtHistory;

    @BindView(R.id.edtMarathi_AddStudentActivity)
    EditText edtMarathi;

    @BindView(R.id.btnAdd_AddStudentActivity)
    Button btnAdd;

    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = MyDatabase.getAppDatabase(AddStudentActivity.this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd_AddStudentActivity:
                if (isValid()){
                    StudentModel obj=new StudentModel();
                    obj.setUserName(edtName.getText().toString());
                    obj.setStd(edtStd.getText().toString());
                    obj.setDivision(edtDiv.getText().toString());
                    obj.setRollNumber(edtRollNumber.getText().toString());
                    obj.setMaths(Double.parseDouble(edtMaths.getText().toString()));
                    obj.setEnglish(Double.parseDouble(edtEnglish.getText().toString()));
                    obj.setScience(Double.parseDouble(edtScience.getText().toString()));
                    obj.setHistory(Double.parseDouble(edtHistory.getText().toString()));
                    obj.setMarathi(Double.parseDouble(edtMarathi.getText().toString()));
                    double total=obj.getMaths()
                            +obj.getEnglish()
                            +obj.getScience()
                            +obj.getHistory()
                            +obj.getMarathi();
                    obj.setTotal(total);
                    obj.setPercentage(total/5);

                    database.userDao().insertData(obj);

                    setResult(200);
                    onBackPressed();
                }

                break;
        }
    }

    public boolean isValid(){

        if (TextUtils.isEmpty(edtName.getText().toString())){
            edtName.setError("Please enter Student Name");
            return false;
        }

        if (TextUtils.isEmpty(edtStd.getText().toString())){
            edtStd.setError("Please enter Student Standard");
            return false;
        }

        if (TextUtils.isEmpty(edtDiv.getText().toString())){
            edtDiv.setError("Please enter Division");
            return false;
        }

        if (TextUtils.isEmpty(edtRollNumber.getText().toString())){
            edtRollNumber.setError("Please enter Roll Number");
            return false;
        }

        if (TextUtils.isEmpty(edtMaths.getText().toString())){
            edtName.setError("Please enter Maths marks");
            return false;
        }

        if (TextUtils.isEmpty(edtEnglish.getText().toString())){
            edtName.setError("Please enter English marks");
            return false;
        }

        if (TextUtils.isEmpty(edtScience.getText().toString())){
            edtScience.setError("Please enter Science marks");
            return false;
        }

        if (TextUtils.isEmpty(edtHistory.getText().toString())){
            edtHistory.setError("Please enter History marks");
            return false;
        }

        if (TextUtils.isEmpty(edtMarathi.getText().toString())){
            edtMarathi.setError("Please enter Marathi marks");
            return false;
        }

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
   


}
