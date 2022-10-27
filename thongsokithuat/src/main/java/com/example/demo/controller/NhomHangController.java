package com.example.demo.controller;

import com.example.demo.dto.NhomHangDto;
import com.example.demo.entity.NhomHang;
import com.example.demo.service.NhomHangSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/nhomhang")
public class NhomHangController {
    @Autowired
    NhomHangSer nhomHangSer;

    @GetMapping("/findall")
    public ResponseEntity<?> findall() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<NhomHang> nhomHangs = nhomHangSer.findAll(pageable);
        return ResponseEntity.ok(nhomHangs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody NhomHang nhomHang) {
        Optional<NhomHang> nhomHang1 = nhomHangSer.save(nhomHang);
        if (nhomHang1.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody NhomHangDto nhomHangDto) {
        Optional<NhomHang> nhomHang1 = nhomHangSer.update(nhomHangDto);
        if (nhomHang1.isPresent()) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        Optional<NhomHang> nhomHang = nhomHangSer.findById(id);
        if (nhomHang.isPresent()) {
            return ResponseEntity.ok(nhomHang.get());
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "ma_nhom_hang") String maNhomHang,
                                    @RequestParam(name ="ten_nhom_hang") String tenNhomHang,
                                    @RequestParam(name = "page") Integer page,
                                    @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<NhomHang> nhomHangs = nhomHangSer.search(maNhomHang,tenNhomHang,pageable);
        return ResponseEntity.ok(nhomHangs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return nhomHangSer.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findByIdNhomHang(@PathVariable(name = "id") Integer id){
        Optional<NhomHang> nhomHang = nhomHangSer.findByIdNhomHang(id);
        if(nhomHang.isPresent()) {
            return ResponseEntity.ok(nhomHang.get());
        }else {
            return ResponseEntity.ok("failure");
        }
    }
}
