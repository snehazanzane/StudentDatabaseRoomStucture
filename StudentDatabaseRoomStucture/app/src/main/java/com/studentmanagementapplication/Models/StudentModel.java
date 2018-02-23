package com.studentmanagementapplication.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sneha on 21/2/18.
 */
@Entity(tableName = "StudentModel")
public class StudentModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;

    @ColumnInfo(name = "userName")
    String userName;

    @ColumnInfo(name = "std")
    String std;

    @ColumnInfo(name = "division")
    String division;

    @ColumnInfo(name = "rollNumber")
    String rollNumber;

    @ColumnInfo(name = "maths")
    double maths;

    @ColumnInfo(name = "english")
    double english;

    @ColumnInfo(name = "science")
    double science;

    @ColumnInfo(name = "history")
    double history;

    @ColumnInfo(name = "marathi")
    double marathi;

    @ColumnInfo(name = "total")
    double total;

    @ColumnInfo(name = "percentage")
    double percentage;

    protected StudentModel(Parcel in) {
        id = in.readInt();
        userName = in.readString();
        std = in.readString();
        division = in.readString();
        rollNumber = in.readString();
        maths = in.readDouble();
        english = in.readDouble();
        science = in.readDouble();
        history = in.readDouble();
        marathi = in.readDouble();
        total = in.readDouble();
        percentage = in.readDouble();
    }

    public StudentModel(){

    }

    public static final Creator<StudentModel> CREATOR = new Creator<StudentModel>() {
        @Override
        public StudentModel createFromParcel(Parcel in) {
            return new StudentModel(in);
        }

        @Override
        public StudentModel[] newArray(int size) {
            return new StudentModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getScience() {
        return science;
    }

    public void setScience(double science) {
        this.science = science;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getMarathi() {
        return marathi;
    }

    public void setMarathi(double marathi) {
        this.marathi = marathi;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(userName);
        parcel.writeString(std);
        parcel.writeString(division);
        parcel.writeString(rollNumber);
        parcel.writeDouble(maths);
        parcel.writeDouble(english);
        parcel.writeDouble(science);
        parcel.writeDouble(history);
        parcel.writeDouble(marathi);
        parcel.writeDouble(total);
        parcel.writeDouble(percentage);
    }
}
