package com.studentmanagementapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.studentmanagementapplication.Models.StudentModel;

import java.util.List;

/**
 * Created by sneha on 23/2/18.
 */

public class StudentRecylerAdapter  extends RecyclerView.Adapter<StudentRecylerAdapter.StudentHolder> {

    Context context;
    List<StudentModel> arr;

    public StudentRecylerAdapter(Context context, List<StudentModel> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public StudentRecylerAdapter.StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_student_list_item, parent, false);
        return new StudentRecylerAdapter.StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, final int position) {
        StudentModel obj = arr.get(position);

        holder.txtRollNo.setText(obj.getRollNumber() + "");
        holder.txtName.setText(obj.getUserName());
        holder.txtStdDiv.setText("Standard : "+obj.getStd()+" ("+obj.getDivision()+")");
        holder.txtPercentage.setText("Percentage : "+obj.getPercentage()+"%");
        if (obj.getPercentage()>70){
            holder.imgReword.setVisibility(View.VISIBLE);
        }
    }

    public List<StudentModel> getArrTrades() {
        return arr;
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        TextView txtRollNo, txtName, txtStdDiv, txtPercentage;
        ImageView imgReword;
        public StudentHolder(View view) {
            super(view);
            txtRollNo = view.findViewById(R.id.txtRollNumber_StudentListItem);
            txtName = view.findViewById(R.id.txtName_StudentListItem);
            txtStdDiv = view.findViewById(R.id.txtStdDiv_StudentListItem);
            txtPercentage = view.findViewById(R.id.txtPercentages_StudentListItem);
            imgReword = view.findViewById(R.id.imgReword_StudentListItem);
        }
    }

}
