package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "thong_so_chi_tiet")
public class ThongSoChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "ten")
    private String ten ;

    @Column(name = "gia_tri")
    private String giaTri;

    @ManyToOne
    @JoinColumn(name ="thong_so_ki_thuat_id")
    private ThongSoKiThuat thongSoKiThuat;

    @Column(name = "xoa")
    private Boolean xoa ;

}
