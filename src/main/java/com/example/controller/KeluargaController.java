package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.KeluargaModel;

import com.example.service.KeluargaService;


@Controller
public class KeluargaController {
	@Autowired
	KeluargaService keluargaService;
	
//	@RequestMapping("/")
//	public String home() {
//		return "index";
//	}
	
	@RequestMapping ("/keluarga")
	public String viewKeluarga(Model model,@RequestParam(value = "nomor_kk", required = true) String nomor_kk) {
		KeluargaModel keluarga = keluargaService.selectKeluarga(nomor_kk);
		if (keluarga != null) {
			model.addAttribute("keluarga", keluarga);
			return "result-keluarga";
		} else {
			model.addAttribute("errormessage" + "NKK Tidak ditemukan");
			return "error/error-page";
		}
	}
	
}
