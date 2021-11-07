package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="DonHang")
public class DonHang {
	@Id 
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="hoTen")
	private String hoTen;
	
	@Column(name="diaChi")
	private String diaChi;
	
	@Column(name="noiDung")
	private String noiDung;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="ngayTao")
	private Date ngayTao;
	
	@Column(name="soDT")
	private String soDT;
	
	@Column(name="giaTien")
	private int giaTien;
	
	@OneToMany(mappedBy="donhang", fetch=FetchType.EAGER)
	private Collection<MuaHang> donhangs;


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getNoiDung() {
		return noiDung;
	}


	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayTao() {
		return ngayTao;
	}


	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSoDT() {
		return soDT;
	}


	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}


	public int getGiaTien() {
		return giaTien;
	}


	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}


	public Collection<MuaHang> getDonhangs() {
		return donhangs;
	}


	public void setDonhangs(Collection<MuaHang> donhangs) {
		this.donhangs = donhangs;
	}

	
	
}
