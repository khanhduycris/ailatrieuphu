package com.poly.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.poly.ailatrieuphu.adapter.TienThuongAdapter;
import com.poly.ailatrieuphu.object.FaceData;
import com.poly.ailatrieuphu.object.Question;

import java.util.ArrayList;
import java.util.Random;

public class PlayGames extends AppCompatActivity {
    ListView lvTienThuong;
    TienThuongAdapter tienThuongAdapter;
    ArrayList<String> arrTienThuong;
    Question question;

    int vitriQuestion = 1;

    View.OnClickListener listener;
    TextView tvQuestion, tvCauTL1, tvCauTL2, tvCauTL3, tvCauTL4, tvYouLose;
    ArrayList<TextView> arrTvCauTraLoi;
    String cauTraLoi;
    FaceData faceData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_games);
        init();
        anhXa();
        setClick();
        setUp();
    }
    public void init(){
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("150.000.000");
        arrTienThuong.add("90.000.000");
        arrTienThuong.add("70.000.000");
        arrTienThuong.add("50.000.000");
        arrTienThuong.add("35.000.000");
        arrTienThuong.add("20.000.000");
        arrTienThuong.add("14.000.000");
        arrTienThuong.add("10.000.000");
        arrTienThuong.add("8.000.000");
        arrTienThuong.add("4.000.000");
        arrTienThuong.add("2.000.000");
        arrTienThuong.add("1.000.000");
        arrTienThuong.add("600.000");
        arrTienThuong.add("400.000");
        arrTienThuong.add("200.000");

        tienThuongAdapter = new TienThuongAdapter(this, 0, arrTienThuong);
        question = new Question();

        faceData = new FaceData();

        arrTvCauTraLoi = new ArrayList<>();
    }
    public void anhXa(){
        tvQuestion = findViewById(R.id.tv_Question);
        tvCauTL1 = findViewById(R.id.tv_CauTL1);
        tvCauTL2 = findViewById(R.id.tv_CauTL2);
        tvCauTL3 = findViewById(R.id.tv_CauTL3);
        tvCauTL4 = findViewById(R.id.tv_CauTL4);
        tvYouLose = findViewById(R.id.tvYouLose);
        lvTienThuong = findViewById(R.id.lvTienThuong);

        arrTvCauTraLoi.add(tvCauTL1);
        arrTvCauTraLoi.add(tvCauTL2);
        arrTvCauTraLoi.add(tvCauTL3);
        arrTvCauTraLoi.add(tvCauTL4);
    }
    public void setUp(){
        tvYouLose.setVisibility(View.GONE);
        lvTienThuong.setAdapter(tienThuongAdapter);

        hienQuestion();
    }
    public void setClick(){
        listener = (view) -> {
            checkQuestion(((TextView) view));
        };
        for (TextView t:arrTvCauTraLoi){
            t.setOnClickListener(listener);
        }
    }

    public void checkQuestion(final TextView tv){
        cauTraLoi = tv.getText().toString();
        tv.setBackgroundResource(R.drawable.bgr_green_btn_cau_chon_30dp);
        //check cau tra loi
        new CountDownTimer(2000, 100) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                for (TextView t : arrTvCauTraLoi){
                    String s = t.getText().toString();
                    if (s.equals(question.getDapAnDung())){
                        t.setBackgroundResource(R.drawable.bgr_btn_cau_dung_30dp);
                        break;
                    }
                }
                new CountDownTimer(2000,100){
                    @Override
                    public void onTick(long l) {
                    }
                    @Override
                    public void onFinish() {
                        if (cauTraLoi.equals(question.getDapAnDung())){
                            vitriQuestion ++;
                            if (vitriQuestion > 15){
                                vitriQuestion = 15;
                                tvYouLose.setVisibility(View.VISIBLE);
                                tvYouLose.setText("Chúc mừng bạn đã được \n" + arrTienThuong.get(0) + "000 vnd");
                                return;
                            }
                            hienQuestion();
                        }else {
                            tvYouLose.setVisibility(View.VISIBLE);
                            int vitriTienThuong = (vitriQuestion/5)* 5;
                            tvYouLose.setText("Bạn sẽ ra về với tiền thưởng là \n" + arrTienThuong.get(14 - vitriTienThuong) + "000 vnd");
                        }
                    }
                }.start();
            }
        }.start();
    }

    public void setQuestion(){
        question = faceData.taoQuestion(vitriQuestion);
    }

    public void hienQuestion(){
        setQuestion();
        tvQuestion.setText(question.getNoiDung());
        ArrayList<String> arrCauTL = new ArrayList<>(question.getArrDapAnSai());
        arrCauTL.add(question.getDapAnDung());


        Random random = new Random();
        for (int i = 0; i < 5; i ++){
            int vitri1 = random.nextInt(arrCauTL.size());
            int vitri2 = random.nextInt(arrCauTL.size());
            String a = arrCauTL.get(vitri1); // random 0 1 2 3
            arrCauTL.set(vitri1, arrCauTL.get(vitri2));
            arrCauTL.set(vitri2,a);
        }

        for (int i=0; i<arrTvCauTraLoi.size(); i++){
            arrTvCauTraLoi.get(i).setOnClickListener(listener);
            arrTvCauTraLoi.get(i).setVisibility(View.VISIBLE);

            arrTvCauTraLoi.get(i).setBackgroundResource(R.drawable.bgr_blue_btn_30dp);
            arrTvCauTraLoi.get(i).setText(arrCauTL.get(i));
        }

        tienThuongAdapter.setViTriQuestion(vitriQuestion);
    }


    boolean troGiup5050 = true;
    public void trogiup5050(View view) {
        if (troGiup5050 == false){
            return;
        }
        Random random = new Random();
        int  sodapAnAnDi = 2;
        do {
            int vitriDapAnAn = random.nextInt(4);
            TextView t = arrTvCauTraLoi.get(vitriDapAnAn);
            if (t.getVisibility() == View.VISIBLE && t.getText().toString().equals(question.getDapAnDung())== false){
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodapAnAnDi --;
            }
        }while (sodapAnAnDi>0);
        troGiup5050 = false;
    }


    boolean troGiupKhanGia = true;
    public void troGiupKhanGia(View view) {
        if (troGiupKhanGia == false){
            return;
        }
        for (int i = 0; i < arrTvCauTraLoi.size(); i++){
            TextView t = arrTvCauTraLoi.get(i);
            if (t.getText().toString().equals(question.getDapAnDung())){
                new DialogKhanGiaTraLoi(this, i+1).show();
                break;
            }
        }
        troGiupKhanGia = false;
    }


    boolean troGiupDoiCauHoi = true;
    public void troGiupDoiCauHoi(View view) {
        if (troGiupDoiCauHoi == false){
            return;
        }
        hienQuestion();
        troGiupDoiCauHoi = false;
    }
}