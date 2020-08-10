package CauLenh;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class DoiTen extends TrungTamLenh {

	public DoiTen(EssentialsTiengViet plugin) {
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
		if (!(sender.hasPermission("estv.doiten") || sender.hasPermission("estv.*"))) {
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

		// Lấy thông tin người gửi (người chơi)
		Player player = (Player) sender;

		// Nhận lệnh
		if (label.equalsIgnoreCase("bietdanh") || label.equalsIgnoreCase("doiten") || label.equalsIgnoreCase("nick")
				|| label.equalsIgnoreCase("nickname")) {

			// Chỉ nhập lệnh
			if (args.length == 0) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [tên mới]"));
				return true;
			}

			// Đếm số lượng ký tự
			String tenmoi = Chat.mau(Chat.LayDoanChat(args, 0));
			int slkt = 0;
			for (int i = 0; i < tenmoi.length(); i++) {
				if (tenmoi.charAt(i) == '§') {
					slkt--;
				} else {
					slkt++;
				}
			}

			// Nếu tên có số ký tự ít hơn cho phép
			if (slkt < cfgLaySo("BietDanh.ToiThieu")) {

				sender.sendMessage(msgLayChu("BietDanh.TenQuaNgan"));
				return true;
			}

			// Nếu tên dài hơn cho phép
			if (slkt > cfgLaySo("BietDanh.ToiDa")) {

				sender.sendMessage(msgLayChu("BietDanh.TenQuaDai"));
				return true;
			}

			// Nếu người chơi có quyền không bị kiểm tra tên đã chọn
			if (sender.hasPermission("estv.doiten.bypass")) {

				// Lưu biệt danh
<<<<<<< HEAD
				plugin.bd.LayDuLieu().set(player.getName(), Chat.mau(Chat.LayDoanChat(args, 0)));
				plugin.bd.LuuDuLieu();
=======
				plugin.bd.layDuLieu().set(player.getName(), Chat.mau(Chat.LayDoanChat(args, 0)));
				plugin.bd.luuDuLieu();
>>>>>>> 06ae6d4... v0.5 BETA

				// Thông báo đến người chơi
				player.sendMessage(msgLayChu("BietDanh.ThanhCong").replace("{TENCU}", player.getDisplayName())
						.replace("{TENMOI}", tenmoi));

				// Thông báo đến toàn bộ người chơi
				if (cfgLayGiaTri("BietDanh.BatThongBao")) {

					for (Player p : plugin.getServer().getOnlinePlayers()) {
						p.sendMessage(msgLayChu("BietDanh.ThongBao").replace("{TENCU}", player.getDisplayName())
								.replace("{TENMOI}", tenmoi));
					}
				}

				// Đặt biệt danh cho người chơi
				player.setDisplayName(tenmoi);
			} else {

				// Kiểm tra tên bị cấm
<<<<<<< HEAD
				for (String i : plugin.cfg.LayDuLieu().getStringList("BietDanh.DanhSachDen")) {
=======
				for (String i : plugin.cfg.layDuLieu().getStringList("BietDanh.DanhSachDen")) {
>>>>>>> 06ae6d4... v0.5 BETA
					if (ChatColor.stripColor(tenmoi).contains(i)) {
						sender.sendMessage(msgLayChu("BietDanh.TenBiCam"));
						return true;
					}
				}

				// Lưu biệt danh
<<<<<<< HEAD
				plugin.bd.LayDuLieu().set(player.getName(), Chat.mau(Chat.LayDoanChat(args, 0)));
				plugin.bd.LuuDuLieu();
=======
				plugin.bd.layDuLieu().set(player.getName(), Chat.mau(Chat.LayDoanChat(args, 0)));
				plugin.bd.luuDuLieu();
>>>>>>> 06ae6d4... v0.5 BETA

				// Thông báo đến người chơi
				player.sendMessage(msgLayChu("BietDanh.ThanhCong").replace("{TENCU}", player.getDisplayName())
						.replace("{TENMOI}", tenmoi));

				// Thông báo đến toàn bộ người chơi
				if (cfgLayGiaTri("BietDanh.BatThongBao")) {

					for (Player p : plugin.getServer().getOnlinePlayers()) {
						p.sendMessage(msgLayChu("BietDanh.ThongBao").replace("{TENCU}", player.getDisplayName())
								.replace("{TENMOI}", tenmoi));
					}
				}

				// Đặt biệt danh cho người chơi
				player.setDisplayName(tenmoi);
			}
		}
		return true;
	}
}
