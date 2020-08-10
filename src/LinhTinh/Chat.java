package LinhTinh;

import org.bukkit.ChatColor;

public class Chat {

<<<<<<< HEAD
	// Biến đoạn chat có chứa "&" thành đoạn chat có màu
=======
	// Biến đoạn ký tự có chứa "&" thành đoạn chat có màu
>>>>>>> 06ae6d4... v0.5 BETA
	public static String mau(String a) {
		return ChatColor.translateAlternateColorCodes('&', a);
	}

<<<<<<< HEAD
=======
	// Loại bỏ màu trong đoạn ký tự
	public static String BoMau(String a) {
		return ChatColor.stripColor(a);
	}

>>>>>>> 06ae6d4... v0.5 BETA
	// Biến tất cả dữ liệu nhập vào thành một đoạn ký tự duy nhất
	public static String LayDoanChat(String[] doan, int batdau) {
		StringBuilder bldr = new StringBuilder();
		for (int i = batdau; i < doan.length; i++) {
			if (i != batdau)
				bldr.append(" ");
			bldr.append(doan[i]);
		}
		return bldr.toString();
	}
<<<<<<< HEAD

=======
>>>>>>> 06ae6d4... v0.5 BETA
}
