package SuKien;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class Dinhdangchat implements Listener {

	EssentialsTiengViet plugin;

	public Dinhdangchat(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

	// Khi người chơi đăng 1 dòng tin nhắn
	@EventHandler(priority = EventPriority.MONITOR)
	public void onChat(AsyncPlayerChatEvent e) {

		// Tạo biến
		String doanchat = e.getMessage();
		Player player = e.getPlayer();
		String ten = player.getName();
		String bietdanh = player.getDisplayName();
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Kiểm tra nếu cho phép bộ lọc hoạt động
		if (plugin.cfg.layDuLieu().getBoolean("LocTuNgu.Bat")) {

			// Kiểm tra đoạn chat của người chơi
			for (String i : plugin.cfg.layDuLieu().getStringList("LocTuNgu.DanhSachDen")) {
				if (doanchat.contains(i)) {
					e.setCancelled(true);
					player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("TuCam")));
				}
			}

			// Nếu người chơi được phép chat màu
			if (player.hasPermission("estv.chatmau")) {
				e.setFormat(Chat.mau(plugin.cfg.layDuLieu().getString("DinhDangChat").replace("{TEN}", ten)
						.replace("{BIETDANH}", bietdanh).replace("{DOANCHAT}", doanchat)));
			} else {
				e.setFormat(plugin.cfg.layDuLieu().getString("DinhDangChat").replace("{TEN}", ten)
						.replace("{BIETDANH}", Chat.mau(bietdanh)).replace("{DOANCHAT}", doanchat));
			}
		} else {

			// Nếu người chơi được phép chat màu
			if (player.hasPermission("estv.chatmau")) {
				e.setFormat(Chat.mau(plugin.cfg.layDuLieu().getString("DinhDangChat").replace("{TEN}", ten)
						.replace("{BIETDANH}", bietdanh).replace("{DOANCHAT}", doanchat)));
			} else {
				e.setFormat(plugin.cfg.layDuLieu().getString("DinhDangChat").replace("{TEN}", ten)
						.replace("{BIETDANH}", Chat.mau(bietdanh)).replace("{DOANCHAT}", doanchat));
			}
		}
	}
}
