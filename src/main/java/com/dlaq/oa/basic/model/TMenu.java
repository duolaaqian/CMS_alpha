package com.dlaq.oa.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="oa_basic_menu")
public class TMenu {
	
	
	/**
	 * 唯一标识
	 */
	private String id;
	
	/**
	 * 父节点id
	 */
	private String pid;
	
	/**
	 * 菜单名称
	 */
	private String name;
	
	/**
	 * 菜单编码
	 */
	private String code;
	
	/**
	 * 菜单路径
	 */
	private String url;
	
	/**
	 * 图标
	 */
	private String imgsrc;
	
	/**
	 * 是否是绝对路径
	 */
	private Boolean isAbsolute=false;
	
	/**
	 * 是否可用
	 */
	private Boolean isEnabled=true;
	
	/**
	 * 显示顺序
	 */
	private Integer showIndex;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 描述
	 */
	private String desc;

	
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
	
	@Column(name = "PID_", length = 50)
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "NAME_", length = 122)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE_", length = 255)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "URL_", length = 255)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "IMGSRC_", length = 255)
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	@Column(name = "ISABSOLUTE_")
	public Boolean getIsAbsolute() {
		return isAbsolute;
	}
	public void setIsAbsolute(Boolean isAbsolute) {
		this.isAbsolute = isAbsolute;
	}

	@Column(name = "ISENABLE_")
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(name = "SHOWINDEX_", length = 10)
	public Integer getShowIndex() {
		return showIndex;
	}
	public void setShowIndex(Integer showIndex) {
		this.showIndex = showIndex;
	}

	@Column(name = "CREATETIME_", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "DESC_", length = 500)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
