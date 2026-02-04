
package PortScanner;

import java.util.Scanner;

public class NetTool {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Java Network Tool ===");
        System.out.println("1. Port Scanner");
        System.out.println("2. Packet Sniffer");
        System.out.println("Select a tool: ");
        
        int choice = input.nextInt();
        
        if (choice == 1) {
            PortScanner scanner = new PortScanner();
            scanner.run();
        }else if (choice == 2){
            System.out.println("Packet Sniffer coming soon...");
        } else {
            System.out.println("Invalid Choice.");
        }
    }
}
