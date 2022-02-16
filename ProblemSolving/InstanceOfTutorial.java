
import java.util.ArrayList;
import java.util.Scanner;


class Programmer {
}

class Rockstar {
}

class Hacker {
}


class InstanceOFTutorial {

    static String count(ArrayList mylist) {
        int a = 0, b = 0, c = 0;
        for (Object element : mylist) {
            if (element instanceof Programmer)
                a++;
            if (element instanceof Rockstar)
                b++;
            if (element instanceof Hacker)
                c++;
        }
        return a + " " + b + " " + c;

    }

    public static void main(String[] args) {
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            if (s.equals("Programmer")) mylist.add(new Programmer());
            if (s.equals("Rockstar")) mylist.add(new Rockstar());
            if (s.equals("Hacker")) mylist.add(new Hacker());
        }
        System.out.println(count(mylist));
    }
}