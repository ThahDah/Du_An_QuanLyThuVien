package quanlythuvien;


import java.util.ArrayList;
import java.util.List;


public class ThanhVien {
	private String maTV;
	private String tenTV;
	private List<String> dsSachDaMuon = new ArrayList<String>();
	
	
	
	public List<String> getDsSachDaMuon() {
		return dsSachDaMuon;
	}
	public void setDsSachDaMuon(String sachDaMuon) {
		if(sachDaMuon!= "" && !sachDaMuon.contains("[]")) {
			this.dsSachDaMuon.add(sachDaMuon);
		}
		
	}
	
	public ThanhVien(String maTV, String tenTV) {
		this.maTV = maTV;
		this.tenTV = tenTV;
		
	}
	public String getMaTV() {
		return maTV;
	}
	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}
	public String getTenTV() {
		return tenTV;
	}
	public void setTenTV(String tenTV) {
		this.tenTV = tenTV;
	}
	@Override
	public String toString() {
		return String.format("| %5s | %20s | %30s |",maTV,tenTV,dsSachDaMuon);
	}
	
	public String toFileString() {
		return maTV + ";" + tenTV + ";" + dsSachDaMuon;
	}
	
	
	public static ThanhVien fromFileString(String fileLine) {
	    try{
            String[] parts = fileLine.split(";");
        
             if (parts.length >= 2) {
                return new ThanhVien(parts[0], parts[1]);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi đọc dòng dữ liệu thành viên: " + fileLine);
        }
        return null;
	}
	
}
