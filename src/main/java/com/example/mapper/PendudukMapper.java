package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.One;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;

@Mapper
public interface PendudukMapper {
	// penduduk
	@Select("SELECT * FROM PENDUDUK WHERE nik=#{nik}")
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "nik", column = "nik"),
			@Result(property = "nama", column = "nama"), @Result(property = "tempat_lahir", column = "tempat_lahir"),
			@Result(property = "tanggal_lahir", column = "tanggal_lahir"),
			@Result(property = "jenis_kelamin", column = "jenis_kelamin"),
			@Result(property = "golongan_darah", column = "golongan_darah"),
			@Result(property = "agama", column = "agama"),
			@Result(property = "status_perkawinan", column = "status_perkawinan"),
			@Result(property = "pekerjaan", column = "pekerjaan"), @Result(property = "is_wni", column = "is_wni"),
			@Result(property = "is_wafat", column = "is_wafat"),
			@Result(property = "id_keluarga", column = "id_keluarga"),
			@Result(property = "keluarga", column = "id_keluarga", javaType = KeluargaModel.class, one = @One(select = "selectKeluarga")) })
	PendudukModel selectPenduduk(@Param("nik") String nik);

	// keluarga
	@Select("SELECT id, alamat, RT, RW, id_kelurahan from keluarga where id=#{id_keluarga}")
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "alamat", column = "alamat"),
			@Result(property = "RT", column = "RT"), @Result(property = "RW", column = "RW"),
			@Result(property = "kelurahan", column = "id_kelurahan", javaType = KelurahanModel.class, one = @One(select = "selectKelurahan")) })
	KeluargaModel selectKeluarga(@Param("id") String id);

	// kelurahan
	@Select("SELECT id_kecamatan, nama_kelurahan from kelurahan where id=#{id_kelurahan}")
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "nama_kelurahan", column = "nama_kelurahan"),
			@Result(property = "kecamatan", column = "id_kecamatan", javaType = KecamatanModel.class, one = @One(select = "selectKecamatan")) })
	KelurahanModel selectKelurahan(@Param("id") String id);

	// kecamatan
	@Select("SELECT id, id_kota, nama_kecamatan from kecamatan where id=#{id_kecamatan}")
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "nama_kecamatan", column = "nama_kecamatan"),
			@Result(property = "kota", column = "id_kota", javaType = KotaModel.class, one = @One(select = "selectKota"))})
	KecamatanModel selectKecamatan(@Param("id") String id);

	// kota
	@Select("SELECT id, nama_kota from kota where id=#{id_kota}")
	@Results(value = { @Result(property = "id", column = "id"),
			@Result(property = "nama_kota", column = "nama_kota") })
	KotaModel selectKota(@Param("id") String id);

	//tambah Penduduk
	@Insert("INSERT INTO PENDUDUK (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat) VALUES (#{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan}, #{status_perkawinan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
	void tambahPenduduk(PendudukModel penduduk);
}