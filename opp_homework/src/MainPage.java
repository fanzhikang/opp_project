import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

public class MainPage extends JFrame{

//        JFrame frame ;
//        JLabel cLabel;

        ArrayList<Club> clubs = new ArrayList<Club>();
        ArrayList<Activity> acts = new ArrayList<Activity>();

        public MainPage(){
            loadAct();
            loadClub();


        }

        public void sortAct(){
            Activity a = new Activity();
            Collections.sort(acts,a);
            for (int i = 0; i <acts.size() ; i++) {
                System.out.println(i+1+"."+acts.get(i).getName());
            }
        }

        public String showClubs(){
            String s ="";
            for (int i = 0; i < clubs.size(); i++) {
                System.out.println(i+1+"."+ clubs.get(i).getName());
            }
            return s;
        }
        public void showActs(){
            for (int i = 0; i <acts.size() ; i++) {
                System.out.println(i+1+"."+acts.get(i).getName());
            }
        }
        //通过社团名查找社团
        public void findClubByName(String name){
            boolean isFind=false;
            for (Club c:clubs
                    ) {
                if(c.getName().equals(name)) {
                    isFind=true;
                    System.out.println(c.toString());
                }
            }
            if(!isFind){
                System.out.println("Sorry, Not Found");
            }
        }
        //通过活动名查找活动
        public void findActByName(String name){
            boolean isFind=false;
            for (Activity a:acts
                    ) {
                if(a.getName().equals(name)) {
                    isFind=true;
                    System.out.println(a.toString());
                }
            }
            if(!isFind){
                System.out.println("Sorry, Not Found");
            }
        }
//通过时间筛选活动
        public void selectByTime(String time,int n) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            Date t = sdf.parse(time);
            ArrayList<Activity> newA = new ArrayList<Activity>();
            for (Activity a : acts
                 ) {
                Date d = sdf.parse(a.getTime());
                if(n==1) {
                    if (t.getTime()<d.getTime()) {
                        newA.add(a);
                    }
                }
                if(n==-1) {
                    if (t.getTime()>d.getTime()) {
                        newA.add(a);
                    }
                }
            }
            for (Activity b : newA
                 ) {
                System.out.println(b.getName());
            }
        }
//通过社团筛选活动
        public void selectByClub(String club){
            ArrayList<Activity> newA = new ArrayList<Activity>();
            for (Activity a: acts
                 ) {
                String[] strs= a.getHolder().split("、");
                for (String s : strs
                     ) {
                    if(Objects.equals(s, club)) newA.add(a);
                }
            }
            for (Activity b: newA
                 ) {
                System.out.println(b.getName());
            }
        }

        public void loadClub(){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/社团表.csv"),"GBK"));
                reader.readLine();
                reader.readLine();
                String line = null;
                while ((line=reader.readLine())!=null){
                    String item[] = line.split(",");
                    Club c = new Club(item[0],item[1],item[2],item[3],item[4],item[5]);

                    clubs.add(c);
                }
//                BufferedReader readerP = new BufferedReader(new InputStreamReader(new FileInputStream("src/picture.csv"),"GBK"));
//                String p = null;
//                while ((line=readerP.readLine())!=null){
//                    String pic[] = line.split(",");
//                    Picture[] ps =null;
//                    Club c = new Club();
//                    for (int i = 0; i < pic.length; i++) {
//                        ps[i] = new Picture(pic[i]);
//                    }
//                    c.setPictures(ps);
//                    clubs.add(c);
//                }
            }
             catch (FileNotFoundException e) {
                e.printStackTrace();
            }
             catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void loadAct(){
            try {
                BufferedReader readerAct = new BufferedReader(new InputStreamReader(new FileInputStream("src/活动表.csv"),"GBK"));
                readerAct.readLine();
                readerAct.readLine();
                String lineAct = null;
                while ((lineAct=readerAct.readLine())!=null){
                    String itemAct[] = lineAct.split(",");
                    if(itemAct.length==1)break;
                    Activity a = new Activity(itemAct[0],itemAct[1],itemAct[2],itemAct[3],itemAct[4]);
                    //if(itemAct[5].equals(null)) a.setNote(itemAct[5]);
                    acts.add(a);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
