/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.lab10.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class Client {
    Socket client;
    DataOutputStream os;
    DataInputStream is;
    String serverName;
    
    public Client() {
        serverName = null;
        
        try {
            client = new Socket(serverName, 1254);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        } 
   
    }
    
    public DataInputStream createInputStream() {
        try {
            is = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        } 
        return is;
    }
    
    public DataOutputStream createOutputStream() {
       
        try {
            os = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        } 
        return os;
    }
    
    public String receiveMessage() {
        String message = "";
        try {
            message = is.readUTF();
        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        }
        return message;
    }
    
    public void sendMessage(String message) {
        try {
            os.writeUTF(message);  
            os.flush();
        } catch (IOException e){
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void close() throws IOException {
        client.close();
        os.close();
        is.close();
    }
}
