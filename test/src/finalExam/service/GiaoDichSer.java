package finalExam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import finalExam.entity.GiaoDich;
import finalExam.entity.GiaoDichDat;
import finalExam.entity.GiaoDichNha;

public class GiaoDichSer {
	Scanner sc = new Scanner(System.in);

	public void sumTungLoai(List<GiaoDich> giaoDich) {
		List<Double> dat = new ArrayList<>();
		List<Double> nha = new ArrayList<>();
	//	double sum = 0; 
		double tongNha = 0; 
		double tongDat = 0;
		for (GiaoDich gd : giaoDich) {
			if (gd instanceof GiaoDichDat) {
				if (((GiaoDichDat) gd).getLoaiDat().equalsIgnoreCase("A")) {
					tongDat += ((GiaoDichDat) gd).getArea() * ((GiaoDichDat) gd).getPrice() * 1.5
							+ ((GiaoDichDat) gd).tinhVat();
					dat.add(tongDat);
				}
				if (((GiaoDichDat) gd).getLoaiDat().equalsIgnoreCase("B")) {
					tongDat += ((GiaoDichDat) gd).getArea() * ((GiaoDichDat) gd).getPrice() + ((GiaoDichDat) gd).tinhVat();
					dat.add(tongDat);
				}
				if (((GiaoDichDat) gd).getLoaiDat().equalsIgnoreCase("C")) {
					tongDat += ((GiaoDichDat) gd).getArea() * ((GiaoDichDat) gd).getPrice();
					dat.add(tongDat);
				}
			}

			if (gd instanceof GiaoDichNha) {
				if (((GiaoDichNha) gd).getLoaiNha().equals("Thương gia")) {
					tongNha += ((GiaoDichNha) gd).getArea() * ((GiaoDichNha) gd).getPrice() + ((GiaoDichNha) gd).tinhVat();
					nha.add(tongNha);
				}
				if (((GiaoDichNha) gd).getLoaiNha().equals("Cao cấp")) {
					tongNha += ((GiaoDichNha) gd).getArea() * ((GiaoDichNha) gd).getPrice();
					nha.add(tongNha);
				}
				if (((GiaoDichNha) gd).getLoaiNha().equals("Thường")) {
					tongNha += ((GiaoDichNha) gd).getArea() * ((GiaoDichNha) gd).getPrice() - ((GiaoDichNha) gd).tinhVat();
					nha.add(tongNha);
				}
			}

		}  
		
		System.out.println("Tổng tiền các khu đất (A,B,C) là: " + tongDat); 
		System.out.println("Tổng tiền các nhà hạng (Thương gia, Cao cấp, Thường) là: " + tongNha);

	}

	public void giaoDichT8(List<GiaoDich> giaoDich) {

		for (GiaoDich gd : giaoDich) {
			if (gd instanceof GiaoDichDat) {
				if (((GiaoDichDat) gd).getDay().getMonthValue() == 8 && ((GiaoDichDat) gd).getDay().getYear() == 2021) {
					System.out.println(((GiaoDichDat) gd).toString());
				}
			}

			if (gd instanceof GiaoDichNha) {
				if (((GiaoDichNha) gd).getDay().getMonthValue() == 8 && ((GiaoDichNha) gd).getDay().getYear() == 2021) {
					System.out.println(((GiaoDichNha) gd).toString());
				}
			}

		}
	}

	public void trungbinhGĐ(List<GiaoDich> giaoDich) {
		List<Double> dat = new ArrayList<>();
		double sum = 0;
		for (GiaoDich gd : giaoDich) {
			if (gd instanceof GiaoDichDat) {
				if (((GiaoDichDat) gd).getLoaiDat().equalsIgnoreCase("A")) {
					sum += ((GiaoDichDat) gd).getArea() * ((GiaoDichDat) gd).getPrice() * 1.5
							+ ((GiaoDichDat) gd).tinhVat();
					dat.add(sum);
				}
				if (((GiaoDichDat) gd).getLoaiDat().equalsIgnoreCase("B")) {
					sum += ((GiaoDichDat) gd).getArea() * ((GiaoDichDat) gd).getPrice() + ((GiaoDichDat) gd).tinhVat();
					dat.add(sum);
				}
				if (((GiaoDichDat) gd).getLoaiDat().equalsIgnoreCase("C")) {
					sum += ((GiaoDichDat) gd).getArea() * ((GiaoDichDat) gd).getPrice();
					dat.add(sum);
				}
			}
		}
		System.out.println("Tổng tiền các khu đất (A,B,C) là: " + sum/(dat.size()));
	}

}
