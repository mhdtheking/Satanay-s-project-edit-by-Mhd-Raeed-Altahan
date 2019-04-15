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

/**
 *
 * @author mhd
 */
public class Tenant extends Customer {

    int rent;
    int park;

    @Override
    void addCustomer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("*****************************************************");
        System.out.println("***************** Welcome Teant ^_^ *****************");
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
        System.out.println("Please Enter Your Rent:");
        Scanner n = new Scanner(System.in);
        rent = n.nextInt();
        System.out.println("\n");

        System.out.println("------------------------------");
        System.out.println("Enter Number The Park:");
        //System.out.println("------------------------------");
        park = scanner.nextInt();
        System.out.println("\n");

        System.out.println("Thank You ^_^ ");

    }

    @Override
    void showInfo() {
        FileInputStream ffis;
        InputStreamReader fisr;
        BufferedReader fbr;
        File ff;

        try {

            ff = new File("Tenant.txt");
            // يشير إلى الملف الذي ستقرأ البيانات منه FileInputStream هنا قمنا بإنشاء كائن نوعه
            ffis = new FileInputStream(ff);

            // BufferedReader من أجل كائن الـ buffer لوضعه في الـ InputStreamReader هنا قمنا بإنشاء كائن نوعه
            fisr = new InputStreamReader(ffis);

            // للقراءة من الملف BufferedReader هنا قمنا بإنشاء كائن نوعه
            fbr = new BufferedReader(fisr);
            System.out.println("------------------------------");
            System.out.println("Please Enter Your Id:");
            Scanner sc = new Scanner(System.in);

            String id = sc.nextLine();
            String line;
            boolean check = false;

            while ((line = fbr.readLine()) != null) {

                String num = line.substring(0, line.indexOf(" "));

                if (num.equalsIgnoreCase(id)) {
                     System.out.println("*****************************************************");
                    System.out.print("The Tenant Information : ");
                    System.out.println(line);
                    check = true;

                }

            }
            if (check) {
                System.out.println();
                System.out.println("Yes He Teant ^_^.");

            } else {
                System.out.println();
                System.out.println("He Not Teant *_*.");
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toSString() {

        return super.id + " " + "Name:" + super.name + " " + "Rent:" + rent + " " + "Park:" + park;

    }

}
