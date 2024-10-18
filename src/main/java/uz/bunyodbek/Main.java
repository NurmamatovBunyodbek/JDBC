package uz.bunyodbek;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        while (true) {
            System.out.println("CRUD");


            int tanlash = scanner.nextInt();

            switch (tanlash) {
                case 1: {
                    System.out.println("Enter id ");
                    int id = scanner.nextInt();

                    System.out.println("Enter name ");
                    String nameuser = scannerString.nextLine();

                    System.out.println("Enter surname");
                    String surname = scannerString.nextLine();

                    System.out.println("Enter phone");
                    String phone = scannerString.nextLine();

                    User user = new User(id, nameuser, surname, phone);

                    MyDatabase myDatabase = new MyDatabase();
                    myDatabase.create(user);

                    System.out.println(" Saqlandi ");
                    break;
                }
                case 2 :{
                    MyDatabase myDatabase = new MyDatabase();
                    myDatabase.read();
                    break;
                }
                case 4 :{
                    System.out.println(" Qaysi Userni o'chirmoqchisiz  id kiriting");
                    int userid=scanner.nextInt();

                    MyDatabase myDatabase = new MyDatabase();
                    myDatabase.delete(userid);
                    break;
                }

            }


        }
    }
}