package ptithcm.controller;

import java.util.List;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.bean.Item;
import ptithcm.entity.DonHang;
import ptithcm.entity.MuaHang;
import ptithcm.entity.Guitar;



@Transactional
@Controller
@RequestMapping("/Guitar/")

public class HomeController {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("introduction")
	public String introduction(ModelMap model){
		
		System.out.println("Hello");
		
		Session session= factory.getCurrentSession();
		
		String hql ="From Guitar";
		Query query = session.createQuery(hql);
		List<Guitar> list = query.list();
		
		model.addAttribute("guitar", list);
		
		
	
		return "user/introduction"; 
	//nhung view duoc DispatcherServlet chuyen qua viewResolver thực hiện
	
	}
	
	@RequestMapping("index") // chuyen qua trang index
	public String indexData(ModelMap model){
		
		System.out.println("Hello1");
		
		Session session= factory.getCurrentSession();
		
		String hql ="From Guitar";
		Query query = session.createQuery(hql);
		List<Guitar> list = query.list();
		
		model.addAttribute("guitar", list); //gui du lieu len jsp lay, guitar dat ten cho list
		
		
	
		return "user/index";
	
	}

	
	@RequestMapping("addToCart/{id}")
	public String addToCartData(ModelMap model, @PathVariable("id") String id, HttpSession ss) {

		Session session = factory.getCurrentSession();

		String hql = "From Guitar";
		Query query = session.createQuery(hql);
		List<Guitar> list = query.list();
		model.addAttribute("guitar", list);

		Session session1 = factory.getCurrentSession();
		String hql1 = "FROM Guitar WHERE id = :id";
		Query query1 = session1.createQuery(hql1);
		query1.setString("id", id);

		List<Guitar> list1 = query1.list();
		Guitar first = list1.get(0);
		int id1 = Integer.parseInt(id);

		if (ss.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(list1.get(0), 1));
			ss.setAttribute("cart", cart);
			System.out.println(cart.get(0).getQuantity() + "hello");

		} else {
			List<Item> cart = (List<Item>) ss.getAttribute("cart");
			int index = -1;
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getProduct().getId() == id1) {
					index = i;
					break;
				}
			}
			if (index == -1) {
				cart.add(new Item(list1.get(0), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}

			ss.setAttribute("cart", cart);
		}
		model.addAttribute("donhang", new DonHang());
		return "user/cart";
	}
	
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(ModelMap model, @PathVariable("id") String id, HttpSession ss) {
		int id1 = Integer.parseInt(id);
		List<Item> cart = (List<Item>) ss.getAttribute("cart");
		int index = 0;;
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduct().getId() == id1) {
			    index = i;
				break;
			}
		}
		
		cart.remove(index);
		ss.setAttribute("cart", cart);
		model.addAttribute("donhang", new DonHang());
		return "user/cart";
	}
	

	@RequestMapping("thanhtoan")
	public String thanhtoan(ModelMap model, HttpSession ss, @ModelAttribute("donhang") DonHang donhang,  BindingResult errors) {
		if(donhang.getHoTen().trim().length()== 0) {
			//kiem tra loi
			errors.rejectValue("hoTen", "donhang", "Vui lòng kiểm tra và nhập lại thông tin");
			return "user/cart";
		}
		if(donhang.getDiaChi().trim().length()== 0) {
			errors.rejectValue("diaChi", "donhang", "Vui lòng kiểm tra và nhập lại thông tin");
			return "user/cart";
		}
		if(donhang.getNoiDung().trim().length()== 0) {
			errors.rejectValue("noiDung", "donhang", "Vui lòng kiểm tra và nhập lại thông tin");
			return "user/cart";
		}
		if(donhang.getSoDT().trim().length()== 0) {
			errors.rejectValue("soDT", "donhang", "Vui lòng kiểm tra và nhập lại thông tin");
			return "user/cart";
		}
		List<Item> cart = (List<Item>) ss.getAttribute("cart");
		if (cart == null) {
			model.addAttribute("message", "Bạn phải chọn hàng!");
			return "user/cart";
		}
		
		int tien = 0;
		for(int i = 0; i < cart.size(); i++) {
			tien = tien + cart.get(i).getQuantity()*cart.get(i).getProduct().getGiaTien();
		}
		donhang.setGiaTien(tien);
		donhang.setNgayTao(new Date());
		
		
		Session session5 = factory.openSession();
		Transaction t5 = session5.beginTransaction();
		//luu xuong data
		try {
			session5.save(donhang); 
			t5.commit();
			System.out.println("Them thanh cong don hang!");
		} catch (Exception ex) {
			t5.rollback();
			System.out.println("Them that bai!");
		} finally {
			session5.close();
		}

		System.out.println("Ma don hang " + donhang.getId());

		// don hang.
		Session session4 = factory.getCurrentSession();

		String hql4 = "From DonHang";
		Query query4 = session4.createQuery(hql4);
		List<DonHang> list4 = query4.list();

		DonHang fisrtdonhang = list4.get(list4.size()-1);
		// end don hang

		for (int i = 0; i < cart.size(); i++) {
			Item item = cart.get(i);

			String id = String.valueOf(item.getProduct().getId());

			Session session = factory.getCurrentSession();
			String hql = "FROM Guitar WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setString("id", id);

			List<Guitar> list = query.list();
			Guitar firstsach = list.get(0);

			MuaHang muahang = new MuaHang();
			muahang.setDonhang(fisrtdonhang);
			muahang.setGuitar(firstsach);

			muahang.setSoLuong(item.getQuantity());
			
			
			muahang.setGiaTien(item.getQuantity()*item.getProduct().getGiaTien());
			

			Session session3 = factory.openSession();
			Transaction t = session3.beginTransaction();

			try {
				session3.save(muahang);
				t.commit();
				System.out.println("Them thanh cong!");
			} catch (Exception ex) {
				t.rollback();
				System.out.println("Them thanh cong!");
			} finally {
				session3.close();
			}

		}
		
		cart = null;
		ss.setAttribute("cart", cart);
		
		model.addAttribute("message", "Thanh toán thành công");
		
		return "user/cart";
	}
	
	@RequestMapping("moreInfo/{id}")
	public String moreInfo(ModelMap model, @PathVariable("id") String id) {
		System.out.println(id);
		
		Session session1 = factory.getCurrentSession();
		String hql1 = "FROM Guitar WHERE id = :id";
		Query query1 = session1.createQuery(hql1);
		query1.setString("id", id);
		
		List<Guitar> list1 = query1.list();
		model.addAttribute("moreInfo", list1.get(0));
		
		Session session= factory.getCurrentSession();
		
		String hql ="From Guitar";
		Query query = session.createQuery(hql);
		List<Guitar> list = query.list();
	
		model.addAttribute("guitar", list);
		return "user/moreInfo";
	}
	
}
