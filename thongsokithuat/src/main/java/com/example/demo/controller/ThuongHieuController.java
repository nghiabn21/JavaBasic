package com.example.demo.controller;

import com.example.demo.dto.ThuongHieuDto;
import com.example.demo.entity.HangHoa;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.service.ThuongHieuSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/thuonghieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuSer  thuongHieuSer;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ThuongHieu thuongHieu){
        Optional<ThuongHieu> thuongHieu1 = thuongHieuSer.save(thuongHieu);
        if(thuongHieu1.isPresent()) {
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody ThuongHieuDto thuongHieuDto){
        Optional<ThuongHieu> thuongHieu1 = thuongHieuSer.update(thuongHieuDto);
        if(thuongHieu1.isPresent()) {
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findall(){
        Pageable pageable = PageRequest.of(0,10);
        Page<ThuongHieu> thuongHieus = thuongHieuSer.findAll(pageable);
        return ResponseEntity.ok(thuongHieus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<ThuongHieu> thuongHieu = thuongHieuSer.findById(id);
        if(thuongHieu.isPresent()) {
            return ResponseEntity.ok(thuongHieu.get());
        }else {
            return ResponseEntity.ok("failure");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name ="ten_thuong_hieu") String tenThuongHieu,
                                    @RequestParam(name ="page") Integer page,
                                    @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page -1,size);
        Page<ThuongHieu> thuongHieus = thuongHieuSer.search(tenThuongHieu,pageable);
        return ResponseEntity.ok(thuongHieus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        return thuongHieuSer.delete(id) ? ResponseEntity.ok("success") : ResponseEntity.ok("failure");

    }

}
