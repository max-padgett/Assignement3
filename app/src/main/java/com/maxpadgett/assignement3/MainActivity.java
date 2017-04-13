package com.maxpadgett.assignement3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<View> allPetals;
    private LayoutInflater layoutInflater;

    private Button addBtn;
    private Button clearBtn;
    private RelativeLayout relativeLayout;

    FibObject myFlower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFlower = new FibObject();
        allPetals = new ArrayList <>();





        initialize();

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);
        addBtn = (Button) findViewById(R.id.button1);
        clearBtn = (Button) findViewById(R.id.button3);
        addBtn.setOnClickListener(addPetal);
        clearBtn.setOnClickListener(clearPetals);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        myFlower.set_xCenter(metrics.widthPixels / 2 - 100);
        myFlower.set_yCenter(metrics.heightPixels / 2);

    }

    private void initialize(){

        myFlower.setRotate(0);
        myFlower.setScaleX((float) .3);
        myFlower.setScaleY((float) .3);
        myFlower.setDegenerate((float) 1.001);
        myFlower.initializeAngle();

    }

    private View.OnClickListener addPetal = new View.OnClickListener() {
        public void onClick (View view) {


            String buttonText = ((Button) view).getText().toString();
            View petal;
            if (buttonText.equals("Text")) {
                petal = layoutInflater.inflate(R.layout.text_item, null);
            }
            else if(buttonText.equals("Circle"))
                petal =  layoutInflater.inflate(R.layout.circle, null);
            else if (buttonText.equals("Oval")) {
                petal = layoutInflater.inflate(R.layout.oval, null);
            }
            else
                petal = layoutInflater.inflate(R.layout.rectangle, null);

            petal.setX(myFlower.get_xCenter());
            petal.setY(myFlower.get_yCenter());
            petal.setPivotY(0);
            petal.setPivotX(100);
            petal.setScaleX(myFlower.getScaleX());
            petal.setScaleY(myFlower.getScaleY());
            petal.setRotation(myFlower.getRotate());


            relativeLayout.addView(petal, 0);

            allPetals.add(petal);

            myFlower.updatePetalValues();
        }
    };

    private View.OnClickListener clearPetals  = new View.OnClickListener() {
        public void onClick (View view) {

            for (int i = 0; i < allPetals.size(); i++) {
                View petal = allPetals.get(i);
                relativeLayout.removeView(petal);
            }


            allPetals.clear();
            initialize();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Button b = (Button) findViewById(R.id.button1);
            b.setText("Text");
            return true;
        }
        else if ( id == R.id.add_pink_menu){
            Button b = (Button) findViewById(R.id.button1);
            b.setText("Circle");
            return true;
        }
        else if(id == R.id.add_oval){
            Button b = (Button) findViewById(R.id.button1);
            b.setText("Oval");
            return true;
        }
        else if(id == R.id.add_rectangle)
        {
            Button b = (Button) findViewById(R.id.button1);
            b.setText("Rectangle");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
