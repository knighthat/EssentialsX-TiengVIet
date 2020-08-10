package CauLenh.CheDoChoi;

import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;
import TepTin.Config;
import TepTin.Message;

public abstract class TrungTamCheDoChoi implements CommandExecutor {

	EssentialsTiengViet plugin;

	public TrungTamCheDoChoi(EssentialsTiengViet plugin) {
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

	// Phân loại chế độ chơi
	public GameMode CheDoChoi(String lenh) {
		if (lenh.equalsIgnoreCase("sinhton") || lenh.equalsIgnoreCase("survival") || lenh.equalsIgnoreCase("0")
				|| lenh.equalsIgnoreCase("gms") || lenh.equalsIgnoreCase("gm0"))
			return GameMode.SURVIVAL;
		if (lenh.equalsIgnoreCase("sangtao") || lenh.equalsIgnoreCase("creative") || lenh.equalsIgnoreCase("1")
				|| lenh.equalsIgnoreCase("gmc") || lenh.equalsIgnoreCase("gm1"))
			return GameMode.CREATIVE;
		if (lenh.equalsIgnoreCase("khampha") || lenh.equalsIgnoreCase("adventure") || lenh.equalsIgnoreCase("2")
				|| lenh.equalsIgnoreCase("gma") || lenh.equalsIgnoreCase("gm2"))
			return GameMode.ADVENTURE;
		if (lenh.equalsIgnoreCase("khangia") || lenh.equalsIgnoreCase("spectator") || lenh.equalsIgnoreCase("3")
				|| lenh.equalsIgnoreCase("gmsp") || lenh.equalsIgnoreCase("gm3"))
			return GameMode.SPECTATOR;
		return null;
	}

	// Phân loại tên của chế độ chơi
	public String CheDo(String lenh) {
		if (lenh.equalsIgnoreCase("sinhton") || lenh.equalsIgnoreCase("survival") || lenh.equalsIgnoreCase("0")
				|| lenh.equalsIgnoreCase("gms") || lenh.equalsIgnoreCase("gm0"))
			return "sinh tồn";
		if (lenh.equalsIgnoreCase("sangtao") || lenh.equalsIgnoreCase("creative") || lenh.equalsIgnoreCase("1")
				|| lenh.equalsIgnoreCase("gmc") || lenh.equalsIgnoreCase("gm1"))
			return "sáng tạo";
		if (lenh.equalsIgnoreCase("khampha") || lenh.equalsIgnoreCase("adventure") || lenh.equalsIgnoreCase("2")
				|| lenh.equalsIgnoreCase("gma") || lenh.equalsIgnoreCase("gm2"))
			return "khám phá";
		if (lenh.equalsIgnoreCase("khangia") || lenh.equalsIgnoreCase("spectator") || lenh.equalsIgnoreCase("3")
				|| lenh.equalsIgnoreCase("gmsp") || lenh.equalsIgnoreCase("gm3"))
			return "khán giả";
		return null;
	}

	// Đặt chế độ chơi
	public void DatCheDoChoi(Player NguoiGui, Player NguoiNhan, String lenh) {

		// Nếu người nhận là người gửi
		if (NguoiGui.equals(NguoiNhan)) {

			// Nếu chế độ chơi hợp lệ
			if (CheDoChoi(lenh) != null) {

				// Áp dụng và gửi thông báo
				NguoiNhan.setGameMode(CheDoChoi(lenh));
				NguoiNhan.sendMessage(msgLayChu("CheDoChoi.BanThan").replace("{0}", CheDo(lenh)));
			} else {

				// Hiển thị các chế độ chơi có sẵn
				NguoiNhan.sendMessage(Chat.mau("&eCác chế độ chơi khả dụng:"));
				NguoiNhan.sendMessage(Chat.mau("&b0, sinhton, survival: &fChế độ sinh tồn"));
				NguoiNhan.sendMessage(Chat.mau("&b1, sangtao, creative: &fChế độ sáng tạo"));
				NguoiNhan.sendMessage(Chat.mau("&b2, khampham adventure: &fChế độ khám phá"));
				NguoiNhan.sendMessage(Chat.mau("&b3, khangia, spectator: &fChế độ khán giả"));
			}
		} else {

			// Nếu người chơi không tồn tại
			if (NguoiNhan == null) {

				NguoiGui.sendMessage(msgLayChu("KhongOnline").replace("{0}", lenh));
			} else {

				// Nếu chế độ chơi hợp lệ
				if (CheDoChoi(lenh) != null) {

					// Áp dụng và gửi thông báo
					NguoiNhan.setGameMode(CheDoChoi(lenh));
					NguoiNhan.sendMessage(msgLayChu("CheDoChoi.NguoiNhan").replace("{0}", CheDo(lenh))
							.replace("{TEN}", NguoiGui.getName()).replace("{BIETDANH}", NguoiGui.getDisplayName()));
					NguoiGui.sendMessage(msgLayChu("CheDoChoi.NguoiCho").replace("{0}", CheDo(lenh))
							.replace("{TEN}", NguoiGui.getName()).replace("{BIETDANH}", NguoiGui.getDisplayName()));
				} else {

					// Hiển thị các chế độ chơi có sẵn
					NguoiNhan.sendMessage(Chat.mau("&eCác chế độ chơi khả dụng:"));
					NguoiNhan.sendMessage(Chat.mau("&b0, sinhton, survival: &fChế độ sinh tồn"));
					NguoiNhan.sendMessage(Chat.mau("&b1, sangtao, creative: &fChế độ sáng tạo"));
					NguoiNhan.sendMessage(Chat.mau("&b2, khampham adventure: &fChế độ khám phá"));
					NguoiNhan.sendMessage(Chat.mau("&b3, khangia, spectator: &fChế độ khán giả"));
				}
			}
		}

	}

}
