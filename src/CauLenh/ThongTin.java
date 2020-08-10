package CauLenh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class ThongTin extends TrungTamLenh {

	public ThongTin(EssentialsTiengViet plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.thongtin") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(KhongQuyen());
			return true;
		}

		// Nhận lệnh
		if (label.equalsIgnoreCase("thongtin") || label.equalsIgnoreCase("info") || label.equalsIgnoreCase("in4")
				|| label.equalsIgnoreCase("information")) {

			// Nếu chỉ nhập lệnh và nhiều hơn 1 tên
			if (args.length == 0 || args.length > 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			String symbols = "&a&m&l-=-=-=-=-=-=-=&r ";

			// Lấy thông tin người được nêu tên
			Player muctieu = plugin.getServer().getPlayer(args[0]);

			// Kiểm tra người chơi có online không
			if (muctieu == null) {

				sender.sendMessage(msgLayChu("KhongOnline"));
				return true;
			}

			// Lấy tọa độ
			Double X = muctieu.getLocation().getX();
			Double Y = muctieu.getLocation().getY();
			Double Z = muctieu.getLocation().getZ();
			String thegioi = muctieu.getWorld().getName();

			// Lấy IP
			String ip = muctieu.getAddress().getHostName();

			sender.sendMessage(Chat.mau(symbols + prefix + symbols));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&eThông tin người chơi: &r" + muctieu.getDisplayName()));
			sender.sendMessage(Chat.mau("&eTên đăng nhập: &r" + muctieu.getName()));
			sender.sendMessage(Chat.mau("&eMã UUID: &b" + muctieu.getUniqueId()));
			sender.sendMessage("");
			sender.sendMessage(
					Chat.mau("&eTọa độ: &bX:" + Math.round(X) + " Y:" + Math.round(Y) + " Y:" + Math.round(Z)));
			sender.sendMessage(Chat.mau("&eThế giới: &b" + thegioi));
			sender.sendMessage(Chat.mau("&eĐịa chỉ IP: &b" + ip));
		}

		return true;
	}
}
