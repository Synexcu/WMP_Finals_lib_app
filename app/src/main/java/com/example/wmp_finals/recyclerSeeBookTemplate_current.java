package com.example.wmp_finals;

import static com.example.wmp_finals.MainActivity.SHARED_PREFS;
import static com.example.wmp_finals.MainActivity.SHARED_PREFS_FAV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class recyclerSeeBookTemplate_current extends AppCompatActivity {

//    RecyclerView recyclerViewSeeBookTemplate;

//    String s1[], s2[], s3[], s4[], s5[];
//    int images[] = {R.drawable.katainaka_no_ossan, R.drawable.spy_x_family};

    ImageView mainImageView;
    TextView title, altTitle, author, pages, description;
    Spinner spinner;
    Button favbtn;

    String data1, data2, data3, descdata, pagedata, index;
    int myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetails_current);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        recyclerViewSeeBookTemplate = findViewById(R.id.recyclerViewSeeBookTemplate);

//        s1 = getResources().getStringArray(R.array.Title);
//        s2 = getResources().getStringArray(R.array.altTitle);
//        s3 = getResources().getStringArray(R.array.Author);
//        s4 = getResources().getStringArray(R.array.pages);
//        s5 = getResources().getStringArray(R.array.Description);

//        recyclerViewSeeBookTemplate.setAdapter(myAdapterSee);
//        recyclerViewSeeBookTemplate.setLayoutManager(new LinearLayoutManager((this)));

        mainImageView = findViewById(R.id.bookCoverImg);
        title = findViewById(R.id.TitleTxt);
        altTitle = findViewById(R.id.altTitleTxt);
        author = findViewById(R.id.authorTxt);
        pages = findViewById(R.id.pageTxt);
        description = findViewById(R.id.descTitleTxt);
        spinner = findViewById(R.id.spinner);
        favbtn = (Button)findViewById(R.id.addtofavBtn);

        favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFav();
                if (favbtn.getText().equals("Add To Favorites")){
                    favbtn.setBackgroundColor(Color.rgb(48, 213, 200));
                    favbtn.setText("Favorited!");
                } else {
                    favbtn.setBackgroundColor(Color.rgb(98, 0, 238));
                    favbtn.setText("Add To Favorites");
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        saveStatus("Current");
                        break;
                    case 2:
                        saveStatus("Want");
                        break;
                    case 3:
                        saveStatus("Already");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2") && getIntent().hasExtra("data3") && getIntent().hasExtra("descdata")) {

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            descdata = getIntent().getStringExtra("descdata");
            pagedata = getIntent().getStringExtra("pagedata");
            myImage = getIntent().getIntExtra("myImage", 1);

        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData() {
        title.setText(data1);
        altTitle.setText(data2);
        author.setText(data3);
        pages.setText(pagedata);
        description.setText(descdata);
        mainImageView.setImageResource(myImage);
        spinner.setSelection(0);
    }

    public void addtofavoritesfx(View view) {
        if (favbtn.getText().equals("Add To Favorites")){
            favbtn.setBackgroundColor(Color.rgb(48, 213, 200));
            favbtn.setText("Favorited!");
        } else {
            favbtn.setBackgroundColor(Color.rgb(98, 0, 238));
            favbtn.setText("Add To Favorites");
        }
    }

    private void saveFav(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_FAV, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(index, "true");

        editor.apply();

        Toast.makeText(this, "Favorite saved", Toast.LENGTH_SHORT).show();
    }

    private void saveStatus(String status){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(index, status);

        editor.apply();

        Toast.makeText(this, "Books added", Toast.LENGTH_SHORT).show();
    }

}