package CauLenh.KhuVuc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import LinhTinh.Packets;
import TepTin.Config;
import TepTin.Message;

public class TrungTamKhuVuc implements CommandExecutor {

	EssentialsTiengViet plugin;

	public TrungTamKhuVuc(EssentialsTiengViet plugin) {
		this.plugin = plugin;
	}

	public static Map<String, Long> xacnhan = new HashMap<String, Long>();
	public static Map<String, String> ten = new HashMap<String, String>();

	// config.yml
	public String cfgLayChu(String a) {
		plugin.cfg = new Config(plugin);
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
		return Chat.mau(prefix + plugin.cfg.layDuLieu().getString(a));
	}

	public int cfgLaySo(String a) {
		plugin.cfg = new Config(plugin);
		return plugin.cfg.layDuLieu().getInt(a);
	}

	public boolean cfgLayGiaTri(String a) {
		plugin.cfg = new Config(plugin);
		return plugin.cfg.layDuLieu().getBoolean(a);
	}

	// message.yml
	public String msgLayChu(String a) {
		plugin.cfg = new Config(plugin);
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
		plugin.msg = new Message(plugin);
		return Chat.mau(prefix + plugin.msg.layDuLieu().getString(a));
	}

	public int msgLaySo(String a) {
		plugin.cfg = new Config(plugin);
		plugin.msg = new Message(plugin);
		return plugin.msg.layDuLieu().getInt(a);
	}

	public boolean msggLayGiaTri(String a) {
		plugin.cfg = new Config(plugin);
		plugin.msg = new Message(plugin);
		return plugin.msg.layDuLieu().getBoolean(a);
	}

	public String KhongQuyen() {
		return msgLayChu("KhongQuyen");
	}

