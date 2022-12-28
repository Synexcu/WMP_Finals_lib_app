package com.example.wmp_finals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class recycler extends AppCompatActivity{
    CardView cardView;
    ImageButton textView;
    RecyclerView recyclerView;
    ConstraintLayout expandableview;

    String s1[], s2[], s3[], s4[], s5[], s6[], bookvalue[];
    int images[] = {R.drawable.katainaka_no_ossan, R.drawable.spy_x_family, R.drawable.otonari_no_tenshi,
    R.drawable.kage_no_jitsuryokusha, R.drawable.nihonkoku_shoukan};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
            recyclerView = findViewById(R.id.recyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            s1 = getResources().getStringArray(R.array.Title);
            s2 = getResources().getStringArray(R.array.altTitle);
            s3 = getResources().getStringArray(R.array.Author);
            s4 = getResources().getStringArray(R.array.shortDesc);
            s5 = getResources().getStringArray(R.array.Description);
            s6 = getResources().getStringArray(R.array.pages);

            MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, s4, s5, s6, images);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager((this)));

    }
}