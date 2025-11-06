package quanlythuvien;



import java.util.TreeMap;
import java.util.Map;




public class ThuVien {
	private TreeMap<String,Sach> dsSach;
	private TreeMap<String,ThanhVien> dsTV;
	
	
	public ThuVien() {
		this.dsSach = new TreeMap<String, Sach>();
		this.dsTV = new TreeMap<String, ThanhVien>();
	}
	
	public void themSach(Sach sach) {
		if(sach == null) {
			return;
		}
		
		if(!dsSach.containsKey(sach.getMaSach())) {
			dsSach.put(sach.getMaSach(), sach);
			System.out.println("*Đã thêm sách " + sach.getTenSach() + " vào thư viện");
		} else System.out.println("*Trùng mã sách");
	}
	
	
	
	public void themThanhVien(ThanhVien tv) {
		if(tv == null) {
			return;
		}
		
		if(!dsTV.containsKey(tv.getMaTV())) {
			dsTV.put(tv.getMaTV(), tv);
			System.out.println("*Đã thêm  "+ tv.getTenTV() + " vào danh sách" );
		}else System.out.println("*Trùng mã thành viên");
		
	}

	
	public Sach timSach(String tenSach) {
		for(Map.Entry<String,Sach> sach : dsSach.entrySet()) {
			if(sach.getValue().getTenSach().equalsIgnoreCase(tenSach)) {
				return sach.getValue();
			}
		}
		return null;
	}
	
	public ThanhVien timThanhVien(String maTV) {
		for(Map.Entry<String,ThanhVien> tv : dsTV.entrySet()) {
			if(tv.getValue().getMaTV().equalsIgnoreCase(maTV)) {
				return tv.getValue();
			}
		}
		return null;
	}
	
	public void xuatDSSTV() {
		
		for(Sach sach : dsSach.values()) {
			System.out.println(sach);
		}
	}
	
	public void xuatDSTV() {
		
		for(ThanhVien tv : dsTV.values()) {
			System.out.println(tv);
		}
	}
	
	  public Map<String, ThanhVien> getDsThanhVien() {
	        return dsTV;
	    }
	  
	  public Map<String, Sach> getDsSach() {
	        return dsSach;
	    }
	
	public boolean muonSach(String maTV, String tenSach) {
		ThanhVien tv = timThanhVien(maTV);
		Sach sach = timSach(tenSach);
		
		if(tv == null) {
			System.out.println("*Không tìm thấy thành viên có mã: "+ maTV);
			return false;
		}
		
		if(sach == null) {
			System.out.println("*Không tìm thấy sách: " + tenSach);
			return false;
		}
		
		if(sach.isTrangThai()) {
			System.out.println("*Sách đã được mượn");
			return false;
		}
		
		sach.setTrangThai(true);
		tv.setDsSachDaMuon(sach.getTenSach());
		return true;
	}
	
	public boolean traSach(String maTV, String tenSach) {
		ThanhVien tv =  timThanhVien(maTV);
		Sach sach = timSach(tenSach);
		
		if(tv == null) {
			System.out.println("*Không tìm thấy thành viên có mã: "+ maTV);
			return false;
		}
		
		if(sach == null) {
			System.out.println("*Không tìm thấy sách: " + tenSach);
			return false;
		}
		
		if(!sach.isTrangThai()) {
			System.out.println("*Sách đã được trả");
			return false;
		}
		
		sach.setTrangThai(false);
		tv.getDsSachDaMuon().remove(sach.getTenSach());
		return true;
	}
	
}
