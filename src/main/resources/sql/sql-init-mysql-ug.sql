/*==============================================================*/
/* Table:OA_BASIC_UG_USER                      组织结构-用户表          */
/*==============================================================*/
CREATE TABLE OA_BASIC_UG_USER (
   ID_                  VARCHAR(50)          NOT NULL COMMENT '表唯一标识',
   USERNAME_            VARCHAR(255)         NULL COMMENT '登录名',
   PASSWORD_            VARCHAR(50)          NULL COMMENT '密码',
   REALNAME_            VARCHAR(255)         NULL COMMENT '用户名称',
   SHOWINDEX_           INT                  NULL COMMENT '序号',
   STATE_               VARCHAR(1)           NULL DEFAULT '1' COMMENT '是否屏蔽',
   ORG_             	VARCHAR(50)          NULL COMMENT '所属部门',
  PRIMARY KEY (ID_)
);
/*==============================================================*/
/* Table:OA_BASIC_UG_ROLE                          组织结构-角色表	*/
/*==============================================================*/
CREATE TABLE OA_BASIC_UG_ROLE (
	ID_					VARCHAR(50)				NOT NULL COMMENT '表唯一标识',
	ROLECODE_			VARCHAR(255)			NULL COMMENT '角色编码',
	ROLENAME_			VARCHAR(255)			NULL COMMENT '角色名称',
	DESC_				VARCHAR(200)			NULL COMMENT '角色简介',
	SHOWINDEX_			INT						NULL COMMENT '显示序号',
	STATE_				VARCHAR(1)				NULL DEFAULT '1' COMMENT '是否屏蔽',
	CREATEDATE_			VARCHAR(20)				NULL COMMENT '创建时间',
	PRIMARY KEY (ID_)
);
/*==============================================================*/
/* Table:OA_BASIC_UG_ROLETOUSER                 组织结构-角色用户中间表    */
/*==============================================================*/
CREATE TABLE OA_BASIC_UG_ROLETOUSER (
   USERID_              VARCHAR(50)          NULL COMMENT '用户ID',
   ROLEID_              VARCHAR(50)          NULL COMMENT '角色ID'
 );

