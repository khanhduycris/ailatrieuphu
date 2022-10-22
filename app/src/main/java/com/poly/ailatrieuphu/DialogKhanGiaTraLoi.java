package com.poly.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Random;

public class DialogKhanGiaTraLoi extends Dialog {
    public DialogKhanGiaTraLoi(@NonNull Context context, int vtD) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tro_giup_khan_gia);
        TextView tvChonA, tvChonB, tvChonC, tvChonD;
        tvChonA = findViewById(R.id.tvChonA);
        tvChonB = findViewById(R.id.tvChonB);
        tvChonC = findViewById(R.id.tvChonC);
        tvChonD = findViewById(R.id.tvChonD);


        int arrdrom[] = new int[]{0,0,0,0};
        int can = 25;
        for (int i=0; i<arrdrom.length; i++){
            arrdrom[i] += can;// 25 50 75 0
            if (i == vtD-1){
                arrdrom[i] = arrdrom[i] +25;//25 50 100
                can += 25;//100
            }
            can += 25;// can 125
        }

        int tong = 125;
        int arrPhanTramTl[] =  new int[]{0,0,0,0};
        int soKhanGia = 200;
        Random random =  new Random();
        for (int i = 0; i<soKhanGia; i++){
            int chon = random.nextInt(tong);
            if (chon >= 0 && chon<arrdrom[0] ){
                arrPhanTramTl[0]++;
            }else if (chon>= arrdrom[0] && chon<arrdrom[1]){
                arrPhanTramTl[1]++;
            }else if (chon>= arrdrom[1] && chon<arrdrom[2]){
                arrPhanTramTl[2]++;
            }else {
                arrPhanTramTl[3]++;
            }
        }
        tvChonA.setText("A: "+(int) (arrPhanTramTl[0]*100.0f/soKhanGia)+ " %");
        tvChonB.setText("A: "+(int) (arrPhanTramTl[1]*100.0f/soKhanGia)+ " %");
        tvChonC.setText("A: "+(int) (arrPhanTramTl[2]*100.0f/soKhanGia)+ " %");
        tvChonD.setText("A: "+(int) (arrPhanTramTl[3]*100.0f/soKhanGia)+ " %");
    }
}
