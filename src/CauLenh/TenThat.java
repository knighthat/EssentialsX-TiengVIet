package CauLenh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class TenThat extends TrungTamLenh {

	public TenThat(EssentialsTiengViet plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.tenthat") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(KhongQuyen());
			return true;
		}

		// Nhận lệnh
		if (label.equalsIgnoreCase("tenthat") || label.equalsIgnoreCase("ten") || label.equalsIgnoreCase("realname")
				|| label.equalsIgnoreCase("real")) {

			// Nếu chỉ nhập lệnh hoặc nhiều hơn 1 tên
			if (args.length == 0) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [biệt danh]"));
				return true;
			}

			// Lấy biệt danh
			String bietdanh = Chat.BoMau(Chat.LayDoanChat(args, 0));

			// So sánh với bietdanh.yml
			for (Player i : plugin.getServer().getOnlinePlayers()) {
				if (Chat.BoMau(i.getDisplayName()).equals(bietdanh)) {

					// Trả thông tin
					sender.sendMessage(msgLayChu("TenThat").replace("{BIETDANH}", i.getDisplayName()).replace("{TEN}",
							i.getName()));
					return true;
				}
			}

			sender.sendMessage(Chat.mau(prefix + "&cKhông tìm thấy &r" + bietdanh));
		}

		return true;
	}
}
