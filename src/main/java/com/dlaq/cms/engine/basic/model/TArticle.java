package com.dlaq.cms.engine.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CMS_BASIC_ARTICLE")
public class TArticle {
	
	/**
	 * 标识
	 */
	private String id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 栏目id
	 */
	private String catalogId;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 创建者id
	 */
	private String createId;
	
	/**
	 * 是否已删除
	 */
	private boolean deleted;
	
	/**
	 * 来源
	 */
	private String from;
	
	/**
	 * 序号
	 */
	private int index;
	
	/**
	 * 静态页名称
	 */
	private String link;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 是否置顶
	 */
	private boolean top;
	
	@Id
	@GenericGenerator(name="hibernate-uuid",strategy="uuid")
	@GeneratedValue(generator="hibernate-uuid")
	@Column(name="ID_", nullable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "TITLE_", length = 100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "AUTHOR_", length = 25)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "CATALOG_ID_", length = 50)
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	
	@Column(name = "CONTENT_", length = 50000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "CREATE_TIME_", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "CREATE_ID_", length = 50)
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	
	@Column(name = "DELETED_", length = 1)
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Column(name = "FROM_", length = 50)
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	@Column(name = "INDEX_", length = 10)
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Column(name = "LINK_", length = 50)
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Column(name = "STATUS_", length = 10)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "TOP_", length = 1)
	public boolean isTop() {
		return top;
	}
	public void setTop(boolean top) {
		this.top = top;
	}
}
