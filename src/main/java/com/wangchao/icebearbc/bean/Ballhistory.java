package com.wangchao.icebearbc.bean;

import lombok.Data;

import javax.naming.Name;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:ballhistory
 * @Date:Created in 2018/9/26 10:26
 * @Despriction:
 * @Modify By:
 */
@Entity(name = "ballhistory")
@Data
public class Ballhistory {
    //彩票的期数
    @Id
    private String code;
    //彩票的名称
    private String name;
    //日期
    private String date;
    //周几开的奖
    private String week;
    //红球的数量
    private String red;
    //蓝球
    private String blue;
    //销售额
    private Long sales;
    //奖池金额
    private Long poolmoney;
    //一等奖中奖信息
    private String content;

    @OneToMany(mappedBy = "code")
    List<Prizegrade> prizegrades;
}
