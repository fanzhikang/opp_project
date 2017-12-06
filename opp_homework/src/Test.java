import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Test {
//    public static void main(String[] args) throws IOException {
//        String filename = "src/活动表.csv";
//        Manager m =new Manager();
//        System.out.println("input:");
//        Scanner in = new Scanner(System.in);
//        String s1 = in.next();
//        String s2 = in.next();
//        //System.out.println(m.writeInf(s1,s2));
//        m.write(filename,m.writeInf(s1,s2));
//    }


    public static void main(String[] args) throws ParseException, IOException {

        FlowPictue f = new FlowPictue();
        String filename = "src/活动表.csv";
        MainPage t = new MainPage();
        Manager m = new Manager();
        welcome();
        Scanner scanner0 = new Scanner(System.in);
        while (scanner0.hasNext()) {
            switch (scanner0.nextInt()) {
                case 1:
                    userWelcome();
                    Scanner scanner1 = new Scanner(System.in);
                    boolean back = false;
                    while (scanner1.hasNext() && (back == false)) {
                        switch (scanner1.nextInt()) {
                            case 1:
                                t.showClubs();
                                break;
                            case 2:
                                t.showActs();
                                break;
                            case 3:
                                System.out.println("请输入社团名: ");
                                Scanner scanner2 = new Scanner(System.in);
                                while (scanner2.hasNext()) {
                                    String name = scanner2.nextLine();
                                    t.findClubByName(name);
                                    if (scanner2.nextInt() == 0) {
                                        userWelcome();
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("请输入活动名: ");
                                scanner2 = new Scanner(System.in);
                                while (scanner2.hasNext()) {
                                    String act = scanner2.nextLine();
                                    t.findActByName(act);
                                    if (scanner2.nextInt() == 0) {
                                        userWelcome();
                                        break;
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("输入时间(yyyy.mm.dd)并输入-1(指定时间之前)或1(指定时间以后)：");
                                scanner2 = new Scanner(System.in);
                                String str = scanner2.nextLine();
                                int i = scanner2.nextInt();
                                t.selectByTime(str, i);
                                if (scanner2.nextInt() == 0) {
                                    userWelcome();
                                    break;
                                }
                                break;
                            case 6:
                                System.out.println("请输入所要找的活动的相关社团名:");
                                scanner2 = new Scanner(System.in);
                                String name = scanner2.nextLine();
                                t.selectByClub(name);
                                if (scanner2.nextInt() == 0) {
                                    userWelcome();
                                    break;
                                }
                                break;
                            case 0:
                                welcome();
                                back = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("请输入密码：");
                    Scanner pass = new Scanner(System.in);
                    String password = "123456";
                    boolean isBack = false;
                    while (pass.hasNext()&&isBack==false) {
                        if (pass.next().equals(password)) {
                            managerWelcome();
                            scanner1 = new Scanner(System.in);
                            while (scanner1.hasNext() && isBack == false) {
                                switch (scanner1.nextInt()) {
                                    case 1:
                                        m.showMembers();
                                        break;
                                    case 2:
                                        m.sortByActNum();
                                        break;
                                    case 3:
                                        m.showDetails();
                                        System.out.println("如需补充信息,请按照活动名补充");
                                        break;
                                    case 4:
                                        System.out.println("输入要补充的活动及信息");
                                        Scanner scanner3 = new Scanner(System.in);
                                        String s1 = scanner3.next();
                                        String s2 = scanner3.next();
                                        m.write(filename, m.writeInf(s1, s2));
                                        System.out.println("添加成功");
//                                        while (scanner3.hasNext()){
//
////                                            MainPage p = new MainPage();
////                                            p.showActs();
//                                            if(scanner3.nextInt()==0){
//                                                managerWelcome();
//                                                break;
//                                            }
//                                        }
                                        break;
                                    case 5:
                                        t.sortAct();
                                        break;
                                    case 0:
                                        welcome();
                                        isBack = true;
                                }

                            }

                        }
                        if (!(pass.next().equals(password))) {
                            System.out.println("密码错误");
                        }
                        break;
                    }
            }

        }
    }
    public static void welcome(){
        System.out.println("欢迎来到社团招新大战！");
        System.out.println("用户登录请输：1  管理员登录请输：2  返回请输：0 ");
    }
    public static void userWelcome(){
        System.out.println("您进入用户界面!");
        System.out.println("显示所有社团请输：1  显示所有活动请输：2  按照社团名查找社团请输：3  按照活动名查找活动请输：4  按时间进行筛选活动请输：5  按照相关社团进行筛选请输：6  返回上一级请输：0");
    }
    public static void managerWelcome(){
        System.out.println("您进入管理员界面!");
        System.out.println("查看每个社团所有成员请输：1  按照活动次数排序请输：2  对所有的活动进行信息汇总请输：3  添加补充信息请输：4  按照规模排序请输：5  返回请输：0");

    }
}
