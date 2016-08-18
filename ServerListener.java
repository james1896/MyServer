package com.evan.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
public void run(){
	try {
		ServerSocket serverSocket = new ServerSocket(12345);
		
		while(true){
			Socket socket =	serverSocket.accept();
			//block
			//建立链接
			JOptionPane.showMessageDialog(null, "有客户端链接到了本机的12345端口");
			
			//将socket传递给新的线程
		ChatSocket cs =	new ChatSocket(socket);
		cs.start();
		
	
		ChatManager.getChatManager().add(cs);
		}
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
