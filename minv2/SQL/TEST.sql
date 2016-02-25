--------------------------------------------------------
--  文件已创建 - 星期二-二月-02-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TEST
--------------------------------------------------------

  CREATE TABLE "TEST"."TEST" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(255 BYTE), 
	"PASSWORD" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 

   COMMENT ON TABLE "TEST"."TEST"  IS '测试表';
REM INSERTING into TEST.TEST
SET DEFINE OFF;
Insert into TEST.TEST (ID,NAME,PASSWORD) values (48,'andy1212','3545');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (11,'haohao','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (13,'abc','abc');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (15,'65','45');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (23,'111','222');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (38,'123','234234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (39,'123','23423');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (40,'123','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (41,'123','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (42,'123','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (43,'123','2342');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (44,'123','123');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (45,'123','12312');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (46,'倒萨大',null);
Insert into TEST.TEST (ID,NAME,PASSWORD) values (2,'andy','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (20,'234','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (28,'倒萨大',null);
Insert into TEST.TEST (ID,NAME,PASSWORD) values (29,'123','12312');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (6,'12345','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (14,'17','123');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (17,'5','6');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (18,'4','4');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (19,'7','9');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (30,'123','123');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (31,'123','2342');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (32,'123','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (33,'123','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (34,'123','234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (35,'123','23423');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (36,'123','234234');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (37,null,null);
Insert into TEST.TEST (ID,NAME,PASSWORD) values (3,'qq3','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (4,'qq4','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (5,'qq5','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (7,'wawa','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (8,'lala','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (9,'xiaoxiao','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (10,'xidada',null);
Insert into TEST.TEST (ID,NAME,PASSWORD) values (12,'haha','123456');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (16,'5','5');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (24,'222','333');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (25,'44','55');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (26,'22','333');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (27,'55','66');
Insert into TEST.TEST (ID,NAME,PASSWORD) values (47,'1','3545');
--------------------------------------------------------
--  DDL for Index PK_USER_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "TEST"."PK_USER_ID" ON "TEST"."TEST" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TEST
--------------------------------------------------------

  ALTER TABLE "TEST"."TEST" ADD CONSTRAINT "PK_USER_ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "TEST"."TEST" MODIFY ("ID" NOT NULL ENABLE);

