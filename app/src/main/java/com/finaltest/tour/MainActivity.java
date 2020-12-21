package com.finaltest.tour;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    String country[]={"Canada","Usa","England"};
    ArrayList<Capital> conList=new ArrayList<>();

    ArrayAdapter<Subdetails> adapter;


    Spinner spcn;
    ImageView imgcn;
    TextView tvcap,tvres,tvprice;

    ListView lv;

    public static double reset = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillingData();

        spcn = findViewById(R.id.spcon);
        imgcn = findViewById(R.id.ivflag);
        tvcap = findViewById(R.id.tvcapital);
        tvres = findViewById(R.id.tvvres);
        tvprice = findViewById(R.id.tvprice);

        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,country);
        spcn.setAdapter(aa);

        ArrayAdapter<Subdetails> adapter;
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getdetails()));

        tvcap.setText(String.valueOf(conList.get(0).getConcapital()));

        spcn.setOnItemSelectedListener(this);

    }

    private ArrayList<Subdetails> getdetails() {

        ArrayList<Subdetails> data = new ArrayList<>();
        data.clear();

        data.add(new Subdetails("Niagara Falls", 100,"Canada"));
        data.add(new Subdetails("CN Tower", 30,"Canada"));
        data.add(new Subdetails("The Butchart Gardens", 30,"Canada"));
        data.add(new Subdetails("Notre-Dame Basilica", 50,"Canada"));
        data.add(new Subdetails("The Statue of Liberty", 90,"Usa"));
        data.add(new Subdetails("The White House", 60,"Usa"));
        data.add(new Subdetails("Times Square ", 75,"Usa"));
        data.add(new Subdetails("Big Ben", 30,"England"));
        data.add(new Subdetails("Westminster Abbey", 25,"England"));
        data.add(new Subdetails("Hyde Park", 15,"England"));

        return data;

    }

    private void fillingData() {

        conList.add(new Capital("Canada","Ottawa","canadafg" ,country[0]));
        conList.add(new Capital("USA","Washington","usafg",country[1]));
        conList.add(new Capital("England","London","englandfg",country[2]));

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position >= 0 && position < country.length)
            {
                getSelectedCategoryData(position);

                tvcap.setText(String.valueOf(conList.get(position).getConcapital()));

                int imgid1 = getResources().getIdentifier(conList.get(position).getConimg(),"drawable",getPackageName());
                imgcn.setImageResource(imgid1);
            }
        else
        {
            Toast.makeText(MainActivity.this, "Selected Category Does not Exist!", Toast.LENGTH_SHORT).show();
        }


    }

    private void getSelectedCategoryData(String conname) {

        //arraylist to hold selected  bodies

        ArrayList<Subdetails> cosmicBodies = new ArrayList<>();
        if(conname == 0)
        {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getdetails());

        }else{

            //filter by id
            for (Subdetails subdet : getdetails()) {
                if (subdet.getCon() == conname) {
                    cosmicBodies.add(subdet);
                }
            }
            //instatiate adapter a
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cosmicBodies);
        }
        //set the adapter to GridView
        lv.setAdapter(adapter);

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}