package com.example.wmp_finals;

import static com.example.wmp_finals.MainActivity.SHARED_PREFS;
import static com.example.wmp_finals.MainActivity.SHARED_PREFS_FAV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

public class recycler_current extends AppCompatActivity {

    CardView cardView;
    ImageButton textView;
    RecyclerView recyclerView;
    ConstraintLayout expandableview;

    String s1[], s2[], s3[], s4[], s5[], s6[], index[];
    String news1[], news2[], news3[], news4[], news5[], news6[];
    int images[] = {R.drawable.katainaka_no_ossan, R.drawable.spy_x_family, R.drawable.otonari_no_tenshi,
            R.drawable.kage_no_jitsuryokusha, R.drawable.nihonkoku_shoukan};
    int newImage[];

    public String[] transferString(String str[], String value[], String cond){
        ArrayList<String> in = new ArrayList<String>();
        ArrayList<String> al = new ArrayList<String>();
        for(int i = 0; i < str.length; i++){
            if(value[i].equals(cond)){
                al.add(str[i]);
                in.add(Integer.toString(i));
            }
        }
        String[] arr = new String[al.size()];
        String[] ind = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ind[i] = in.get(i);
        }
        index = ind;
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }


    public int[] transferInt(int str[], String value[], String cond){
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0; i < str.length; i++){
            if(value[i].equals(cond)){
                al.add(str[i]);
            }
        }
        int[] arr = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_current);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.Title);
        s2 = getResources().getStringArray(R.array.altTitle);
        s3 = getResources().getStringArray(R.array.Author);
        s4 = getResources().getStringArray(R.array.shortDesc);
        s5 = getResources().getStringArray(R.array.Description);
        s6 = getResources().getStringArray(R.array.pages);

        news1 = transferString(s1, loadData(s1.length), "Current");
        news2 = transferString(s2, loadData(s1.length), "Current");
        news3 = transferString(s3, loadData(s1.length), "Current");
        news4 = transferString(s4, loadData(s1.length), "Current");
        news5 = transferString(s5, loadData(s1.length), "Current");
        news6 = transferString(s6, loadData(s1.length), "Current");
        newImage = transferInt(images, loadData(s1.length), "Current");


        MyAdapterCurrent myAdapter = new MyAdapterCurrent(this, news1, news2, news3, news4, news5, news6, newImage, index);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }

    public String[] loadData(int size) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        ArrayList<String> al = new ArrayList<String>();
        for(int i = 0; i < size; i++){
            if(sharedPreferences.contains(Integer.toString(i))) {
                al.add(sharedPreferences.getString(Integer.toString(i), "false"));
            } else {
                al.add("false");
            }
        }

        String[] arr = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }
}