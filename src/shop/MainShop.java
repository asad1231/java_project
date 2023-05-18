package shop;

import java.util.Scanner;

import service.MainPage2;
import service.serviceFunc;

public class MainShop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MainPage mp = new MainFunc();
		MainPage2 sf = new serviceFunc();
		int num;
		String logcheck = null;
		while(true) {
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.비회원 로그인");
			System.out.print(">>>");
			num = sc.nextInt();
			switch(num) {
			case 1 : mp.signup();
				break;
			case 2 : logcheck = mp.login();
					 if(logcheck != null) {
						 while(logcheck != null) {
								System.out.println("1.상품등록 2.상품검색 3.마이페이지 4.고객센터 5.로그아웃");
								num = sc.nextInt();
								switch(num) {
								case 1 :
									sf.add(logcheck);
									break;
								case 2 :
									break;
								case 3 : sf.myPage(logcheck);
									break;
								case 4 :
									sf.service(logcheck);
									break;
								case 5 :
									logcheck = null;
								}
							}
					 }
				break;
			case 3 :
				break;
			}
			
		}
	}
}
