package com.example.demo.responsitory;

import com.example.demo.dto.HangHoaDto;
import com.example.demo.entity.HangHoa;
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
public interface HangHoaRepo extends JpaRepository<HangHoa,Integer> {
    @Query(value = "from HangHoa hd where hd.xoa = false ")
    Page<HangHoa> findAll(Pageable pageable);

    @Query(value = "from HangHoa hd where (?1 is null or hd.ma = ?1) " +
            "and (?2 is null or hd.tenHangHoa = ?2) " +
            "and hd.xoa = false")
    Page<HangHoa> search(String ma, String maHangHoa, Pageable pageable);

    @Query(value = "from HangHoa hd where hd.xoa = false and hd.id = ?1")
    Optional<HangHoa> findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update HangHoa hd set hd.xoa = true where hd.id =?1")
    Integer deleteId(int id);

    @Query(value = "from HangHoa hd where hd.nhomhang.id = ?1")
    List<HangHoa> HangHoafindByIdNhomhang(Integer id);

    @Query(value = "from HangHoa hd where hd.thuongHieu.id = ?1")
    List<HangHoa> HangHoafindByIdThuongHieu(Integer id);


}
