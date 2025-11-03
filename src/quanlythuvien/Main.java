package quanlythuvien;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		ThuVien myLibrary  = new ThuVien();
		Scanner sc = new Scanner(System.in);
		
		Sach s01 = new Sach("KH01", "Vật lý lượng tử","Newton", false);
		Sach s02 = new Sach("KH02", "Cấu trúc rời rạc","Ainstein", false);
		Sach s03 = new Sach("KH03", "Cấu trúc dữ liệu","Lyori", false);
		
		ThanhVien tv1 =  new ThanhVien("TV01","Lê Thành Danh");
		ThanhVien tv2 =  new ThanhVien("TV02","Lê Thành Đạt");
		ThanhVien tv3 =  new ThanhVien("TV03","Nguyễn Thành An");
		
		myLibrary.themSach(s01);
		myLibrary.themSach(s02);
		myLibrary.themSach(s03);
		
		myLibrary.themThanhVien(tv1);
		myLibrary.themThanhVien(tv2);
		myLibrary.themThanhVien(tv3);
		
		
		
//		System.out.println("Danh sách sách trong thư viên: ");
//		System.out.printf("| %5s | %20s | %10s | %15s |\n","Mã","Tên sách","Tác giả","Trạng thái");
//		dsSach.getDsSach().forEach(sach-> System.out.println(sach));
//		System.out.println();
//		
//		System.out.println("Danh sách thành viên của thư viện: ");
//		System.out.printf("| %5s | %20s | %30s |\n","Mã","Tên thành viên","Danh sách sách đã mượn");
//		dsTv.getDsTv().forEach(sach-> System.out.println(sach));
//		System.out.println();
//		
//		
//		
//		System.out.println("Thông tin của cuốn sách 'Vật lý lượng tử' là: ");
//		System.out.println(dsSach.timSach("Vật lý lượng tử"));
		
		int option;
		do {
			System.out.println();
			System.out.println("==============MENU==============");
			System.out.println("1.Thêm sách");
			System.out.println("2.Mượn sách");
			System.out.println("3.Trả sách");
			System.out.println("4.Danh sách sách trong thư viện");
			System.out.println("5.Danh sách thành viên của thư viện");
			System.out.println("0.Thoát");
			System.out.println("================================");
			System.out.println();
			
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:
					System.out.println("Mời nhập mã sách: ");
					String ma = sc.nextLine();
					System.out.println("Mời nhập tên sách: ");
					String ten = sc.nextLine();
					System.out.println("Mời nhập tác giả sách: ");
					String tacGia = sc.nextLine();
					Sach s =  new Sach(ma, ten, tacGia, false);
					myLibrary.themSach(s);
					break;
				case 2:
					System.out.println("Mời bạn nhập mã thành viên:");
					String maTV = sc.nextLine();
					System.out.println("Mời bạn nhập tên sách cần mượn:");
					String tenSach = sc.nextLine();
					if(myLibrary.muonSach(maTV, tenSach)) {
						System.out.println("MƯỢN SÁCH THÀNH CÔNG!!!");
					} else System.out.println("MƯỢN SÁCH KHÔNG THÀNH CÔNG!!!");
					break;
				case 3:
					System.out.println("Mời bạn nhập mã thành viên: ");
					String maTV1 = sc.nextLine();
					System.out.println("Mời bạn nhập tên sách cần trả: ");
					String tenSach1 = sc.nextLine();
					if(myLibrary.traSach(maTV1, tenSach1)) {
						System.out.println("TRẢ SÁCH THÀNH CÔNG");
					} else System.out.println("TRẢ SÁCH KHÔNG THÀNH CÔNG");
					break;
				case 4:
					System.out.println("---DANH SÁCH SÁCH CÓ TRONG THƯ VIỆN---");
					System.out.printf("| %5s | %20s | %10s | %15s |\n","Mã","Tên sách","Tác giả","Trạng thái");
					myLibrary.xuatDSSTV();
					break;
				case 5:
					System.out.println("---DANH SÁCH THÀNH VIÊN CỦA THƯ VIỆN---");
					System.out.printf("| %5s | %20s | %30s |\n","Mã","Tên thành viên","Danh sách sách đã mượn");
					myLibrary.xuatDSTV();
					break;
				case 0: 
					System.out.println("Đã thoát");
					break;
			}

		}while(option != 0);

	}
	
}
