/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservationsystem;

import java.util.*;

/**
 *
 * @author vinee
 */
class Menu {
    public static int mainMenu(Scanner scan){
        System.out.println("----------------------------------------");
        System.out.println("----------------Main Menu----------------");
        System.out.println("1. Book ticket");
        System.out.println("2. Cancel ticket");
        System.out.println("3. View chart");
        System.out.println("4. Exit");
        System.out.println("----------------------------------------");
        return scan.nextInt();
    }
}
