package Controller;

import Controller.CommonContent.DIRECTION;
import Model.Player;
import Model.Room;

public class UserInput {
	public static void dealInput(Player player, String inputMessage) {
		/*
		 * 可以处理的命令 l,look e,east,w,west,n,north,s,south,
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
					MessageManagement.showToPlayer(player, "找不到该玩家！");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "玩家名字不能为空！");
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
					MessageManagement.showToPlayer(player, "发送的信息不能为空！");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "指令错误！");
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
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.EAST)!=null) {
					player.move(DIRECTION.EAST);
				}
				else {
					MessageManagement.showToPlayer(player, "此地东边没有出口！");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("w") || inputs[0].equals("west")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.WEST)!=null) {
					player.move(DIRECTION.WEST);
				}
				else {
					MessageManagement.showToPlayer(player, "此地西边没有出口！");
				}				
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("s") || inputs[0].equals("south")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.SOUTH)!=null) {
					player.move(DIRECTION.SOUTH);
				}
				else {
					MessageManagement.showToPlayer(player, "此地南边没有出口！");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("n") || inputs[0].equals("north")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.NORTH)!=null) {
					player.move(DIRECTION.NORTH);
				}
				else {
					MessageManagement.showToPlayer(player, "此地北边没有出口！");
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("ne") || inputs[0].equals("northeast")) {
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.NORTHEAST)!=null) {
					player.move(DIRECTION.NORTHEAST);
				}
				else {
					MessageManagement.showToPlayer(player, "此地东北边没有出口！");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		if (inputs[0].equals("nw") || inputs[0].equals("northwest")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.NORTHWEST)!=null) {
					player.move(DIRECTION.NORTHWEST);
				}
				else {
					MessageManagement.showToPlayer(player, "此地西北边没有出口！");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("se") || inputs[0].equals("southeast")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.SOUTHEAST)!=null) {
					player.move(DIRECTION.SOUTHEAST);
				}
				else {
					MessageManagement.showToPlayer(player, "此地东南边没有出口！");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("sw") || inputs[0].equals("southwest")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.SOUTHWEST)!=null) {
					player.move(DIRECTION.SOUTHWEST);
				}
				else {
					MessageManagement.showToPlayer(player, "此地西南边没有出口！");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("u") || inputs[0].equals("up")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.UP)!=null) {
					player.move(DIRECTION.UP);
				}
				else {
					MessageManagement.showToPlayer(player, "此地上方没有出口！");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if (inputs[0].equals("d") || inputs[0].equals("down")) {
			
			Room r=RoomManagement.cityMap.get(player.getLocation());       					//获取玩家当前所在房间
			if(r!=null) {
				if(r.getRoom(CommonContent.DIRECTION.DOWN)!=null) {
					player.move(DIRECTION.DOWN);
				}
				else {
					MessageManagement.showToPlayer(player, "此地下方没有出口！");
					
				}
			}
			else {
				MessageManagement.showToPlayer(player, "获取房间信息失败");
			}
			return;
		}
		else if(inputs[0].equals("help")) {
			MessageManagement.showToPlayer(player, "quit:退出");
			MessageManagement.showToPlayer(player, "attack+用户id:攻击指定玩家");
			MessageManagement.showToPlayer(player, "talk with+用户id+消息:向指定玩家发送消息");
			MessageManagement.showToPlayer(player, "talk with+all+消息:向房间内其他所有玩家发送消息");
			MessageManagement.showToPlayer(player, "n或north:向北移动");
			MessageManagement.showToPlayer(player, "s或south:向南移动");
			MessageManagement.showToPlayer(player, "w或west:向西移动");
			MessageManagement.showToPlayer(player, "e或east:向东移动");
			MessageManagement.showToPlayer(player, "ne或northeast:向东北移动");
			MessageManagement.showToPlayer(player, "nw或northwest:向西北移动");
			MessageManagement.showToPlayer(player, "se或southeast:向东南移动");
			MessageManagement.showToPlayer(player, "sw或southwest:向西南移动");
			MessageManagement.showToPlayer(player, "u或up:向上移动");
			MessageManagement.showToPlayer(player, "d或down:向下移动");
			MessageManagement.showToPlayer(player, "help:获取帮助文档");
		}		
	}
}

