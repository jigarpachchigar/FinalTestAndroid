package com.finaltest.tour;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    String country[]={"Canada","Usa","England"};
    ArrayList<Spot> conList=new ArrayList<>();

    ArrayList<Country> capList=new ArrayList<Country>();

    public static ArrayList<Spot>spotmpList = new ArrayList<>();

    Spinner spcn;
    ImageView imgcn;
    TextView tvcap,tvres,tvprice,tvexit;
    SeekBar sb;

    ListView lv;

    public static double reset = 0;
    public static double fare = 0;
    public static double total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filligcapital();
        fillingData();

        spcn = findViewById(R.id.spcon);
        imgcn = findViewById(R.id.ivspot);
        tvcap = findViewById(R.id.tvcapital);
        tvres = findViewById(R.id.tvvno);
        tvprice = findViewById(R.id.tvtotfare);
        tvexit = findViewById(R.id.txtexit);
        sb = findViewById(R.id.sbvisno);
        lv = findViewById(R.id.lvspot);


        lv.setAdapter(new ConSpotAdp(this,spotmpList));
        lv.setOnItemClickListener(this);

        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,country);
        spcn.setAdapter(aa);


        tvexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        tvcap.setText(String.valueOf(conList.get(0).getCon()));

        spcn.setOnItemSelectedListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvres.setText("1");
                sb.setProgress(1);
                fare = spotmpList.get(i).getSpotfare();
                total = fare;
                tvprice.setText(String.valueOf(total));
            }
        });


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(progress>15){
                    tvres.setText(String.valueOf(progress));
                    total = fare * progress * 0.95;
                    tvprice.setText(String.valueOf(total));
                } else {
                    tvres.setText(String.valueOf(progress));
                    total = fare * progress;
                    tvprice.setText(String.valueOf(total));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    private void filligcapital() {

        capList.add(new Country("Canada","Ottawa","canadafg"));
        capList.add(new Country("Usa","Washington","usafg"));
        capList.add(new Country("England","London","englandfg"));



    }


    private void fillingData() {

        conList.add(new Spot("Niagara Falls", 100,"niagara",country[0]));
        conList.add(new Spot("CN Tower", 30,"cntower",country[0]));
        conList.add(new Spot("The Butchart Gardens", 30,"butchart",country[0]));
        conList.add(new Spot("Notre-Dame Basilica", 50,"notre",country[0]));
        conList.add(new Spot("The Statue of Liberty", 90,"liberty",country[1]));
        conList.add(new Spot("The White House", 60,"whitehouse",country[1]));
        conList.add(new Spot("Times Square ", 75,"timessq",country[1]));
        conList.add(new Spot("Big Ben", 30,"bigben",country[2]));
        conList.add(new Spot("Westminster Abbey", 25,"westmminster",country[2]));
        conList.add(new Spot("Hyde Park", 15,"hydepark",country[2]));


       // tvprice.setText(String.valueOf(conList.get(0).getSpotfare()));
        total = conList.get(0).getSpotfare();
        fare = conList.get(0).getSpotfare();
//        tvprice.setText(String.valueOf(conList.get(0).getSpotfare()));
    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position >= 0 && position < country.length)
            {
                spotmpList.clear();
                fillTempList(country[position]);

                lv.setAdapter(new ConSpotAdp(this,spotmpList));
                tvcap.setText(capList.get(position).getConcap());

                int imgid1 = getResources().getIdentifier(capList.get(position).getConimg(),"drawable",getPackageName());
                imgcn.setImageResource(imgid1);

                tvres.setText("1");
                sb.setProgress(1);
                tvprice.setText(String.valueOf(spotmpList.get(0).getSpotfare()));
                total = spotmpList.get(0).getSpotfare();
                fare = spotmpList.get(0).getSpotfare();
            }
        else
        {
            Toast.makeText(MainActivity.this, "Selected Category Does not Exist!", Toast.LENGTH_SHORT).show();
        }


    }




    public void fillTempList(String country){
        for(int i=0;i<conList.size();i++)
            if(country.equals(conList.get(i).getCon()))
                spotmpList.add(conList.get(i));
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}