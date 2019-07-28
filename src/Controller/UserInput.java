package Controller;

import Controller.CommonContent.DIRECTION;
import Model.Player;
import Model.Room;

public class UserInput {
	public static void dealInput(Player player, String inputMessage) {
		/*
		 * ���Դ�������� l,look e,east,w,west,n,north,s,south,
		 */

		String[] inputs = inputMessage.split(" ");
		if(inputs[0].equals("attack")) {
			String id=inputs[1];
			if(id!="") {
				Player item=RoomManagement.cityMap.get(player.getLocation()).getPlayerList().get(id);
				if(item!=null) {
					player.attack(item);
				}
				else {
					MessageManagement.showToPlayer(player, "�Ҳ�������ң�");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "������ֲ���Ϊ�գ�");
			}
		}
		else if(inputs[0].equals("talk")&&inputs[1].equals("with")) {
			String cmd=inputs[2];
			String message=inputs[3];
			if(cmd!=null) {
				if(message!=null) {
					player.talk(cmd, message);
				}
				else {
					MessageManagement.showToPlayer(player, "���͵���Ϣ����Ϊ�գ�");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "ָ�����");
			}
		}
		else if (inputs[0].equals("l") || inputs[0].equals("look")) {
			if (inputs.length == 1) {
				player.look("");
				return;
			}
		}
		else if (inputs[0].equals("quit")) {
			
			return;
		}
		else if (inputs[0].equals("e") || inputs[0].equals("east")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.EAST)!=null) {
					player.move(DIRECTION.EAST);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵ض���û�г��ڣ�");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("w") || inputs[0].equals("west")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.WEST)!=null) {
					player.move(DIRECTION.WEST);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵�����û�г��ڣ�");
				}				
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("s") || inputs[0].equals("south")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.SOUTH)!=null) {
					player.move(DIRECTION.SOUTH);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵��ϱ�û�г��ڣ�");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("n") || inputs[0].equals("north")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.NORTH)!=null) {
					player.move(DIRECTION.NORTH);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵ر���û�г��ڣ�");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("ne") || inputs[0].equals("northeast")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.NORTHEAST)!=null) {
					player.move(DIRECTION.NORTHEAST);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵ض�����û�г��ڣ�");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		if (inputs[0].equals("nw") || inputs[0].equals("northwest")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.NORTHWEST)!=null) {
					player.move(DIRECTION.NORTHWEST);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵�������û�г��ڣ�");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("se") || inputs[0].equals("southeast")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.SOUTHEAST)!=null) {
					player.move(DIRECTION.SOUTHEAST);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵ض��ϱ�û�г��ڣ�");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("sw") || inputs[0].equals("southwest")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.SOUTHWEST)!=null) {
					player.move(DIRECTION.SOUTHWEST);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵����ϱ�û�г��ڣ�");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("u") || inputs[0].equals("up")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.UP)!=null) {
					player.move(DIRECTION.UP);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵��Ϸ�û�г��ڣ�");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if (inputs[0].equals("d") || inputs[0].equals("down")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//��ȡ��ҵ�ǰ���ڷ���
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.DOWN)!=null) {
					player.move(DIRECTION.DOWN);
				}
				else {
					MessageManagement.showToPlayer(player, "�˵��·�û�г��ڣ�");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "��ȡ������Ϣʧ��");
			}
			return;
		}
		else if(inputs[0].equals("help")) {
			MessageManagement.showToPlayer(player, "quit:�˳�");
			MessageManagement.showToPlayer(player, "attack+�û�id:����ָ�����");
			MessageManagement.showToPlayer(player, "talk with+�û�id+��Ϣ:��ָ����ҷ�����Ϣ");
			MessageManagement.showToPlayer(player, "talk with+all+��Ϣ:�򷿼�������������ҷ�����Ϣ");
			MessageManagement.showToPlayer(player, "n��north:���ƶ�");
			MessageManagement.showToPlayer(player, "s��south:�����ƶ�");
			MessageManagement.showToPlayer(player, "w��west:�����ƶ�");
			MessageManagement.showToPlayer(player, "e��east:���ƶ�");
			MessageManagement.showToPlayer(player, "ne��northeast:�򶫱��ƶ�");
			MessageManagement.showToPlayer(player, "nw��northwest:�������ƶ�");
			MessageManagement.showToPlayer(player, "se��southeast:�����ƶ�");
			MessageManagement.showToPlayer(player, "sw��southwest:�������ƶ�");
			MessageManagement.showToPlayer(player, "u��up:�����ƶ�");
			MessageManagement.showToPlayer(player, "d��down:�����ƶ�");
			MessageManagement.showToPlayer(player, "help:��ȡ�����ĵ�");
		}		
	}
}

