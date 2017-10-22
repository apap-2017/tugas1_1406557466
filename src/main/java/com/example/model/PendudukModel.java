package com.example.model;

import java.sql.Date;
//import java.text.DateFormatSymbols;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PendudukModel {
	private int id;
	private String nik;
	private String nama;
	private String tempat_lahir;
	private String tanggal_lahir;
	private String golongan_darah;
	private String agama;
	private String status_perkawinan;
	private String pekerjaan;
	private int is_wni;
	private int is_wafat;
	private int id_keluarga;
	private int jenis_kelamin;
	private String status_dalam_keluarga;
	private KeluargaModel keluarga;
	private KelurahanModel kelurahan;
	private KecamatanModel kecamatan;
	private KotaModel kota;

	public PendudukModel(String nama, String tempat_lahir, Date tanggal_lahir, String golongan_darah,
			String status_perkawinan, String pekerjaan, int is_wni, int is_wafat, int id_keluarga) {
	}
}
