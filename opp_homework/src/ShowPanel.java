import javax.swing.*;
import java.awt.*;

public class ShowPanel extends JFrame {


    public ShowPanel(String title) throws HeadlessException {
        super(title);
        this.setSize(new Dimension(1920,1050));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(0,0);
        this.setLayout(null);
    }
}
