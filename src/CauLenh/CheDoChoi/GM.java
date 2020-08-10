package CauLenh.CheDoChoi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class GM extends TrungTamCheDoChoi {

	public GM(EssentialsTiengViet plugin) {
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

		// Lấy thông tin người chơi
		Player player = (Player) sender;

		// Nhận lệnh
		if (label.equalsIgnoreCase("gm")) {

			// Nếu chỉ nhập lệnh hoặc nhiều hơn dữ kiện cho phép
			if (args.length == 0 || args.length > 2) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/gm [chế độ] [người chơi]"));
				return true;
			}

			// Nếu chỉ nhập chế độ chơi
			if (args.length == 1) {

				// Áp dụng biến đặt chế độ chơi
				DatCheDoChoi(player, player, args[0]);
				return true;
			}

			// Nếu có thêm tên người chơi
			if (args.length == 2) {

				// Kiểm tra quyền
<<<<<<< HEAD
				if (!sender.hasPermission("estv.gamemode.nguoikhac")) {
=======
				if (!(sender.hasPermission("estv.gamemode.nguoikhac") || sender.hasPermission("estv.*"))) {
>>>>>>> 06ae6d4... v0.5 BETA

					sender.sendMessage(KhongQuyen());
					return true;
				}

				// Lấy thông tin người nhận
				Player muctieu = plugin.getServer().getPlayer(args[1]);

				// Áp dụng biến đặt chế độ chơi
				DatCheDoChoi(player, muctieu, args[0]);
			}

		}
		return true;
	}
}
