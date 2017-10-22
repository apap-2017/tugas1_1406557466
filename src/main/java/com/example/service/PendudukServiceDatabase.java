package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.PendudukMapper;
import com.example.model.PendudukModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService {
	
	@Autowired
	PendudukMapper pendudukMapper;
	
	@Override
	public PendudukModel selectPenduduk(String nik) {
		// TODO Auto-generated method stub
		return pendudukMapper.selectPenduduk(nik);
	}
	
	@Override
	public void tambahPenduduk(PendudukModel penduduk) {
		pendudukMapper.tambahPenduduk(penduduk);
	}

	
}
