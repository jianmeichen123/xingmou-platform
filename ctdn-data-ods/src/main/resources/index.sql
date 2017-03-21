

-----------------------+
| alexa_pv_uv           |
| aso_ios_down          |
| aso_ios_rate          |
| aso_ios_rate_daily    |
| dw_project            |
| op_indice_summary     |
| qq_android_down       |
| qq_android_rate       |
| qq_android_rate_daily |
| weibo_indice          |
| weixin_indice


alter table alexa_pv_uv add column code char(6) not null default "";
alter table aso_ios_down add column code char(6) not null default "";
alter table aso_ios_rate add column code char(6) not null default "";
alter table aso_ios_rate_daily add column code char(6) not null default "";
alter table dw_project add column code char(6) not null default "";
alter table op_indice_summary add column code char(6) not null default "";
alter table qq_android_down add column code char(6) not null default "";
alter table qq_android_rate add column code char(6) not null default "";
alter table qq_android_rate_daily add column code char(6) not null default "";
alter table weibo_indice add column code char(6) not null default "";
alter table weixin_indice add column code char(6) not null default "";


alter table aso_iosalexa_pv_uv_down add index code(code);
alter table aso_ios_down add index code(code);
alter table aso_ios_rate add index code(code);
alter table aso_ios_rate_daily add index code(code);
alter table dw_project add index code(code);
alter table op_indice_summary add index code(code);
alter table aso_ios_down add index code(code);
alter table aso_ios_down add index code(code);
alter table aso_ios_down add index code(code);
alter table aso_ios_down add index code(code);
alter table aso_ios_down add index code(code);
alter table aso_ios_down add index code(code);