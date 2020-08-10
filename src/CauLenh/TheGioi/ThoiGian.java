package CauLenh.TheGioi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import TepTin.Message;

public class ThoiGian implements CommandExecutor {

	EssentialsTiengViet plugin;

	public ThoiGian(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		plugin.msg = new Message(plugin);

		// Lấy tiền tố trong config.yml
<<<<<<< HEAD
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.thoigian") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(Chat.mau(plugin.msg.LayDuLieu().getString("KhongQuyen")));
=======
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.thoigian") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(Chat.mau(plugin.msg.layDuLieu().getString("KhongQuyen")));
>>>>>>> 06ae6d4... v0.5 BETA
			return true;
		}

		// Bắt buộc người thi hành lệnh là người chơi
		if (!(sender instanceof Player)) {
			sender.sendMessage(Chat.mau(prefix + "Chỉ người chơi mới được thi hành lệnh này"));
<<<<<<< HEAD
=======
			return true;
>>>>>>> 06ae6d4... v0.5 BETA
		}

		Player player = (Player) sender;

		// Nhận lệnh - Sáng
		if (label.equalsIgnoreCase("sang") || label.equalsIgnoreCase("day")) {

			player.getWorld().setTime(0);
<<<<<<< HEAD
			player.sendMessage(Chat.mau(prefix + plugin.msg.LayDuLieu().getString("ChuyenThoiGian")
=======
			player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("ChuyenThoiGian")
>>>>>>> 06ae6d4... v0.5 BETA
					.replace("{0}", "6:00AM").replace("{1}", player.getWorld().getName())));
			return true;
		}

		// Nhận lệnh - Trưa
		if (label.equalsIgnoreCase("trua") || label.equalsIgnoreCase("noon") || label.equalsIgnoreCase("midday")) {

			player.getWorld().setTime(6000);
<<<<<<< HEAD
			player.sendMessage(Chat.mau(prefix + plugin.msg.LayDuLieu().getString("ChuyenThoiGian")
=======
			player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("ChuyenThoiGian")
>>>>>>> 06ae6d4... v0.5 BETA
					.replace("{0}", "12:00PM").replace("{1}", player.getWorld().getName())));
			return true;
		}

		// Nhận lệnh - Chiều
		if (label.equalsIgnoreCase("chieu") || label.equalsIgnoreCase("afternoon")) {

			player.getWorld().setTime(12000);
<<<<<<< HEAD
			player.sendMessage(Chat.mau(prefix + plugin.msg.LayDuLieu().getString("ChuyenThoiGian")
=======
			player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("ChuyenThoiGian")
>>>>>>> 06ae6d4... v0.5 BETA
					.replace("{0}", "18:00PM").replace("{1}", player.getWorld().getName())));
			return true;
		}

		// Nhận lệnh - Tồi
		if (label.equalsIgnoreCase("toi") || label.equalsIgnoreCase("khuya") || label.equalsIgnoreCase("night")
				|| label.equalsIgnoreCase("midnight")) {

			player.getWorld().setTime(18000);
<<<<<<< HEAD
			player.sendMessage(Chat.mau(prefix + plugin.msg.LayDuLieu().getString("ChuyenThoiGian")
=======
			player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("ChuyenThoiGian")
>>>>>>> 06ae6d4... v0.5 BETA
					.replace("{0}", "00:00AM").replace("{1}", player.getWorld().getName())));
			return true;
		}
		return true;
	}
}