	public void NhapXacNhan(Player a, int b, String c) {
		xacnhan.put(a.getName(), System.currentTimeMillis() + (b * 1000));
		ten.put(a.getName(), c);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Kiếm tra quyền
		if (!(sender.hasPermission("estv.khuvuc") || sender.hasPermission("estv.*"))) {
			sender.sendMessage(KhongQuyen());
			return true;
		}

		// Bắt buộc người thi hành lệnh là người chơi
		if (!(sender instanceof Player)) {
			sender.sendMessage(Chat.mau(prefix + "Chỉ người chơi mới được thi hành lệnh này"));
			return true;
		}

		Player player = (Player) sender;

		// Nhận lệnh - Đặt khu vực
		if (label.equalsIgnoreCase("setwarp") || label.equalsIgnoreCase("datwarp")
				|| label.equalsIgnoreCase("datkhuvuc") || label.equalsIgnoreCase("taokhuvuc")) {

			// Kiếm tra quyền
			if (!(player.hasPermission("estv.khuvuc.tao") || player.hasPermission("estv.*"))) {

				player.sendMessage(KhongQuyen());
				return true;
			}

			// Di chuyển đến class DatKhuVuc
			DatKhuVuc dkv = new DatKhuVuc(plugin);
			dkv.onCommand(sender, cmd, label, args);
			return true;
		}

		// Nhận lệnh - Xóa khu vực
		if (label.equalsIgnoreCase("delwarp") || label.equalsIgnoreCase("xoawarp")
				|| label.equalsIgnoreCase("xoakhuvuc")) {

			// Kiếm tra quyền
			if (!(player.hasPermission("estv.khuvuc.xoa") || player.hasPermission("estv.*"))) {

				player.sendMessage(KhongQuyen());
				return true;
			}

			// Di chuyển đến class DatKhuVuc
			XoaKhuVuc xkv = new XoaKhuVuc(plugin);
			xkv.onCommand(sender, cmd, label, args);
			return true;
		}

		// Nhận lệnh - Khu vực
		if (label.equalsIgnoreCase("warp") || label.equalsIgnoreCase("khuvuc")) {

			// Nếu chỉ nhập lệnh hoặc nhiều hơn 1 khu vực
			if (args.length == 0 || args.length > 1) {

				player.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [tên khu vực]"));
			}

			// Biến tên nhập vào thành chữ thường
			String tenkhuvuc = args[0].toLowerCase();

			// Kiểm tra nếu tên có tồn tại
			if (plugin.kv.layDuLieu().getString(tenkhuvuc) == null) {

				player.sendMessage(msgLayChu("KhuVuc.KhongTimThay").replace("{0}", args[0]));
				return true;
			}

			// Kiểm tra quyền
			if (!(player.hasPermission("estv.khuvuc." + tenkhuvuc) || player.hasPermission("estv.khuvuc.*")
					|| player.hasPermission("estv.*"))) {

				player.sendMessage(msgLayChu("KhuVuc.KhongQuyen"));
				return true;
			}

			// Kiểm tra nếu thế giới muốn đến có tồn tại
			if (plugin.getServer().getWorld(plugin.kv.layDuLieu().getString(tenkhuvuc + ".TheGioi")) == null) {

				player.sendMessage(Chat.mau(prefix + "&cThế giới bạn muốn đến không còn tồn tại nữa!"));
				return true;
			}

			// Kiểm tra nếu người chơi có quyền không chờ
			if (!player.hasPermission("estv.khuvuc.bypass"))

				// Kiểm tra nếu có bắt buộc chờ
				if (plugin.cfg.layDuLieu().getBoolean("DichChuyen.Bat")) {

					// Kiểm tra thời gian chờ
					if (!plugin.cfg.layDuLieu().getString("DichChuyen.ThoiGian").matches("-?\\d+")) {
						player.sendMessage(Chat.mau(prefix + plugin.cfg.layDuLieu().getString("DichChuyen.ThoiGian")
								+ "&c không phải là số"));
						return true;
					}

					// Kiểm tra thời gian chờ
					if (plugin.cfg.layDuLieu().getInt("DichChuyen.ThoiGian") < 0
							&& plugin.cfg.layDuLieu().getInt("DichChuyen.ThoiGian") > 100) {
						player.sendMessage(Chat.mau(prefix + "&c Thời gian delay phải lớn hơn 1 và nhỏ hơn 100 giây!"));
						return true;
					}

					// Đếm ngược
					for (int i = 0; i < plugin.cfg.layDuLieu().getInt("DichChuyen.ThoiGian"); i++) {

						String demnguoc = Chat.mau(plugin.msg.layDuLieu().getString("KhuVuc.DemNguoc").replace("{0}",
								"" + (plugin.cfg.layDuLieu().getInt("DichChuyen.ThoiGian") - i)));

						Packets.sendActionBarMessage(player, demnguoc);

						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							plugin.getLogger().info(Chat.mau(prefix + "&cKhông thể tiếp tục đếm ngược"));
						}
					}
				}

			// Tạo biến cho các giá trị của nơi cần đến
			World thegioi = plugin.getServer().getWorld(plugin.kv.layDuLieu().getString(tenkhuvuc + ".TheGioi"));
			double X = plugin.kv.layDuLieu().getInt(tenkhuvuc + ".ToaDo.X");
			double Y = plugin.kv.layDuLieu().getInt(tenkhuvuc + ".ToaDo.Y");
			double Z = plugin.kv.layDuLieu().getInt(tenkhuvuc + ".ToaDo.Z");
			float yaw = plugin.kv.layDuLieu().getInt(tenkhuvuc + ".ToaDo.Yaw");
			float pitch = plugin.kv.layDuLieu().getInt(tenkhuvuc + ".ToaDo.Pitch");

			// Đặt địa điểm cần đến
			Location dichden = new Location(thegioi, X, Y, Z, yaw, pitch);

			// Dịch chuyển người chơi đến vị trí đã lấy
			player.teleport(dichden);

			// Gửi thông báo dịch chuyển
			String Ten = Chat.mau(plugin.kv.layDuLieu().getString(tenkhuvuc + ".TenKhac"));
			player.sendMessage(msgLayChu("KhuVuc.DichChuyen").replace("{0}", Ten));
			return true;
		}

		// Nhận lệnh - Xem các khu vực
		if (label.equalsIgnoreCase("cackhuvuc") || label.equalsIgnoreCase("warps")
				|| label.equalsIgnoreCase("danhsachkhuvuc")) {

			if (!(player.hasPermission("estv.xemkhuvuc") || player.hasPermission("estv.*"))) {

				player.sendMessage(KhongQuyen());
			}

			player.sendMessage(Chat.mau(prefix + "&6Danh sách các khu vực: &r" + cacKhuVuc()));

		}

		return true;
	}

	public String cacKhuVuc() {

		// Tạo danh sách các tên khu vực
		List<String> ten = new ArrayList<String>();

		// Lấy tên các khu vực rồi cho vào danh sách
		plugin.kv.layDuLieu().getConfigurationSection("").getKeys(false).forEach(khuvuc -> {

			ten.add(khuvuc);
		});

		// Gủi danh sách đến người chơi
		return ten.toString().replace("[", "").replace("]", "");
	}
}
