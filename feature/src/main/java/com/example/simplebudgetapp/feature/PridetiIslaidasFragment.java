package com.example.simplebudgetapp.feature;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PridetiIslaidasFragment extends Fragment {

    private Button pridetiIslaidas;
    EditText Islaidos, islaiduPastaba;
    Spinner islaiduMeniu;


    public PridetiIslaidasFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_prideti_islaidas, container, false);


        pridetiIslaidas = view.findViewById(R.id.pridetiIslaidasButton);
        islaiduPastaba = view.findViewById(R.id.editTextIslaiduPastaba);
        Islaidos = view.findViewById(R.id.islaidosEUR);
        islaiduMeniu = view.findViewById(R.id.spinner);

        List<String> islaiduSarasas = new ArrayList<>();
        islaiduSarasas.add("Maistas");
        islaiduSarasas.add("Mokesčiai");
        islaiduSarasas.add("Pramogos");
        islaiduSarasas.add("Drabužiai");
        islaiduSarasas.add("Kitos");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, islaiduSarasas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        islaiduMeniu.setAdapter(adapter);

        islaiduMeniu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemvalue = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pridetiIslaidas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Biudzetas biudzetas = new Biudzetas();
                Date data = new Date();

                String itemvalue = islaiduMeniu.getSelectedItem().toString();
                Log.d("DB operations", "Pasirinkta " + itemvalue);


                if(itemvalue.equals("Maistas")){

                    try{
                        double islaidos = Double.parseDouble(Islaidos.getText().toString());
                        String iPastaba = islaiduPastaba.getText().toString();

                        if(iPastaba == null){
                            biudzetas.setPastaba("");
                        } else{
                            biudzetas.setPastaba(iPastaba);
                        }

                        biudzetas.setIslaiduTipas("Maistas");
                        biudzetas.setIslaiduSuma(islaidos);
                        biudzetas.setTransakcijosData(data.getTime());
                        MainActivity.myAppDatabase.myDao().addToBiudzetas(biudzetas);
                        Islaidos.setText("");
                        islaiduPastaba.setText(" ");
                        Toast.makeText(getContext(),islaidos + " Eur įtraukti į išlaidas", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){

                        Toast.makeText(getActivity(),"Neįvedėte išlaidų.", Toast.LENGTH_SHORT).show();
                    }

                } else if (itemvalue.equals("Mokesčiai")){

                    try{

                        double islaidos = Double.parseDouble(Islaidos.getText().toString());
                        String iPastaba = islaiduPastaba.getText().toString();

                        if(iPastaba == null){
                            biudzetas.setPastaba("");
                        } else{
                            biudzetas.setPastaba(iPastaba);
                        }

                        biudzetas.setIslaiduTipas("Mokesčiai");
                        biudzetas.setIslaiduSuma(islaidos);
                        biudzetas.setTransakcijosData(data.getTime());
                        MainActivity.myAppDatabase.myDao().addToBiudzetas(biudzetas);
                        Islaidos.setText("");
                        islaiduPastaba.setText(" ");
                        Log.d("DB operacijos", "Islaidos sekmingai pridetos" + islaidos);
                        Toast.makeText(getContext(),islaidos + " Eur įtraukti į išlaidas", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){

                        Toast.makeText(getActivity(),"Neįvedėte išlaidų.", Toast.LENGTH_SHORT).show();
                    }

                } else if (itemvalue.equals("Pramogos")){

                    try{
                        double islaidos = Double.parseDouble(Islaidos.getText().toString());
                        String iPastaba = islaiduPastaba.getText().toString();

                        if(iPastaba == null){
                            biudzetas.setPastaba("");
                        } else{
                            biudzetas.setPastaba(iPastaba);
                        }

                        biudzetas.setIslaiduTipas("Pramogos");
                        biudzetas.setIslaiduSuma(islaidos);
                        biudzetas.setTransakcijosData(data.getTime());
                        MainActivity.myAppDatabase.myDao().addToBiudzetas(biudzetas);
                        Islaidos.setText("");
                        islaiduPastaba.setText(" ");
                        Toast.makeText(getContext(),islaidos + " Eur įtraukti į išlaidas", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){

                        Toast.makeText(getActivity(),"Neįvedėte išlaidų.", Toast.LENGTH_SHORT).show();
                    }
                } else if (itemvalue.equals("Drabužiai")){

                    try{
                        double islaidos = Double.parseDouble(Islaidos.getText().toString());
                        String iPastaba = islaiduPastaba.getText().toString();

                        if(iPastaba == null){
                            biudzetas.setPastaba("");
                        } else{
                            biudzetas.setPastaba(iPastaba);
                        }
                        biudzetas.setIslaiduTipas("Drabužiai");
                        biudzetas.setIslaiduSuma(islaidos);
                        biudzetas.setTransakcijosData(data.getTime());
                        MainActivity.myAppDatabase.myDao().addToBiudzetas(biudzetas);
                        Islaidos.setText("");
                        islaiduPastaba.setText(" ");
                        Toast.makeText(getContext(),islaidos + " Eur įtraukti į išlaidas", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){

                        Toast.makeText(getActivity(),"Neįvedėte išlaidų.", Toast.LENGTH_SHORT).show();
                    }

                } else if (itemvalue.equals("Kitos")){

                    try{
                        double islaidos = Double.parseDouble(Islaidos.getText().toString());
                        String iPastaba = islaiduPastaba.getText().toString();

                        if(iPastaba == null){
                            biudzetas.setPastaba("");
                        } else{
                            biudzetas.setPastaba(iPastaba);
                        }
                        biudzetas.setIslaiduTipas("Kitos");
                        biudzetas.setIslaiduSuma(islaidos);
                        biudzetas.setTransakcijosData(data.getTime());
                        MainActivity.myAppDatabase.myDao().addToBiudzetas(biudzetas);
                        Islaidos.setText(" ");
                        islaiduPastaba.setText("");
                        Toast.makeText(getContext(),islaidos + " Eur įtraukti į išlaidas", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){

                        Toast.makeText(getActivity(),"Neįvedėte išlaidų.", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
