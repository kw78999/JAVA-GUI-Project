    CREATE TABLE "BOOKS" 
   (	"BID" NUMBER, 
	"ISBN" VARCHAR2(250 BYTE) , 
	"TITLE" VARCHAR2(250 BYTE) , 
	"AUTHOR" VARCHAR2(250 BYTE), 
	"PUBLISHER" VARCHAR2(250 BYTE), 
	"LOCATION" VARCHAR2(250 BYTE) NOT NULL ENABLE, 
	"BOOKSTATE" VARCHAR2(250 BYTE) NOT NULL ENABLE, 
	"BCOPY" VARCHAR2(50 BYTE), 
	"BDATE" DATE NOT NULL ENABLE, 
	"BCOUNT" NUMBER NOT NULL ENABLE, 
	"BIMAGE" VARCHAR2(50 BYTE), 
 	"CATE" VARCHAR2(50 BYTE) NOT NULL ENABLE,
	 PRIMARY KEY ("BID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;