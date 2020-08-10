package CauLenh;

<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;

>>>>>>> 06ae6d4... v0.5 BETA
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import TepTin.Config;
import TepTin.Message;

public class TrungTamLenh implements CommandExecutor {

	EssentialsTiengViet plugin;

	public TrungTamLenh(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

<<<<<<< HEAD
	// config.yml
	public String cfgLayChu(String a) {
		plugin.cfg = new Config(plugin);
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");
		return Chat.mau(prefix + plugin.cfg.LayDuLieu().getString(a));
=======
	Map<Player, Boolean> xacnhan = new HashMap<Player, Boolean>();
	Map<Player, Long> thoigian = new HashMap<Player, Long>();

	// config.yml
	public String cfgLayChu(String a) {
		plugin.cfg = new Config(plugin);
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
		return Chat.mau(prefix + plugin.cfg.layDuLieu().getString(a));
>>>>>>> 06ae6d4... v0.5 BETA
	}

	public int cfgLaySo(String a) {
		plugin.cfg = new Config(plugin);
<<<<<<< HEAD
		return plugin.cfg.LayDuLieu().getInt(a);
=======
		return plugin.cfg.layDuLieu().getInt(a);
>>>>>>> 06ae6d4... v0.5 BETA
	}

	public boolean cfgLayGiaTri(String a) {
		plugin.cfg = new Config(plugin);
<<<<<<< HEAD
		return plugin.cfg.LayDuLieu().getBoolean(a);
=======
		return plugin.cfg.layDuLieu().getBoolean(a);
>>>>>>> 06ae6d4... v0.5 BETA
	}

	// message.yml
	public String msgLayChu(String a) {
		plugin.cfg = new Config(plugin);
<<<<<<< HEAD
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");
		plugin.msg = new Message(plugin);
		return Chat.mau(prefix + plugin.msg.LayDuLieu().getString(a));
=======
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
		plugin.msg = new Message(plugin);
		return Chat.mau(prefix + plugin.msg.layDuLieu().getString(a));
>>>>>>> 06ae6d4... v0.5 BETA
	}

	public int msgLaySo(String a) {
		plugin.cfg = new Config(plugin);
		plugin.msg = new Message(plugin);
<<<<<<< HEAD
		return plugin.msg.LayDuLieu().getInt(a);
=======
		return plugin.msg.layDuLieu().getInt(a);
>>>>>>> 06ae6d4... v0.5 BETA
	}

	public boolean msggLayGiaTri(String a) {
		plugin.cfg = new Config(plugin);
		plugin.msg = new Message(plugin);
<<<<<<< HEAD
		return plugin.msg.LayDuLieu().getBoolean(a);
=======
		return plugin.msg.layDuLieu().getBoolean(a);
>>>>>>> 06ae6d4... v0.5 BETA
	}

	public String KhongQuyen() {
		return msgLayChu("KhongQuyen");
	}

<<<<<<< HEAD
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.admin.reload") || sender.hasPermission("estv.*")
				|| sender.hasPermission("estv.admin.*"))) {
			sender.sendMessage(KhongQuyen());
			return true;
		}

		// Bắt buộc người thi hành lệnh là người chơi
		if (!(sender instanceof Player)) {
			sender.sendMessage(Chat.mau(prefix + "Chỉ người chơi mới được thi hành lệnh này"));
		}
=======
	public void HoiMau(CommandSender nguoigui, Player nguoinhan) {

		if (nguoigui.equals(nguoinhan)) {
			nguoinhan.setHealth(20);
			nguoinhan.setFoodLevel(20);
			nguoinhan.sendMessage(msgLayChu("HoiMau.BanThan"));
		} else {

			String ten = null;
			String bietdanh = null;
			if (nguoigui instanceof Player) {
				Player sender = (Player) nguoigui;
				ten = sender.getName();
				bietdanh = sender.getDisplayName();
			} else {
				ten = Chat.mau(plugin.cfg.layDuLieu().getString("Console"));
				bietdanh = Chat.mau(plugin.cfg.layDuLieu().getString("Console"));
			}
			nguoinhan.setHealth(20);
			nguoinhan.setFoodLevel(20);
			nguoinhan.sendMessage(msgLayChu("HoiMau.NguoiNhan").replace("{TEN}", ten).replace("{BIETDANH}", bietdanh));
			nguoigui.sendMessage(msgLayChu("HoiMau.NguoiNhan").replace("{TEN}", ten).replace("{BIETDANH}", bietdanh));
		}
		return;
	}

