package com.example.demo.controller;

import com.example.demo.dto.ThongSoChiTietDto;
import com.example.demo.entity.ThongSoChiTiet;
import com.example.demo.service.ThongSoChiTietSer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/thongsochitiet")
public class ThongSoChiTietController {
    @Autowired
    ThongSoChiTietSer thongSoChiTietSer;

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        Pageable pageable = PageRequest.of(0,10);
        Page<ThongSoChiTiet> thongSoChiTiets = thongSoChiTietSer.findAll(pageable);
        return ResponseEntity.ok(thongSoChiTiets);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "ten") String ten,
                                    @RequestParam(name = "giaTri") String giaTri,
                                    @RequestParam(name = "page") Integer page,
                                    @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page - 1 ,size);
        Page<ThongSoChiTiet> thongSoChiTiets = thongSoChiTietSer.search(ten,giaTri,pageable);
        return ResponseEntity.ok(thongSoChiTiets);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ThongSoChiTiet thongSoChiTiet,
                                  @RequestParam(name = "thongSoKiThuatId") int id){
        Optional<ThongSoChiTiet> thongSoChiTiet1 = thongSoChiTietSer.save(thongSoChiTiet, id);
        if(thongSoChiTiet1.isPresent()) {
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("faiure");
        }
    }

    @PutMapping ("/update")
    public ResponseEntity<?> update(@RequestBody ThongSoChiTietDto thongSoChiTietDto,
                                  @RequestParam(name = "thong_so_ki_thuat_id") int id){
        Optional<ThongSoChiTiet> thongSoChiTiet1 = thongSoChiTietSer.update(thongSoChiTietDto, id);
        if(thongSoChiTiet1.isPresent()) {
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("faiure");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<ThongSoChiTiet> thongSoChiTiet =thongSoChiTietSer.findByid(id);
        if(thongSoChiTiet.isPresent()) {
            return ResponseEntity.ok(thongSoChiTiet.get());
        } else {
            return ResponseEntity.ok("failure");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return thongSoChiTietSer.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");
    }
}
