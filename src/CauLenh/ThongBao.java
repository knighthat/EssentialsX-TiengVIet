package CauLenh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class ThongBao extends TrungTamLenh implements Listener {

	public ThongBao(EssentialsTiengViet plugin) {
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

		// Nhận lệnh
		if (label.equalsIgnoreCase("thongbao") || label.equalsIgnoreCase("broadcast")
				|| label.equalsIgnoreCase("loalon")) {

			// Nếu chỉ nhập lệnh mà không nhập dữ kiện
			if (args.length == 0) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [tin nhắn]"));
				return true;
			}

			// Kiểm tra nếu được phép thêm tiền tố cho thông báo
			if (cfgLayGiaTri("ThongBao.BatTienTo")) {

				// Tạo biến cho tiền tố
<<<<<<< HEAD
				String thongbao = plugin.cfg.LayDuLieu().getString("ThongBao.TienTo");
=======
				String thongbao = plugin.cfg.layDuLieu().getString("ThongBao.TienTo");
>>>>>>> 06ae6d4... v0.5 BETA

				// Gửi thông báo kém tiền tố
				for (Player i : plugin.getServer().getOnlinePlayers()) {
					i.sendMessage(Chat.mau(thongbao + Chat.LayDoanChat(args, 0)));
				}

				return true;
			} else {

				// Gửi thông báo không kèm tiền tố
				for (Player i : plugin.getServer().getOnlinePlayers()) {
					i.sendMessage(Chat.mau(Chat.LayDoanChat(args, 0)));
				}
				return true;
			}
		}
		return true;
	}
}
