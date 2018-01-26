package com.example.antoine.projet_contact;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class test extends AppCompatActivity {
    String nom ;
    LatLng pos;
    String address;
    String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        LaTacheAsync TACHE=new LaTacheAsync();
        TACHE.execute();

        TextView t_nom = (TextView) findViewById(R.id.name);
        TextView t_forname = (TextView) findViewById(R.id.forname);
        TextView t_address = (TextView) findViewById(R.id.adresse);
        TextView t_num = (TextView) findViewById(R.id.telNum);

        int j=0;
        int i =1;

        Intent myIntent = getIntent();
        String newString= myIntent.getStringExtra("name");



        nom = Data.fnameArray[i];
        pos = Data.pos[i];
        address = Data.address[i];
        num = Data.contactArray[i];
        t_nom.setText(nom);
        t_forname.setText(newString);
        t_address.setText(address);
        t_num.setText(num);

        for (i=0;i<Data.nameArray.length;i++)
        {
            if (newString.equals(Data.nameArray[i]))
            {
                j = i;
            }
        }

        nom = Data.fnameArray[j];
        pos = Data.pos[j];
        address = Data.address[j];
        num = Data.contactArray[j];
        t_nom.setText(nom);
        t_forname.setText(newString);
        t_address.setText(address);
        t_num.setText(num);

        Button map = (Button) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(test.this, Maps2.class);
                String keyIdentifer  = nom;
                i.putExtra("name", keyIdentifer );
                startActivity(i);
            }
        });
    }

    private class LaTacheAsync extends AsyncTask<Void, Integer, Void>
    {
        TextView syncinfo = (TextView) findViewById(R.id.async);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //traitement debut
            syncinfo.setText("pret a être exécuté");
        }

        @Override
        protected void onPostExecute(Void result) {
            //traitement fin

            syncinfo.setText("fermeture asynctask");
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            syncinfo.setText("En cours d'exécution");
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(0);
            for (int i = 0 ; i < 26 ; i++) {
                progressBar.setProgress(i*4);
                try {
                    Thread.currentThread();
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

}
