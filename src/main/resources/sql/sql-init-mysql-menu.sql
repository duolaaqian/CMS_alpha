/*==============================================================*/
/* Table:OA_BASIC_MENU                 				菜单表	    */
/*==============================================================*/
CREATE TABLE OA_BASIC_MENU (
   ID_					VARCHAR(50) 			NOT NULL COMMENT '唯一标识', 
   PID_					VARCHAR(50) 			COMMENT '父节点ID', 
   NAME_				VARCHAR(255) 			COMMENT '菜单名称', 
   CODE_				VARCHAR(255) 			COMMENT '菜单编码', 
   URL_					VARCHAR(255) 			COMMENT '菜单路径', 
   IMGSRC_				VARCHAR(255) 			COMMENT '图标', 
   ISABSOLUTE_			INT(1) DEFAULT '0' 		COMMENT '是否是绝对路径', 
   ISENABLE_			INT(1) DEFAULT '1' 		COMMENT '是否可用', 
   SHOWINDEX_			INT(10) 				COMMENT '显示顺序', 
   CREATETIME_			VARCHAR(20) 			COMMENT '创建时间', 
   DESC_				VARCHAR(1000) 			COMMENT '描述', 
   PRIMARY KEY (ID_)
 );
 
