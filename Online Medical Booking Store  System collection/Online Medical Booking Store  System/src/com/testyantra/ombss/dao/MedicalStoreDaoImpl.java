package com.testyantra.ombss.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import com.testyantra.ombss.bean.MedicineInfoBean;
import com.testyantra.ombss.bean.UserInfoBean;
import com.testyantra.ombss.db.DbCart;
import com.testyantra.ombss.db.DbStore;
import com.testyantra.ombss.db.DbUser;

public class MedicalStoreDaoImpl implements MedicalStoreDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean signUp(UserInfoBean userInfoBean) {
		boolean isSignUP = false;
		LinkedList ll =null;
		if (userInfoBean != null) {
			ll = new LinkedList();
			ll.add(userInfoBean.getUsrName());
			ll.add(userInfoBean.getUsrAge());
			ll.add(userInfoBean.getUsrPassword());
			ll.add(userInfoBean.getUsrPhone());

			if (DbUser.userDb(ll)) {
				System.out.println(" User Id s "+DbUser.temp); 
			}

			isSignUP = true;
		}

		return isSignUP;

	}// end of signUp()

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean addMedicine(MedicineInfoBean medicineInfoBean, LinkedList li) {

		boolean isAdded = false;
		LinkedList ll = null;
		if (medicineInfoBean != null) {
			ll = new LinkedList();
			ll.add(medicineInfoBean.getShName());
			for (int i = 0; i < li.size(); i++) {
				ll.add(li.get(i));
			}
			//ll.add(medicineInfoBean.getPrice());
			//ll.add(medicineInfoBean.getTabName());

			if (DbStore.medicalDb(ll)) {
				System.out.println("Medicine Id "+DbStore.temp1); 
				//System.out.println(" Added");
				isAdded = true;
			}

		}

		return isAdded;

	}//end of addMedicine()

	@Override
	public boolean deleteMedicine(int id) {
		boolean isDeleted= false;

		if(DbStore.mDB.containsKey(id)) {

			System.out.println("Deleted elemet is "+DbStore.mDB.remove(id));
			isDeleted=true;
		}
		else {
			System.out.println(id + " Medicine Not Matched ");
		}


		return isDeleted;
	}//end of deletemedicine()

	@Override
	public boolean deleteUser(int id) {
		boolean isDeleted= false;

		if(DbUser.mp.containsKey(id)) {

			System.out.println("Deleted User is "+DbUser.mp.remove(id));
			isDeleted=true;
		}
		else {
			System.out.println(id + " User Not Matched ");
		}

		return isDeleted;
	}//end of deleteUser()

	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	@Override
	public boolean updateMedicine(int id ) {
		boolean isUpadte = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input to modify Medicine details");
		System.out.println("1.Tablet Name\n2.ShopName\n3.Price");
		int ch1 = sc.nextInt();

		if(ch1==1) {
			System.out.println("Enter Tablet Name ");
			String tabName = sc.next();

			MedicineInfoBean medicineInfoBean = new MedicineInfoBean();
			medicineInfoBean.setTabName(tabName);
			if(DbStore.mDB.containsKey(id)) {
				Set<Integer> keys = DbStore.mDB.keySet();
				Iterator<Integer> it = keys.iterator();
				while (it.hasNext()) {
					Integer integer = it.next();
					if (id==integer) {
						LinkedList res =DbStore.mDB.get(id);
						for (int i = 0; i < res.size(); i++) {
							if(i==0) {
								res.set(i,medicineInfoBean.getTabName());
								isUpadte = true;
							}
						}
						System.out.println(res);
					}

				}
			}
		}
		else if(ch1==2) {
			System.out.println("Enter Shope Name ");
			String shName = sc.next();

			MedicineInfoBean medicineInfoBean = new MedicineInfoBean();
			medicineInfoBean.setShName(shName);
			if(DbStore.mDB.containsKey(id)) {
				Set<Integer> keys = DbStore.mDB.keySet();
				Iterator<Integer> it = keys.iterator();
				while (it.hasNext()) {
					Integer integer = it.next();
					if (id==integer) {
						LinkedList res =DbStore.mDB.get(id);
						for (int i = 0; i < res.size(); i++) {
							if(i==1) {
								res.set(i,medicineInfoBean.getShName());
								isUpadte = true;
							}
						}
						System.out.println(res);
					}

				}
			}
		}

		else if(ch1==3) {
			System.out.println("Enter New Price ");
			Double price = sc.nextDouble();

			MedicineInfoBean medicineInfoBean = new MedicineInfoBean();
			medicineInfoBean.setPrice(price);
			if(DbStore.mDB.containsKey(id)) {
				Set<Integer> keys = DbStore.mDB.keySet();
				Iterator<Integer> it = keys.iterator();
				while (it.hasNext()) {
					Integer integer = it.next();
					if (id==integer) {
						LinkedList res =DbStore.mDB.get(id);
						for (int i = 0; i < res.size(); i++) {
							if(i==2) {
								res.set(i,medicineInfoBean.getPrice());
								isUpadte = true;
							}
						}
						System.out.println(res);
					}
				}
			}
		}
		return isUpadte;
	}// end of updateMedicine()

	@SuppressWarnings("rawtypes")
	@Override
	public boolean userAuthenticate(int id, String password) {

		boolean isLogin = false;
		//MedicineInfoBean medicineInfoBean = new MedicineInfoBean();
		if(DbUser.mp.containsKey(id)) {
			Set<Integer> keys = DbUser.mp.keySet();
			Iterator<Integer> it = keys.iterator();
			while (it.hasNext()) {
				Integer integer = it.next();
				if (id==integer) {
					LinkedList res =DbUser.mp.get(id);
					for (int i = 0; i < res.size(); i++) {
						if(i==2) {
							if(res.get(i).equals(password)) {
								isLogin = true;
							}
						}
					}
					System.out.println(res);
				}
			}

		}
		return isLogin;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean addCart(MedicineInfoBean medicineInfoBean) {
		boolean cartAdded = false;
		LinkedList ll = null;

		Set<Integer> keys = DbStore.mDB.keySet();
		Iterator<Integer> it = keys.iterator();
		while (it.hasNext()) {
			Integer integer = it.next();
			LinkedList res1 = DbStore.mDB.get(integer);
			for (int i = 0; i < res1.size(); i++) {

				if(res1.get(i).equals(medicineInfoBean.getTabName())) {

					if (medicineInfoBean != null) {
						ll = new LinkedList();
						ll.add(medicineInfoBean.getTabName());


						//ll.add(medicineInfoBean.getShName());
						//ll.add(medicineInfoBean.getPrice());

						if (DbCart.cartDb(ll)) {

							//System.out.println("Id Is "+DbStore.temp); 
							//System.out.println("Added");
							System.out.println("Your cart item is "+ll);
						}

						cartAdded = true;
					}
				}

			}
			System.out.println(res1);
		}


		return cartAdded;

	}


}// end of class