package com.studentmanagementapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.studentmanagementapplication.Models.StudentModel;
import com.studentmanagementapplication.database.MyDatabase;
import com.studentmanagementapplication.listener.RecyclerItemListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_CODE = 100;
    @BindView(R.id.btnAdd_MainActivity)
    FloatingActionButton btnAdd;
    @BindView(R.id.recyclerView_MainActivity)
    RecyclerView recyclerView;
    @BindView(R.id.imgNoData_MainActivity)
    ImageView imgNoData;

    MyDatabase database;

    ArrayList<StudentModel> arrStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        onClickActionHandel();
    }

    private void initView() {
        database = MyDatabase.getAppDatabase(MainActivity.this);
        arrStudents=new ArrayList<StudentModel>();
        setData();
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdd_MainActivity:
                startActivityForResult(new Intent(MainActivity.this, AddStudentActivity.class), REQUEST_CODE);
                break;
        }
    }

    private void onClickActionHandel() {

        recyclerView.addOnItemTouchListener(new RecyclerItemListener(MainActivity.this, recyclerView,
                new RecyclerItemListener.RecyclerTouchListener() {
                    public void onClickItem(View v, int position) {

                        Intent intent=new Intent(MainActivity.this, StudentDetailsActivity.class);
                        intent.putExtra("obj",arrStudents.get(position));
                        startActivityForResult(intent,REQUEST_CODE);
                    }

                    public void onLongClickItem(View v, int position) {
                    }


                }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode==200){
               setData();
            }
        }
    }

    private void setData(){

        arrStudents= (ArrayList<StudentModel>) database.userDao().getAllStudents();

        StudentRecylerAdapter mAdapter = new StudentRecylerAdapter(MainActivity.this, arrStudents);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        if (arrStudents.size()>0){
            imgNoData.setVisibility(View.GONE);
        }else{
            imgNoData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        MyDatabase.destroyInstance();
    }
}
