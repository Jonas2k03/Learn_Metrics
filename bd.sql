use lm_bd;

drop table if exists ASIG_COMP_DOCENTE;

drop table if exists RESULTAAP_RUBRICA;

drop table if exists TBL_ASIGNATURA;

drop table if exists TBL_COMPETENCIA;

drop table if exists TBL_CRITERIO;

drop table if exists TBL_DOCENTE;

drop table if exists TBL_NIVEL;

drop table if exists TBL_RA;

drop table if exists TBL_RUBRICA;

/*==============================================================*/
/* Table: ASIG_COMP_DOCENTE                                     */
/*==============================================================*/
create table ASIG_COMP_DOCENTE
(
   ASIG_ID              int not null,
   DOC_ID               int not null,
   COMP_ID              int not null,
   PERIODO              varchar(20),
   primary key (ASIG_ID, DOC_ID, COMP_ID)
);

/*==============================================================*/
/* Table: RESULTAAP_RUBRICA                                     */
/*==============================================================*/
create table RESULTAAP_RUBRICA
(
   RAP_ID               int not null,
   IDRUBRICA            char(10) not null,
   primary key (RAP_ID, IDRUBRICA)
);

/*==============================================================*/
/* Table: TBL_ASIGNATURA                                        */
/*==============================================================*/
create table TBL_ASIGNATURA
(
   ASIG_ID              int not null,
   ASIG_NOMBRE          varchar(100),
   ASIG_CREDITOS        int,
   ASIG_OBJETIVOS       varchar(500),
   ASIG_SEMESTRE        int,
   primary key (ASIG_ID)
);

/*==============================================================*/
/* Table: TBL_COMPETENCIA                                       */
/*==============================================================*/
create table TBL_COMPETENCIA
(
   COMP_ID              int not null,
   TBL_COMP_ID          int,
   COMP_DESCRIPCION     varchar(250),
   COMP_TIPO            varchar(50),
   COMP_NIVEL           varchar(50),
   primary key (COMP_ID)
);

/*==============================================================*/
/* Table: TBL_CRITERIO                                          */
/*==============================================================*/
create table TBL_CRITERIO
(
   IDCRITERIO           int not null,
   IDRUBRICA            char(10),
   CRI_DESCRIPCION      varchar(50),
   primary key (IDCRITERIO)
);

/*==============================================================*/
/* Table: TBL_DOCENTE                                           */
/*==============================================================*/
create table TBL_DOCENTE
(
   DOC_ID               int not null,
   DOC_TIPOIDENTIFICACION varchar(50),
   DOC_TIPODOCENTE      varchar(50),
   DOC_NOMBRES          varchar(100),
   DOC_APELLIDOS        varchar(100),
   DOC_IDENTIFICACION   varchar(100),
   DOC_TITULO           varchar(100),
   primary key (DOC_ID)
);

/*==============================================================*/
/* Table: TBL_NIVEL                                             */
/*==============================================================*/
create table TBL_NIVEL
(
   IDNIVEL              int not null,
   IDCRITERIO           int,
   NIVELDESCRIPCION     varchar(50),
   NIVELRANGONOTA       varchar(50),
   primary key (IDNIVEL)
);

/*==============================================================*/
/* Table: TBL_RA                                                */
/*==============================================================*/
create table TBL_RA
(
   RAP_ID               int not null,
   COMP_ID              int not null,
   RAP_DESCRIPCION      varchar(250),
   primary key (RAP_ID)
);

/*==============================================================*/
/* Table: TBL_RUBRICA                                           */
/*==============================================================*/
create table TBL_RUBRICA
(
   IDRUBRICA            char(10) not null,
   RUB_NOMBRE           char(10),
   RUB_NOTA             char(10),
   primary key (IDRUBRICA)
);

alter table ASIG_COMP_DOCENTE add constraint FK_ASIG_COMP_DOCENTE foreign key (ASIG_ID)
      references TBL_ASIGNATURA (ASIG_ID) on delete restrict on update restrict;

alter table ASIG_COMP_DOCENTE add constraint FK_ASIG_COMP_DOCENTE2 foreign key (DOC_ID)
      references TBL_DOCENTE (DOC_ID) on delete restrict on update restrict;

alter table ASIG_COMP_DOCENTE add constraint FK_ASIG_COMP_DOCENTE3 foreign key (COMP_ID)
      references TBL_COMPETENCIA (COMP_ID) on delete restrict on update restrict;

alter table RESULTAAP_RUBRICA add constraint FK_RESULTAAP_RUBRICA foreign key (RAP_ID)
      references TBL_RA (RAP_ID) on delete restrict on update restrict;

alter table RESULTAAP_RUBRICA add constraint FK_RESULTAAP_RUBRICA2 foreign key (IDRUBRICA)
      references TBL_RUBRICA (IDRUBRICA) on delete restrict on update restrict;

alter table TBL_COMPETENCIA add constraint FK_FK_COMPETENCIAPROGRAMA foreign key (TBL_COMP_ID)
      references TBL_COMPETENCIA (COMP_ID) on delete restrict on update restrict;

alter table TBL_CRITERIO add constraint FK_RELATIONSHIP_3 foreign key (IDRUBRICA)
      references TBL_RUBRICA (IDRUBRICA) on delete restrict on update restrict;

alter table TBL_NIVEL add constraint FK_RELATIONSHIP_4 foreign key (IDCRITERIO)
      references TBL_CRITERIO (IDCRITERIO) on delete restrict on update restrict;

alter table TBL_RA add constraint FK_COMP_RA_PRO foreign key (COMP_ID)
      references TBL_COMPETENCIA (COMP_ID) on delete restrict on update restrict;
