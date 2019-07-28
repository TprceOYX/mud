package Controller;

import java.io.*;
import java.util.*;

import Model.Player;

public class MessageManagement {
	static HashMap<String, PrintWriter> playerChannels = new HashMap<String, PrintWriter>(); // 服务器向其添加

	public static void showToPlayer(Player player, String message) {
		playerChannels.get(player.getId()).println(message);
		playerChannels.get(player.getId()).flush();
	}

	public static void addPlayerChannels(String playerId, PrintWriter bw) {
		playerChannels.put(playerId, bw);
	}

	public static void removePlayerChannels(String playerId) {
		playerChannels.remove(playerId);
	}
}
