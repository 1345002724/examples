package com.jsg.examples.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * yb_jymx
 * @author 
 */
@Data
public class YbJymx implements Serializable {
    private Integer id;

    /**
     * 病人姓名
     */
    private String psnname;

    /**
     * 医保卡号
     */
    private String mdtrtcertno;

    /**
     * 身份证号
     */
    private String certno;

    /**
     * 经办时间
     */
    private Date opttime;

    /**
     * 经办工号
     */
    private String opterid;

    /**
     * 经办机构代码
     */
    private String optinsno;

    /**
     * 经办机构名称
     */
    private String fixmedinsname;

    /**
     * 人员编号
     */
    private String psnno;

    /**
     * 就诊 ID
     */
    private String mdtrtid;

    /**
     * 结算 ID
     */
    private String setlid;

    /**
     * 医疗总费用
     */
    private String medfeesumamt;

    /**
     * 统筹基金支出
     */
    private String hifppay;

    /**
     * 大病补充支付(居民)
     */
    private String hifmipay;

    /**
     * 大额保险支付(职工)
     */
    private String hifobpay;

    /**
     * # 公务员补助(职工)
     */
    private String cvlservpay;

    /**
     * 医疗救助
     */
    private String mafpay;

    /**
     * 个人账户支付
     */
    private String acctpay;

    /**
     * 扶贫救济基金（其他支付）
     */
    private String othfundpay;

    /**
     * 病人性质
     */
    private String brxz;

    private static final long serialVersionUID = 1L;
}