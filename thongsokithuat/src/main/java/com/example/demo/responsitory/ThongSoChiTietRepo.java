package com.example.demo.responsitory;

import com.example.demo.entity.ThongSoChiTiet;
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
public interface ThongSoChiTietRepo extends JpaRepository<ThongSoChiTiet,Integer> {
    @Query(value = "from ThongSoChiTiet ts where ts.xoa = false ")
    Page<ThongSoChiTiet> findAll(Pageable pageable);

    @Query(value = "from ThongSoChiTiet ts where (?1 is null or ts.ten =?1) " +
            "and (?2 is null or ts.giaTri = ?2) " +
            "and ts.xoa = false ")
    Page<ThongSoChiTiet> search(String ten, String giaTri, Pageable pageable);

    @Query(value = "from ThongSoChiTiet ts where ts.xoa = false and ts.id =?1")
    Optional<ThongSoChiTiet> findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update ThongSoChiTiet ts set ts.xoa =true where ts.id = ?1")
    Integer delete(int id);

    @Query(value = "from ThongSoChiTiet ts where ts.thongSoKiThuat.id =?1")
    List<ThongSoChiTiet> ThongSochiTietFindIdThongSoKiThuat(Integer id);



}
