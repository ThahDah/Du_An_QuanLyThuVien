package quanlythuvien;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ThanhVien {
	private String maTV;
	private String tenTV;
	private List<String> dsSachDaMuon = new ArrayList<String>();
	
	
	
	public List<String> getDsSachDaMuon() {
		return dsSachDaMuon;
	}
	public void setDsSachDaMuon(Sach sachDaMuon) {
		this.dsSachDaMuon.add(sachDaMuon.getTenSach());
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
	@Override
	public int hashCode() {
		return Objects.hash(maTV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThanhVien other = (ThanhVien) obj;
		return Objects.equals(maTV, other.maTV);
	}
	
	
	
}
