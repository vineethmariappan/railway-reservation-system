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
public class Ticket {
        private char from,to;
        private int noOfPassengers;
        private int PNRNO;
        private int seatNO;
        protected static Set<Integer> PNRs=null;
        Ticket(char from, char to, int noOfPassengers){
            this.from=from;
            this.to=to;
            this.noOfPassengers=noOfPassengers;
            if(PNRs==null)
                PNRs=new TreeSet();
            do{
                PNRNO=generatePNR();
            }while(PNRs.contains(PNRNO));
            PNRs.add(PNRNO);
        }
        private int generatePNR(){
            Random rand = new Random();
            return rand.nextInt(999999999);
        }
        public void setSeatNO(int seatNO){
            this.seatNO=seatNO;
        }
        public int getPNRNO(){
            return this.PNRNO;
        }


    public char getFrom() {
        return from;
    }


    public char getTo() {
        return to;
    }


    public int getNoOfPassengers() {
        return noOfPassengers;
    }


    public int getSeatNO() {
        return seatNO;
    }
        
}
