package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Guitar")
public class Guitar {
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="tenGuitar")
	private String tenGuitar;
	
	@Column(name="maGuitar")
	private String maGuitar;
	
	@Column(name="noiDung")
	private String noiDung;
	
	@Column(name="thuongHieu")
	private String thuongHieu;
	
	@Column(name="noiSanXuat")
	private String noiSanXuat;
	
	@Column(name="hinhAnh")
	private String hinhAnh;
	
	@Column(name="giaTien")
	private int giaTien;
	
	@OneToMany(mappedBy="guitar", fetch=FetchType.EAGER)
	Collection<MuaHang> guitars;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenGuitar() {
		return tenGuitar;
	}

	public void setTenGuitar(String tenGuitar) {
		this.tenGuitar = tenGuitar;
	}

	public String getMaGuitar() {
		return maGuitar;
	}

	public void setMaGuitar(String maGuitar) {
		this.maGuitar = maGuitar;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public String getNoiSanXuat() {
		return noiSanXuat;
	}

	public void setNoiSanXuat(String noiSanXuat) {
		this.noiSanXuat = noiSanXuat;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public Collection<MuaHang> getGuitars() {
		return guitars;
	}

	public void setGuitars(Collection<MuaHang> guitars) {
		this.guitars = guitars;
	}
}
