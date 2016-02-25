--------------------------------------------------------
--  文件已创建 - 星期二-二月-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PJ_FIX_ITEM_PREINSTALL_TYPE
--------------------------------------------------------

  CREATE TABLE "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE" 
   (	"ID" NUMBER, 
	"PREINSTALL_TYPE_NAME" VARCHAR2(255 BYTE), 
	"PJ_STATIC_ID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
 

   COMMENT ON COLUMN "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE"."ID" IS '主键<序列自增>';
 
   COMMENT ON COLUMN "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE"."PREINSTALL_TYPE_NAME" IS '预设配件检修项目分类名称';
 
   COMMENT ON COLUMN "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE"."PJ_STATIC_ID" IS '配件静态信息ID';
 
   COMMENT ON TABLE "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE"  IS '预设配件检修项目分类表';
REM INSERTING into TEST.PJ_FIX_ITEM_PREINSTALL_TYPE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0012209
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."SYS_C0012209" ON "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PJ_FIX_ITEM_PREINSTALL_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PJ_FIX_ITEM_PREINSTALL_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE" ADD CONSTRAINT "PFIPTPSSI_FOR" FOREIGN KEY ("PJ_STATIC_ID")
	  REFERENCES "TEST"."PJ_STORE_STATIC_INFO" ("ID") ENABLE;
