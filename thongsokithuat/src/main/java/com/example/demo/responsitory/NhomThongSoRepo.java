package com.example.demo.responsitory;

import com.example.demo.entity.NhomThongSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Repository
public interface NhomThongSoRepo extends JpaRepository<NhomThongSo, Integer>{
    @Query(value = "from NhomThongSo nts where nts.xoa = false ")
    Page<NhomThongSo> findAll(Pageable pageable);

    @Query(value ="from NhomThongSo nhs where (?1 is null or nhs.maNhomThongSo = ?1) " +
            "and (?2 is null or nhs.tenNhomThongSo =?2) " +
            "and nhs.xoa = false ")
    Page<NhomThongSo> search(String maNhomThongSo, String tenNhomThongSo, Pageable pageable);

    @Query(value = "from NhomThongSo nhs where nhs.xoa =false and nhs.id =?1")
    Optional<NhomThongSo> findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update NhomThongSo nts set nts.xoa = true where nts.id =?1")
    Integer delete(int id);

    @Query(value = "from NhomThongSo nts where nts.hangHoa.id =?1")
    List<NhomThongSo> NhomThongSoFindByIdHangHoa(Integer id);

}
