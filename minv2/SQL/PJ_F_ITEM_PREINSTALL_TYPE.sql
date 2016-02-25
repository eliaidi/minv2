--------------------------------------------------------
--  文件已创建 - 星期二-二月-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PJ_F_ITEM_PREINSTALL_TYPE
--------------------------------------------------------

  CREATE TABLE "TEST"."PJ_F_ITEM_PREINSTALL_TYPE" 
   (	"ID" NUMBER, 
	"PJ_F_I_ID" NUMBER, 
	"PJ_F_I_PREINSTALL_TYPE_ID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
 

   COMMENT ON COLUMN "TEST"."PJ_F_ITEM_PREINSTALL_TYPE"."ID" IS '主键<序列自增>';
 
   COMMENT ON COLUMN "TEST"."PJ_F_ITEM_PREINSTALL_TYPE"."PJ_F_I_ID" IS '检修项目表ID';
 
   COMMENT ON COLUMN "TEST"."PJ_F_ITEM_PREINSTALL_TYPE"."PJ_F_I_PREINSTALL_TYPE_ID" IS '检修项目分类表ID';
 
   COMMENT ON TABLE "TEST"."PJ_F_ITEM_PREINSTALL_TYPE"  IS '检修项目-预设配件检修项目分类表-中间表';
REM INSERTING into TEST.PJ_F_ITEM_PREINSTALL_TYPE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0012204
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."SYS_C0012204" ON "TEST"."PJ_F_ITEM_PREINSTALL_TYPE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PJ_F_ITEM_PREINSTALL_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST"."PJ_F_ITEM_PREINSTALL_TYPE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PJ_F_ITEM_PREINSTALL_TYPE
--------------------------------------------------------

  ALTER TABLE "TEST"."PJ_F_ITEM_PREINSTALL_TYPE" ADD CONSTRAINT "PFIPTPFIPT_FOR" FOREIGN KEY ("PJ_F_I_PREINSTALL_TYPE_ID")
	  REFERENCES "TEST"."PJ_FIX_ITEM_PREINSTALL_TYPE" ("ID") ENABLE;
 
  ALTER TABLE "TEST"."PJ_F_ITEM_PREINSTALL_TYPE" ADD CONSTRAINT "PFIPTPFI_FOR" FOREIGN KEY ("PJ_F_I_ID")
	  REFERENCES "TEST"."PJ_FIX_ITEM" ("ID") ENABLE;
