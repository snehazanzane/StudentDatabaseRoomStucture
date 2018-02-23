package com.studentmanagementapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.studentmanagementapplication.Models.StudentModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class StudentDetailsActivity extends AppCompatActivity {

    @BindView(R.id.txtName_StudentDetailsActivity)
    TextView txtName;

    @BindView(R.id.txtStandard_StudentDetailsActivity)
    TextView txtStandard;

    @BindView(R.id.imgReword_StudentDetailsActivity)
    ImageView imgReword;

    @BindView(R.id.txtMaths_StudentDetailsActivity)
    TextView txtMaths;

    @BindView(R.id.txtEnglish_StudentDetailsActivity)
    TextView txtEnglish;

    @BindView(R.id.txtScience_StudentDetailsActivity)
    TextView txtScience;

    @BindView(R.id.txtHistory_StudentDetailsActivity)
    TextView txtHistory;

    @BindView(R.id.txtMarathi_StudentDetailsActivity)
    TextView txtMarathi;

    @BindView(R.id.txtTotal_StudentDetailsActivity)
    TextView txtTotal;

    @BindView(R.id.txtPercentage_StudentDetailsActivity)
    TextView txtPercentage;

    StudentModel obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        ButterKnife.bind(this);
        initViews();
        setData();
    }


    private void initViews() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        obj=new StudentModel();
    }

    private void setData(){
        obj=getIntent().getParcelableExtra("obj");

        txtName.setText(obj.getUserName());
        setMultipleFontAndText("Standard : ",obj.getStd()+" ("+obj.getDivision()+")",txtStandard);
        setMultipleFontAndText("Maths : ",obj.getMaths()+"",txtMaths);
        setMultipleFontAndText("English : ",obj.getEnglish()+"",txtEnglish);
        setMultipleFontAndText("Science : ",obj.getScience()+"",txtScience);
        setMultipleFontAndText("History : ",obj.getHistory()+"",txtHistory);
        setMultipleFontAndText("Marathi : ",obj.getMarathi()+"",txtMarathi);
        setMultipleFontAndText("Total : ",obj.getTotal()+"/500",txtTotal);
        setMultipleFontAndText("Percentage : ",obj.getPercentage()+"%",txtPercentage);

        if (obj.getPercentage()>70){
            imgReword.setVisibility(View.VISIBLE);
        }
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

    private void setMultipleFontAndText(String str1, String str2, TextView txtview) {
        try {

            String completeStr = str1 + " " + str2;
            SpannableStringBuilder sBuilder = new SpannableStringBuilder();
            sBuilder.append(completeStr);
            CalligraphyTypefaceSpan typefaceSpanMedium = new CalligraphyTypefaceSpan(TypefaceUtils.load(getAssets(), "fonts/Roboto-Medium.ttf"));
            CalligraphyTypefaceSpan typefaceSpanRegular = new CalligraphyTypefaceSpan(TypefaceUtils.load(getAssets(), "fonts/Roboto-Light.ttf"));
            sBuilder.setSpan(typefaceSpanRegular, 0, str1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sBuilder.setSpan(typefaceSpanMedium, str1.length(), completeStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            txtview.setText(sBuilder, TextView.BufferType.SPANNABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
