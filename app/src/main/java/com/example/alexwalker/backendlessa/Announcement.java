package com.example.alexwalker.backendlessa;

import android.content.Intent;

import java.util.Locale;

/**
 * Created by AlexWalker on 01.10.2016.
 */
public class Announcement {
    String annText;
    String authorEmail;
    String time;

    Announcement()
    {}

    public Announcement (String annText, String authorEmail){
        this.annText = annText;
        this.authorEmail = authorEmail;
    }

    public String getAnnText(){
        return annText;
    }
    public void setAnnText(String annText){
        this.annText = annText;
    }

    public String getAuthorEmail(){
        return authorEmail;
    }
    public void setAuthorEmail(String authorEmail){
        this.authorEmail = authorEmail;
    }
    public String getTime (){
        this.time = String.valueOf(System.currentTimeMillis());
        return time;
    }



}
