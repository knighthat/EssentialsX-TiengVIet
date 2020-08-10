package CauLenh.LayVatPham;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import TepTin.Config;
import TepTin.Message;

public class TrungTamVatPham implements CommandExecutor {

	EssentialsTiengViet plugin;

	public TrungTamVatPham(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

	// config.yml
	public String cfgLayChu(String a) {
		plugin.cfg = new Config(plugin);
<<<<<<< HEAD
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");
		return Chat.mau(prefix + plugin.cfg.LayDuLieu().getString(a));
=======
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

	// Kiểm tra đoạn nhập vào
	public static boolean LocDo(String a) {
		if (a.contains("_PICKAXE") || a.contains("_AXE") || a.contains("_SPADE") || a.contains("_HOE")
				|| a.contains("FISHING") || a.contains("_STEEL") || a.contains("SHEARS") || a.contains("BOW")
				|| a.contains("_SWORD") || a.contains("_HELMET") || a.contains("_CHESTPLATE") || a.contains("_LEGGINGS")
				|| a.contains("_BOOTS") || a.contains("_CROSSBOW") || a.contains("TRIDENT") || a.contains("SHIELD")) {
			return true;
		} else {
			return false;
		}
	}

	// Kiểm tra đoạn nhập vào nếu là số
	public boolean KiemTraSo(Player sender, String dukien) {

<<<<<<< HEAD
		String prefix = plugin.cfg.LayDuLieu().getString("TienTo");
=======
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
>>>>>>> 06ae6d4... v0.5 BETA

		if (!dukien.matches("-?\\d+")) {
			sender.sendMessage(Chat.mau(prefix + dukien + " &ckhông phải là số!"));
			return false;
		}
		int sl = Integer.parseInt(dukien);
		if (sl < 0) {
			sender.sendMessage(Chat.mau(prefix + "&cSố lượng không được phép âm!"));
			return false;
		}
		return true;
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

		// Nhận lệnh
		if (label.equalsIgnoreCase("getitem") || label.equalsIgnoreCase("i") || label.equalsIgnoreCase("item")
				|| label.equalsIgnoreCase("layitem") || label.equalsIgnoreCase("layvatpham")
				|| label.equalsIgnoreCase("vp")) {

			// Hỗ trợ lệnh
			if (args.length == 0 || args.length > 3) {
				sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [vật phẩm] [số lượng] [độ bền]"));
				return true;
			}

			// Tạo biến cho món đồ nhập vào
			String vatpham = args[0].toUpperCase();
			Material ten = Material.getMaterial(vatpham);
			if (ten == null) {
<<<<<<< HEAD
				sender.sendMessage(Chat.mau(prefix + vatpham + " " + plugin.msg.LayDuLieu().getString("KhongTonTai")));
=======
				sender.sendMessage(Chat.mau(prefix + vatpham + " " + plugin.msg.layDuLieu().getString("KhongTonTai")));
>>>>>>> 06ae6d4... v0.5 BETA
				return true;
			}

			// Nếu chỉ nhập tên món đồ
			if (args.length == 1) {

				ItemStack vp = new ItemStack(ten);
				player.getInventory().addItem(vp);
				player.sendMessage(Chat.mau(prefix + "&6Bạn nhận được &b&lx1 " + vatpham + "&6."));
				return true;
			}

			// Tên món đồ và số lượng
			if (args.length == 2) {

				// Kiểm tra số lượng
				if (!KiemTraSo(player, args[1]))
					return true;

				int sl = Integer.parseInt(args[1]);

				// Gửi item và thông báo
				ItemStack vp = new ItemStack(ten, sl);
				player.getInventory().addItem(vp);
				player.sendMessage(Chat.mau(prefix + "&6Bạn nhận được &b&lx" + sl + " " + vatpham + "&6."));
				return true;
			}

			// Thêm độ bền vào món đồ
			if (args.length == 3) {

				// Kiểm tra số lượng
				if (!KiemTraSo(player, args[1]))
					return true;

				// Kiểm tra độ bền
				if (!KiemTraSo(player, args[2]))
					return true;

				// Phân bố đến các class khác nhau dựa trên phiên bản của máy chủ
				if (plugin.getServer().getVersion().contains("1.8")) {
					Thap thap = new Thap(plugin);
					thap.onCommand(sender, cmd, label, args);
					return true;
				} else {
					Cao cao = new Cao(plugin);
					cao.onCommand(sender, cmd, label, args);
					return true;
				}

			}
		}
		return true;
	}
}
