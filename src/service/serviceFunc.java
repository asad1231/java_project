package service;

import java.util.Scanner;

import common.addService;
import common.mypageService;
import common.serviceService;

public class serviceFunc implements MainPage2{
	Scanner sc = new Scanner(System.in);
	serviceDTO sdto = null;
	addService as = new addService();
	serviceService ss = new serviceService();
	mypageService ms = new mypageService();
	@Override
	public void add(String id) {
		sdto = new serviceDTO();
		System.out.println("==================");
		System.out.println("상품 등록");
		System.out.println("==================");
		sdto.setSId(id);
		System.out.print("등록할 상품명 : ");
		sdto.setSName(sc.next());
		System.out.print("등록할 가격 : ");
		sdto.setSPrice(sc.nextInt());
		System.out.print("등록할 수량 : ");
		sdto.setSTotal(sc.nextInt());
		System.out.print("등록할 브랜드 : ");
		sdto.setSBrand(sc.next());
		if(as.add(sdto) != 0) {
			System.out.println("등록되었습니다");
		}
		
	}

	@Override
	public void search() {
		
		
	}

	public void product(String id) {
		int num;
		String s1;
		System.out.println("=====등록한 상품 목록=====");
		ms.myPView(id, "s_name",1);
		System.out.println("1.삭제 2.나가기");
		num = sc.nextInt();
		switch(num) {
		case 1 : System.out.print("삭제할 상품명 : ");
				 s1 = sc.next();
				 sc.nextLine();
				 num = ms.myPDelete(id, s1, 0);
				 if(num != 0) {
					 System.out.println("삭제되었습니다.");
				 }
			break;
		case 2 :
			break;
		}
	}
	
	public void suggest(String id) {
		int num,num1;
		String s1;
		System.out.println("=====등록한 건의사항 목록=====");
		ms.myPView(id, "suggest", 2);
		System.out.println("1.삭제 2.나가기");
		num = sc.nextInt();
		switch(num) {
		case 1 : System.out.print("삭제할 건의사항 번호 : ");
				 num1 = sc.nextInt();
				 num = ms.myPDelete(id, null, num1);
				 if(num != 0) {
					 System.out.println("삭제되었습니다.");
				 }
			break;
		case 2 :
			break;
		}
	}
	
	public void modify() {
		System.out.println("1.비밀번호 변경 2.이메일 변경 3.전화번호 변경 4.이름 변경");
	}
	
	
	
	@Override
	public void myPage(String id) {
		int num;
		while(true) {
			System.out.println("1.상품관리 2.건의사항관리 3.찜목록 4.정보수정 5.나가기");
			num = sc.nextInt();
			switch(num) {
			case 1 : product(id);
				break;
			case 2 : suggest(id);
				break;
			case 3 :
				break;
			case 4 :
				break;
			case 5 :
				return;
			}
		}
		
	}

	@Override
	public void service(String id) {
		int num;
		System.out.println("1.공지사항 2.건의사항");
		num = sc.nextInt();
		switch(num) {
		case 1 : ss.serviceView("notice");
				System.out.println("1.등록 2.나가기");
				num = sc.nextInt();
				switch(num) {
				case 1 : System.out.print("등록할 공지사항 : ");
						String s2 = sc.next();
						sc.nextLine();
					if(ss.serviceAdd(s2, 0, id) != 0) {
							System.out.println("등록되었습니다.");
						}
					break;
				case 2 : break;
				}
			break;
		case 2 : ss.serviceView("suggest");
				System.out.println("1.등록 2.나가기");
				num = sc.nextInt();
				switch(num) {
				case 1 :
					System.out.print("등록할 건의사항 : ");
					String s2 = sc.next();
					sc.nextLine();
					if(ss.serviceAdd(s2, 1, id) != 0) {
					System.out.println("등록되었습니다.");
					}
					break;
				case 2 : break;
				}
			break;
		}
		
	}

	@Override
	public void logout() {
		
	}
	
}
