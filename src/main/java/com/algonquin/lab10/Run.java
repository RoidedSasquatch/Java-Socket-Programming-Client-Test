/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.algonquin.lab10;

import com.algonquin.lab10.client.Client;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class Run {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner keyboard = new Scanner(System.in);
        boolean isFinished = false;
        String response = "";
        
        client.createInputStream();
        client.createOutputStream();
        
        while(!isFinished) {
            System.out.println("Enter a message to send: ");
            String message = keyboard.nextLine();
            client.sendMessage(message);
            
            System.out.println("\nAwaiting response...");
            response = client.receiveMessage();
            System.out.println("\nServer responded with: " + response + "\n");
            
            if(response.equalsIgnoreCase("Finish")) {
                isFinished = true;
            }
        }
        keyboard.close();
        client.close();
    }
}
