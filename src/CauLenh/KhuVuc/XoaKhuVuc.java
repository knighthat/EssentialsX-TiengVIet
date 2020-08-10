package CauLenh.KhuVuc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class XoaKhuVuc extends TrungTamKhuVuc {

	public XoaKhuVuc(EssentialsTiengViet plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Lấy thông tin người chơi
		Player player = (Player) sender;

		// Nếu chỉ nhập lệnh hoặc nhiều hơn 1 tên
		if (args.length == 0 || args.length > 1) {

			sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [tên khu vực]"));
			return true;
		}

		// Kiểm tra nếu khu vực có tồn tại trong bộ nhớ
		if (plugin.kv.layDuLieu().getString(args[0].toLowerCase()) == null) {
			player.sendMessage(msgLayChu("KhuVuc.KhongTimThay").replace("{0}", args[0]));
			return true;
		}

		// Kiểm tra nếu đây là lệnh dùng để xác nhận
		if (xacnhan.containsKey(player.getName())) {

			// Kiểm tra thời gian còn lại để nhập lệnh
			if (xacnhan.get(player.getName()) > System.currentTimeMillis()) {

				// Xóa khu vực ra khỏi khuvuc.yml
				plugin.kv.layDuLieu().set(args[0].toLowerCase(), null);
				plugin.kv.LuuDuLieu();

				// Xóa dữ liệu trong bộ nhớ
				xacnhan.remove(player.getName());
				ten.remove(player.getName());

				// Gửi thông báo thành công
				player.sendMessage(msgLayChu("KhuVuc.XoaKhuVuc").replace("{0}", args[0].toLowerCase()));
				return true;
			} else {

				// Gủi thông báo đã hết thời hạn
				player.sendMessage(Chat.mau(prefix + "&cĐã hết thời gian chờ! Vui lòng thực hiện lại."));

				// Xóa dữ liệu trong bộ nhớ
				xacnhan.remove(player.getName());
				ten.remove(player.getName());
				return true;
			}
		}

		// Lưu khu vực cần xóa và chờ xác nhận
		NhapXacNhan(player, 10, args[0]);

		// Gửi thông báo yêu cầu xác nhận
		player.sendMessage(Chat.mau(prefix + "&cHãy nhập lại lệnh để xác nhận xóa!"));
		return true;
	}
}
