package com.poly.ailatrieuphu.object;

import java.util.ArrayList;
import java.util.Random;

public class FaceData {
    public FaceData(){
        taoQuestion1();
    }
    public Question taoQuestion(int lever){
        Random random = new Random();
        ArrayList<Question> arr = arrQuestion.get(lever-1);
//        int so1 = random.nextInt(100);
//        int so2 = random.nextInt(100);
//        int tong = so1 + so2;
//        String noiDungQuestion = so1+" + "+ so2+ " = ? "+"(+lever+)";
//        Question question = new Question();
//        question.setNoiDung(noiDungQuestion);
//        question.setDapAnDung(""+tong);
//            ArrayList<String> arrDapAnSai = new ArrayList<>();
//        do {
//            int tongFace =  random.nextInt(200);
//            if (tongFace != tong){
//                arrDapAnSai.add(""+ tongFace);
//            }
//        }while (arrDapAnSai.size()!= 3);
//        question.setArrDapAnSai(arrDapAnSai);
        return arr.get(random.nextInt(arr.size()));
    }

    ArrayList<ArrayList<Question>> arrQuestion = new ArrayList<>();
    public void taoQuestion1(){
        ArrayList<Question> arrQuestion1 = new ArrayList<>();
        arrQuestion1.add(taoQuestion("Cristiano Ronaldo bao nhiêu Goden Ball ?","5","6&7&8"));
        arrQuestion1.add(taoQuestion("Read Marid có tổng cộng bao nhiêu Champions league","14","15&16&18"));
        arrQuestion1.add(taoQuestion("Cầu thủ đắt giá nhất thế giới năm 2021","Kylian Mbappe","Erling Haaland&Eden Hazard&Andre Iniesta"));
        arrQuestion1.add(taoQuestion("Đội tuyển nào vô địch Word Cup nhiều nhất?","Brazil","Bồ Đào Nha&Anh&Ý"));
        arrQuestion1.add(taoQuestion("Ai đã giành giải Man of the Match trong trận chung kết World Cup 2014?","Mario Goetze","Sergio Aguero&Bastian Schweinsteiger&Lionel Messi"));
        arrQuestion.add(arrQuestion1);

        //cau so 2

        ArrayList<Question> arrQuestion2 = new ArrayList<>();
        arrQuestion2.add(taoQuestion("Cristiano Ronaldo có bao nhiêu danh hiệu Champions league","5","7&9&3"));
        arrQuestion2.add(taoQuestion("Cristiano Ronaldo có bao nhiêu bàn thắng cấp CLB ","700","721&754&724"));
        arrQuestion2.add(taoQuestion("Cristiano Ronaldo giàu thứ bao nhiêu thế giới ","2","3&4&5"));
        arrQuestion2.add(taoQuestion("Ai là vua phá lưới năm 2021 ở ngoại hạng anh","Harry Kane","N'golo Kanté&Luis Suarez&Lionel Messi"));
        arrQuestion2.add(taoQuestion("Ronaldo thi đấu cho CLB nào trước khi chuyển tới Manchester United?","Juvetus","Real Madrid&Sporting Lisbon&Aletico Madrid"));
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
        arrQuestion.add(arrQuestion2);
    }

    private Question taoQuestion(String s1, String s2, String s3){
        Question c1 = new Question();
        c1.setNoiDung(s1);
        c1.setDapAnDung(s2);
        c1.setArrDapAnSai(s3);
        return c1;
    }
}
