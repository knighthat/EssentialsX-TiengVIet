package TepTin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Chinh.EssentialsTiengViet;

public class Khuvuc {

	EssentialsTiengViet plugin;

	private File tep = null;
	private FileConfiguration config = null;

	public Khuvuc(EssentialsTiengViet plugin) {
		this.plugin = plugin;
		khoiDong();
	}

	// Nếu tệp không tồn tại thì tạo lại và lấy dữ liệu từ trong plugin
	public void khoiDong() {

		// Đọc dữ liệu từ config.yml
		if (tep == null)
			tep = new File(plugin.getDataFolder(), "khuvuc.yml");

		// Nếu không tồn tại thì sao chép từ trong plugin
		if (!tep.exists()) {
			plugin.saveResource("khuvuc.yml", false);
		}
	}

	// Dùng để lưu dữ liệu sau khi được chỉnh sửa
	public void taiLai() {

		// Đọc dữ liệu từ config.yml
		if (tep == null) {
			tep = new File(plugin.getDataFolder(), "khuvuc.yml");
		}

		this.config = YamlConfiguration.loadConfiguration(tep);

		// Nếu không tồn tại thì sao chép từ trong plugin
		if (!tep.exists()) {
			plugin.saveResource("khuvuc.yml", false);
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
	public void LuuDuLieu() {

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
