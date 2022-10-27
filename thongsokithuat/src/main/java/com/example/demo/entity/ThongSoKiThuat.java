package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "thong_so_ki_thuat")
public class ThongSoKiThuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "ten_thong_so")
    private String tenThongSo;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "nhom_hang_id")
    private NhomHang nhomHang;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "nhom_thong_so_id")
    private NhomThongSo nhomThongSo;

    @Column(name = "xoa")
    private Boolean xoa ;

}
