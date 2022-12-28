package com.example.wmp_finals;

import static com.example.wmp_finals.MainActivity.SHARED_PREFS_FAV;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterFavorite extends RecyclerView.Adapter<MyAdapterFavorite.MyViewHolder> {


    String data1[], data2[], data3[], shortdescdata[], descdata[], pages[], index[];
    int images[];
    Context context;
    ConstraintLayout expandableview;
    ImageButton textView;


    public MyAdapterFavorite(Context ct, String s1[], String s2[], String s3[], String s4[], String s5[], String s6[], int img[], String indexx[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        shortdescdata = s4;
        descdata = s5;
        images = img;
        pages = s6;
        index = indexx;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_favorite, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.myText1.setText(data1[position]);
            holder.myText2.setText(data2[position]);
            holder.myText3.setText(data3[position]);
            holder.myImage.setImageResource(images[position]);
            holder.shortdescText.setText(shortdescdata[position]);
            holder.shortdescTitle.setText("Description");
            holder.expandableview.setVisibility(View.GONE);

            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, recyclerSeeBookTemplate_favorite.class);
                    intent.putExtra("data1", data1[position]);
                    intent.putExtra("data2", data2[position]);
                    intent.putExtra("data3", data3[position]);
                    intent.putExtra("descdata", descdata[position]);
                    intent.putExtra("pagedata", pages[position]);
                    intent.putExtra("myImage", images[position]);
                    intent.putExtra("index", position);
                    context.startActivity(intent);
                }
            });

            holder.delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_FAV, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove(index[position]);
                    editor.apply();
                    Intent fav = new Intent(context, recycler_favorite.class);
                    context.startActivity(fav);
                }
            });

    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2, myText3, shortdescText, shortdescTitle;
        ImageView myImage;
        ConstraintLayout expandableview, mainLayout;
        CardView cardView;
        ImageButton textView;
        Button favBtn, delBtn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myText1 = itemView.findViewById(R.id.myText1); //TITLE
            myText2 = itemView.findViewById(R.id.myText2); //ALTTITLE
            myText3 = itemView.findViewById(R.id.myText3); //AUTHOR
            myImage = itemView.findViewById(R.id.myImageView);
            shortdescTitle = itemView.findViewById(R.id.dropdowndescTitle);
            shortdescText = itemView.findViewById(R.id.dropdowndescTxt);
            textView = itemView.findViewById(R.id.detailsBtn);
            expandableview = itemView.findViewById(R.id.expandable_view);

            mainLayout = itemView.findViewById(R.id.mainLayout);

            favBtn = itemView.findViewById(R.id.addtofavBtn);
            delBtn = itemView.findViewById(R.id.buttondelete);


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (expandableview.getVisibility() == View.GONE) {
                        textView.setRotationX(180);
                        TransitionManager.beginDelayedTransition(expandableview, new AutoTransition());
                        expandableview.setVisibility(View.VISIBLE);
                    } else {
                        textView.setRotationX(0);
                        TransitionManager.beginDelayedTransition(expandableview, new AutoTransition());
                        expandableview.setVisibility((View.GONE));
                    }
                }
            });


        }

    }
}