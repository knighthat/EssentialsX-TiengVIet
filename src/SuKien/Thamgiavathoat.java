package SuKien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import TepTin.Bietdanh;

public class Thamgiavathoat implements Listener {
	EssentialsTiengViet plugin;

	public Thamgiavathoat(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

	// Khi người chơi kết nối đến Server
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) throws IOException {

		// Lấy thông tin người chơi
		Player player = e.getPlayer();

		// Nếu người chơi tham gia lần đầu
		if (!player.hasPlayedBefore()) {

			// Ghi tên vào bietdanh.yml
			plugin.bd.layDuLieu().set(player.getName(), player.getName());
			plugin.bd.luuDuLieu();

			// Gửi thông báo cho toàn bộ người chơi
			player.setDisplayName(plugin.bd.layDuLieu().getString(player.getName()));
			e.setJoinMessage(Chat.mau(plugin.msg.layDuLieu().getString("ThamGia.LanDau")
					.replace("{TEN}", player.getName()).replace("{BIETDANH}", player.getDisplayName())));
		} else {

			// Nếu tên không có trong bietdanh.yml thì tạo lại
			if (plugin.bd.layDuLieu().getString(player.getName()) == null) {
				plugin.bd = new Bietdanh(plugin);
				plugin.bd.layDuLieu().set(player.getName(), player.getName());
				plugin.bd.luuDuLieu();
			}

			// Gủi thông báo cho toàn bộ người chơi
			player.setDisplayName(plugin.bd.layDuLieu().getString(player.getName()));
			e.setJoinMessage(Chat.mau(plugin.msg.layDuLieu().getString("ThamGia.KetNoi")
					.replace("{TEN}", player.getName()).replace("{BIETDANH}", player.getDisplayName())));
		}

		// Kiểm tra nếu bảng giới thiệu được bật trong config.yml
		if (plugin.cfg.layDuLieu().getBoolean("BatBangGioiThieu")) {

			// Truy cập banggioithieu.txt
			File file = new File(plugin.getDataFolder(), "banggioithieu.txt");
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

			// Tạo biến
			String line = null;
			int dangchoi = Bukkit.getOnlinePlayers().size();

			// Gửi tất cả các dòng trong banggioithieu.txt
			while ((line = in.readLine()) != null)
				player.sendMessage(Chat.mau(line).replace("{TEN}", player.getName())
						.replace("{BIETDANH}", player.getDisplayName())
						.replace("{SERVER}", plugin.cfg.layDuLieu().getString("TenMayChu"))
						.replace("{ONLINE}", "" + dangchoi).replace("{MAX}", "" + plugin.getServer().getMaxPlayers()));
		}
	}

	// Khi người chơi rời máy chủ
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e) {

		// Lấy thông tin người chơi
		Player player = e.getPlayer();

		// Gửi thông báo cho toàn bộ người chơi
		plugin.bd.layDuLieu().set(player.getName(), player.getDisplayName());
		plugin.bd.luuDuLieu();
		e.setQuitMessage(Chat.mau(plugin.msg.layDuLieu().getString("ThamGia.NgatKetNoi")
				.replace("{TEN}", player.getName()).replace("{BIETDANH}", player.getDisplayName())));
	}
}