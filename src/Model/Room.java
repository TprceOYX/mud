package Model;
import java.util.*;

import Controller.CommonContent;
import Controller.MessageManagement;
import Controller.RoomManagement;
import Controller.StaticFunctions;
import Controller.CommonContent.DIRECTION;

public class Room {

	private HashMap<CommonContent.DIRECTION, Room> neighbor = new HashMap<CommonContent.DIRECTION, Room>();		//相邻房间

	public void setRoom(CommonContent.DIRECTION d, Room r) {
		neighbor.put(d, r);
		// assert r.getRoom(d) == this;
	}

	public Room getRoom(CommonContent.DIRECTION d) {			//获取相邻房间信息
		return neighbor.get(d);

	}

	private String roomDescription;
	private String roomLooking;
	private String roomId;
	private String roomName;
	private HashMap<String, Player> playerList = new HashMap<String, Player>();			//每个房间的实时玩家列表

	public void exist(Player player, CommonContent.DIRECTION direction) {				//通知房间的其他玩家player从direction方向离开了
		playerList.remove(player.getId());
		String message="从"+StaticFunctions.getDirection(direction)+"离开了";
		Collection<Player> p=playerList.values();
		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")"+message);
			MessageManagement.showToPlayer(item, listRoomPlayers());
		}
	}
	public HashMap<String, Player> getPlayerList(){
		return playerList;
	}
	public void enter(Player player, CommonContent.DIRECTION direction) {				//通知房间的其他玩家player从direction方向进入了
		playerList.put(player.getId(),player);
		String message="从"+StaticFunctions.getReverseDirection(direction)+"走了过来";
		Collection<Player> p=playerList.values();
		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(player)) {
				MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")"+message);
				MessageManagement.showToPlayer(item, listRoomPlayers());
			}
			
		}
	}
	public void removePlayer(Player player){
	//用户退出后，清除用户在列表中内容，通知房间内其他玩家
		playerList.remove(player.getId());
		Collection<Player> p=playerList.values();

		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")"+"离开了游戏");
			MessageManagement.showToPlayer(item, listRoomPlayers());
			
		}

	}
	public void addPlayer(Player player){
	//用户连线进入，加入列表，通知房间其他玩家
		playerList.put(player.getId(),player);
		Collection<Player> p=playerList.values();

		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(player)) {
				MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")"+"加入了游戏");
				MessageManagement.showToPlayer(item, listRoomPlayers());
			}
		}	
	}
	
	//玩家之间的战斗
	public void Fright(Player killer,Player victim) {
		int armyHp;
		armyHp=victim.beAttacked(killer.getCon());					//被攻击后的血量
		if(armyHp>0) {
			MessageManagement.showToPlayer(killer, "你攻击了"+victim.getName()+"("+victim.getId()+")对其造成了"+killer.getCon()+"点伤害！");
			MessageManagement.showToPlayer(victim, "你受到"+killer.getName()+"("+killer.getId()+")的攻击，损失了"+killer.getCon()+"点生命值！"+"\n"+"当前生命值为"+victim.getHp());
			Collection<Player> p=playerList.values();
			for(Iterator<Player> it=p.iterator();it.hasNext();) {
				Player item=it.next();
				if(!item.equals(killer)&&!item.equals(victim)) {
					MessageManagement.showToPlayer(item,killer.getName()+"("+killer.getId()+")攻击了"+victim.getName()+"("+victim.getId()+")！");
				}
			}
		}
		else {
			MessageManagement.showToPlayer(killer, "你杀死了"+victim.getName()+"("+victim.getId()+")");
			
			MessageManagement.showToPlayer(victim, "你被"+killer.getName()+"("+killer.getId()+")杀死了！"+"\n"+"你将在扬州广场复活");
			playerList.remove(victim.getId());
			MessageManagement.showToPlayer(killer,this.listRoomPlayers());
			Collection<Player> p=playerList.values();
			for(Iterator<Player> it=p.iterator();it.hasNext();) {
				Player item=it.next();
				if(!item.equals(killer)) {
					MessageManagement.showToPlayer(item,killer.getName()+"("+killer.getId()+")杀了"+victim.getName()+"("+victim.getId()+")");
				}
			}
			victim.setLocation("yangzhou_guangchang");
			RoomManagement.cityMap.get("yangzhou_guangchang").revivePlayer(victim);	
			victim.setHp(victim.getMax_hp());
			victim.look("");
		}
	}
	
	//玩家被杀死后复活
	public void revivePlayer(Player player) {
		playerList.put(player.getId(),player);
		Collection<Player> p=playerList.values();
		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(player)) {
				MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")复活了");
				MessageManagement.showToPlayer(item, listRoomPlayers());
			}
		}	
	}

	public void talkWithPlayer(Player sender,Player receiver,String message) {
		MessageManagement.showToPlayer(receiver, sender.getName()+"("+sender.getId()+")对你说："+message);
	}
	public void talkWithAllPlayer(Player sender,String message) {
		Collection<Player> p=playerList.values();
		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(sender)) {
				MessageManagement.showToPlayer(item, sender.getName()+"("+sender.getId()+")对所有人说："+message);
			}
		}	
	}
	public void setDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getDescription() {
		return roomDescription;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void SetRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	/*public String getRoomLooking() {
		return roomLooking;
	}*/

	public String getRoomLooking() {
		// 房间名
		roomLooking = roomName + "\t";
		// 房间描述
		// 应该由Client负责解析传输过来的字符（设定字体，每行字数）
		int roomDescriptionLength = roomDescription.length();
		if (roomDescriptionLength <= CommonContent.CHARS_PER_LINE)
			roomLooking += roomDescription + "\t";
		else {
			int i;
			for (i = 0; i <= roomDescriptionLength
					- CommonContent.CHARS_PER_LINE; i = i
					+ CommonContent.CHARS_PER_LINE) {
				roomLooking += roomDescription.substring(i, i
						+ CommonContent.CHARS_PER_LINE)
						+ "\t";
			}
			roomLooking += roomDescription.substring(i, roomDescriptionLength)
					+ "\t";
		}

		// 房间出口
		roomLooking += getChuKou() + "\t";
		// 房间npc

		// 房间player
		roomLooking += listRoomPlayers();
		// 房间obj
		return roomLooking;
	}
	private String listRoomPlayers(){
		//列出这个房间中的所有玩家
		String temp = "";
		if(!playerList.isEmpty()) {
			temp=temp+"房间当前玩家列表："+"\n";
			Set<String> playerName=playerList.keySet();
			for(Iterator<String> it=playerName.iterator();it.hasNext();) {
				String id=it.next();
				temp=temp+playerList.get(id).getName()+"("+id+")"+"\n";
			}
		}
		return temp;
	}
	private String getChuKou() {
		/*描述每个房间的出口
		 * 
		 * 
		 * */
		String temp = "";
		if(!neighbor.isEmpty()) {
			temp=temp+"此地通往："+"\n";
			Set<CommonContent.DIRECTION>nextRoom=neighbor.keySet();
			for(Iterator<DIRECTION> it=nextRoom.iterator();it.hasNext();) {
				DIRECTION item=it.next();
				temp+=StaticFunctions.getDirection(item);
				temp=temp+"边："+neighbor.get(item).getRoomName()+"\n";
			}
		}
		return temp;
	}
}

