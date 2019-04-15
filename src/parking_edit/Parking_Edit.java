/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking_edit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Scanner;
import lib.ExcelDataConfig_Read;
import lib.ExcelDataConfig_Write;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author mhd
 */
public class Parking_Edit {

    /**
     * @param args the command line arguments
     */
    static File f;
    static FileOutputStream fos;
    static FileInputStream fis;
    static OutputStreamWriter osw;
    static BufferedWriter bw;
    static File ff;
    static FileOutputStream ffos;
    static FileInputStream ffis;
    static OutputStreamWriter fosw;
    static BufferedWriter fbw;

    public static void main(String[] args) throws IOException {

        int option = 0 ;
        while (true && option != 5) {
            System.out.println("*****************************************************");
            System.out.println("********************** Welcome ^_^ ******************");
            System.out.println("*****************************************************");
            System.out.println("\n");
            System.out.println("*********************************************************************** ");
            System.out.println("1-New Tenant");
            System.out.println("2-New Visitor");
            System.out.println("3-Old Tenant");
            System.out.println("4-Old Visitor");
            System.out.println("5-Exit");
            System.out.println("\n");
            System.out.println("*********************************************************************** ");
            System.out.println("Enter an option :");

            Scanner op = new Scanner(System.in);

            option = op.nextInt();

            switch (option) {
                case 1:
                    try {
                        ff = new File("Tenant.txt");
                        ffos = new FileOutputStream(ff, true);
                        fosw = new OutputStreamWriter(ffos);
                        fbw = new BufferedWriter(fosw);
                        Tenant t = new Tenant();
                        t.addCustomer();
                        String aa = t.toSString();

                        fbw.write(aa);
                        fbw.newLine();
                    } catch (Exception e) {
                        System.out.println("file not found");
                    } finally {

                        fbw.close();
                    }

                    break;
                case 2:

                    try {

                        f = new File("visitor.txt");
                        fos = new FileOutputStream(f, true);
                        osw = new OutputStreamWriter(fos);
                        fbw = new BufferedWriter(osw);
                        Visitor v = new Visitor();
                        v.addCustomer();
                        String a = v.toSString();

                        fbw.write(a);
                        fbw.newLine();

                    } catch (Exception e) {
                        System.out.println("file not found");
                    } finally {
                        // bw.close();
                        fbw.close();
                    }
                    break;
                case 3:
                    Tenant t = new Tenant();

                    t.showInfo();
                    break;
                case 4:
                    Visitor v = new Visitor();
                    v.showInfo();
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Invaild option!!.please enter again");
                    break;

            }
            System.out.println("\n");
        }

    }

}
