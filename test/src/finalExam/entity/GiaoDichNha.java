package finalExam.entity;

import java.time.LocalDate;
import java.util.Scanner;

import finalExam.utils.Validation;

public class GiaoDichNha extends GiaoDich {
	private String address, loaiNha;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(String loaiNha) {
		this.loaiNha = loaiNha;
	}

	public GiaoDichNha() {
		super();
	}

	public GiaoDichNha(String maID, double area, double price, LocalDate day) {
		super(maID, area, price, day);
	}

	@Override
	public String toString() {
		return super.toString() + ", địa chỉ: " + address + ", loại nhà: " + loaiNha + "]";
	}

	public void nhap() {
		super.nhap();
		System.out.println("Nhập Address: ");
		address = sc.nextLine();
		int number = 0;
		do {
			try {
				System.out.println("Nhập loại nhà (0: Thương gia, 1: Cao cấp, 2: Thường ): ");
				String choose = sc.nextLine();
				number = Validation.isnumber(choose); 
			} catch (NumberFormatException e) {
				System.out.println("Lỗi cú pháp, yêu cầu nhập lại!"); 
				System.out.println("Yêu cầu là số (0, 1, 2)!");
				continue;
			}
			break;
		} while (true); 
		switch (number) {
		case 0:
			loaiNha = "Thương gia";
			break;
		case 1:
			loaiNha = "Cao cấp";
			break;
		case 2:
			loaiNha = "Thường"; 
			break ;
		}
	}
}
