package CauLenh.KhuVuc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class DatKhuVuc extends TrungTamKhuVuc {

	public DatKhuVuc(EssentialsTiengViet plugin) {
		super(plugin);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Lấy thông tin người chơi
		Player player = (Player) sender;

		// Lấy tiền tố trong config.yml
		String prefix = plugin.cfg.layDuLieu().getString("TienTo");

		// Nếu chỉ nhập lệnh hoặc nhiều hơn tên của khu vực
		if (args.length == 0 || args.length > 1) {

			sender.sendMessage(Chat.mau(prefix + "&6&l/" + label + " [tên khu vực]"));
			return true;
		}

		// Kiểm tra nếu khu vực có tồn tại trong bộ nhớ
		if (plugin.kv.layDuLieu().getString(args[0].toLowerCase()) != null) {

			// Kiểm tra nếu đây là lệnh dùng để xác nhận
			if (xacnhan.containsKey(player.getName())) {

				// Kiểm tra thời gian còn lại để nhập lệnh
				if (xacnhan.get(player.getName()) > System.currentTimeMillis()) {

					// Thực hiện tạo khu vực
					TaoKhuVuc(player, ten.get(player.getName()));

					// Xóa dữ liệu trong bộ nhớ
					xacnhan.remove(player.getName());
					ten.remove(player.getName());
				} else {

					// Gủi thông báo đã hết thời hạn
					player.sendMessage(Chat.mau(prefix + "&cQuá thời gian cho phép! Hãy tạo lại."));

					// Xóa dữ liệu trong bộ nhớ
					xacnhan.remove(player.getName());
					ten.remove(player.getName());
					return true;
				}
			} else {

				// Lưu khu vực cần xóa và chờ xác nhận
				NhapXacNhan(player, 10, args[0].toLowerCase());

				// Gửi thông báo yêu cầu xác nhận
				player.sendMessage(Chat.mau(prefix + args[0] + "&c đã tồn tại! Hãy nhập lại lệnh để xác nhận"));
				return true;
			}
		} else {

			// Thực hiện tạo khu vực
			TaoKhuVuc(player, args[0]);
		}
		return true;
	}

	public void TaoKhuVuc(Player player, String ten) {

		// Tạo biến các thông tin cần thiết để ghi vào khuvuc.yml
		ten = ten.toLowerCase();
		String thegioi = player.getWorld().getName();
		Double X = player.getLocation().getX();
		Double Y = player.getLocation().getY();
		Double Z = player.getLocation().getZ();
		Float yaw = player.getLocation().getYaw();
		Float pitch = player.getLocation().getPitch();

		// Thực hiện công việc tạo khu vực
		plugin.kv.layDuLieu().set(ten + ".TenKhac", ten);
		plugin.kv.layDuLieu().set(ten + ".ToaDo.X", X);
		plugin.kv.layDuLieu().set(ten + ".ToaDo.Y", Y);
		plugin.kv.layDuLieu().set(ten + ".ToaDo.Z", Z);
		plugin.kv.layDuLieu().set(ten + ".ToaDo.Yaw", yaw);
		plugin.kv.layDuLieu().set(ten + ".ToaDo.Pitch", pitch);
		plugin.kv.layDuLieu().set(ten + ".TheGioi", thegioi);
		plugin.kv.LuuDuLieu();

		// Gủi thông báo thành công
		player.sendMessage(msgLayChu("KhuVuc.TaoKhuVuc").replace("{0}", ten));
	}
}
