package com.example.demo.service;

import com.example.demo.dto.ThuongHieuDto;
import com.example.demo.entity.ThuongHieu;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ThuongHieuSer {
    Optional<ThuongHieu> save(ThuongHieu thuongHieu);
    Optional<ThuongHieu> update(ThuongHieuDto thuongHieuDto);
    Page<ThuongHieu> findAll(Pageable pageable);
    Optional<ThuongHieu> findById(int id);
    Page<ThuongHieu> search(String tenthuonghieu, Pageable pageable);
    Boolean delete(int id);

}
