import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlowPictue extends JFrame {

    private MyPanel mp ;
    private int index;
//    ArrayList<ImageIcon> igs = new ArrayList<ImageIcon>();
    ImageIcon[] imgs={
        new ImageIcon("src/pic/pic1.png"),
        new ImageIcon("src/pic/pic2.png"),
        new ImageIcon("src/pic/pic3.png"),
        new ImageIcon("src/pic/pic4.png"),
        new ImageIcon("src/pic/pic5.png"),
        new ImageIcon("src/pic/pic6.png"),
        new ImageIcon("src/pic/pic7.png"),
        new ImageIcon("src/pic/pic8.png"),
        new ImageIcon("src/pic/pic9.png"),
        new ImageIcon("src/pic/pic10.png"),
        new ImageIcon("src/pic/pic11.png"),
        new ImageIcon("src/pic/pic12.png"),
    };


//    public void image(){
//        r = new Random();
//
//        MainPage m = new MainPage();
//        int n1,n2=0;
//        for (Club c : clubs
//             ) {
//            do{
//                n1=r.nextInt(3);
//                n2=r.nextInt(3);
//            }while (n1!=n2);
//            igs.add(new ImageIcon(c.getPictures()[n1].getLocation()));
//            igs.add(new ImageIcon(c.getPictures()[n2].getLocation()));
//        }
//    }

    public FlowPictue(){

        mp = new MyPanel();
//        image();
        this.add(mp);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        this.setTitle("FlowPicture");

        this.setVisible(true);
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp.repaint();
            }
        });
        timer.start();
    }

    class MyPanel extends JPanel{
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(imgs[(index%imgs.length)].getImage(),0,0,this);
            index++;
        }
    }
}