	public void XoaTui(Player player, Player muctieu) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		if (cfgLayGiaTri("XacNhanXoaTui")) {

			if (!xacnhan.containsKey(player)) {

				xacnhan.put(player, true);
				thoigian.put(player, (System.currentTimeMillis() + (10 * 1000)));
				player.sendMessage(Chat.mau(prefix + "&6Bạn có chắc muốn xóa túi của" + muctieu.getDisplayName()));
				return;
			}

			if (!(thoigian.get(player) > System.currentTimeMillis())) {

				player.sendMessage(Chat.mau(prefix + "&cĐã quá thời gian chờ! Vui lòng làm lại từ đầu"));
				xacnhan.remove(player);
				thoigian.remove(player);
				return;
			}

			xacnhan.remove(player);
			thoigian.remove(player);
		}

		player.getInventory().clear();
		if (!player.equals(muctieu)) {

			muctieu.sendMessage(msgLayChu("XoaTui.NguoiNhan").replace("{TEN}", player.getName()).replace("{BIETDANH}",
					player.getDisplayName()));
			player.sendMessage(msgLayChu("XoaTui.NguoiGui").replace("{TEN}", muctieu.getName()).replace("{BIETDANH}",
					muctieu.getDisplayName()));
		} else {
			player.getInventory().clear();
			player.sendMessage(msgLayChu("XoaTui.BanThan"));

		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
>>>>>>> 06ae6d4... v0.5 BETA

		// Nhận lệnh
		if (label.equalsIgnoreCase("estv") || label.equalsIgnoreCase("estiengviet")) {

<<<<<<< HEAD
			if (args[0].equalsIgnoreCase("reload")) {

				// Đọc và ghi dữ liệu từ các tệp tin vào bộ nhớ
				plugin.cfg.TaiLai();
				plugin.bd.TaiLai();
				plugin.msg.TaiLai();

				// Kiểm tra biệt danh
				for (Player p : plugin.getServer().getOnlinePlayers()) {
					if (plugin.bd.LayDuLieu().getString(p.getName()) == null) {
						plugin.bd.LayDuLieu().set(p.getName(), p.getDisplayName());
						plugin.bd.LuuDuLieu();
=======
			// Lệnh tải lại
			if (args.length == 1 && (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("tailai"))) {

				// Kiếm tra quyền
				if (!(sender.hasPermission("estv.admin.reload") || sender.hasPermission("estv.*")
						|| sender.hasPermission("estv.admin.*"))) {
					sender.sendMessage(KhongQuyen());
					return true;
				}

				// Đọc và ghi dữ liệu từ các tệp tin vào bộ nhớ
				plugin.cfg.taiLai();
				plugin.bd.taiLai();
				plugin.msg.taiLai();
				plugin.kv.taiLai();
				plugin.bgt.taiLai();

				// Kiểm tra biệt danh
				for (Player p : plugin.getServer().getOnlinePlayers()) {
					if (plugin.bd.layDuLieu().getString(p.getName()) == null) {
						plugin.bd.layDuLieu().set(p.getName(), p.getDisplayName());
						plugin.bd.layDuLieu();
>>>>>>> 06ae6d4... v0.5 BETA
					}
				}

				// Gửi thông báo tải lại thành công
				sender.sendMessage(msgLayChu("ThongBaoReload"));
				return true;
			}

<<<<<<< HEAD
			// Trợ giúp khi không đáp ứng các yêu cầu bên trên
			sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " trogiup"));
=======
			// Nếu không khớp với trường hợp nào bên trên thì chuyển vào class TroGiup
			TroGiup tg = new TroGiup(plugin);
			tg.onCommand(sender, cmd, label, args);
			return true;
		}

		if (label.equalsIgnoreCase("heal") || label.equalsIgnoreCase("hoimau") || label.equalsIgnoreCase("hoiphuc")) {

			// Kiểm tra quyền
			if (!sender.hasPermission("estv.hoimau")) {

				sender.sendMessage(KhongQuyen());
				return true;
			}

			// Nếu nhập nhiều hơn 1 tên
			if (args.length > 1) {

				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [người chơi]"));
				return true;
			}

			// Nếu chỉ nhập lệnh
			if (args.length == 0) {

				// Kiểm tra nếu người gửi là người chơi
				if (!(sender instanceof Player)) {

					sender.sendMessage(Chat.mau(prefix + "Chỉ người chơi mới được thi hành lệnh này"));
					return true;
				}

				// Lấy thông tin người chơi
				Player player = (Player) sender;

				// Thực hiện hồi máu
				HoiMau(player, player);
				return true;
			}

			// Lấy thông tin người được nhắc tên
			Player muctieu = plugin.getServer().getPlayer(args[0]);

			// Kiếm tra nếu người chơi offline
			if (muctieu == null) {

				sender.sendMessage(msgLayChu("KhongOnline").replace("{0}", args[0]));
				return true;
			}

			// Thực hiện hồi máu
			HoiMau(sender, muctieu);
			return true;
		}

		// Nhận lệnh
		if (label.equalsIgnoreCase("kill") || label.equalsIgnoreCase("giet") || label.equalsIgnoreCase("tieudiet")) {

			// Kiểm tra quyền
			if (!(sender.hasPermission("estv.tieudiet") || sender.hasPermission("estv.*"))) {

				sender.sendMessage(KhongQuyen());
				return true;
			}

			// Nếu không nhập gì ngoài lệnh
			if (args.length == 0) {

				// Kiểm tra nếu người gửi là người chơi
				if (!(sender instanceof Player)) {

					sender.sendMessage(Chat.mau(prefix + "Chỉ người chơi mới được thi hành lệnh này"));
					return true;
				}

				// Lấy thông tin người thi hành lệnh
				Player player = (Player) sender;

				// Đặt máu thành 0 - Chết
				player.setHealth(0);
				player.sendMessage(msgLayChu("TuTu"));
				return true;
			}

			// Lấy thông tin người được nêu tên
			Player muctieu = plugin.getServer().getPlayer(args[0]);

			// Kiếm tra nếu người chơi có online
			if (muctieu == null) {

				sender.sendMessage(msgLayChu("KhongOnline").replace("{0}", args[0]));
				return true;
			}

			// Đặt máu thành 0 - Chết
			muctieu.setHealth(0);
			sender.sendMessage(msgLayChu("TieuDiet").replace("{BIETDANH}", muctieu.getDisplayName()).replace("{TEN}",
					muctieu.getName()));
			return true;
		}

		// Nhận lệnh - Dọn túi
		if (label.equalsIgnoreCase("clear") || label.equalsIgnoreCase("dontui") || label.equalsIgnoreCase("xoatui")) {

			// Kiểm tra quyền
			if (!(sender.hasPermission("estv.xoatui") || sender.hasPermission("estv.*"))) {

				sender.sendMessage(KhongQuyen());
				return true;
			}

			// Kiểm tra người thực hiện lệnh là người chơi
			if (!(sender instanceof Player)) {

				sender.sendMessage(Chat.mau(prefix + "Chỉ người chơi mới được thi hành lệnh này"));
				return true;
			}

			// Lấy thông tin người thi hành lệnh
			Player player = (Player) sender;

			// Lấy thông tin người được nhắc tên
			Player muctieu;

			if (args.length == 1) {

				muctieu = plugin.getServer().getPlayer(args[0]);
				if (muctieu == null) {

					player.sendMessage(msgLayChu("KhongOnline"));
					return true;
				}
				XoaTui(player, muctieu);
			} else {
				XoaTui(player, player);
			}

>>>>>>> 06ae6d4... v0.5 BETA
		}
		return true;
	}
}
