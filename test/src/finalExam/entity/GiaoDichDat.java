package finalExam.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class GiaoDichDat extends GiaoDich {
	private String loaiDat;

	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat(String loaiDat) {
		super();
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat(String maID, double area, double price, LocalDate day) {
		super(maID, area, price, day);
	}

	public GiaoDichDat() {
		super();

	}

	public void nhap() {
		super.nhap();
		System.out.println("Nhập loại đất (A, B, C):");
		loaiDat = sc.nextLine();
	}

	@Override
	public String toString() {
		return super.toString() + ", loại đất: " + this.loaiDat;
	}

}
