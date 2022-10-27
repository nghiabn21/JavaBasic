package com.example.demo.responsitory;

import com.example.demo.dto.HangHoaThongSoDto;
import com.example.demo.entity.HangHoaThongSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface HangHoaThongSoRepo extends JpaRepository<HangHoaThongSo, Integer> {
    @Query(value = "from HangHoaThongSo hd where hd.xoa = false ")
    Page<HangHoaThongSo> findAll(Pageable pageable);

    @Query(value = "from HangHoaThongSo hd where (?1 is null or hd.giaTri = ?1)" +
            "and hd.xoa = false ")
    Page<HangHoaThongSo> search(String giaTri, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update HangHoaThongSo hd set hd.xoa = true where hd.id = ?1")
    Integer delete(int id);

    @Query(value = "from HangHoaThongSo hd where hd.xoa = false and hd.id = ?1")
    Optional<HangHoaThongSo> findByid(int id);

    @Query(value = "from HangHoaThongSo hd where hd.thongSoChiTiet.id =?1")
    List<HangHoaThongSo> HangHoaThongSoFindByIdThongSoChiTiet(Integer id);

    @Query(value = "from HangHoaThongSo hd where hd.hangHoa.id =?1")
    List<HangHoaThongSo> HangHoaThongSoFindByIdHangHoa(Integer id);

    @Query(value = "from HangHoaThongSo hd where hd.thongSoKiThuat.id =?1")
    List<HangHoaThongSo> HangHoaThongSoFindByIdThongSoKithuat(Integer id);



}
