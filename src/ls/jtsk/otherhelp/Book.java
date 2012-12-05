package ls.jtsk.otherhelp;

import java.util.Date;
/**
 * File Name:   Book.java
 * Created by:  IntelliJ IDEA.
 * Copyright:   Copyright (c) 2003-2006
 * Author:      leizhimin
 * Modifier:    leizhimin
 * Date Time:   2006-12-16 12:54:50
 * Readme:      图书
 */
/**
 * 图书
 *
 * @hibernate.mapping default-lazy="false"
 * @hibernate.meta attribute="class-description" value="图书"
 * @hibernate.class table="bk_ts"
 */
public class Book {
    private Long id;            //标识
    private String code;        //代码
    private String name;        //名称*
    private String bookman;     //出版社
    private Date pubDate;       //出版日期
    private String author;      //作者
    private String translator;  //译者
    private Double price;       //单价*
    private int amount;         //采购数量*
    private String buyer;       //采购人
    private String assessor;    //审核人
    private Date dateMark;      //操作时间（登记日期）*
    private String operator;    //操作员(录入人)*
    private String sort;        //类别（XXYYZZ格式，对应大中细类别）*
    private String summary;     //摘要（内容简介）
    private String remark;      //备注
    public Book() {
    }
    /**
     * @hibernate.id generator-class="native" column="id"
     * @hibernate.meta attribute="field-description" value="标识"
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @hibernate.property column="dm" type="string" length="20" not-null="false"
     * @hibernate.meta attribute="field-description" value="代码"
     */
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @hibernate.property column="mc" type="string" length="100" not-null="true"
     * @hibernate.meta attribute="field-description" value="名称"
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @hibernate.property column="cbs" type="string" length="24"  not-null="false"
     * @hibernate.meta attribute="field-description" value="出版社"
     */
    public String getBookman() {
        return bookman;
    }
    public void setBookman(String bookman) {
        this.bookman = bookman;
    }
    /**
     * @hibernate.property column="cbrq" type="timestamp" not-null="false"
     * @hibernate.meta attribute="field-description" value="出版日期"
     */
    public Date getPubDate() {
        return pubDate;
    }
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    /**
     * @hibernate.property column="zz" type="string" length="24" not-null="false"
     * @hibernate.meta attribute="field-description" value="作者"
     */
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * @hibernate.property column="yz" type="string" length="24" not-null="false"
     * @hibernate.meta attribute="field-description" value="译者"
     */
    public String getTranslator() {
        return translator;
    }
    public void setTranslator(String translator) {
        this.translator = translator;
    }
    /**
     * @hibernate.property column="dj" type="big_decimal" precision="19" scale="6"  not-null="true"
     * @hibernate.meta attribute="field-description" value="单价"
     */
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    /**
     * @hibernate.property column="sl" type="int" not-null="true"
     * @hibernate.meta attribute="field-description" value="数量"
     */
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * @hibernate.property column="cgr" type="string" length="12" not-null="false"
     * @hibernate.meta attribute="field-description" value="采购人"
     */
    public String getBuyer() {
        return buyer;
    }
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
    /**
     * @hibernate.property column="shr" type="string" length="12" not-null="false"
     * @hibernate.meta attribute="field-description" value="审核人"
     */
    public String getAssessor() {
        return assessor;
    }
    public void setAssessor(String assessor) {
        this.assessor = assessor;
    }
    /**
     * @hibernate.property column="czsj" type="timestamp" not-null="true"
     * @hibernate.meta attribute="field-description" value="操作时间"
     */
    public Date getDateMark() {
        return dateMark;
    }
    public void setDateMark(Date dateMark) {
        this.dateMark = dateMark;
    }
    /**
     * @hibernate.property column="czy" type="string" length="12" not-null="true"
     * @hibernate.meta attribute="field-description" value="操作员"
     */
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    /**
     * @hibernate.property column="lb" type="string" length="12" not-null="true"
     * @hibernate.meta attribute="field-description" value="类别"
     */
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    /**
     * @hibernate.property column="zy" type="string" length="600" not-null="false"
     * @hibernate.meta attribute="field-description" value="摘要"
     */
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    /**
     * @hibernate.property column="bz" type="string" length="200" not-null="false"
     * @hibernate.meta attribute="field-description" value="备注"
     */
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
