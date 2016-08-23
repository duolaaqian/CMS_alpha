package com.dlaq.oa.basic.role;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.dlaq.oa.basic.model.TUser;


@Entity
@Table(name="oa_basic_ug_role")
public class TRole {
	

	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 角色编码
	 */
	private String roleCode;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色描述
	 */
	private String desc;
	
	/**
	 * 角色顺序
	 */
	private Integer showIndex;
	
	/**
	 * 角色状态
	 */
	private String state;
	
	/**
	 * 创建时间
	 */
	private String createTime;

	@Id
	@GenericGenerator(name="hibernate-uuid",strategy="uuid")
	@GeneratedValue(generator="hibernate-uuid")
	@Column(name="ID_", nullable=false, length=50, insertable=false, updatable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	@Column(name = "ROLECODE_", length = 255)
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	

	@Column(name = "ROLENAME_", length = 122)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

	@Column(name = "DESC_", length = 100)
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

	@Column(name = "SHOWINDEX_", length = 11)
	public Integer getShowIndex() {
		return showIndex;
	}
	public void setShowIndex(Integer showIndex) {
		this.showIndex = showIndex;
	}
	

	@Column(name = "STATE_", length = 1)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	@Column(name = "CREATEDATE_", length = 20)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	

	//others start
	private Set<TUser> users;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	public Set<TUser> getUsers() {
		return users;
	}
	public void setUsers(Set<TUser> users) {
		this.users = users;
	}
	//others end

}
