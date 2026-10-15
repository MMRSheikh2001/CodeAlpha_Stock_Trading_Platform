/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stocktradingplatform;

import stocktradingplatform.db.DataBase;

/**
 *
 * @author Administrator
 */
public class StockTradingPlatform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        DataBase db = new DataBase();

        try {
            db.getCon();
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println("Not Connected");
        }

    }

}
