package com.example.lawnmower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectThread extends Thread{

    //singleton pattern
    private static ConnectThread instance;

    //private static String ThreadStatus = "Disconnected";

    private String SERVER_IP;
    private int SERVER_PORT;

    public static ConnectThread getInstance(String SERVER_IP, int SERVER_PORT) {
        if(instance == null) {
            if(SERVER_IP == null || SERVER_PORT == -1) {

                //
            } else {
                instance = new ConnectThread(SERVER_IP, SERVER_PORT);
            }
        }
        return instance;
        //return (instance == null) ? instance = new ConnectThread(SERVER_IP, SERVER_PORT) : instance;
    }

    private ConnectThread(String SERVER_IP, int SERVER_PORT) {
        this.SERVER_IP = SERVER_IP;
        this.SERVER_PORT = SERVER_PORT;
    }

    //implementation
    private static Socket mSocket = null;

    private PrintWriter output;

    private BufferedReader input;

    public static Socket getSocket() {
        return mSocket;
    }

    @Override
    public void run() {
        //manage Connection
        try {
            mSocket = new Socket(SERVER_IP, SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Send(byte[] message) {
        try {
            mSocket.getInputStream().read(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
