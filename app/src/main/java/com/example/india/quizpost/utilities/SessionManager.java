package com.example.india.quizpost.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager
{

    Context context;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    // Constructor

    public SessionManager(Context context) {
        this.context = context;
        pref = this.context.getSharedPreferences("My_Pref", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void clearall(){
        editor.clear().commit();

    }

    public void addString(String key, String str) {
        editor.putString(key, str);
        editor.commit();
    }

    public String getString(String key) {

        return pref.getString(key, "");
    }

    public void addBoolean(String key, boolean str) {
        editor.putBoolean(key, str);
        editor.commit();
    }

    public boolean getBoolean(String key) {

        return pref.getBoolean(key, false);
    }

    public void addInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key) {

        return pref.getInt(key, 0);
    }

    public void clear() {
        editor.clear();
        editor.commit();

    }

    public void setKeyValueString(String key,String value){
        editor.putString(key,value).commit();

    }
    public String getKeyValueString(String key){
        String getvalue= pref.getString(key,"");
        return getvalue;
    }




}
