package com.example.bsimmelink19.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * this class models a roll in yahtzee
 * five dice faces chosen at random appear
 */
public class yahtzee extends AppCompatActivity implements View.OnClickListener, Runnable{

    int[] img = {R.drawable.dice1, R.drawable.dice2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yahtzee);

        //button that rolls the dice
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);

    }

    /**
     * sets all image views to a random image of one of the six faces of a dice
     */
    @Override
    public void run() {
        //array of the 5 imageviews
        int views[] = {R.id.imageView, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5};
        //used to display the sum of the dice
        TextView t = (TextView)yahtzee.this.findViewById(R.id.textView2);
        //selects the random face of the dice
        Random r = new Random();
        int sum = 0;
        //loops through all the imageviews, setting them to a random image
        for (int i = 0; i < 5; i++)
        {
            int rnd = r.nextInt(6);
            ImageView v = (ImageView) findViewById(views[i]);
            v.setImageResource(img[rnd]);
            sum += rnd + 1;
        }
        //displays the sum of the dice
            t.setText(String.format("Total: %d", sum));
    }

    /**
     * rolls the dice
     * @param v, button clicked
     */
    @Override
    public void onClick(View v) {
        run();
    }
}
