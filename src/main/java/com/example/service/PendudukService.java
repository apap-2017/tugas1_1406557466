package com.example.service;

import java.util.List;

import com.example.model.PendudukModel;

public interface PendudukService {
	void tambahPenduduk (PendudukModel penduduk);
	PendudukModel selectPenduduk (String nik);
//	List<PendudukModel> selectPenduduk(string nik);
	void updatePendudukWafat(String nik);
}
