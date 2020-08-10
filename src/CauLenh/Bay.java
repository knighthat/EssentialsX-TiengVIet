package CauLenh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class Bay extends TrungTamLenh {

	public Bay(EssentialsTiengViet plugin) {
		super(plugin);
	}

	public void DatBay(Player NguoiCho, Player NguoiNhan) {

		if (NguoiCho.equals(NguoiNhan)) {

			// Kiểm tra người chơi có đang được bay hay không
			if (NguoiNhan.getAllowFlight()) {

				// Tắt chế độ bay
				NguoiNhan.setAllowFlight(false);
				NguoiNhan.setFlying(false);
				NguoiNhan.sendMessage(msgLayChu("Bay.BanThan").replace("{0}", "tắt"));
			} else {

				// Tắt chế độ bay
				NguoiNhan.setAllowFlight(true);
				NguoiNhan.setFlying(true);
				NguoiNhan.sendMessage(msgLayChu("Bay.BanThan").replace("{0}", "bật"));
			}
		} else {

			// Kiểm tra người chơi có đang được bay hay không
			if (NguoiNhan.getAllowFlight()) {

				// Tắt chế độ bay
				NguoiNhan.setAllowFlight(false);
				NguoiNhan.setFlying(false);
				NguoiNhan.sendMessage(msgLayChu("Bay.NguoiNhan").replace("{0}", "tắt")
						.replace("{TEN}", NguoiCho.getName()).replace("{BIETDANH}", NguoiCho.getDisplayName()));
				NguoiCho.sendMessage(msgLayChu("Bay.NguoiCho").replace("{0}", "tắt")
						.replace("{TEN}", NguoiNhan.getName()).replace("{BIETDANH}", NguoiNhan.getDisplayName()));
			} else {

				// Bật chế độ bay
				NguoiNhan.setAllowFlight(true);
				NguoiNhan.setFlying(true);
				NguoiNhan.sendMessage(msgLayChu("Bay.NguoiNhan").replace("{0}", "bật").replace("{0}", "tắt")
						.replace("{TEN}", NguoiCho.getName()).replace("{BIETDANH}", NguoiCho.getDisplayName()));
				NguoiCho.sendMessage(msgLayChu("Bay.NguoiCho").replace("{0}", "bật")
						.replace("{TEN}", NguoiNhan.getName()).replace("{BIETDANH}", NguoiNhan.getDisplayName()));
			}
		}
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
		if (!(sender.hasPermission("estv.bay") || sender.hasPermission("estv.*"))) {
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
		if (label.equalsIgnoreCase("bay") || label.equalsIgnoreCase("fly")) {

			// Lấy thông tin người gửi (người chơi)
			Player player = (Player) sender;

			// Nếu nhập nhiều hơn lệnh và tên người chơi
			if (args.length > 1) {
				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			// Nếu không nhập tên -> Tự đặt cho bản thân
			if (args.length == 0) {

				DatBay(player, player);
				return true;
			}

			// Nếu đặt cho người chơi
			if (args.length == 1) {

				// Kiểm tra quyền
<<<<<<< HEAD
				if (!sender.hasPermission("estv.bay.nguoikhac")) {
=======
				if (!(sender.hasPermission("estv.bay.nguoikhac") || sender.hasPermission("estv.*"))) {
>>>>>>> 06ae6d4... v0.5 BETA
					sender.sendMessage(KhongQuyen());
				}

				// Lấy thông tin người nhận
				Player doituong = plugin.getServer().getPlayer(args[0]);

				// Kiểm tra người chơi có online
				if (doituong == null) {

					sender.sendMessage(msgLayChu("KhongOnline").replace("{0}", args[0]));
					return true;
				}

				DatBay(player, doituong);
			}

		}

		return true;
	}

}
