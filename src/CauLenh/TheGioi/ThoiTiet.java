package CauLenh.TheGioi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import TepTin.Message;

public class ThoiTiet implements CommandExecutor {

	EssentialsTiengViet plugin;

	public ThoiTiet(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		plugin.msg = new Message(plugin);

		// Lấy tiền tố trong config.yml
<<<<<<< HEAD
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.thoitiet") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(Chat.mau(plugin.msg.LayDuLieu().getString("KhongQuyen")));
=======
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.thoitiet") || sender.hasPermission("estv.*"))) {
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

		// Nhận lệnh - Trời trong lành
		if (label.equalsIgnoreCase("nang") || label.equalsIgnoreCase("tronglanh") || label.equalsIgnoreCase("sun")
				|| label.equalsIgnoreCase("sunny")) {

			if (args.length > 0) {

				player.sendMessage(Chat.mau(prefix + "&6&l/" + label));
				return true;
			}
			player.getWorld().setStorm(false);
			player.getWorld().setThundering(false);
<<<<<<< HEAD
			player.sendMessage(Chat.mau(prefix + plugin.msg.LayDuLieu().getString("ChuyenThoiTiet")
=======
			player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("ChuyenThoiTiet")
>>>>>>> 06ae6d4... v0.5 BETA
					.replace("{0}", "trong lành").replace("{1}", player.getWorld().getName())));
			return true;
		}

		// Nhận lệnh - Trời mưa/bão
		if (label.equalsIgnoreCase("mua") || label.equalsIgnoreCase("rain") || label.equalsIgnoreCase("samchop")
				|| label.equalsIgnoreCase("thunder") || label.equalsIgnoreCase("rainy")
				|| label.equalsIgnoreCase("bao")) {

			if (args.length > 0) {

				player.sendMessage(Chat.mau(prefix + "&6&l/" + label));
				return true;
			}

			player.getWorld().setStorm(true);
<<<<<<< HEAD
			player.sendMessage(Chat.mau(prefix + plugin.msg.LayDuLieu().getString("ChuyenThoiTiet")
=======
			player.sendMessage(Chat.mau(prefix + plugin.msg.layDuLieu().getString("ChuyenThoiTiet")
>>>>>>> 06ae6d4... v0.5 BETA
					.replace("{0}", "bão").replace("{1}", player.getWorld().getName())));
			return true;
		}
		return true;
	}
}
