package model;


public class Sach {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private boolean trangThai;
	
	public Sach() {
		this("","","",false);
	}
	
	public Sach(String maSach, String tenSach, String tacGia, boolean trangThai) {
		
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.trangThai = trangThai;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return String.format("| %5s | %20s | %10s | %15s | ",maSach,tenSach,tacGia,
																(trangThai)? "đã được mượn" :"chưa được mượn");
	}

	public String toFileString() {
		return maSach + ";" + tenSach + ";" + tacGia + ";" + trangThai;
	}
	
	public static Sach fromFileString(String fileLine) {
        try {
            String[] parts = fileLine.split(";");
            if (parts.length == 4) {
                String ma = parts[0];
                String ten = parts[1];
                String tacGia = parts[2];
                boolean trangThaiMuon = Boolean.parseBoolean(parts[3]);
                return new Sach(ma, ten, tacGia, trangThaiMuon);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi đọc dòng dữ liệu sách: " + fileLine);
        }
        return null;
	}
}
