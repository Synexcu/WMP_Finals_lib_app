package com.example.wmp_finals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private Button see, current, about, favorite, already, want;

    public static final String SHARED_PREFS_FAV = "sharedPrefsFav";
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        see = findViewById(R.id.seebookBtn);
        current = findViewById(R.id.currentbookBtn);
        about = findViewById(R.id.aboutBtn);
        favorite = findViewById(R.id.favbookBtn);
        already = findViewById(R.id.alreadybookBtn);
        want = findViewById(R.id.wantbookBtn);

        ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.bookappicon);

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotosee();
            }
        });

        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotocurrent();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotofav();
            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoalready();
            }
        });

        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotowant();
            }
        });

    }


    private void gotosee(){
        Intent intent = new Intent(this, recycler.class);
        startActivity(intent);
    }

    private void gotocurrent(){
        Intent intent = new Intent(this, recycler_current.class);
        startActivity(intent);
    }

    public void openDialog() {
        DialogVisit dialog = new DialogVisit();
        dialog.show(getSupportFragmentManager(), "My Library");
    }

    public void gotofav() {
        Intent intent = new Intent(this, recycler_favorite.class);
        startActivity(intent);
    }

    public void gotoalready() {
        Intent intent = new Intent(this, recycler_already.class);
        startActivity(intent);
    }

    public void gotowant() {
        Intent intent = new Intent(this, recycler_want.class);
        startActivity(intent);
    }
 }