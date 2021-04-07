
  CREATE TABLE "BMEMBERS" 
   (	"MID" NUMBER, 
	"MNAME" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"MGRADE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"MPHONE" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"MAXRENTAL" NUMBER NOT NULL ENABLE, 
	"ECOUNT" NUMBER NOT NULL ENABLE, 
	"ELIMIT" NUMBER NOT NULL ENABLE, 
	 PRIMARY KEY ("MID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
 insert into BMEMBERS(MID,MNAME,MGRADE,PHONE,MAXRENTAL,ECOUNT,ELIMIT)
values (seqmember.nextval, '�̰���','VIP', '010-3690-7733','7','20','7');