package com.example.simplebudgetapp.feature;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class PridetiPajamasFragment extends Fragment {

    private Button pridetiPajamas;
    EditText Pajamos, pajamosNote;



    public PridetiPajamasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_prideti_pajamas, container, false);
        pridetiPajamas = view.findViewById(R.id.pridetiPajamasButton);
        pajamosNote = view.findViewById(R.id.editTextPastaba);
        Pajamos = view.findViewById(R.id.pajamosEUR);


        pridetiPajamas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double pajamos = Double.parseDouble(Pajamos.getText().toString());
                    String pPastaba = pajamosNote.getText().toString();

                    Date data = new Date();

                    Biudzetas biudzetas = new Biudzetas();
                    biudzetas.setIslaiduTipas("Pajamos");
                    biudzetas.setPajamuSuma(pajamos);
                    biudzetas.setPastaba(pPastaba);
                    biudzetas.setTransakcijosData(data.getTime());


                    MainActivity.myAppDatabase.myDao().addToBiudzetas(biudzetas);
                    Toast.makeText(getActivity(),"Pajamos sėkmingai įtrauktos į biudžetą.", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(getActivity(),"Neįvedėte pajamų.", Toast.LENGTH_SHORT).show();
                }

                Pajamos.setText("");
                pajamosNote.setText("");

            }
        });



        return view;
    }

}
