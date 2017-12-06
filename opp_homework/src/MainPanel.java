import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JFrame {

    ArrayList<Club> clubs = new ArrayList<Club>();
    ArrayList<Activity> acts = new ArrayList<Activity>();

    private JPanel clubPanel = new JPanel();
    private JPanel actPanle = new JPanel();

    private JButton ManageButton = new JButton("进入管理员界面");
    private JButton ExitButton = new JButton("退出管理员界面");

    private JButton SortCount = new JButton("按照活动开展次数排序");
    private JButton SortScale = new JButton("按照活动活动规模从高到低排序");

    private JLabel clubLabel = new JLabel("社团列表");
    private JLabel actLabel = new JLabel("活动列表");

    private JButton clubButton = new JButton("查找");
    private JButton actButton = new JButton("查找");

    private  JTextField actField = new JTextField(40);
    private  JTextField clubField = new JTextField(40);


    public MainPanel(String title) throws HeadlessException {
        super(title);

        this.setSize(new Dimension(1920,1050));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(0,0);
        this.setLayout(null);
        MainPage m = new MainPage();
//        initClub();
        ActivityPanel activityPanel = new ActivityPanel("活动");
        this.getContentPane().add(BorderLayout.WEST,activityPanel);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        MainPanel m = new MainPanel("主界面");
    }



    public void initClub(){

        clubPanel.setBackground(new Color(240,248,255));
        clubPanel.setSize(950,1035);
        clubPanel.setLayout(null);
        clubPanel.setBounds(400,50,200,150);
        clubPanel.setFont(new Font("SansSerif",Font.BOLD,30));
        //标题
        clubLabel.setBounds(400,50,200,150);
        clubLabel.setFont(new Font("SansSerif",Font.PLAIN,22));
        //输入框
        clubField.setBounds(330,180,200,50);
        clubField.setText("输入社团名称");
        clubField.setFont(new Font("SansSerif",Font.PLAIN,22));
        //查找按钮
        clubButton.setBounds(530,180,100,50);
        clubButton.setFont(new Font("SansSerif",Font.PLAIN,22));

        clubPanel.add(clubLabel);
        clubPanel.add(clubField);
        clubPanel.add(clubButton);

        this.getContentPane().add(clubPanel);

    }
}
