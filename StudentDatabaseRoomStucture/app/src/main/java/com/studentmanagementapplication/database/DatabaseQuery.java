package com.studentmanagementapplication.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.studentmanagementapplication.Models.StudentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sneha on 30/1/18.
 */

@Dao
public interface DatabaseQuery {

    @Insert
    void insertData(StudentModel obj);

    @Query("SELECT * FROM StudentModel ORDER BY percentage DESC")
    List<StudentModel> getAllStudents();

}
