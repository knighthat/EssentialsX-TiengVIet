package TepTin;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import Chinh.EssentialsTiengViet;

public class Banggioithieu {

	EssentialsTiengViet plugin;

	private File tep = null;
	private FileConfiguration config = null;

	public Banggioithieu(EssentialsTiengViet plugin) {
		this.plugin = plugin;
		khoiDong();
	}

	// Nếu tệp không tồn tại thì tạo lại và lấy dữ liệu từ trong plugin
	public void khoiDong() {

		// Đọc dữ liệu từ config.yml
		if (tep == null)
			tep = new File(plugin.getDataFolder(), "banggioithieu.txt");

		// Nếu không tồn tại thì sao chép từ trong plugin
		if (!tep.exists()) {
			plugin.saveResource("banggioithieu.txt", false);
		}
	}

	// Dùng để lưu dữ liệu sau khi được chỉnh sửa
	public void taiLai() {

		// Đọc dữ liệu từ config.yml
		if (tep == null) {
			tep = new File(plugin.getDataFolder(), "banggioithieu.txt");
		}

		// Nếu không tồn tại thì sao chép từ trong plugin
		if (!tep.exists()) {
			plugin.saveResource("banggioithieu.txt", false);
		}

	}

	// Lấy các dữ liệu đặt trong tệp và đưa ra ngoài
	public FileConfiguration layDuLieu() {

		// Đọc được thì trả về dữ liệu trong file
		return config;
	}
}
