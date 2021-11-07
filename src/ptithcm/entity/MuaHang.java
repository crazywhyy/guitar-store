package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MuaHang")
public class MuaHang {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "giaTien")
	private int giaTien;

	@Column(name = "soLuong")
	private int soLuong;

	@Column(name = "trangThai")
	private int trangThai;

	@ManyToOne
	@JoinColumn(name = "idGuitar")
	Guitar guitar;

	@ManyToOne
	@JoinColumn(name = "idDonHang")
	private DonHang donhang;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}


	public DonHang getDonhang() {
		return donhang;
	}

	public Guitar getGuitar() {
		return guitar;
	}

	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}

	public void setDonhang(DonHang donhang) {
		this.donhang = donhang;
	}

}
