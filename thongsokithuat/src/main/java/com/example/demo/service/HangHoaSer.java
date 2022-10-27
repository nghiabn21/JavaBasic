package com.example.demo.service;

import com.example.demo.dto.HangHoaDto;
import com.example.demo.entity.HangHoa;
import com.example.demo.entity.createRequest.Request;
import com.example.demo.response.MyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HangHoaSer {
    Optional<HangHoa> save(HangHoa hanghoa, int nhomHangId, int thuongHieuId);

    Optional<HangHoa> update(HangHoaDto hangHoaDto, int nhomHangId, int thuongHieuId);

    Page<HangHoa> findAll(Pageable pageable);

    Page<HangHoa> search(String ma, String maHangHoa, Pageable pageable);

    Boolean delete(int id);

    Optional<HangHoa> findById(int id);

}
