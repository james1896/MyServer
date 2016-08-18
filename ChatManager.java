package com.evan.test;

import java.util.Vector;

public class ChatManager {

	private ChatManager(){};
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket socket){
		vector.add(socket);
	}
	
	public void publish(ChatSocket socket,String out){
		for(int i = 0;i<vector.size();i++){
			
			ChatSocket chatSocket = vector.get(i);
			//如果不是当前发送消息的 对象
			if(!socket.equals(chatSocket)){
				chatSocket.out(out);
			}
		}
	}
}
