package TepTin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Chinh.EssentialsTiengViet;

public class Bietdanh {

	EssentialsTiengViet plugin;

	private File tep = null;
	private FileConfiguration config = null;

	public Bietdanh(EssentialsTiengViet plugin) {
		this.plugin = plugin;
		khoiDong();
	}

	// Nếu tệp không tồn tại thì tạo lại và lấy dữ liệu từ trong plugin
	public void khoiDong() {

		// Đọc dữ liệu từ config.yml
		if (tep == null)
			tep = new File(plugin.getDataFolder() + "/DuLieuPlugin/bietdanh.yml");

		// Nếu không tồn tại thì sao chép từ trong plugin
		if (!tep.exists()) {
			plugin.saveResource("DuLieuPlugin/bietdanh.yml", false);
		}
	}

	// Dùng để lưu dữ liệu sau khi được chỉnh sửa
	public void taiLai() {

		// Đọc dữ liệu từ config.yml
		if (tep == null) {
			tep = new File(plugin.getDataFolder() + "/DuLieuPlugin/bietdanh.yml");
		}

		this.config = YamlConfiguration.loadConfiguration(tep);

		// Không tìm thấy thì tạo tệp mới
		InputStream dulieu = plugin.getResource("DuLieuPlugin/bietdanh.yml");
		if (dulieu != null) {
			YamlConfiguration macdinh = YamlConfiguration.loadConfiguration(new InputStreamReader(dulieu));
			config.setDefaults(macdinh);
		}
	}

	// Lấy các dữ liệu đặt trong tệp và đưa ra ngoài
	public FileConfiguration layDuLieu() {

		// Nếu không đọc được thì áp dụng lệnh tải lại (reload)
		if (this.config == null) {
			taiLai();
		}

		// Đọc được thì trả về dữ liệu trong file
		return config;
	}

	// Lưu các thay đổi khi áp dụng vào plugin (dùng nội bộ trong plugin)
	public void luuDuLieu() {

		// Nếu không có thay đổi thì thôi
		if (config == null || tep == null)
			return;

		// Thử lưu dữ liệu vào plugin. Nếu không được sẽ hiện thông báo
		try {
			this.layDuLieu().save(tep);
		} catch (IOException e) {
			plugin.getServer().getLogger().log(Level.WARNING, "Không thể lưu vào" + tep, e);
		}
	}
}
