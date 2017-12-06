import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ClubPanel extends JFrame {

    private JTextArea clubDetails = new JTextArea();
    private ArrayList<Club> clubs = new ArrayList<Club>();
    private int type;

    public ClubPanel(String title) throws HeadlessException {
        super(title);

        this.setSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(500,0);
        this.setVisible(true);
        this.setLayout(null);

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
        initClub();
    }

    public void initClub(){
//        clubDetails.setLineWrap(true);
//
        for (Club c: clubs
             ) {
            clubDetails.append("社团名称："+c.getName()+"\n");
            clubDetails.append("成立时间："+c.getTime()+"\n");
            clubDetails.append("负责人名字："+c.getManager_name()+"\n");
            clubDetails.append("联系方式"+"\n");
            clubDetails.append("        ："+"电话 "+c.getManager_tel()+"\n");
            clubDetails.append("        ："+"邮箱 "+c.getManager_mail()+"\n");
            clubDetails.append("举办的活动："+c.getActs()+"\n");
        }

        //如果是管理员  显示增加



        clubDetails.setFont(new Font("SansSerif",Font.PLAIN,27));
        clubDetails.setBounds(100,30,800,500);
        clubDetails.setBackground(new Color(240,248,255));
        clubDetails.setEditable(false);
        this.add(clubDetails);

    }

//    public static void main(String[] args) {
//        ClubPanel c = new ClubPanel("社团");
//    }
}
