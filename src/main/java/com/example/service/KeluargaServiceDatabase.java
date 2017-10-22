package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.KeluargaMapper;
import com.example.mapper.PendudukMapper;
import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService {
	@Autowired
	private KeluargaMapper keluargaMapper;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KeluargaServiceDatabase.class);
	
	@Override
	public KeluargaModel selectKeluarga(String nomor_kk) {
		log.info("select keluarga with nomor_kk {}", nomor_kk);
		return keluargaMapper.selectKeluarga(nomor_kk);
	}
	
	@Override
	public KeluargaModel selectKeluargaId(String id)
	{
		log.info("select keluarga with nomor_kk {}", id);
		return keluargaMapper.selectKeluargaId(id);
	}
//	public CourseModel selectCourse(String id_course) {
//		log.info("select course with id_course {}", id_course);
//		return courseMapper.selectCourse(id_course);
//	}
}
