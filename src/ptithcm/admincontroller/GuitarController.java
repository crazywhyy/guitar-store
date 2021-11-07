package ptithcm.admincontroller;

import java.util.List;

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

import ptithcm.entity.Guitar;

@Transactional
@Controller
@RequestMapping("admin/Guitar/")
public class GuitarController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String indexData(ModelMap model) {

		Session session = factory.getCurrentSession();

		String hql = "From Guitar";
		Query query = session.createQuery(hql);
		List<Guitar> list = query.list();

		model.addAttribute("guitars", list);

		return "admin/info/index";
	}

	@RequestMapping(value = "update/{id}")
	public String update(ModelMap model, @PathVariable("id") String id) {

		Session session = factory.getCurrentSession();
		String hql = "From Guitar where id = :id";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		List<Guitar> list = query.list();
		model.addAttribute("guitar", list.get(0));
		model.addAttribute("insert", "update");

		// model.addAttribute("guitar", new Guitar());
		return "admin/info/insert";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update_food(ModelMap model, @ModelAttribute("guitar") Guitar n, BindingResult errors) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		model.addAttribute("insert", "insert");
		if(n.getTenGuitar().trim().length()== 0) {
			errors.rejectValue("tenGuitar", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(n.getMaGuitar().trim().length()== 0) {
			errors.rejectValue("maGuitar", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(n.getNoiDung().trim().length()== 0) {
			errors.rejectValue("noiDung", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(n.getHinhAnh()== null) {
			errors.rejectValue("hinhAnh", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(n.getThuongHieu().trim().length()== 0) {
			errors.rejectValue("thuongHieu", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(n.getNoiSanXuat().trim().length()== 0) {
			errors.rejectValue("noiSanXuat", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(n.getGiaTien()== 0) {
			errors.rejectValue("giaTien", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		
		try {
			session.update(n);
			t.commit();
			model.addAttribute("message", "Bạn đã cập nhật thành công!");
		} catch (Exception ex) {
			t.rollback();
			model.addAttribute("message", "Bạn đã cập nhật thất bại!");
		} finally {
			session.close();
		}
		Session session2 = factory.getCurrentSession();

		String hql2 = "From Guitar";
		Query query2 = session2.createQuery(hql2);
		List<Guitar> list2 = query2.list();

		model.addAttribute("guitars", list2);

		return "admin/info/index";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(ModelMap model, @PathVariable("id") String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Guitar WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		List<Guitar> list = query.list();
		Guitar guitar = list.get(0);

		Session session1 = factory.openSession();
		Transaction t = session1.beginTransaction();
		try {
			session1.delete(guitar);
			t.commit();
			model.addAttribute("message", "Bạn đã xóa thành công!");
		} catch (Exception e) {
			t.rollback();
		} finally {
			session1.close();
		}

		Session session2 = factory.getCurrentSession();
		String hql1 = "FROM Guitar";
		Query query1 = session2.createQuery(hql1);
		List<Guitar> list1 = query1.list();
		model.addAttribute("guitars", list1);
		return "admin/info/index";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {

		model.addAttribute("guitar", new Guitar());
		model.addAttribute("insert", "insert");

		return "admin/info/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("guitar") Guitar s, BindingResult errors) {
		model.addAttribute("insert", "insert");
		if(s.getTenGuitar().trim().length()== 0) {
			errors.rejectValue("tenGuitar", "s", "Vui lòng kiểm tra và nhập đủ thông tin!");
			return "admin/info/insert";
		}
		if(s.getMaGuitar().trim().length()== 0) {
			errors.rejectValue("maGuitar", "s", "Vui lòng kiểm tra và nhập đủ thông tin");
			return "admin/info/insert";
		}
		if(s.getNoiDung().trim().length()== 0) {
			errors.rejectValue("noiDung", "s", "Vui lòng kiểm tra và nhập đủ thông tin");
			return "admin/info/insert";
		}
		if(s.getHinhAnh()== null) {
			errors.rejectValue("hinhAnh", "s", "Vui lòng kiểm tra và nhập đủ thông tin");
			return "admin/info/insert";
		}
		if(s.getThuongHieu().trim().length()== 0) {
			errors.rejectValue("thuongHieu", "s", "Vui lòng kiểm tra và nhập đủ thông tin");
			return "admin/info/insert";
		}
		if(s.getNoiSanXuat().trim().length()== 0) {
			errors.rejectValue("noiSanXuat", "s", "Vui lòng kiểm tra và nhập đủ thông tin");
			return "admin/info/insert";
		}
		if(s.getGiaTien()== 0) {
			errors.rejectValue("giaTien", "s", "Vui lòng kiểm tra và nhập đủ thông tin");
			return "admin/info/insert";
		}
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(s); 
			t.commit(); 
			model.addAttribute("message", "Bạn đã thêm mới thành công");
		} catch (Exception ex) {
			t.rollback(); 
			model.addAttribute("message", "Bạn đã thêm mới thất bại");
		} finally {
			session.close();
		}

		Session session1 = factory.getCurrentSession();

		String hql1 = "From Guitar";
		Query query1 = session1.createQuery(hql1);
		List<Guitar> list1 = query1.list();

		model.addAttribute("guitars", list1);

		return "admin/info/index";
		
	}
}
