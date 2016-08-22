/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author allan
 */
public class printOrder {

    public printOrder() {
    }

    
    public void printLocalOrder(ArrayList<String> orderArray, int n) {

        try {
            FileWriter file = new FileWriter("/dev/usb/lp2");
            BufferedWriter buffer = new BufferedWriter(file);
            PrintWriter ps = new PrintWriter(buffer);
            // java.setFormato(5, ps);

            ps.write(0x1B);
            ps.write("M");
            ps.write(1);
            formatPrintKitchen(ps, n);
            for (String orderArray1 : orderArray) {
                ps.write(orderArray1);
            }
            ps.write(0x1B);
            ps.write("d");
            ps.write(4);

//         
//             formatPrintKitchen(ps,112);
//            for (String orderArray1 : orderArray) {
//                ps.write(orderArray1);
//            }
//            formatPrintKitchen(ps, n);
//            for (String orderArray1 : orderArray) {
//                ps.write(orderArray1);
//            }
//            
//            ps.write(0x1B);
//            ps.write("d");
//            ps.write(5);

            //Recibe 40 caracteres máximo por línea.
           // ps.write(0xA);
            ps.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void formatPrintKitchen(PrintWriter ps, int n) {
        ps.write(0x1B);
        ps.write("!");
        ps.write(n);
    }
}
