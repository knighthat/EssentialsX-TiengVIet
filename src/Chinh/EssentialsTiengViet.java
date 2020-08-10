package Chinh;

import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.SpigotConfig;

import CauLenh.Bay;
import CauLenh.DoiTen;
import CauLenh.GuiTinNhan;
<<<<<<< HEAD
import CauLenh.ThongBao;
import CauLenh.TrungTamLenh;
import CauLenh.CheDoChoi.DatCheDoChoi;
import CauLenh.CheDoChoi.GM;
=======
import CauLenh.TenThat;
import CauLenh.ThongBao;
import CauLenh.ThongTin;
import CauLenh.TrungTamLenh;
import CauLenh.CheDoChoi.DatCheDoChoi;
import CauLenh.CheDoChoi.GM;
import CauLenh.KhuVuc.TrungTamKhuVuc;
>>>>>>> 06ae6d4... v0.5 BETA
import CauLenh.LayVatPham.TrungTamVatPham;
import CauLenh.TheGioi.ThoiGian;
import CauLenh.TheGioi.ThoiTiet;
import LinhTinh.Chat;
<<<<<<< HEAD
import SuKien.DinhDangChat;
import SuKien.ThamGiaVaThoat;
import TepTin.BangGioiThieu;
import TepTin.BietDanh;
import TepTin.Config;
=======
import SuKien.Dinhdangchat;
import SuKien.Thamgiavathoat;
import TepTin.Banggioithieu;
import TepTin.Bietdanh;
import TepTin.Config;
import TepTin.Khuvuc;
>>>>>>> 06ae6d4... v0.5 BETA
import TepTin.Message;

public class EssentialsTiengViet extends JavaPlugin {

	public Config cfg = new Config(this);
<<<<<<< HEAD
	public BietDanh bd = new BietDanh(this);
	public Message msg = new Message(this);
	public BangGioiThieu bgt = new BangGioiThieu(this);
=======
	public Bietdanh bd = new Bietdanh(this);
	public Message msg = new Message(this);
	public Banggioithieu bgt = new Banggioithieu(this);
	public Khuvuc kv = new Khuvuc(this);
>>>>>>> 06ae6d4... v0.5 BETA

	@Override
	public void onEnable() {
		SuKien();
		Lenh();
		SpigotConfig();
	}

	// Đăng ký các sự kiện diễn ra trong server
	public void SuKien() {

		// Định dạng chat trong Server
<<<<<<< HEAD
		this.getServer().getPluginManager().registerEvents(new DinhDangChat(this), this);

		// Tham gia và thoát khỏi máy chủ
		this.getServer().getPluginManager().registerEvents(new ThamGiaVaThoat(this), this);

=======
		this.getServer().getPluginManager().registerEvents(new Dinhdangchat(this), this);

		// Tham gia và thoát khỏi máy chủ
		this.getServer().getPluginManager().registerEvents(new Thamgiavathoat(this), this);
>>>>>>> 06ae6d4... v0.5 BETA
	}

	// Đăng ký lệnh
	public void Lenh() {

		// Câu lệnh chính
		this.getCommand("estv").setExecutor(new TrungTamLenh(this));

		// Đặt biệt danh
		this.getCommand("bietdanh").setExecutor(new DoiTen(this));

		// Lấy vật phẩm
		this.getCommand("i").setExecutor(new TrungTamVatPham(this));

		// Bật/tắt bay
		this.getCommand("bay").setExecutor(new Bay(this));

		// Chế độ chơi
		this.getCommand("gm").setExecutor(new GM(this));
		this.getCommand("sinhton").setExecutor(new DatCheDoChoi(this));
		this.getCommand("sangtao").setExecutor(new DatCheDoChoi(this));
		this.getCommand("khampha").setExecutor(new DatCheDoChoi(this));
		this.getCommand("khangia").setExecutor(new DatCheDoChoi(this));

		// Thời tiết
		this.getCommand("nang").setExecutor(new ThoiTiet(this));
		this.getCommand("mua").setExecutor(new ThoiTiet(this));

		// Thời gian
		this.getCommand("sang").setExecutor(new ThoiGian(this));
		this.getCommand("trua").setExecutor(new ThoiGian(this));
		this.getCommand("chieu").setExecutor(new ThoiGian(this));
		this.getCommand("toi").setExecutor(new ThoiGian(this));

		// Tạo thông báo
		this.getCommand("thongbao").setExecutor(new ThongBao(this));

		// Gửi tin nhắn
		this.getCommand("tinnhan").setExecutor(new GuiTinNhan(this));
<<<<<<< HEAD
=======

		// Xem tên thật
		this.getCommand("tenthat").setExecutor(new TenThat(this));

		// Xem thông tin
		this.getCommand("thongtin").setExecutor(new ThongTin(this));

		// Khu vực - warps
		this.getCommand("datkhuvuc").setExecutor(new TrungTamKhuVuc(this));
		this.getCommand("xoakhuvuc").setExecutor(new TrungTamKhuVuc(this));
		this.getCommand("khuvuc").setExecutor(new TrungTamKhuVuc(this));
		this.getCommand("cackhuvuc").setExecutor(new TrungTamKhuVuc(this));

		// Hồi phục
		this.getCommand("hoimau").setExecutor(new TrungTamLenh(this));

		// Tiêu diệt
		this.getCommand("tieudiet").setExecutor(new TrungTamLenh(this));

		// Xóa túi
		this.getCommand("xoatui").setExecutor(new TrungTamLenh(this));
>>>>>>> 06ae6d4... v0.5 BETA
	}

	// Các thông báo mặc định trọng của máy chủ
	public void SpigotConfig() {

		// Lấy phiên bản của Server
		String a = getServer().getVersion();
		String phienban = a.substring(a.lastIndexOf(':') + 2).replace(")", "");

		// Sai lệnh
<<<<<<< HEAD
		SpigotConfig.unknownCommandMessage = Chat.mau(msg.LayDuLieu().getString("SaiLenh"));

		// Phiên bản không hợp lệ
		SpigotConfig.outdatedClientMessage = Chat
				.mau(msg.LayDuLieu().getString("SaiPhienBan").replace("{0}", phienban));
		SpigotConfig.outdatedServerMessage = Chat
				.mau(msg.LayDuLieu().getString("SaiPhienBan").replace("{0}", phienban));

		// Máy chủ đã đầy
		SpigotConfig.serverFullMessage = Chat.mau(msg.LayDuLieu().getString("MayChuDay"));

		// Danh sách trắng
		SpigotConfig.whitelistMessage = Chat.mau(msg.LayDuLieu().getString("DanhSachTrang"));
=======
		SpigotConfig.unknownCommandMessage = Chat.mau(msg.layDuLieu().getString("SaiLenh"));

		// Phiên bản không hợp lệ
		SpigotConfig.outdatedClientMessage = Chat
				.mau(msg.layDuLieu().getString("SaiPhienBan").replace("{0}", phienban));
		SpigotConfig.outdatedServerMessage = Chat
				.mau(msg.layDuLieu().getString("SaiPhienBan").replace("{0}", phienban));

		// Máy chủ đã đầy
		SpigotConfig.serverFullMessage = Chat.mau(msg.layDuLieu().getString("MayChuDay"));

		// Danh sách trắng
		SpigotConfig.whitelistMessage = Chat.mau(msg.layDuLieu().getString("DanhSachTrang"));
>>>>>>> 06ae6d4... v0.5 BETA
	}
}
