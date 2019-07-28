package Interface;

/*
 * ���������̷߳������ͻ���
 */
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import Controller.MessageManagement;
import Controller.RoomManagement;
import Controller.UserInput;
import Model.Player;

public class Server {

	static Vector<ServerThread> vector = new Vector<ServerThread>(); // �����û�����
	static HashMap<String, String> allPlayer = new HashMap<String, String>(); // ������ע���û��б�id+����
	static Set<String> onlinePlayer = new HashSet<String>(); // �Ѿ���¼�����
	public static int num = 0;

	static class ServerThread extends Thread {
		private Socket socket;
		private BufferedReader reader;
		public PrintWriter writer;
		private Player player;

		public BufferedReader getReader() {
			return reader;
		}

		public PrintWriter getWriter() {
			return writer;
		}

		public Player getPlayer() {
			return player;
		}

		public ServerThread(Socket socket) {

			try {
				this.socket = socket;
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream());
				out("��ѡ���¼��login��/ע�ᣨregister��");
				vector.add(this);

			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}

		}

		public void createPlayer(File file) {
			InputStreamReader ir;
			try {
				ir = new InputStreamReader(new FileInputStream(file));
				BufferedReader br = new BufferedReader(ir);
				String line = null;
				if ((line = br.readLine()) != null) {
					String[] inf = line.split(" ");
					if (inf.length == 15) {
						player = new Player(inf);
					} else {
						out("�ļ���ȡʧ�ܣ�");
					}
				} else {
					out("�ļ���ȡʧ�ܣ�");
				}
				br.close();
				ir.close();

			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			String message = null;
			boolean hasPlayer = false;
			while (true) {
				try {
					message = reader.readLine();// ���տͻ�����Ϣ
					if (message.equals("quit"))// ��������
					{
						if (hasPlayer) {
							MessageManagement.removePlayerChannels(player.getId());
							player.quit();
						}
						reader.close();
						writer.close();
						socket.close();
						for (int i = vector.size() - 1; i >= 0; i--) {
							if (vector.get(i).getPlayer() == this.player) {
								ServerThread temp = vector.get(i);
								vector.remove(i);// ɾ�����û��ķ����߳�
								temp.stop();// ֹͣ���������߳�
								return;
							}
						}
						System.out.println("�û��˳�");
						return;
					} else if (hasPlayer == false && message.equals("login")) {
						out("�������¼id��");
						String id = reader.readLine();
						System.out.println(id);
						out(id);
						if (allPlayer.get(id) != null) {
							if (!onlinePlayer.contains(id)) {
								out("�������¼���룺");
								String password = reader.readLine();
								while (!allPlayer.get(id).equals(password)) {
									out("����������������룺");
									password = reader.readLine();
								}
								out(password);
								String pathname = "E:\\java_project\\mud\\users\\" + id + ".txt";
								File file = new File(pathname);
								createPlayer(file);
								out("��½�ɹ���");
								onlinePlayer.add(id);
								MessageManagement.addPlayerChannels(player.getId(), this.writer);
								out("����û���Ϊ��" + player.getName());
								out("���idΪ��" + player.getId());
								player.look("");
								hasPlayer = true;
							} else {
								out("���û��ѵ�¼��");
								out("��ѡ���¼��login��/ע�ᣨregister��");
							}
						} else {
							out("�û������ڣ�");
							out("��ѡ���¼��login��/ע�ᣨregister��");
						}
					} else if (hasPlayer == false && message.equals("register")) {
						out("������ע���û�����name����");
						System.out.println("������ע���û�����name����");
						String name = reader.readLine();
						System.out.println(name);
						out(name);
						out("������ע��id��");
						String id = reader.readLine();
						System.out.println(id);
						out(id);
						out("���������룺");
						String password = reader.readLine();
						System.out.println(password);
						out(password);
						allPlayer.put(id, password);
						player = new Player(id, name);
						MessageManagement.addPlayerChannels(player.getId(), this.writer);
						out("����û���Ϊ��" + player.getName());
						out("���idΪ��" + player.getId());
						out("�������Ϊ��" + password);
						player.look("");
						String pathname = "E:\\java_project\\mud\\users\\" + id + ".txt";
						File file = new File(pathname);
						file.createNewFile();
						updataPlayerlist(id, password);
						hasPlayer = true;
					} else {
//                    	System.out.println("����"+message);
						out(player.getName() + ":" + message);
						UserInput.dealInput(this.player, message);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		public void updataPlayerlist(String id, String password) {
			String filename = "E:\\java_project\\mud\\users\\userslist.txt";
			try {
				RandomAccessFile ra = new RandomAccessFile(filename, "rw");
				ra.seek(ra.length());
				ra.writeBytes(id + " " + password + "\n");
				ra.close();
			} catch (FileNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

		public void out(String out) throws IOException {
			if (out != null || out != "") {
				writer.println(out);
				writer.flush();
			}
		}
	}

	public static int PORT_NUM = 1888;
	static ServerSocket serversocket;

	static public void main(String[] args) throws IOException {
		serversocket = new ServerSocket(PORT_NUM);
		System.out.println("Server starts!");
		String pathname = "E:\\java_project\\mud\\users\\userslist.txt";
		File file = new File(pathname);
		if (!file.exists()) {
			file.createNewFile();
		} else {
//			FileReader fs=new FileReader(file);
//			BufferedReader bb=new BufferedReader(fs);

			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			System.out.println("��ע���û���");
			while ((line = br.readLine()) != null) {
				String[] inf = line.split(" ");
				allPlayer.put(inf[0], inf[1]);
				System.out.println(inf[0] + " " + allPlayer.get(inf[0]));
				br.readLine();
			}
			br.close();
			reader.close();
		}
		RoomManagement.creatRooms();
		for (;;) {
			num++;
			Socket socket = serversocket.accept();
			ServerThread st = new ServerThread(socket);
			st.start();
			vector.add(st);
		}
	}// end main

}// end Server class
