package CauLenh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class GuiTinNhan extends TrungTamLenh {

	public GuiTinNhan(EssentialsTiengViet plugin) {
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
		if (!(sender.hasPermission("estv.msg") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(KhongQuyen());
			return true;
		}

		// Nhận lệnh
		if (label.equalsIgnoreCase("tinnhan") || label.equalsIgnoreCase("gui") || label.equalsIgnoreCase("msg")
				|| label.equalsIgnoreCase("message")) {

			// Tạo biến cho tên người gửi đi
			String tengui = "";

			// Nếu người gửi là người chơi là
			if (sender instanceof Player) {
				Player nguoigui = (Player) sender;
				tengui = nguoigui.getDisplayName();
			} else {

				// Nếu là bảng điều khiển thì lấy tên trong config.yml
<<<<<<< HEAD
				tengui = Chat.mau(plugin.cfg.LayDuLieu().getString("Console"));
=======
				tengui = Chat.mau(plugin.cfg.layDuLieu().getString("Console"));
>>>>>>> 06ae6d4... v0.5 BETA
			}

			// Nếu chỉ nhập lệnh hoặc lệnh và tên người chơi thì hiển thị lệnh giúp đỡ
			if (args.length == 0 || args.length == 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi] [tin nhắn]"));
				return true;
			}

			// Lấy thông tin người nhận
			Player nguoinhan = plugin.getServer().getPlayer(args[0]);

			// Kiểm tra nếu người chơi có online
			if (nguoinhan == null) {

				sender.sendMessage(msgLayChu("KhongOnline"));
			}

			// Tạo biến cho tên người nhận và lấy tin nhắn
			String tennhan = nguoinhan.getDisplayName();
			String tinnhan = Chat.LayDoanChat(args, 1);

<<<<<<< HEAD
			// Gửi tin nhắn cho người nhận và người gửi
			nguoinhan.sendMessage(Chat.mau("&f[&r" + tengui + " &7-> &6bạn&f] &c>>&r " + tinnhan));
			sender.sendMessage(Chat.mau("&f[&6bạn&7 ->&r " + tennhan + "&f] &c>>&r " + tinnhan));
=======
			// Kiểm tra quyền
			if (!(sender.hasPermission("estv.chatmau") || sender.hasPermission("estv.*"))) {

				// Gửi tin nhắn cho người nhận và người gửi
				nguoinhan.sendMessage(Chat.mau("&f[&r" + tengui + " &7-> &6bạn&f] &c>>&r ") + tinnhan);
				sender.sendMessage(Chat.mau("&f[&6bạn&7 ->&r " + tennhan + "&f] &c>>&r ") + tinnhan);
				return true;
			} else {

				// Gửi tin nhắn cho người nhận và người gửi
				nguoinhan.sendMessage(Chat.mau("&f[&r" + tengui + " &7-> &6bạn&f] &c>>&r " + tinnhan));
				sender.sendMessage(Chat.mau("&f[&6bạn&7 ->&r " + tennhan + "&f] &c>>&r " + tinnhan));
				return true;
			}
>>>>>>> 06ae6d4... v0.5 BETA
		}

		return true;
	}

}
