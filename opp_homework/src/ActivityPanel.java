import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ActivityPanel extends JFrame implements ActionListener {
    private JTextArea ActDetails = new JTextArea();
    private JTextArea manageField = new JTextArea();
    private JButton manageInpute = new JButton("确定");

    ArrayList<Activity> acts = new ArrayList<Activity>();

    public ActivityPanel(String title) throws HeadlessException {
        super(title);
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

        this.setSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(500,0);
        this.setVisible(true);
        this.setLayout(null);
        initAct();

    }

    public void initAct(){
        ActDetails.setLineWrap(true);
        ActDetails.setWrapStyleWord(true);
        for (Activity a : acts
                ) {
            ActDetails.append("活动名称: "+ a.getName()+"\n");
            ActDetails.append("举办时间: "+a.getTime()+"\n");
            ActDetails.append("举办地点:"+a.getPlace()+"\n");
            ActDetails.append("主办社团:"+a.getHolder()+"\n");
        }
        ActDetails.setFont(new Font("SansSerif",Font.PLAIN,27));
        ActDetails.setBounds(100,30,800,500);
        ActDetails.setBackground(new Color(240,248,255));
        ActDetails.setEditable(false);
        this.add(ActDetails);
    }

    public void initManageInpute(){
        manageField.setBounds(100,560,800,300);
        manageField.setText("请输入活动补充信息");
        manageField.setFont(new Font("SansSerif",Font.PLAIN,30));
        this.add(manageField);

        //当进入管理员界面setvisible

    }

    public void initButton(){
        manageInpute.setBounds(450,880,100,50);
        manageInpute.setFont(new Font("SansSerif",Font.PLAIN,30));
        manageInpute.addActionListener(this);
        this.add(manageInpute);
        //改变visiabel

    }

//    public static void main(String[] args) {
//        ActivityPanel a = new ActivityPanel("活动");
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
