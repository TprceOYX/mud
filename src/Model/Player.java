package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Controller.CommonContent;
import Controller.MessageManagement;
import Controller.RoomManagement;

public class Player {

	private int experience;						//����
	private int con;							//������
	private int dex;							//����
	private int str;							//����
	private int wis;							//�ǻ�
	private int hp, max_hp;						//����ֵ
	private int nl, max_nl;						//����ֵ
	private int jl, max_jl;						//����ֵ
	private String id;							//��Ϊ���Ψһ��ʶ
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
		//���߷����˳��ˣ��ͷ���Դ
		RoomManagement.cityMap.get(location).removePlayer(this);
		String pathname="E:\\java_project\\mud\\users\\"+id+".txt";
		File filename=new File(pathname);
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(filename));
			out.write(id+" "+username+" "+experience+" "+con+" "+dex+" "+str+" "+wis+" "+hp+" "+max_hp+" "+nl+" "+max_nl+" "+jl+" "+max_jl+" "+party+" "+location);
			out.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//save���������
	}
	public void attack(Player player) {
		if(!player.equals(this)) {
			RoomManagement.cityMap.get(this.location).Fright(this, player);
		}
		else {
			MessageManagement.showToPlayer(this, "�㲻�ܹ����Լ���");
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
				MessageManagement.showToPlayer(this, "������û�и���ң�");
			}
		}
	}
	public void move(CommonContent.DIRECTION direction) {
		String leaveLocation=this.location;			  		
		location=RoomManagement.cityMap.get(this.location).getRoom(direction).getRoomId();			//�ҵ���һ�����������
		Room item=RoomManagement.cityMap.get(leaveLocation);
		if(item!=null) {
			if(item.getRoom(direction)!=null) {
				item.exist(this, direction);			              //�˳���ǰ����
				item.getRoom(direction).enter(this, direction);			              //������һ������
				look("");
			}
			else {
				location=leaveLocation;
				MessageManagement.showToPlayer(this, "��ȡ��һ���������");
			}
		}
		else {
			location=leaveLocation;
			MessageManagement.showToPlayer(this, "��ȡ��ǰ�������");
		}
		
		
	}
	public void look(String something){
		if(something.equals("")) {
			MessageManagement.showToPlayer(this, RoomManagement.cityMap.get(location).getRoomLooking());
		}
			//�鿴��ǰ����;
		else {
			
		}
			//�鿴������Ʒ
	}
	
	public void setLocation(String location){           //��ҽ�������ʱ����
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
