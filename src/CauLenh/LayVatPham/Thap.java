package CauLenh.LayVatPham;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class Thap extends TrungTamVatPham {

	public Thap(EssentialsTiengViet plugin) {
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

		// Tạo biến cho món đồ nhập vào
		String vatpham = args[0].toUpperCase();
		Material ten = Material.getMaterial(vatpham);

		// Chuyển người gửi sang người chơi
		Player player = (Player) sender;

		// Tạo biến cho số lượng và độ bền
		int sl = Integer.parseInt(args[1]);
		int db = Integer.parseInt(args[2]);

		if (LocDo(vatpham)) {

			// Kiểm tra mức độ hư hại tối đa cho phép
			if (db > ten.getMaxDurability()) {
				player.sendMessage(Chat.mau(prefix + "&cMức độ hư hại tối đa là: &f" + ten.getMaxDurability()));
				return true;
			}

			// Gửi vật phẩm vào túi người chơi kèm độ bền
			ItemStack vp = new ItemStack(ten, sl, (short) db);
			player.getInventory().addItem(vp);
			player.sendMessage(Chat.mau(prefix + "&6Bạn nhận được &b&lx" + sl + " " + vatpham + "&6."));
			return true;
		} else {

			// Gửi vật phẩm vào túi người chơi kèm dữ liệu (data như màu, loại)
			ItemStack vp = new ItemStack(ten, sl, (byte) db);
			player.getInventory().addItem(vp);
			player.sendMessage(Chat.mau(prefix + "&6Bạn nhận được &b&lx" + sl + " " + vatpham + "&6."));
			return true;
		}
	}

}
