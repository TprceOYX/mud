package Interface;

/*
 * 服务器多线程服务多个客户端
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

	static Vector<ServerThread> vector = new Vector<ServerThread>(); // 保存用户进程
	static HashMap<String, String> allPlayer = new HashMap<String, String>(); // 保存已注册用户列表id+密码
	static Set<String> onlinePlayer = new HashSet<String>(); // 已经登录的玩家
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
				out("请选择登录（login）/注册（register）");
				vector.add(this);

			} catch (IOException e) {
				// TODO 自动生成的 catch 块
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
						out("文件读取失败！");
					}
				} else {
					out("文件读取失败！");
				}
				br.close();
				ir.close();

			} catch (IOException e) {
				// TODO 自动生成的 catch 块
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
					message = reader.readLine();// 接收客户端消息
					if (message.equals("quit"))// 下线命令
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
								vector.remove(i);// 删除此用户的服务线程
								temp.stop();// 停止这条服务线程
								return;
							}
						}
						System.out.println("用户退出");
						return;
					} else if (hasPlayer == false && message.equals("login")) {
						out("请输入登录id：");
						String id = reader.readLine();
						System.out.println(id);
						out(id);
						if (allPlayer.get(id) != null) {
							if (!onlinePlayer.contains(id)) {
								out("请输入登录密码：");
								String password = reader.readLine();
								while (!allPlayer.get(id).equals(password)) {
									out("密码错误！请重新输入：");
									password = reader.readLine();
								}
								out(password);
								String pathname = "E:\\java_project\\mud\\users\\" + id + ".txt";
								File file = new File(pathname);
								createPlayer(file);
								out("登陆成功！");
								onlinePlayer.add(id);
								MessageManagement.addPlayerChannels(player.getId(), this.writer);
								out("你的用户名为：" + player.getName());
								out("你的id为：" + player.getId());
								player.look("");
								hasPlayer = true;
							} else {
								out("该用户已登录！");
								out("请选择登录（login）/注册（register）");
							}
						} else {
							out("用户不存在！");
							out("请选择登录（login）/注册（register）");
						}
					} else if (hasPlayer == false && message.equals("register")) {
						out("请输入注册用户名（name）：");
						System.out.println("请输入注册用户名（name）：");
						String name = reader.readLine();
						System.out.println(name);
						out(name);
						out("请输入注册id：");
						String id = reader.readLine();
						System.out.println(id);
						out(id);
						out("请输入密码：");
						String password = reader.readLine();
						System.out.println(password);
						out(password);
						allPlayer.put(id, password);
						player = new Player(id, name);
						MessageManagement.addPlayerChannels(player.getId(), this.writer);
						out("你的用户名为：" + player.getName());
						out("你的id为：" + player.getId());
						out("你的密码为：" + password);
						player.look("");
						String pathname = "E:\\java_project\\mud\\users\\" + id + ".txt";
						File file = new File(pathname);
						file.createNewFile();
						updataPlayerlist(id, password);
						hasPlayer = true;
					} else {
//                    	System.out.println("正常"+message);
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
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
			System.out.println("已注册用户：");
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
