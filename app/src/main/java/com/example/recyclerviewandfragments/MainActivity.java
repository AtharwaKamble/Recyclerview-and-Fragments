package com.example.recyclerviewandfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked
{

    TextView tvName, tvTel, tvModel;
    ImageView ivMake;
    Button btnCarinfo, btnOwnerinfo;
    FragmentManager fragmentManager;
    Fragment buttonFrag, listFrag, carInfoFrag, ownerInfoFrag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        tvModel = findViewById(R.id.tvModel);
        ivMake = findViewById(R.id.ivMake);
        btnCarinfo = findViewById(R.id.btnCarinfo);
        btnOwnerinfo = findViewById(R.id.btnOwnerinfo);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carInfoFrag)
                .hide(ownerInfoFrag)
                .commit();

        btnCarinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(ownerInfoFrag)
                        .commit();

            }
        });

        btnOwnerinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(ownerInfoFrag)
                        .commit();

            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {

        tvName.setText(ApplicationClass.cars.get(index).getOwnerName());
        tvModel.setText(ApplicationClass.cars.get(index).getModel());
        tvTel.setText(ApplicationClass.cars.get(index).getOwnerTel());

        if (ApplicationClass.cars.get(index).getMake().equals("Volkswagen"))
        {
            ivMake.setImageResource(R.drawable.volkswagen);
        }
        else if (ApplicationClass.cars.get(index).getMake().equals("Nissan"))
        {
            ivMake.setImageResource(R.drawable.nissan);
        }
        else
        {
            ivMake.setImageResource(R.drawable.mercedes);
        }

    }
}