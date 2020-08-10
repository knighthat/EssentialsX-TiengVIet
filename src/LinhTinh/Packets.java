package LinhTinh;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle.EnumTitleAction;

public class Packets {

	public static void Title(Player players, String DoanTieuDe, String DoanPhuDe) {
		IChatBaseComponent TieuDe = ChatSerializer.a("{\"text\": \"" + DoanTieuDe + "\"}");
		IChatBaseComponent PhuDe = ChatSerializer.a("{\"text\": \"" + DoanPhuDe + "\"}");
		PacketPlayOutTitle phude = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, PhuDe);
		PacketPlayOutTitle tieude = new PacketPlayOutTitle(EnumTitleAction.TITLE, TieuDe);
		((CraftPlayer) players).getHandle().playerConnection.sendPacket(tieude);
		((CraftPlayer) players).getHandle().playerConnection.sendPacket(phude);
	}

	private static final Map<Player, BukkitTask> PENDING_MESSAGES = new HashMap<>();

	public static void sendActionBarMessage(Player bukkitPlayer, String message) {
		sendRawActionBarMessage(bukkitPlayer, "{\"text\": \"" + message + "\"}");
	}

	public static void sendRawActionBarMessage(Player bukkitPlayer, String rawMessage) {
		CraftPlayer player = (CraftPlayer) bukkitPlayer;
		IChatBaseComponent chatBaseComponent = ChatSerializer.a(rawMessage);
		PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chatBaseComponent, (byte) 2);
		player.getHandle().playerConnection.sendPacket(packetPlayOutChat);
	}

	public static void sendActionBarMessage(final Player bukkitPlayer, final String message, final int duration,
			Plugin plugin) {
		cancelPendingMessages(bukkitPlayer);
		final BukkitTask messageTask = new BukkitRunnable() {
			private int count = 0;

			@Override
			public void run() {
				if (count >= (duration - 3)) {
					this.cancel();
				}
				sendActionBarMessage(bukkitPlayer, message);
				count++;
			}
		}.runTaskTimer(plugin, 0L, 20L);
		PENDING_MESSAGES.put(bukkitPlayer, messageTask);
	}

	private static void cancelPendingMessages(Player bukkitPlayer) {
		if (PENDING_MESSAGES.containsKey(bukkitPlayer)) {
			PENDING_MESSAGES.get(bukkitPlayer).cancel();
		}
	}
}
