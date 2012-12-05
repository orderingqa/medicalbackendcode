package ls.jtsk.otherhelp;

import java.util.Date;
/**
 * File Name:   Book.java
 * Created by:  IntelliJ IDEA.
 * Copyright:   Copyright (c) 2003-2006
 * Author:      leizhimin
 * Modifier:    leizhimin
 * Date Time:   2006-12-16 12:54:50
 * Readme:      ͼ��
 */
/**
 * ͼ��
 *
 * @hibernate.mapping default-lazy="false"
 * @hibernate.meta attribute="class-description" value="ͼ��"
 * @hibernate.class table="bk_ts"
 */
public class Book {
    private Long id;            //��ʶ
    private String code;        //����
    private String name;        //����*
    private String bookman;     //������
    private Date pubDate;       //��������
    private String author;      //����
    private String translator;  //����
    private Double price;       //����*
    private int amount;         //�ɹ�����*
    private String buyer;       //�ɹ���
    private String assessor;    //�����
    private Date dateMark;      //����ʱ�䣨�Ǽ����ڣ�*
    private String operator;    //����Ա(¼����)*
    private String sort;        //���XXYYZZ��ʽ����Ӧ����ϸ���*
    private String summary;     //ժҪ�����ݼ�飩
    private String remark;      //��ע
    public Book() {
    }
    /**
     * @hibernate.id generator-class="native" column="id"
     * @hibernate.meta attribute="field-description" value="��ʶ"
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @hibernate.property column="dm" type="string" length="20" not-null="false"
     * @hibernate.meta attribute="field-description" value="����"
     */
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @hibernate.property column="mc" type="string" length="100" not-null="true"
     * @hibernate.meta attribute="field-description" value="����"
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @hibernate.property column="cbs" type="string" length="24"  not-null="false"
     * @hibernate.meta attribute="field-description" value="������"
     */
    public String getBookman() {
        return bookman;
    }
    public void setBookman(String bookman) {
        this.bookman = bookman;
    }
    /**
     * @hibernate.property column="cbrq" type="timestamp" not-null="false"
     * @hibernate.meta attribute="field-description" value="��������"
     */
    public Date getPubDate() {
        return pubDate;
    }
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    /**
     * @hibernate.property column="zz" type="string" length="24" not-null="false"
     * @hibernate.meta attribute="field-description" value="����"
     */
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * @hibernate.property column="yz" type="string" length="24" not-null="false"
     * @hibernate.meta attribute="field-description" value="����"
     */
    public String getTranslator() {
        return translator;
    }
    public void setTranslator(String translator) {
        this.translator = translator;
    }
    /**
     * @hibernate.property column="dj" type="big_decimal" precision="19" scale="6"  not-null="true"
     * @hibernate.meta attribute="field-description" value="����"
     */
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    /**
     * @hibernate.property column="sl" type="int" not-null="true"
     * @hibernate.meta attribute="field-description" value="����"
     */
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * @hibernate.property column="cgr" type="string" length="12" not-null="false"
     * @hibernate.meta attribute="field-description" value="�ɹ���"
     */
    public String getBuyer() {
        return buyer;
    }
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
    /**
     * @hibernate.property column="shr" type="string" length="12" not-null="false"
     * @hibernate.meta attribute="field-description" value="�����"
     */
    public String getAssessor() {
        return assessor;
    }
    public void setAssessor(String assessor) {
        this.assessor = assessor;
    }
    /**
     * @hibernate.property column="czsj" type="timestamp" not-null="true"
     * @hibernate.meta attribute="field-description" value="����ʱ��"
     */
    public Date getDateMark() {
        return dateMark;
    }
    public void setDateMark(Date dateMark) {
        this.dateMark = dateMark;
    }
    /**
     * @hibernate.property column="czy" type="string" length="12" not-null="true"
     * @hibernate.meta attribute="field-description" value="����Ա"
     */
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    /**
     * @hibernate.property column="lb" type="string" length="12" not-null="true"
     * @hibernate.meta attribute="field-description" value="���"
     */
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
    /**
     * @hibernate.property column="zy" type="string" length="600" not-null="false"
     * @hibernate.meta attribute="field-description" value="ժҪ"
     */
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    /**
     * @hibernate.property column="bz" type="string" length="200" not-null="false"
     * @hibernate.meta attribute="field-description" value="��ע"
     */
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
