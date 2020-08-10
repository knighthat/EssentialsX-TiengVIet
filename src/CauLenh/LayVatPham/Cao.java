package CauLenh.LayVatPham;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Chinh.EssentialsTiengViet;
import LinhTinh.Chat;

public class Cao extends TrungTamVatPham {

	public Cao(EssentialsTiengViet plugin) {
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

		int sl = Integer.parseInt(args[1]);
		int db = Integer.parseInt(args[2]);

		if (LocDo(vatpham)) {

			// Kiểm tra mức độ hư hại tối đa cho phép
			if (db > ten.getMaxDurability()) {
				player.sendMessage(Chat.mau(prefix + "&cMức độ hư hại tối đa là: &f" + ten.getMaxDurability()));
				return true;
			}

			// Thêm độ bền vào dụng cụ
			ItemStack vp = new ItemStack(ten, sl);
			Damageable doben = (Damageable) vp.getItemMeta();
			doben.damage(db);
			vp.setItemMeta((ItemMeta) doben);

			// Gửi vật phẩm vào túi người chơi
			player.getInventory().addItem(vp);
			player.sendMessage(Chat.mau(prefix + "&6Bạn nhận được &b&lx" + sl + " " + vatpham + "&6."));
			return true;
		} else {

			// Nếu món đồ không thể có mức độ hư hại thì gửi thông báo về
			player.sendMessage(Chat.mau(prefix + vatpham + "&c không thể bị hư hại!"));
			return true;
		}

	}

}
