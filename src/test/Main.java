package test;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.Sach;
import model.ThanhVien;
import model.ThuVien;
	

public class Main {
	private static final String FILE_SACH = "Sach.txt";
	private static final String FILE_TV = "ThanhVien.txt";
	private static ThuVien myLibrary  = new ThuVien();
	private static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) throws IOException {
		
		loadTatCaDuLieu();
		
		int option;
		do {
			System.out.println();
			System.out.println("==============MENU==============");
			System.out.println("1.Thêm sách");
			System.out.println("2.Thêm thành viên");
			System.out.println("3.Mượn sách");
			System.out.println("4.Trả sách");
			System.out.println("5.Danh sách sách trong thư viện");
			System.out.println("6.Danh sách thành viên của thư viện");
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
					System.out.println("Mời bạn nhập mã thành viên: ");
					String maTv = sc.nextLine();
					System.out.println("Mời bạn nhập tên thành viên: ");
					String tenTv = sc.nextLine();
					ThanhVien tv  =  new ThanhVien(maTv, tenTv);
					myLibrary.themThanhVien(tv);
					break;
				case 3:
					System.out.println("Mời bạn nhập mã thành viên:");
					String maTV = sc.nextLine();
					System.out.println("Mời bạn nhập tên sách cần mượn:");
					String tenSach = sc.nextLine();
					if(myLibrary.muonSach(maTV, tenSach)) {
						System.out.println("MƯỢN SÁCH THÀNH CÔNG!!!");
					} else System.out.println("MƯỢN SÁCH KHÔNG THÀNH CÔNG!!!");
					break;
				case 4:
					System.out.println("Mời bạn nhập mã thành viên: ");
					String maTV1 = sc.nextLine();
					System.out.println("Mời bạn nhập tên sách cần trả: ");
					String tenSach1 = sc.nextLine();
					if(myLibrary.traSach(maTV1, tenSach1)) {
						System.out.println("TRẢ SÁCH THÀNH CÔNG");
					} else System.out.println("TRẢ SÁCH KHÔNG THÀNH CÔNG");
					break;
				case 5:
					System.out.println("---DANH SÁCH SÁCH CÓ TRONG THƯ VIỆN---");
					System.out.printf("| %5s | %20s | %10s | %15s |\n","Mã","Tên sách","Tác giả","Trạng thái");
					myLibrary.xuatDSSTV();
					break;
				case 6:
					System.out.println("---DANH SÁCH THÀNH VIÊN CỦA THƯ VIỆN---");
					System.out.printf("| %5s | %20s | %30s |\n","Mã","Tên thành viên","Danh sách sách đã mượn");
					myLibrary.xuatDSTV();
					break;
				case 0: 
					saveTatCaDuLieu();
					System.out.println("Đã thoát");
					break;
			}

		}while(option != 0);
		sc.close();
	}
	
	private static void loadTatCaDuLieu() {
		
		try(BufferedReader brSach = new BufferedReader(new FileReader(FILE_SACH))) {
			String line = "";
			while((line = brSach.readLine()) != null)
			{
				Sach s = Sach.fromFileString(line);
				myLibrary.themSach(s);
			}
		} catch (IOException e) {
		}
		
		try (BufferedReader brTV = new BufferedReader(new FileReader(FILE_TV))) {
            String line;
            while ((line = brTV.readLine()) != null) {
                ThanhVien tv = ThanhVien.fromFileString(line);
                if (tv != null) {
                    myLibrary.themThanhVien(tv);
                }
            }
        } catch (IOException e) {
            System.err.println("Không tìm thấy file " + FILE_TV + ". Sẽ tạo file mới khi thoát.");
        }	
	}
	
	private static void saveTatCaDuLieu() {
        
        try (BufferedWriter bwSach = new BufferedWriter(new FileWriter(FILE_SACH, false))) {
            for (Sach s : myLibrary.getDsSach().values()) {
                bwSach.write(s.toFileString());
                bwSach.newLine(); 
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file sách: " + e.getMessage());
        }

        
        try (BufferedWriter bwTV = new BufferedWriter(new FileWriter(FILE_TV, false))) {
            for (ThanhVien tv : myLibrary.getDsThanhVien().values()) {
                bwTV.write(tv.toFileString());
                bwTV.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file thành viên: " + e.getMessage());
        }
        int cnt = 0;
        for(Sach s : myLibrary.getDsSach().values())
        {
        	if(!s.isTrangThai()) {
        		cnt++;
        	}
        }
        System.out.println("Số sách đang có trong thư viện: " + cnt +" quyển\n"
        					+"Số thành viên của thư viện: " + myLibrary.getDsThanhVien().size() +" người");
    }
	
}
