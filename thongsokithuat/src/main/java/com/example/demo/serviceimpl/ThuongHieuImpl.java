package com.example.demo.serviceimpl;

import com.example.demo.dto.ThuongHieuDto;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.responsitory.ThuongHieuRepo;
import com.example.demo.service.ThuongHieuSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThuongHieuImpl implements ThuongHieuSer {
    @Autowired
    ThuongHieuRepo thuongHieuRepo;

    @Override
    public Optional<ThuongHieu> save(ThuongHieu thuongHieu) {
        try {
            return Optional.ofNullable(thuongHieuRepo.save(thuongHieu));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ThuongHieu> update(ThuongHieuDto thuongHieuDto) {
        try {
            Optional<ThuongHieu> thuongHieu = thuongHieuRepo.findById(thuongHieuDto.getId());
            if (!thuongHieu.isPresent()) {
                return Optional.empty();
            }
            ThuongHieu thuongHieu1 = thuongHieu.get();
            thuongHieu1.setTenThuongHieu(thuongHieuDto.getTenThuongHieu());
            thuongHieu1.setXoa(false);

            return Optional.ofNullable(thuongHieuRepo.save(thuongHieu1));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Page<ThuongHieu> findAll(Pageable pageable) {
        try {
            return thuongHieuRepo.findAll(pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Optional<ThuongHieu> findById(int id) {
        try {
            return thuongHieuRepo.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Page<ThuongHieu> search(String tenThuongHieu, Pageable pageable) {
        try {
            return thuongHieuRepo.search(tenThuongHieu, pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            int rs = thuongHieuRepo.delete(id);
            return thuongHieuRepo.delete(id) >= 0;
        } catch (Exception e) {
            return false;
        }
    }
}
