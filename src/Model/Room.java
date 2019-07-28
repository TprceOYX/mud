package Model;
import java.util.*;

import Controller.CommonContent;
import Controller.MessageManagement;
import Controller.RoomManagement;
import Controller.StaticFunctions;
import Controller.CommonContent.DIRECTION;

public class Room {

	private HashMap<CommonContent.DIRECTION, Room> neighbor = new HashMap<CommonContent.DIRECTION, Room>();		//���ڷ���

	public void setRoom(CommonContent.DIRECTION d, Room r) {
		neighbor.put(d, r);
		// assert r.getRoom(d) == this;
	}

	public Room getRoom(CommonContent.DIRECTION d) {			//��ȡ���ڷ�����Ϣ
		return neighbor.get(d);

	}

	private String roomDescription;
	private String roomLooking;
	private String roomId;
	private String roomName;
	private HashMap<String, Player> playerList = new HashMap<String, Player>();			//ÿ�������ʵʱ����б�

	public void exist(Player player, CommonContent.DIRECTION direction) {				//֪ͨ������������player��direction�����뿪��
		playerList.remove(player.getId());
		String message="��"+StaticFunctions.getDirection(direction)+"�뿪��";
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
	public void enter(Player player, CommonContent.DIRECTION direction) {				//֪ͨ������������player��direction���������
		playerList.put(player.getId(),player);
		String message="��"+StaticFunctions.getReverseDirection(direction)+"���˹���";
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
	//�û��˳�������û����б������ݣ�֪ͨ�������������
		playerList.remove(player.getId());
		Collection<Player> p=playerList.values();

		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")"+"�뿪����Ϸ");
			MessageManagement.showToPlayer(item, listRoomPlayers());
			
		}

	}
	public void addPlayer(Player player){
	//�û����߽��룬�����б�֪ͨ�����������
		playerList.put(player.getId(),player);
		Collection<Player> p=playerList.values();

		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(player)) {
				MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")"+"��������Ϸ");
				MessageManagement.showToPlayer(item, listRoomPlayers());
			}
		}	
	}
	
	//���֮���ս��
	public void Fright(Player killer,Player victim) {
		int armyHp;
		armyHp=victim.beAttacked(killer.getCon());					//���������Ѫ��
		if(armyHp>0) {
			MessageManagement.showToPlayer(killer, "�㹥����"+victim.getName()+"("+victim.getId()+")���������"+killer.getCon()+"���˺���");
			MessageManagement.showToPlayer(victim, "���ܵ�"+killer.getName()+"("+killer.getId()+")�Ĺ�������ʧ��"+killer.getCon()+"������ֵ��"+"\n"+"��ǰ����ֵΪ"+victim.getHp());
			Collection<Player> p=playerList.values();
			for(Iterator<Player> it=p.iterator();it.hasNext();) {
				Player item=it.next();
				if(!item.equals(killer)&&!item.equals(victim)) {
					MessageManagement.showToPlayer(item,killer.getName()+"("+killer.getId()+")������"+victim.getName()+"("+victim.getId()+")��");
				}
			}
		}
		else {
			MessageManagement.showToPlayer(killer, "��ɱ����"+victim.getName()+"("+victim.getId()+")");
			
			MessageManagement.showToPlayer(victim, "�㱻"+killer.getName()+"("+killer.getId()+")ɱ���ˣ�"+"\n"+"�㽫�����ݹ㳡����");
			playerList.remove(victim.getId());
			MessageManagement.showToPlayer(killer,this.listRoomPlayers());
			Collection<Player> p=playerList.values();
			for(Iterator<Player> it=p.iterator();it.hasNext();) {
				Player item=it.next();
				if(!item.equals(killer)) {
					MessageManagement.showToPlayer(item,killer.getName()+"("+killer.getId()+")ɱ��"+victim.getName()+"("+victim.getId()+")");
				}
			}
			victim.setLocation("yangzhou_guangchang");
			RoomManagement.cityMap.get("yangzhou_guangchang").revivePlayer(victim);	
			victim.setHp(victim.getMax_hp());
			victim.look("");
		}
	}
	
	//��ұ�ɱ���󸴻�
	public void revivePlayer(Player player) {
		playerList.put(player.getId(),player);
		Collection<Player> p=playerList.values();
		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(player)) {
				MessageManagement.showToPlayer(item, player.getName()+"("+player.getId()+")������");
				MessageManagement.showToPlayer(item, listRoomPlayers());
			}
		}	
	}

	public void talkWithPlayer(Player sender,Player receiver,String message) {
		MessageManagement.showToPlayer(receiver, sender.getName()+"("+sender.getId()+")����˵��"+message);
	}
	public void talkWithAllPlayer(Player sender,String message) {
		Collection<Player> p=playerList.values();
		for(Iterator<Player> it=p.iterator();it.hasNext();) {
			Player item=it.next();
			if(!item.equals(sender)) {
				MessageManagement.showToPlayer(item, sender.getName()+"("+sender.getId()+")��������˵��"+message);
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
		// ������
		roomLooking = roomName + "\t";
		// ��������
		// Ӧ����Client�����������������ַ����趨���壬ÿ��������
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

		// �������
		roomLooking += getChuKou() + "\t";
		// ����npc

		// ����player
		roomLooking += listRoomPlayers();
		// ����obj
		return roomLooking;
	}
	private String listRoomPlayers(){
		//�г���������е��������
		String temp = "";
		if(!playerList.isEmpty()) {
			temp=temp+"���䵱ǰ����б�"+"\n";
			Set<String> playerName=playerList.keySet();
			for(Iterator<String> it=playerName.iterator();it.hasNext();) {
				String id=it.next();
				temp=temp+playerList.get(id).getName()+"("+id+")"+"\n";
			}
		}
		return temp;
	}
	private String getChuKou() {
		/*����ÿ������ĳ���
		 * 
		 * 
		 * */
		String temp = "";
		if(!neighbor.isEmpty()) {
			temp=temp+"�˵�ͨ����"+"\n";
			Set<CommonContent.DIRECTION>nextRoom=neighbor.keySet();
			for(Iterator<DIRECTION> it=nextRoom.iterator();it.hasNext();) {
				DIRECTION item=it.next();
				temp+=StaticFunctions.getDirection(item);
				temp=temp+"�ߣ�"+neighbor.get(item).getRoomName()+"\n";
			}
		}
		return temp;
	}
}

