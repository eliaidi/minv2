--------------------------------------------------------
--  文件已创建 - 星期二-二月-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DICT_JC_FIX_MILEAGE
--------------------------------------------------------

  CREATE TABLE "TEST"."DICT_JC_FIX_MILEAGE" 
   (	"ID" NUMBER, 
	"FIX_MILEAGE_VALUE" VARCHAR2(255 BYTE), 
	"REMARK" VARCHAR2(1000 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into TEST.DICT_JC_FIX_MILEAGE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0012159
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."SYS_C0012159" ON "TEST"."DICT_JC_FIX_MILEAGE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DICT_JC_FIX_MILEAGE
--------------------------------------------------------

  ALTER TABLE "TEST"."DICT_JC_FIX_MILEAGE" MODIFY ("FIX_MILEAGE_VALUE" NOT NULL ENABLE);
 
  ALTER TABLE "TEST"."DICT_JC_FIX_MILEAGE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;

