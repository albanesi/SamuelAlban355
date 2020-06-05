package com.example.a355uek;


import androidx.room.TypeConverter;
import java.util.Date;

//A DateConverter class is needed for the db to get created
//Room DBs cant handle with the Dates so they need a converter who converts them to long
//date is saved in the db as byte code
public class DateConverter {

    //converts from long to Date
    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null: new Date(dateLong);
    }
    //converts from Date to long
    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }
}
