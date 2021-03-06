--------------------------------------------------------
--  文件已创建 - 星期二-二月-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PJ_STORE_STATIC_INFO
--------------------------------------------------------

  CREATE TABLE "TEST"."PJ_STORE_STATIC_INFO" 
   (	"ID" NUMBER, 
	"PJ_PARENT_ID" NUMBER, 
	"PJ_NAME" VARCHAR2(255 BYTE), 
	"PJ_LOWE_STSTORE" VARCHAR2(255 BYTE), 
	"PJ_ACTIVATE" NUMBER DEFAULT 1, 
	"PJ_ASSEMBLY_TYPE" NUMBER, 
	"PY" VARCHAR2(255 BYTE), 
	"REMARK" VARCHAR2(1000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 

   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."ID" IS '主键<序列自动增长>';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."PJ_PARENT_ID" IS '配件父级ID';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."PJ_NAME" IS '配件名称';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."PJ_LOWE_STSTORE" IS '最小库存量（当配件动态表=《最小库存，标红报警）';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."PJ_ACTIVATE" IS '是否启用：0、不启用；1、启用；默认1';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."PJ_ASSEMBLY_TYPE" IS '配件组装状态：0:车上组装；1:配件组装';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."PY" IS '拼音';
 
   COMMENT ON COLUMN "TEST"."PJ_STORE_STATIC_INFO"."REMARK" IS '备注';
 
   COMMENT ON TABLE "TEST"."PJ_STORE_STATIC_INFO"  IS '配件仓库静态/基本信息表';
REM INSERTING into TEST.PJ_STORE_STATIC_INFO
SET DEFINE OFF;
Insert into TEST.PJ_STORE_STATIC_INFO (ID,PJ_PARENT_ID,PJ_NAME,PJ_LOWE_STSTORE,PJ_ACTIVATE,PJ_ASSEMBLY_TYPE,PY,REMARK) values (21,22,'火车轮子','1',1,0,'hclz',null);
Insert into TEST.PJ_STORE_STATIC_INFO (ID,PJ_PARENT_ID,PJ_NAME,PJ_LOWE_STSTORE,PJ_ACTIVATE,PJ_ASSEMBLY_TYPE,PY,REMARK) values (22,24,'车干轮轴','2',1,0,'cglz',null);
Insert into TEST.PJ_STORE_STATIC_INFO (ID,PJ_PARENT_ID,PJ_NAME,PJ_LOWE_STSTORE,PJ_ACTIVATE,PJ_ASSEMBLY_TYPE,PY,REMARK) values (7,null,'柴油机','1',1,1,'cyj',null);
Insert into TEST.PJ_STORE_STATIC_INFO (ID,PJ_PARENT_ID,PJ_NAME,PJ_LOWE_STSTORE,PJ_ACTIVATE,PJ_ASSEMBLY_TYPE,PY,REMARK) values (24,21,'齿轮','10',0,0,'cl',null);
Insert into TEST.PJ_STORE_STATIC_INFO (ID,PJ_PARENT_ID,PJ_NAME,PJ_LOWE_STSTORE,PJ_ACTIVATE,PJ_ASSEMBLY_TYPE,PY,REMARK) values (27,28,'牵引电机','0',1,0,'qydj',null);
Insert into TEST.PJ_STORE_STATIC_INFO (ID,PJ_PARENT_ID,PJ_NAME,PJ_LOWE_STSTORE,PJ_ACTIVATE,PJ_ASSEMBLY_TYPE,PY,REMARK) values (28,27,'柴油机','2',1,1,'cyj',null);
--------------------------------------------------------
--  DDL for Index SYS_C0012184
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."SYS_C0012184" ON "TEST"."PJ_STORE_STATIC_INFO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PJ_STORE_STATIC_INFO
--------------------------------------------------------

  ALTER TABLE "TEST"."PJ_STORE_STATIC_INFO" ADD CONSTRAINT "PSSI_CK_ACTIVATE" CHECK (PJ_ACTIVATE in(0,1)) ENABLE;
 
  ALTER TABLE "TEST"."PJ_STORE_STATIC_INFO" ADD CONSTRAINT "PSSI_CK_TYPE" CHECK (PJ_ASSEMBLY_TYPE in(0,1)) ENABLE;
 
  ALTER TABLE "TEST"."PJ_STORE_STATIC_INFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PJ_STORE_STATIC_INFO
--------------------------------------------------------

  ALTER TABLE "TEST"."PJ_STORE_STATIC_INFO" ADD CONSTRAINT "PSSIPSSI_FOR" FOREIGN KEY ("PJ_PARENT_ID")
	  REFERENCES "TEST"."PJ_STORE_STATIC_INFO" ("ID") ENABLE;
