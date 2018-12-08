package com.example.simplebudgetapp.feature;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button addPajamos, addIslaidos, addAtaskaita;
    private TextView pajamuSuma;
    PieChart pieChart;

    public HomeFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addPajamos = view.findViewById(R.id.pajamuButton);
        addPajamos.setOnClickListener(this);

        addIslaidos = view.findViewById(R.id.islaiduButton);
        addIslaidos.setOnClickListener(this);

        addAtaskaita = view.findViewById(R.id.Ataskaitosbutton);
        addAtaskaita.setOnClickListener(this);

        pajamuSuma = view.findViewById(R.id.textViewPajamuSuma);


        List<Biudzetas> biudzetas = MainActivity.myAppDatabase.myDao().getDuomenys();

        double bendrosPajamos = 0;
        double bendrosIslaidos = 0;
        double bendrasMaistas = 0;
        double bendrasMokesciai = 0;
        double bendrasPramogos = 0;
        double bendrasDrabuziai = 0;
        double bendrasKita = 0;

        for(Biudzetas b: biudzetas){
            if(b.getIslaiduTipas().equals("Maistas")){
                bendrasMaistas = bendrasMaistas + b.getIslaiduSuma();
            }
            else if (b.getIslaiduTipas().equals("Mokesčiai")){
                bendrasMokesciai = bendrasMokesciai + b.getIslaiduSuma();
            }
            else if (b.getIslaiduTipas().equals("Drabužiai")){
                bendrasDrabuziai = bendrasDrabuziai + b.getIslaiduSuma();
            }
            else if (b.getIslaiduTipas().equals("Pramogos")){
                bendrasPramogos = bendrasPramogos + b.getIslaiduSuma();
            }
            else if (b.getIslaiduTipas().equals("Kitos")){
                bendrasKita = bendrasKita + b.getIslaiduSuma();
            }
            else if (b.getIslaiduTipas().equals("Pajamos")){
                bendrosPajamos = bendrosPajamos + b.getPajamuSuma();
            }
        }

        bendrosIslaidos =  bendrasMaistas + bendrasMokesciai + bendrasPramogos + bendrasDrabuziai
                            + bendrasKita;

        double bendrasBalansas =  bendrosPajamos - bendrosIslaidos;

        pajamuSuma.setText("Pajamos: € " + Double.toString(bendrosPajamos) + "   " + "Išlaidos: € -" + Double.toString(bendrosIslaidos) +
                "   " + "Balansas € " + Double.toString(bendrasBalansas));

        //Skrituline diagrama

        int pM = (int)bendrasMaistas;
        int pMo = (int)bendrasMokesciai;
        int pP = (int)bendrasPramogos;
        int pD = (int)bendrasDrabuziai;
        int pK = (int)bendrasKita;

        pieChart = (PieChart) view.findViewById(R.id.pieChart2);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setDrawCenterText(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(pM,"Maistas"));
        yValues.add(new PieEntry(pMo, "Mokesčiai"));
        yValues.add(new PieEntry(pP, "Pramogos"));
        yValues.add(new PieEntry(pD, "Drabužiai"));
        yValues.add(new PieEntry(pK, "Kita"));

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.CYAN);

        pieChart.setData(data);


        return view;
    }

    @Override
    public void onClick(View view) {

        int i = view.getId();
        if (i == R.id.pajamuButton) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new PridetiPajamasFragment()).addToBackStack(null).commit();
        } else if (i == R.id.islaiduButton) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new PridetiIslaidasFragment()).addToBackStack(null).commit();
        } else if (i == R.id.Ataskaitosbutton) {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AtaskaitaFragment()).addToBackStack(null).commit();
        }
    }

}
