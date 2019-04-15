/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking_edit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhd
 */
public class Visitor extends Customer {

    int entering_hour;
    int leaving_hour;
    int total_cost;

    Visitor() {
        entering_hour = 0;

        leaving_hour = 0;
    }

    protected void payment() {
        this.total_cost = (leaving_hour - entering_hour) * 500;
        System.out.print(total_cost);
    }

    @Override
    void addCustomer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("*****************************************************");
        System.out.println("***************** Welcome Visitor ^_^ ***************");
        System.out.println("*****************************************************");

        System.out.println("\n");
        System.out.println("------------------------------");

        System.out.println("Please Enter Your Id:");
        Scanner id = new Scanner(System.in);
        super.id = id.nextInt();
        System.out.println("------------------------------");
        System.out.println("Please Enter Your Name:");
        Scanner s = new Scanner(System.in);
        super.name = s.next();
        System.out.println("\n");
        System.out.println("------------------------------");
        System.out.println("Please Enter Your Car Number:");
        Scanner n = new Scanner(System.in);
        super.number = n.next();
        System.out.println("\n");

        System.out.println("------------------------------");
        System.out.println("Enter Your Visit Beginning Hour");

        this.entering_hour = scanner.nextInt();
        System.out.println("\n");

        System.out.println("Thank you ^_^");
    }

    @Override
    void showInfo() {

        //InputStream visit = null;
        FileInputStream fis;
        InputStreamReader isr;
        BufferedReader br;
        File f;

        try {

            f = new File("visitor.txt");
            // يشير إلى الملف الذي ستقرأ البيانات منه FileInputStream هنا قمنا بإنشاء كائن نوعه
            fis = new FileInputStream(f);

            // BufferedReader من أجل كائن الـ buffer لوضعه في الـ InputStreamReader هنا قمنا بإنشاء كائن نوعه
            isr = new InputStreamReader(fis);

            // للقراءة من الملف BufferedReader هنا قمنا بإنشاء كائن نوعه
            br = new BufferedReader(isr);
            System.out.println("------------------------------");
            System.out.println("Please Enter Your Id:");
            Scanner sc = new Scanner(System.in);

            String id = sc.nextLine();
            String line;
            boolean check = false;
            String entering = null;

            while ((line = br.readLine()) != null) {

                String num = line.substring(0, line.indexOf(" "));

                if (num.equalsIgnoreCase(id)) {
                    System.out.println("*****************************************************");
                    System.out.print("The Visitor Information : ");
                    System.out.println(line);
                    check = true;
                    entering = line.substring(line.lastIndexOf(" ") + 1, line.length());
                    break;
                    //System.out.println("the en :" + entering);
                }

            }
            if (check) {
                System.out.println("------------------------------");
                System.out.println("Enter Your Visit Ending Hour : ");
                this.leaving_hour = sc.nextInt();
                int a = Integer.parseInt(entering);
                int cost = (this.leaving_hour - a) * 500;
                System.out.println("(The Cost : " + cost + ")");

            } else {
                System.out.println("Id Not Found *_*");
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

   
    @Override
    public String toSString() {

        return id + " " + "Name:" + name + " " + "The Car Number:" + number + " " + entering_hour;

    }

}
