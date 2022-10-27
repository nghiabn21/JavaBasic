package com.example.demo.responsitory;

import com.example.demo.entity.ThongSoKiThuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThongSoKiThuatRepo extends JpaRepository<ThongSoKiThuat,Integer> {
    @Query(value = "from ThongSoKiThuat ts where ts.xoa = false ")
    Page<ThongSoKiThuat> findAll(Pageable pageable);

    @Query(value = "from ThongSoKiThuat ts where (?1 is null or ts.tenThongSo = ?1) " +
            "and ts.xoa = false")
    Page<ThongSoKiThuat> search(String tenThongSo, Pageable pageable);

    @Query(value = "from ThongSoKiThuat ts where ts.xoa =false and ts.id =?1")
    Optional<ThongSoKiThuat> findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update ThongSoKiThuat ts set ts.xoa = true  where ts.id =?1")
    Integer delete(int id);

    @Query(value = "from ThongSoKiThuat ts where ts.nhomHang.id =?1")
    List<ThongSoKiThuat> ThongsokithuatFindIdNhomHang(Integer id);

    @Query(value = "from ThongSoKiThuat ts where ts.nhomThongSo.id =?1")
    List<ThongSoKiThuat> ThongsokithuatFindIdNhomThongSo(Integer id);

}
