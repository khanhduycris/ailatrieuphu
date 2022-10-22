package com.poly.ailatrieuphu.object;

import java.util.ArrayList;

public class Question {
    private String noiDung, dapAnDung;
    private ArrayList<String> arrDapAnSai;

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public ArrayList<String> getArrDapAnSai() {
        return arrDapAnSai;
    }

    public void setArrDapAnSai(ArrayList<String> arrDapAnSai) {
        this.arrDapAnSai = arrDapAnSai;
    }

    public void setArrDapAnSai(String dapAnSai) {  // dap an 1 va dap an 2, dap an 3
        String arrS[] = dapAnSai.split("&");
        this.arrDapAnSai = new ArrayList<>();
        for (String s : arrS){
            arrDapAnSai.add(s);
        }
    }

}
