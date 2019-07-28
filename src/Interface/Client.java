package Interface;
import java.io.*;
import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7991604596199043370L;
	private JTextArea screen;                                 	//显示游戏内容
	private JTextField input;									//输入指令
	private JButton connection;									//连接服务器
	private JButton discon;

	private Socket socket;										
	private BufferedReader in;									//接收信息								
	private PrintWriter out;

	private MonitorThread monitorthread;
	private String ipaddress = "127.0.0.1";
	private int port = 1888;
	private boolean connected = false;

	public PrintWriter get_pw() {
		return out;
	}
	
	class MonitorThread extends Thread {
		private JTextArea textArea;
		private BufferedReader reader;
		public MonitorThread(BufferedReader reader, JTextArea textArea) {  
            this.reader = reader;  
            this.textArea = textArea;  
        }
		public void run() {
			//接收服务器消息的控制在这里添加
			String message = ""; 
			while(true) {
				try {
					message = reader.readLine();
					setText(textArea,message);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} 
			}
		}
	}
	
	public void sendMessage(String s) throws IOException {	
		out.println(s);
		out.flush();
	}

	public Client() {
		super("Mud Client");
		setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		add(BorderLayout.CENTER, leftPanel);
		add(BorderLayout.EAST, rightPanel);
		leftPanel.setLayout(new BorderLayout());
		screen = new JTextArea();
		screen.setEditable(false);
		screen.setAutoscrolls(true);
		JScrollPane jsp = new  JScrollPane(screen);					//带滚动条的JTextArea
		input = new JTextField();
		connection = new JButton("conncet");
		discon=new JButton("disconncet");
		leftPanel.add(BorderLayout.CENTER, jsp);
		leftPanel.add(BorderLayout.SOUTH, input);
		// rightPanel.setLayout(new FlowLayout());
		rightPanel.add(connection);
		rightPanel.add(discon);
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input.addKeyListener(new KeyAdapter() {					//匿名内部类
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//用户键盘输入在这里添加
				
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER&&connected) {
					try {
						if(input.getText().equals("quit")) {
							
							if(disconnect()) {
								setText(screen,"成功断开连接！");
							}
						}
						else {
							sendMessage(input.getText());
						}
						
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}				
					input.setText("");
				}
			}
		});
		//窗口关闭事件
		addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                if (connected) {  
                    disconnect();// 关闭连接  
                }  
                System.exit(0);// 退出程序  
            }  
        });  
		discon.addActionListener(new ActionListener() {              //断开连接

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
	            if (!connected) {  
	            	setText(screen,"已经断开不要重复操作！");
                    return;  
                }  
                try {  
                    boolean flag = disconnect();// 断开连接  
                    if (flag == false) {  
                        throw new Exception("断开连接发生异常！");  
                    }  
                    setText(screen,"成功断开");
                } catch (Exception exc) {  
                	setText(screen,"断开异常");
                }  
			}
			
		});
		connection.addActionListener(new ActionListener() {					

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(connected==false) {
					try {
						//连接服务器在这里添加
						socket=new Socket(ipaddress,port);	
						in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						out=new PrintWriter(socket.getOutputStream());
						monitorthread=new MonitorThread(in,screen);
						monitorthread.start();
						connected=true;
					} catch (Exception e) {
						e.printStackTrace();
						screen.setText(screen.getText() + "链接服务器失败！请重试\n");
						System.exit(1);
					}
				}
			}
		});
	}
	
	@SuppressWarnings("deprecation")
	public synchronized boolean disconnect() {
		try {
			sendMessage("quit");	
			monitorthread.stop();
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(socket!=null) {
				socket.close();
			}
			connected = false;	
			return true;
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return false;
		}	
	}
	

/*
	public void setDefaultCloseOperation(int arg0) {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (connected) {
			try {
				sendMessage("close");
				connected = false;		
				socket.close();
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.exit(1);
	}
*/
	public void setText(JTextArea screen, String Message) {				//输出游戏实时信息
		if(Message!=null) {
			String[] temp = Message.split("\t");
			for (int i = 0; i < temp.length; i++) {
				screen.setText(screen.getText() + temp[i] + "\n");
				// System.out.print(temp[i]+"\n");
			}
			screen.setCaretPosition(screen.getDocument().getLength());
		}
	}

	public static void main(String[] args) {
		new Client();	
	}
}
