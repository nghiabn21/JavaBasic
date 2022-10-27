package com.example.demo.responsitory;

import com.example.demo.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ThuongHieuRepo extends JpaRepository<ThuongHieu,Integer> {
    @Query(value = "from ThuongHieu th where th.xoa = false ")
    Page<ThuongHieu> findAll(Pageable pageable);

    @Query(value = "from ThuongHieu th where (?1 is null or th.tenThuongHieu =?1) " +
            "and th.xoa = false ")
    Page<ThuongHieu> search(String tenThuongHieu, Pageable pageable);

    @Query(value = "from ThuongHieu th where th.xoa = false and th.id = ?1")
    Optional<ThuongHieu> findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update ThuongHieu th set th.xoa = true where th.id =?1")
    Integer delete(int id);
}
