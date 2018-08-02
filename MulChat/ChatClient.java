package MulChat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JApplet implements ActionListener,Runnable{
	int port = 7070;
	
	DataInputStream di;
	DataOutputStream dou;
	JTextField tfNickName, tfInput;
	JTextArea ta;
	CardLayout card;
	Thread tr;
	boolean flag=false;
	
	Container cont;
	
	int lineCnt;
	String lastMsg;
	
	Socket sk;
	
	

	public void init() {
		cont = getContentPane();
		card = new CardLayout();
		cont.setLayout(card);
		
		JPanel NameP = new JPanel();
		JPanel ChatP = new JPanel(new BorderLayout());
		
		cont.add(NameP, "login");
		cont.add(ChatP, "chat");
		card.show(cont, "login");

		//1) 로그인 화면 - 닉네임 화면 만들기.
		NameP.add(new JLabel("닉네임"));
		NameP.add(tfNickName=new JTextField(10));

		//2)채팅화면 만들기.
		ChatP.add(new JScrollPane(ta = new JTextArea()));
		ChatP.add(tfInput=new JTextField(), "South");
		ta.setEditable(false);
		ta.setBackground(Color.orange);
		ta.setForeground(Color.BLACK);
		
		//리스너 등록
		tfNickName.addActionListener(this);
		tfInput.addActionListener(this);
		
		
	}//init()
	
	
	public void start() {
		// 스레드를 동작시킨다.
		Thread th = new Thread(this);
		th.start();
		
		
	}//start()
	
	
	public void stop() {
		//스레드 정지
		if(tr!=null) {
			flag=true;
		}
		tr=null;
	}//stop()
	
	public void destroy() {
		
			try {
				if(di != null)di.close(); 				
				if(dou !=null)dou.close();
				if(sk !=null)sk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource(); //object 반환값.
		if(obj == tfNickName) {
			String nickName = tfNickName.getText();
			if(nickName == null || nickName.trim().equals("")) {
				showStatus("닉네임을 입력하세요...");
				return;
			}
			
			try {
				dou.writeUTF(nickName);
				dou.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//채딩 화면 보여주기
			card.show(cont, "chat");
			
			tfInput.setEditable(true);
			tfInput.requestFocus();

		}else if(obj == tfInput){
			String sendMsg = tfInput.getText();
			
			try {
				dou.writeUTF(sendMsg);
				dou.flush();
				tfInput.setText("");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}//actionPerformed()




	@Override
	public void run() {
		//서버에 접속하기위한 서버주소 얻어오기.
		String ip = getCodeBase().getHost();
		System.out.println(ip);
		ta.append(ip + " 서버와 연결중 ...\n");
		try {
			sk = new Socket(ip, port);
			ta.append("연결되었습니다..\n");
			
			InputStream in = sk.getInputStream();
			OutputStream out = sk.getOutputStream();
			
			di = new DataInputStream(in);
			dou = new DataOutputStream(out);
			
			readfunc();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//run()
	
	//서버에세 메세지를 읽어오는 메서드.
	public void readfunc() throws Exception {
		String serverMsg="";
		while(!flag) {
			serverMsg = di.readUTF();
			if(lineCnt > 20) {
				ta.setText("");
				ta.append(serverMsg+"\n");
				lineCnt = 0;
			}
			
			ta.append(serverMsg+"\n");
			lastMsg = serverMsg;
			lineCnt++;
		}
	}
	
	
	

	
	
	
	
}
