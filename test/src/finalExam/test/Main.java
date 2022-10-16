package finalExam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import finalExam.entity.GiaoDich;
import finalExam.entity.GiaoDichDat;
import finalExam.entity.GiaoDichNha;
import finalExam.service.GiaoDichSer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	private static List<GiaoDich> listGD = new ArrayList<GiaoDich>();
	static GiaoDichSer dichSer = new GiaoDichSer();

	public static void main(String[] args) {
		do {
			System.out.println("--------------Menu------------");
			System.out.println("1: Nhập thông tin giao dịch đất");
			System.out.println("2: Nhập thông tin giao dịch nhà");
			System.out.println("3: Tổng số tiền cho từng loại giao dịch");
			System.out.println("4: Trung bình thành tiền của giao dịch đất");
			System.out.println("5: Xuất các giao dịch của tháng 8 - 2021");
			System.out.println(">> Your choose!!!");
			int choose = sc.nextInt();
			sc.nextLine();
			String loop;
			switch (choose) {
			case 1:
				do {
					GiaoDichDat dat = new GiaoDichDat();
					dat.nhap();
					listGD.add(dat);

					System.out.println("Bạn có muốn tiếp tục nhập giao dịch không (Y/N) ?");
					loop = sc.nextLine();
				} while (loop.charAt(0) == 'y' || loop.charAt(0) == 'Y');
				break;
			case 2:
				do {
					GiaoDichNha nha = new GiaoDichNha();
					nha.nhap();
					listGD.add(nha);

					System.out.println("Bạn có muốn tiếp tục nhập giao dịch không (Y/N) ?");
					loop = sc.nextLine();
				} while (loop.charAt(0) == 'y' || loop.charAt(0) == 'Y');
				break;
			case 3:
				dichSer.sumTungLoai(listGD);
				break;
			case 4:
				dichSer.trungbinhGĐ(listGD);
				break;
			case 5:
				dichSer.giaoDichT8(listGD); 
				break ;
			default:
				System.out.println("Không đúng cú pháp!!!");
				break;
			}

		} while (true);

	}

}
