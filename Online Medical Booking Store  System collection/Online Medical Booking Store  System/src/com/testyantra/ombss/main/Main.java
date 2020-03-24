package com.testyantra.ombss.main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import com.testyantra.ombss.bean.MedicineInfoBean;
import com.testyantra.ombss.bean.UserInfoBean;
import com.testyantra.ombss.dao.MedicalStoreDao;
import com.testyantra.ombss.dao.MedicalStoreDaoImpl;
import com.testyantra.ombss.db.DbStore;

public class Main {

	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static void main(String[] args) {

		MedicalStoreDao medicalStoreDao = new MedicalStoreDaoImpl();
		Scanner sc = new Scanner(System.in);
		UserInfoBean userInfoBean=null;

		MedicineInfoBean medicineInfoBean = null;

		while(true) {

			System.out.println("1. Press 1 to continue ");
			System.out.println("2. Press 0 to Exit ");
			int c = sc.nextInt();

			if (c==1) {

				System.out.println("Enter your choice: ");
				System.out.println("1.Admin Module");
				System.out.println("2.Visitor module");
				System.out.println("3.User module");
				System.out.println("4.Payment module");
				System.out.println("5.Shopping cart module");
				int  choice = sc.nextInt();

				if(choice==1) {
					System.out.println("1.Add Medicine : ");
					System.out.println("2.Delete Medicine : ");
					System.out.println("3.Modify Medicine : ");
					System.out.println("4.Delete User : ");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						System.out.println("Enter Shop Name: ");
						String shName = sc.next();
						System.out.println("Enter no of tablet");
						int c1 = sc.nextInt();
						LinkedList ll = new LinkedList();
						for (int i = 0; i < c1 ; i++) {

							System.out.println("Enter Tablet Name ");
							String tabName = sc.next();
							System.out.println("Enter tablet Price: ");
							double price = sc.nextDouble();
							ll.add(tabName);
							ll.add(price);
						}

						medicineInfoBean = new MedicineInfoBean();
						//medicineInfoBean.setTabName(tabName);
						medicineInfoBean.setShName(shName);
						//medicineInfoBean.setPrice(price);

						//boolean add= medicalStoreDao.addMedicine(medicineInfoBean);

						if(medicalStoreDao.addMedicine(medicineInfoBean,ll)) {
							//System.out.println("Medicine name is "+medicineInfoBean.getShName());
							System.out.println("Added");
						}
						break;

					case 2:
						System.out.println("Enter Medicine Id to Delete");
						int id = sc.nextInt();
						if(medicalStoreDao.deleteMedicine(id)) {

							System.out.println("Deleted successfully ");
						}
						else {
							System.out.println("Id Not found ");
						}

						break;

					case 3:
						System.out.println("Enter medicine id to modify ");
						int mid= sc.nextInt();
						if(DbStore.mDB.containsKey(mid)) {
							if(medicalStoreDao.updateMedicine(mid)) {
								System.out.println("Data Modifeid");
							}
							else {
								System.out.println("not Modifeid");
							}
						}
						else {
							System.out.println("Entered Id not found!!");
						}

						break;

					case 4:
						System.out.println("Enter User Id to Delete");
						int uid = sc.nextInt();
						if(medicalStoreDao.deleteUser(uid)) {

							System.out.println("User Deleted successfully ");
						}
						else {
							System.out.println("User Id Not found ");
						}

						break;

					default: System.out.println("Wrong Choice!!");

					break;
					}

				}
				else if(choice==2) {
					System.out.println("Welcome to medical store");
					//System.out.println(DbStore.mDB);
					Set<Integer> keys = DbStore.mDB.keySet();
					Iterator<Integer> it = keys.iterator();
					while (it.hasNext()) {
						Integer key = it.next();
						LinkedList res =DbStore.mDB.get(key);

						for (int i = 1; i < res.size(); i++) {
							if(i%2!=0) {
								System.out.println("Tablet Name "+res.get(i));
							}
							/*else if(i==1) {
									System.out.println("Shop Name "+res.get(i));
								}*/
							else if(i%2==0 ) {
								System.out.println("Price "+res.get(i));
								System.out.println("-------------------------");
							}
						}	
					}
					System.out.println("1.signUp\n2.Exit");
					int j=sc.nextInt();
					if(j==1) {
						System.out.println("Enter your Name ");
						String usrName = sc.next();
						System.out.println("Enter your Age: ");
						int usrAge = sc.nextInt();
						System.out.println("Enter your Phone: ");
						Long usrPhone = sc.nextLong();
						System.out.println("Enter your Password: ");
						String usrPassword = sc.next();

						userInfoBean = new UserInfoBean();

						userInfoBean.setUsrName(usrName);
						userInfoBean.setUsrAge(usrAge);
						userInfoBean.setUsrPhone(usrPhone);
						userInfoBean.setUsrPassword(usrPassword);

						//boolean res = medicalStoreDao.signUp(userInfoBean);
						if (medicalStoreDao.signUp(userInfoBean)) {

							System.out.println("welcome "+userInfoBean.getUsrName());
						}
						else {
							System.out.println("User Not Added");
						}
					}
					else if(j==2) {
						break;
					}
					//System.out.println("Medice "+DbStore.mDB);
				}
				else if(choice==3) {

					System.out.println("1.User SignUp : ");
					System.out.println("2.User Login : ");
					int ch = sc.nextInt();
					switch(ch) {

					case 1:

						System.out.println("Enter your Name ");
						String usrName = sc.next();
						System.out.println("Enter your Age: ");
						int usrAge = sc.nextInt();
						System.out.println("Enter your Phone: ");
						Long usrPhone = sc.nextLong();
						System.out.println("Enter your Password: ");
						String usrPassword = sc.next();

						userInfoBean = new UserInfoBean();

						userInfoBean.setUsrName(usrName);
						userInfoBean.setUsrAge(usrAge);
						userInfoBean.setUsrPhone(usrPhone);
						userInfoBean.setUsrPassword(usrPassword);

						//boolean res = medicalStoreDao.signUp(userInfoBean);
						if (medicalStoreDao.signUp(userInfoBean)) {

							System.out.println("welcome "+userInfoBean.getUsrName());
						}
						else {
							System.out.println("User Not Added");
						}

						break;

					case 2:

						System.out.println("Enter your User Id ");
						int id = sc.nextInt();
						System.out.println("Enter your Password: ");
						String password = sc.next();

						userInfoBean = new UserInfoBean();
						userInfoBean.setUsrPassword(password);
						//boolean auth =medicalStoreDao.userAuthenticate(id, password);
						if(medicalStoreDao.userAuthenticate(id, password)) {
							System.out.println("Welcome to medical store");
							System.out.println("Cart the Medicine");
							Set<Integer> keys = DbStore.mDB.keySet();
							Iterator<Integer> it = keys.iterator();
							while (it.hasNext()) {
								Integer key = it.next();
								LinkedList res =DbStore.mDB.get(key);

								for (int i = 1; i < res.size(); i++) {
									if(i%2!=0) {
										System.out.println("Tablet Name "+res.get(i));
									}
									/*else if(i==1) {
											System.out.println("Shop Name "+res.get(i));
										}*/
									else if(i%2==0 ) {
										System.out.println("Price "+res.get(i));
										System.out.println("-------------------------");
									}
								}	
							}
							System.out.println("Want to shop, Then add to Cart ");
							System.out.println("Press 1 to cart\nPress 2 to Payment\n 3 to Logout");
							int i = sc.nextInt();
							if(i==1) {
								System.out.println("Enter Tablet Name ");
								String tabName=sc.next();

								medicineInfoBean = new MedicineInfoBean();
								medicineInfoBean.setTabName(tabName);
								if(medicalStoreDao.addCart(medicineInfoBean)) {

									System.out.println("Cart added Successfull");
								}
								else {
									System.out.println("Cart not added");
								}

							}
							else if(i==2) {
								System.out.println("Payment Gateway");
							}
							else if(i==3){
								System.out.println("LogOut");
							}
							else {
								System.out.println("Wrong Choice!!");
							}
						}
						else {
							System.out.println("User not found");
						}


						break;

					default : System.out.println("Wrong Choice!!");

					}//End of switch
				}
				else if(choice==4) {
					System.out.println("Payment GateWay");
				}
				else if(choice==5) {
					
				}

			} 

			else {

				break;
			}


		}//End of While

	}//End of main()

}//End of class