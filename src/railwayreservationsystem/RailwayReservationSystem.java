/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservationsystem;

import java.util.Scanner;

/**
 *
 * @author vi1nee
 */
public class RailwayReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Train chennaiExpress = new Train(50);
        while(true){
            int choice = Menu.mainMenu(scan);
            switch(choice){
                case 1:
                    chennaiExpress.bookTicket(scan);
                    break;
                case 2:
                    chennaiExpress.cancelTicket(scan);
                    break;
                case 3:
                    chennaiExpress.displayChart();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    
}
