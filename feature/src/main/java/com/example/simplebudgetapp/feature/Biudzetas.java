package com.example.simplebudgetapp.feature;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "duomenys")
public class Biudzetas {


    public long getId() {
        return id;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "data")
    private Long transakcijosData;

    @ColumnInfo(name = "islaiduTipas")
    private String islaiduTipas;

    public double getIslaiduSuma() {
        return islaiduSuma;
    }

    public void setIslaiduSuma(double islaiduSuma) {
        this.islaiduSuma = islaiduSuma;
    }

    public double getPajamuSuma() {
        return pajamuSuma;
    }

    public void setPajamuSuma(double pajamuSuma) {
        this.pajamuSuma = pajamuSuma;
    }

    @ColumnInfo(name = "islaiduSuma")

    private double islaiduSuma;

    @ColumnInfo(name = "pajamuSuma")
    private double pajamuSuma;

    public String getPastaba() {
        return pastaba;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPastaba(String pastaba) {
        this.pastaba = pastaba;
    }

    @ColumnInfo(name = "pastaba")
    private String pastaba;

    public Long getTransakcijosData() {
        return transakcijosData;
    }

    public void setTransakcijosData(Long transakcijosData) {
        this.transakcijosData = transakcijosData;
    }

    public String getIslaiduTipas() {
        return islaiduTipas;
    }

    public void setIslaiduTipas(String islaiduTipas) {
        this.islaiduTipas = islaiduTipas;
    }

}
