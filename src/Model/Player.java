package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Controller.CommonContent;
import Controller.MessageManagement;
import Controller.RoomManagement;

public class Player {

	private int experience;						//经验
	private int con;							//攻击力
	private int dex;							//敏捷
	private int str;							//力量
	private int wis;							//智慧
	private int hp, max_hp;						//生命值
	private int nl, max_nl;						//耐力值
	private int jl, max_jl;						//精力值
	private String id;							//作为玩家唯一标识
	private String username;
	private String party;
	private String location;
	public Player() {
		experience=100;
		con=100;
		dex=100;
		str=100;
		wis=100;
		max_hp=hp=1000;
		nl=max_nl=1000;
		jl=max_jl=1000;
		id="aaa";
		username="AAA";
		party="null";
		location="yangzhou_guangchang";
	}
	public Player(String[] inf) {
		this.experience = Integer.parseInt(inf[2]);
		this.con = Integer.parseInt(inf[3]);
		this.dex = Integer.parseInt(inf[4]);
		this.str = Integer.parseInt(inf[5]);
		this.wis = Integer.parseInt(inf[6]);
		this.hp = Integer.parseInt(inf[7]);
		this.max_hp = Integer.parseInt(inf[8]);
		this.nl = Integer.parseInt(inf[9]);
		this.max_nl = Integer.parseInt(inf[10]);
		this.jl = Integer.parseInt(inf[11]);
		this.max_jl = Integer.parseInt(inf[12]);
		this.id = inf[0];
		this.username = inf[1];
		this.party = inf[13];
		this.location = inf[14];
		RoomManagement.cityMap.get(location).addPlayer(this);
	}
	public Player(String id,String username){
		this.experience = 100;
		this.con = 500;
		this.dex = 100;
		this.str = 100;
		this.wis = 100;
		this.hp = 1000;
		this.max_hp = 1000;
		this.nl = 1000;
		this.max_nl = 1000;
		this.jl = 0;
		this.max_jl = 1000;
		this.id = id;
		this.username = username;
		this.party = "null";
		this.location = "yangzhou_guangchang";
		RoomManagement.cityMap.get(location).addPlayer(this);
	}

	public void quit(){
		//告诉房间退出了，释放资源
		RoomManagement.cityMap.get(location).removePlayer(this);
		String pathname="E:\\java_project\\mud\\users\\"+id+".txt";
		File filename=new File(pathname);
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(filename));
			out.write(id+" "+username+" "+experience+" "+con+" "+dex+" "+str+" "+wis+" "+hp+" "+max_hp+" "+nl+" "+max_nl+" "+jl+" "+max_jl+" "+party+" "+location);
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//save添加在这里
	}
	public void attack(Player player) {
		if(!player.equals(this)) {
			RoomManagement.cityMap.get(this.location).Fright(this, player);
		}
		else {
			MessageManagement.showToPlayer(this, "你不能攻击自己！");
		}
		
	}
	public void talk(String cmd,String message) {
		if(cmd.equals("all")) {
			RoomManagement.cityMap.get(this.location).talkWithAllPlayer(this, message);
		}
		else {
			Player reciever=RoomManagement.cityMap.get(this.location).getPlayerList().get(cmd);
			if(reciever!=null) {
				RoomManagement.cityMap.get(this.location).talkWithPlayer(this, reciever, message);
			}
			else {
				MessageManagement.showToPlayer(this, "房间里没有该玩家！");
			}
		}
	}
	public void move(CommonContent.DIRECTION direction) {
		String leaveLocation=this.location;			  		
		location=RoomManagement.cityMap.get(this.location).getRoom(direction).getRoomId();			//找到下一个房间的名字
		Room item=RoomManagement.cityMap.get(leaveLocation);
		if(item!=null) {
			if(item.getRoom(direction)!=null) {
				item.exist(this, direction);			              //退出当前房间
				item.getRoom(direction).enter(this, direction);			              //进入另一个房间
				look("");
			}
			else {
				location=leaveLocation;
				MessageManagement.showToPlayer(this, "获取下一个房间出错");
			}
		}
		else {
			location=leaveLocation;
			MessageManagement.showToPlayer(this, "获取当前房间出错");
		}
		
		
	}
	public void look(String something){
		if(something.equals("")) {
			MessageManagement.showToPlayer(this, RoomManagement.cityMap.get(location).getRoomLooking());
		}
			//查看当前房间;
		else {
			
		}
			//查看其它物品
	}
	
	public void setLocation(String location){           //玩家进入世界时调用
		this.location=location;
	}
	public String getLocation(){
		return this.location;
	}
	public String getId(){
		return id;
	}
	public int getCon() {
		return con;
	}
	public void setId(String id){
		
	}
	public String getName(){
		return this.username;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int a) {
		this.hp=a;
	}
	public int beAttacked(int attack) {
		this.hp-=attack;
		return hp;
	}
	public int getMax_hp() {
		return max_hp;
	}
	public void setName(String username){
		
	}
}
