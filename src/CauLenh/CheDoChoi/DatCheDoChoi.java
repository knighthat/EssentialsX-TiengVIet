package CauLenh.CheDoChoi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class DatCheDoChoi extends TrungTamCheDoChoi {

	public DatCheDoChoi(EssentialsTiengViet plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
<<<<<<< HEAD
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");
=======
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
>>>>>>> 06ae6d4... v0.5 BETA

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.gamemode") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(KhongQuyen());
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

		// Nhận lệnh - GMS
		if (label.equalsIgnoreCase("gms") || label.equalsIgnoreCase("sinhton") || label.equalsIgnoreCase("gm0")
				|| label.equalsIgnoreCase("survival")) {

			// Nếu nhập nhiều hơn số lượng các dữ kiện cho phép
			if (args.length > 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			// Nếu có tên người chơi
			if (args.length == 1) {

				// Kiểm tra quyền
<<<<<<< HEAD
				if (!sender.hasPermission("estv.gamemode.nguoikhac")) {
=======
				if (!(sender.hasPermission("estv.gamemode.nguoikhac") || sender.hasPermission("estv.*"))) {
>>>>>>> 06ae6d4... v0.5 BETA
					sender.sendMessage(KhongQuyen());
				}

				// Lấy thông tin người nhận
				Player muctieu = plugin.getServer().getPlayer(args[0]);

				// Áp dụng biến đặt chế độ chơi
				DatCheDoChoi(player, muctieu, label);
				return true;
			}

			// Áp dụng biến đặt chế độ chơi
			DatCheDoChoi(player, player, label);
			return true;
		}

		// Nhận lệnh - GMC
		if (label.equalsIgnoreCase("gmc") || label.equalsIgnoreCase("sangtao") || label.equalsIgnoreCase("gm1")
				|| label.equalsIgnoreCase("creative")) {

			if (args.length > 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			if (args.length == 1) {

<<<<<<< HEAD
				if (!sender.hasPermission("estv.gamemode.nguoikhac")) {
=======
				if (!(sender.hasPermission("estv.gamemode.nguoikhac") || sender.hasPermission("estv.*"))) {
>>>>>>> 06ae6d4... v0.5 BETA
					sender.sendMessage(KhongQuyen());
				}
				Player muctieu = plugin.getServer().getPlayer(args[0]);
				DatCheDoChoi(player, muctieu, label);
				return true;
			}

			DatCheDoChoi(player, player, label);
			return true;
		}

		// Nhận lệnh - GMA
		if (label.equalsIgnoreCase("gma") || label.equalsIgnoreCase("khampha") || label.equalsIgnoreCase("gm2")
				|| label.equalsIgnoreCase("adventure")) {

			if (args.length > 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			if (args.length == 1) {

<<<<<<< HEAD
				if (!sender.hasPermission("estv.gamemode.nguoikhac")) {
=======
				if (!(sender.hasPermission("estv.gamemode.nguoikhac") || sender.hasPermission("estv.*"))) {
>>>>>>> 06ae6d4... v0.5 BETA
					sender.sendMessage(KhongQuyen());
				}
				Player muctieu = plugin.getServer().getPlayer(args[0]);
				DatCheDoChoi(player, muctieu, label);
				return true;
			}

			DatCheDoChoi(player, player, label);
			return true;
		}

		// Nhận lệnh - GMSP
		if (label.equalsIgnoreCase("gmsp") || label.equalsIgnoreCase("khangia") || label.equalsIgnoreCase("gm3")
				|| label.equalsIgnoreCase("spectator")) {

			if (args.length > 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			if (args.length == 1) {

<<<<<<< HEAD
				if (!sender.hasPermission("estv.gamemode.nguoikhac")) {
=======
				if (!(sender.hasPermission("estv.gamemode.nguoikhac") || sender.hasPermission("estv.*"))) {
>>>>>>> 06ae6d4... v0.5 BETA
					sender.sendMessage(KhongQuyen());
				}
				Player muctieu = plugin.getServer().getPlayer(args[0]);
				DatCheDoChoi(player, muctieu, label);
				return true;
			}

			DatCheDoChoi(player, player, label);
			return true;
		}
		return true;
	}
}
