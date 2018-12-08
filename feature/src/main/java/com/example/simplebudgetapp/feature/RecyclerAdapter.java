package com.example.simplebudgetapp.feature;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lina.Sukauskaite on 11/8/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    List<Biudzetas> biudzetas;

    public RecyclerAdapter(List<Biudzetas> biudzetas){

        this.biudzetas = biudzetas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.db_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Date currentDate = new Date(biudzetas.get(position).getTransakcijosData());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (biudzetas.get(position).getIslaiduTipas().equals("Pajamos")){

            holder.eiluteIslaidos.setText(df.format(currentDate) + " " + biudzetas.get(position).getIslaiduTipas() + ": " + Double.toString(biudzetas.get(position).getPajamuSuma())
                    + " eur");
        } else {
            holder.eiluteIslaidos.setText(df.format(currentDate) + " " + biudzetas.get(position).getIslaiduTipas() + ": -" + Double.toString(biudzetas.get(position).getIslaiduSuma())
                    + " eur");
        }

        if (biudzetas.get(position).getPastaba().equals("")){
            holder.eilutePastabos.setText("        Pastaba: - ");
        } else{
            holder.eilutePastabos.setText("        Pastaba: " + biudzetas.get(position).getPastaba());
        }

    }

    @Override
    public int getItemCount() {
        return biudzetas.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView eiluteIslaidos, eilutePastabos;

        public MyViewHolder(View view) {
            super(view);
            eiluteIslaidos = itemView.findViewById(R.id.eilute_islaidos);
            eilutePastabos = itemView.findViewById(R.id.eilute_pastabos);
        }
    }
    public void deleteItem(int position) {

       try{

           MainActivity.myAppDatabase.myDao().deleteEntry(biudzetas.get(position));
           biudzetas.remove(position);
           notifyItemRemoved(position);

       }catch (Exception e){

       }

    }


}
