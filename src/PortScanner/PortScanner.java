
package PortScanner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PortScanner {
    public void run (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your target IP address ");
        String ip = scanner.nextLine();
        
        ExecutorService pool = Executors.newFixedThreadPool(50);
        
        for ( int port = 1; port <= 65535; port++){
         
            
            final int currentPort = port;
           
            pool.submit(() -> {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, currentPort), 200);
                    
                    System.out.println("Success! Port " + currentPort + " is open. Yay!");
                    socket.close();
                    
                    } catch (IOException e){
            
                }
            });
        }
        
        pool.shutdown();
        
        try {
            
            
            if (!pool.awaitTermination(10, TimeUnit.MINUTES)){
                System.err.println("ERROR! Scan timed out. Some ports may have been missed.");
                pool.shutdownNow(); //if it takes too long, shut down. kills any leftover threads
            }
        } catch (InterruptedException e){
            pool.shutdownNow();
        }
        
        System.out.println("Scan Completed. Yay!");
    }
    }
