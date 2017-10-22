package com.example.controller;

import java.util.Optional;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.PendudukModel;
import com.example.service.PendudukService;

@Controller
public class PendudukController {

	@Autowired
	PendudukService pendudukService;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/penduduk")
	public String viewPenduduk(Model model, @RequestParam(value = "nik", required = true) String nik) {
		PendudukModel penduduk = pendudukService.selectPenduduk(nik);
		if (penduduk != null) {
			model.addAttribute("penduduk", penduduk);
			return "result-penduduk";
		} else {
			model.addAttribute("error message" + "NIK Tidak ditemukan");
			return "error/error-page";
		}
	}

	@RequestMapping("/penduduk/tambah")
	public String tambahPenduduk() {
		return "add-penduduk";
	}
	
	
	@RequestMapping("/penduduk/tambah/submit")
	public String tambahPendudukSubmit(@RequestParam(value = "nama", required = true) String nama,
			@RequestParam(value = "tempat_lahir", required = true) String tempat_lahir, @RequestParam(value = "tanggal_lahir", required = true) String tanggal_lahir, 
			@RequestParam(value = "golongan_darah", required = true) String golongan_darah, @RequestParam(value = "agama", required = true) String agama, 
			@RequestParam(value = "status_perkawinan", required = true) String status_perkawinan, @RequestParam(value = "pekerjaan", required = true) String pekerjaan,
			@RequestParam(value = "is_wni", required = true) int is_wni, @RequestParam(value = "is_wafat", required = true) int is_wafat, @RequestParam(value = "id_keluarga", required = true) int id_keluarga, @RequestParam(value = "jenis_kelamin", required = true) int jenis_kelamin, @RequestParam(value = "status_dalam_keluarga", required = true) String status_dalam_keluarga) throws ParseException
	{
		
		String nik = "1234567891234567";
		PendudukModel penduduk =  new PendudukModel(0, nik, nama, tempat_lahir, tanggal_lahir, golongan_darah, agama, status_perkawinan, pekerjaan, is_wni, is_wafat, id_keluarga, jenis_kelamin, status_dalam_keluarga, null, null, null, null);
		//panggil method nik 
//		penduduk.setNik(PendudukMapper.generateNIK(penduduk));
		pendudukService.tambahPenduduk(penduduk);
		return "sukses-add-penduduk";
	}
	
	//bikin method generate nik
//	@RequestMapping("/")
//	public String generateNIK(PendudukModel penduduk) {
//		log.info("Generate NIK");
//		String nik = "";
//		String[] tglSplit = penduduk.getTanggal_lahir().split("-");
//		nik += PendudukMapper.selectPenduduk(penduduk.getId_keluarga()).getNomor_kk().substring(0,6);
//		nik += (Integer.parseInt(tglSplit[2]) + Integer.parseInt(penduduk.getJenis_kelamin())*40) + "" + tglSplit[1] + tglSplit[0].substring(2);
//		
//		PendudukModel pendudukDua = PendudukMapper.getNIKBefore(nik);
//		
//		if(pendudukDua == null) {
//			nik += "0001";
//		} else {
//			log.info("Input {}", pendudukDua.getNik());
//			long doubleNIK = Long.parseLong(pendudukDua.getNik()) + 1;
//			nik = doubleNIK + "";
//		}
//		return nik;
//	}
	// @RequestMapping(value = { "/penduduk/submit", "penduduk/submit/{nik}" })
	// public String viewPenduduk(@PathVariable Optional<String> nik, Model
	// model) {
	// if (nik.isPresent()) {
	// if (pendudukService.selectPenduduk(nik.get()) == null) {
	// model.addAttribute("pesanerror", "NIK tidak ditemukan, mohon untuk di cek
	// kembali masukkan NIK.");
	// return "home";
	// } else {
	// PendudukModel penduduk = pendudukService.selectPenduduk(nik.get());
	// model.addAttribute("penduduk", penduduk);
	// return "home";
	// }
	// } else {
	// model.addAttribute("pesanerror", "NIK kosong, mohon berikan NIK sebagai
	// masukkan.");
	// return "home";
	// }
	// }
}
