package CauLenh;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class TroGiup extends TrungTamLenh {

	public TroGiup(EssentialsTiengViet plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");
		String symbols = "&a&m&l-=-=-=-=-=-=-=&r ";

		if (!(sender.hasPermission("estv.admin.help") || sender.hasPermission("estv.*"))) {

			sender.sendMessage(KhongQuyen());
			return true;
		}

		// Trang trợ giúp số 1
		if (args.length == 0
				|| (args.length == 1 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup")))
				|| (args.length == 1 && args[0].equalsIgnoreCase("1"))
				|| (args.length == 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup"))
						&& (args[1].equalsIgnoreCase("1")))) {

			sender.sendMessage(Chat.mau(symbols + prefix + "&f[&61&e/&66&f] " + symbols));
			sender.sendMessage(Chat.mau("&3&l/estv trogiup 2: &fSang trang trợ giúp kế tiếp."));
			sender.sendMessage(Chat.mau("&9&l/estv trogiup [số trang]: &fMở trang giúp đỡ cho các câu lệnh."));
			sender.sendMessage(Chat.mau("&9&l/estv reload: &fTải lại toàn bộ plugin (config.yml, message.yml, ...)."));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&9&l/bay [người chơi]: &fBật/tắt chế độ bay."));
			sender.sendMessage(Chat.mau("&9&l/bietdanh [tên mới]: &fThay đổi tên hiển thị."));
			sender.sendMessage(Chat.mau("&9&l/tinnhan [người chơi] [tin nhắn]: &fGửi tin nhắn cho người chơi."));
			sender.sendMessage(Chat.mau("&9&l/tenthat [biệt danh]: &fTìm tên đăng nhập của người chơi."));
			return true;
		}

		// Trang trợ giúp số 2
		if ((args.length == 1 && args[0].equalsIgnoreCase("2"))
				|| (args.length == 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup"))
						&& args[1].equalsIgnoreCase("2"))) {

			sender.sendMessage(Chat.mau(symbols + prefix + "&f[&62&e/&66&f] " + symbols));
			sender.sendMessage(Chat.mau("&3&l/estv trogiup 3: &fSang trang trợ giúp kế tiếp."));
			sender.sendMessage(Chat.mau("&9&l/estv trogiup [số trang]: &fMở trang giúp đỡ cho các câu lệnh."));
			sender.sendMessage(Chat.mau("&9&l/estv reload: &fTải lại toàn bộ plugin (config.yml, message.yml, ...)."));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&9&l/thongbao: &fThông báo gửi đến toàn bộ người chơi."));
			sender.sendMessage(Chat.mau("&9&l/thongtin [người chơi]: &fXem thông tin của người chơi."));
			sender.sendMessage(Chat.mau("&9&l/nang: &fChuyển thời tiết thành trong lành."));
			sender.sendMessage(Chat.mau("&9&l/mua: &fĐặt thời tiết thành mưa/bão."));
			return true;
		}

		// Trang trợ giúp số 3
		if ((args.length == 1 && args[0].equalsIgnoreCase("3"))
				|| (args.length == 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup"))
						&& args[1].equalsIgnoreCase("3"))) {

			sender.sendMessage(Chat.mau(symbols + prefix + "&f[&63&e/&66&f] " + symbols));
			sender.sendMessage(Chat.mau("&3&l/estv trogiup 4: &fSang trang trợ giúp kế tiếp."));
			sender.sendMessage(Chat.mau("&9&l/estv trogiup [số trang]: &fMở trang giúp đỡ cho các câu lệnh."));
			sender.sendMessage(Chat.mau("&9&l/estv reload: &fTải lại toàn bộ plugin (config.yml, message.yml, ...)."));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&9&l/vatpham [vật phẩm] [số lượng] [độ hư hại]: &fLấy một món đồ nhất định."));
			sender.sendMessage(Chat.mau("&9&l/gms [người chơi]: &fChuyển chế độ chơi thành SINH TỒN."));
			sender.sendMessage(Chat.mau("&9&l/gmc [người chơi]: &fChuyển chế độ chơi thành SÁNG TẠO."));
			sender.sendMessage(Chat.mau("&9&l/gma [người chơi]: &fChuyển chế độ chơi thành KHÁM PHÁ."));
			return true;
		}

		// Trang trợ giúp số 4
		if ((args.length == 1 && args[0].equalsIgnoreCase("4"))
				|| (args.length == 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup"))
						&& args[1].equalsIgnoreCase("4"))) {

			sender.sendMessage(Chat.mau(symbols + prefix + "&f[&64&e/&66&f] " + symbols));
			sender.sendMessage(Chat.mau("&3&l/estv trogiup 6: &fSang trang trợ giúp kế tiếp."));
			sender.sendMessage(Chat.mau("&9&l/estv trogiup [số trang]: &fMở trang giúp đỡ cho các câu lệnh."));
			sender.sendMessage(Chat.mau("&9&l/estv reload: &fTải lại toàn bộ plugin (config.yml, message.yml, ...)."));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&9&l/gmsp [người chơi]: &fChuyển chế độ chơi thành KHÁN GIẢ."));
			sender.sendMessage(Chat.mau("&9&l/gm [chế độ] [người chơi]: &fChuyển đổi chế độ chơi."));
			sender.sendMessage(Chat.mau("&9&l/tenthat [biệt danh]: &fXem tên đăng nhập của người chơi."));
			sender.sendMessage(Chat.mau("&9&l/thongtin [người chơi]: &fXem thông tin cơ bản của người chơi."));
			return true;
		}

		// Trang trợ giúp số 5
		if ((args.length == 1 && args[0].equalsIgnoreCase("5"))
				|| (args.length == 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup"))
						&& args[1].equalsIgnoreCase("5"))) {

			sender.sendMessage(Chat.mau(symbols + prefix + "&f[&65&e/&66&f] " + symbols));
			sender.sendMessage(Chat.mau("&3&l/estv trogiup 6: &fSang trang trợ giúp kế tiếp."));
			sender.sendMessage(Chat.mau("&9&l/estv trogiup [số trang]: &fMở trang giúp đỡ cho các câu lệnh."));
			sender.sendMessage(Chat.mau("&9&l/estv reload: &fTải lại toàn bộ plugin (config.yml, message.yml, ...)."));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&9&l/datkhuvuc [tên khu vực]: &fĐặt một khu vực để dịch chuyển."));
			sender.sendMessage(Chat.mau("&9&l/xoakhuvuc [tên khu vực]: &fXóa khu vực khỏi bộ nhớ."));
			sender.sendMessage(Chat.mau("&9&l/cackhuvuc: &fXem các khu vực khả dụng có thể dịch chuyển tới."));
			sender.sendMessage(Chat.mau("&9&l/khuvuc [tên khu vực]: &fDịch chuyển tới khu vực đã được chỉ định."));
			return true;
		}

		// Trang trợ giúp số 6
		if ((args.length == 1 && args[0].equalsIgnoreCase("6"))
				|| (args.length == 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("trogiup"))
						&& args[1].equalsIgnoreCase("6"))) {

			sender.sendMessage(Chat.mau(symbols + prefix + "&f[&66&e/&66&f] " + symbols));
			sender.sendMessage(Chat.mau("&3&l/estv trogiup 5: &fSang trang trợ giúp kế tiếp."));
			sender.sendMessage(Chat.mau("&9&l/estv trogiup [số trang]: &fMở trang giúp đỡ cho các câu lệnh."));
			sender.sendMessage(Chat.mau("&9&l/estv reload: &fTải lại toàn bộ plugin (config.yml, message.yml, ...)."));
			sender.sendMessage(Chat.mau(""));
			sender.sendMessage(Chat.mau("&9&l/hoimau [người chơi]: &fHồi máu cho bản thân hoặc người chơi khác."));
			sender.sendMessage(Chat.mau("&9&l/tieudiet [người chơi]: &fXử tử."));
			sender.sendMessage(Chat.mau("&9&l/dontui [người chơi]: &fXóa toàn bộ vật phẩm trong túi của người chơi."));
			return true;
		}

		// Trợ giúp khi không đáp ứng các yêu cầu bên trên
		sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " trogiup + [số trang]"));

		return true;
	}
}
