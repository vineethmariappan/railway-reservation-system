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
public class Train {
        List<Ticket> confirmedTickets;
        List<Ticket> waitingTickets;
        TreeSet<Integer> availableSeats;
        int totalSeats;
        static boolean chart[][];
        Train(int totalSeats){
            this.totalSeats=totalSeats;
            confirmedTickets =  new LinkedList<>();
            waitingTickets =  new LinkedList<>();
            availableSeats = new TreeSet();
            chart = new boolean[8][5];
            for(int i=1;i<=8;i++)
                availableSeats.add(i);
        }
       
        public void bookTicket(Scanner scan){
            if(confirmedTickets.size()==8 && waitingTickets.size()==2){
                System.out.println("No tickets are available");
                return;
            }
            System.out.println("Enter depature location(A,B,C,D, or E)");
            char from = ((String)(scan.next())).charAt(0);
            System.out.println("Enter destination location(A,B,C,D, or E)");
            char to = ((String)(scan.next())).charAt(0);
            System.out.println("Enter No of Seats");
            int noOfPassengers = scan.nextInt();
            if(totalSeats<noOfPassengers){
                System.out.println("The Train doesnt have the required no of seats!");
                return;
            }
            Ticket ticket = new Ticket(from,to,noOfPassengers);
            if(confirmedTickets.size()<8){
                int seatNO=this.availableSeats.pollFirst();
                for(int i=(int)(from-'A');i<=(int)(to-'A');i++){
                    chart[seatNO-1][i]=true;
                }
                ticket.setSeatNO(seatNO);
                confirmedTickets.add(ticket);
            }
            else if(waitingTickets.size()<2)
                waitingTickets.add(ticket);
            totalSeats-=noOfPassengers;
            System.out.println("----------------Ticket----------------");
            System.out.println("PNR NO : "+ticket.getPNRNO());
            System.out.println("-------------------------------------");
        }
        public void displayChart(){
            System.out.println(" A   B   C   D   E ");
            for(int i=0;i<8;i++){
                System.out.print(i+"");
                for(int j=0;j<5;j++){
                    if(chart[i][j]==true)
                        System.out.print("*   ");
                    else
                        System.out.print("    ");
                }
                 System.out.println("");
            }
        }
        public void cancelTicket(Scanner scan){
            System.out.println("Enter PNR number to cancel");
            int PNR = scan.nextInt();
            char from,to;
            Ticket cancelTicket=null;
            for(int i=0;i<confirmedTickets.size();i++){
                if(confirmedTickets.get(i).getPNRNO()==PNR){
                    cancelTicket=confirmedTickets.get(i);
                    break;
                }
            }
            if(cancelTicket==null) return;
//            Ticket.PNRs.removeIf(TPNR->(TPNR==PNR));
             this.availableSeats.add(cancelTicket.getSeatNO());
            for(int i=(int)(cancelTicket.getFrom()-'A');i<=(int)(cancelTicket.getTo()-'A');i++){
                chart[cancelTicket.getSeatNO()-1][i]=false;
            }
            confirmedTickets.remove(cancelTicket);
            if(waitingTickets.size()>0){
                confirmedTickets.add(waitingTickets.get(0));
                waitingTickets.remove(0);
            }
            System.out.println("Ticket Cancelled Successfully!");
        }
}
