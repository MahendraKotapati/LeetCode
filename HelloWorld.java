import java.util.Scanner;
public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Hello world " + name);
        sc.close();
    }
}

/*
 * How to run Java Program
 * > javac HelloWord.java    
 * > java HelloWorld
 */