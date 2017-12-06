import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {
    ArrayList<Club> clubs = new ArrayList<Club>();
    ArrayList<Activity> acts = new ArrayList<Activity>();

    public Manager(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/社团表.csv"),"GBK"));
            reader.readLine();
            reader.readLine();
            String line = null;
            while ((line=reader.readLine())!=null){
                String item[] = line.split(",");
                Club c = new Club(item[0],item[1],item[2],item[3],item[4],item[5]);
                c.setActs(item[6]);
                clubs.add(c);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader readerAct = new BufferedReader(new InputStreamReader(new FileInputStream("src/活动表.csv"),"GBK"));
            readerAct.readLine();
            readerAct.readLine();
            String lineAct = null;
            while ((lineAct=readerAct.readLine())!=null){
                String itemAct[] = lineAct.split(",");
                if(itemAct.length==1)break;
                Activity a = new Activity(itemAct[0],itemAct[1],itemAct[2],itemAct[3],itemAct[4]);
                acts.add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMembers(){
        for (int i = 0; i < clubs.size(); i++) {
            System.out.println(clubs.get(i).getName()+"全体成员: "+ clubs.get(i).getMembers());
        }
    }

    public void sortByActNum(){
        Club a = new Club();
        Collections.sort(clubs,a);
        for (int i = 0; i <clubs.size() ; i++) {
            System.out.println(i+1+"."+clubs.get(i).getName());
        }
    }

    public void showDetails(){
        int i =1;
        for (Activity a : acts
             ) {
            System.out.println(i +". "+a.toString());
            i++;
        }
    }
    public void addInf(int i){
        System.out.println(acts.get(i).getNote());
    }

    public String writeInf(String start, String inf) throws IOException {
        String filename = "src/活动表.csv";
        StringBuffer buf = new StringBuffer();
        try {
            BufferedReader readerAct = new BufferedReader(new InputStreamReader(new FileInputStream("src/活动表.csv"),"GBK"));
            String lineAct = null;
            while ((lineAct=readerAct.readLine())!=null ){
                if(lineAct.startsWith(start)){
                    buf.append(lineAct+","+inf).append("\n");
                }
                else {
                    buf.append(lineAct).append("\n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();

    }
    public void write(String filePath , String content) throws IOException {
        BufferedWriter bw = null;
        try {
            //File  f = new File(filePath);
            bw = new BufferedWriter(new FileWriter(filePath));

            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bw.flush();
        bw.close();
    }
}
