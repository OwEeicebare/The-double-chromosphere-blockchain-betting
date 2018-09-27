package com.wangchao.icebearbc.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther:WangChao
 * @ClassName:Prizegrade
 * @Date:Created in 2018/9/26 10:33
 * @Despriction:
 * @Modify By:
 */
@Data
@Entity(name = "prizegrade")
public class Prizegrade {
    @Id
    @GeneratedValue
    private Integer pid;
    //几等奖
    private Integer type;
    //中了几注
    private Integer typenum;
    //中奖金额
    private Long typemoney;
    //属于哪一期
    private String code;
}
