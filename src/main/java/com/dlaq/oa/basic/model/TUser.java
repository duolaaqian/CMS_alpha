package com.dlaq.oa.basic.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dlaq.oa.basic.role.TRole;

//@Table(name="t_user")
//public class TUser{
@Entity
@Table(name="oa_basic_ug_user")
public class TUser implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String username;
	
	private String password;
	
	private String realName;
	
	private Integer showIndex = 1;
	
	private String state = "1";
	
	private String org;
	
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
	
	@Column(name = "REALNAME_", length = 122)
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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
	
	@Column(name = "ORG_", length = 50)
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	
	
	//spring security start
	protected Collection<GrantedAuthority>	authorities;
	
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(null==authorities){
			authorities	= new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return authorities;
	}

	@Column(name = "PASSWORD_", length = 255)
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "USERNAME_", length = 255)
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Transient
	public boolean isEnabled() {
		return "1".equals(this.state) ? true : false;
	}
	//spring security end
	
	
	//others start
	private Set<TRole> roles;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "OA_BASIC_UG_ROLETOUSER", 
				joinColumns = {@JoinColumn(name = "USERID_")}, 
				inverseJoinColumns = {@JoinColumn(name = "ROLEID_")})
	public Set<TRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<TRole> roles) {
		this.roles = roles;
	}
	
	
	//others end

}
