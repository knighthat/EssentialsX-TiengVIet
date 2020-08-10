package TepTin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Chinh.EssentialsTiengViet;

public class Message {

	EssentialsTiengViet plugin;

	private File tep = null;
	private FileConfiguration config = null;

	public Message(EssentialsTiengViet plugin) {
		this.plugin = plugin;
<<<<<<< HEAD
		KhoiDong();
	}

	// Nếu tệp không tồn tại thì tạo lại và lấy dữ liệu từ trong plugin
	public void KhoiDong() {
=======
		khoiDong();
	}

	// Nếu tệp không tồn tại thì tạo lại và lấy dữ liệu từ trong plugin
	public void khoiDong() {
>>>>>>> 06ae6d4... v0.5 BETA

		// Đọc dữ liệu từ config.yml
		if (tep == null)
			tep = new File(plugin.getDataFolder(), "message.yml");

		// Nếu không tồn tại thì sao chép từ trong plugin
		if (!tep.exists()) {
			plugin.saveResource("message.yml", false);
		}
	}

	// Dùng để lưu dữ liệu sau khi được chỉnh sửa
<<<<<<< HEAD
	public void TaiLai() {
=======
	public void taiLai() {
>>>>>>> 06ae6d4... v0.5 BETA

		// Đọc dữ liệu từ config.yml
		if (tep == null) {
			tep = new File(plugin.getDataFolder(), "message.yml");
		}

		this.config = YamlConfiguration.loadConfiguration(tep);

		// Không tìm thấy thì tạo tệp mới
		InputStream dulieu = plugin.getResource("message.yml");
		if (dulieu != null) {
			YamlConfiguration macdinh = YamlConfiguration.loadConfiguration(new InputStreamReader(dulieu));
			config.setDefaults(macdinh);
		}
	}

	// Lấy các dữ liệu đặt trong tệp và đưa ra ngoài
<<<<<<< HEAD
	public FileConfiguration LayDuLieu() {

		// Nếu không đọc được thì áp dụng lệnh tải lại (reload)
		if (this.config == null) {
			TaiLai();
=======
	public FileConfiguration layDuLieu() {

		// Nếu không đọc được thì áp dụng lệnh tải lại (reload)
		if (this.config == null) {
			taiLai();
>>>>>>> 06ae6d4... v0.5 BETA
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
<<<<<<< HEAD
			this.LayDuLieu().save(tep);
=======
			this.layDuLieu().save(tep);
>>>>>>> 06ae6d4... v0.5 BETA
		} catch (IOException e) {
			plugin.getServer().getLogger().log(Level.WARNING, "Không thể lưu vào" + tep, e);
		}
	}
}
