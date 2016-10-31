select c.`id`,c.`investfirm_id`, c.investfirm_name,c.`investfirm_link`,c.`invest_num`,c.`invest_money`,c.`invest_industry`,c.`invest_round`,c.`invest_month_rate`,c.`newest_invest_projects` from dm_invest_events a left join dm_invest_events_investfirm b on a.id=b.`event_id` left join dm_investfirms_data c on b.`investfirm_id`= c.`investfirm_id` 
WHERE a.`industry_id` in ( 1 ) AND a.`round_id` in ( 9 ) group by c.`id` order by id desc limit 0,15;



select * from sop_project;



select * from dm_industry_reports


truncate table dm_industry_reports;


drop table dm_industry_reports;
CREATE TABLE `dm_industry_reports` (	
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `publish_date` datetime DEFAULT NULL COMMENT '发布日期（源）',
  `source_type` int(1) DEFAULT NULL COMMENT '1. 艾瑞网 2.易观',
  `source_url` varchar(255) DEFAULT NULL COMMENT '源地址',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `industry_id` int(11) not null DEFAULT -1 COMMENT '一级行业分类id',
  `industry_sub_id` int(11) not null default -1 COMMENT '二级行业分类id',
  `summary_short` text COMMENT '摘要',
  `summary` MEDIUMTEXT COMMENT '正文',
  `craw_summary` MEDIUMTEXT COMMENT '抓到的原始数据',
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `source_id` varchar(32) NOT NULL DEFAULT '0',
  `year` int(11) NOT NULL DEFAULT '2016',
  `doc_type` tinyint(4) NOT NULL DEFAULT '1',
  `source_type_name` varchar(100) NOT null default "",
  `tags` varchar(100) NOT null default "",
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 COMMENT='行业报告'


update dm_industry_reports set icon=   concat("/iresearch/report/",source_id,"/face.png")  where source_type =2
 
select id, industry_id, summary_short from dm_industry_reports 


select * from dw_v_industry where parent_id = 0

1	金融	FIN	0	1
2	教育培训		0	2
3	汽车交通		0	3
4	本地生活		0	4
5	医疗健康		0	5
6	企业服务		0	6
7	社交网络		0	7
8	旅游户外		0	8
9	硬件		0	9
10	广告营销		0	10
11	文化娱乐		0	11
12	体育运动		0	12
13	物流		0	13
14	房产服务		0	14
15	电子商务	EC	0	15
16	游戏		0	16
17	工具软件		0	17
18	云计算大数据		0	18


 update  dm_industry_reports set industry_id = 3 where summary_short like "%汽车%" or summary_short like "%交通%" ;
 
  update  dm_industry_reports set industry_id = 1 where summary_short like "%金融%"  ;
  update  dm_industry_reports set industry_id = 2 where summary_short like "%教育%";
   update  dm_industry_reports set industry_id = 4 where summary_short like "%生活%";
  update  dm_industry_reports set industry_id = 5 where summary_short like "%医疗%" or summary_short like "%健康%" ;
  update  dm_industry_reports set industry_id = 6 where summary_short like "%企业服务%" or summary_short like "%企业服务%" ;
  update  dm_industry_reports set industry_id = 7 where summary_short like "%社交%"  ;
  update  dm_industry_reports set industry_id = 8 where summary_short like "%广告营销%" or summary_short like "%户外%" ;
  update  dm_industry_reports set industry_id = 9 where summary_short like "%硬件%" ;
  update  dm_industry_reports set industry_id = 10 where summary_short like "%营销%" or summary_short like "%广告%" ;
   update  dm_industry_reports set industry_id = 11 where summary_short like "%文化%" or summary_short like "%娱乐%" ; 
  
    update  dm_industry_reports set industry_id = 12 where summary_short like "%体育%" or summary_short like "%运动%" ;
 update  dm_industry_reports set industry_id = 13 where summary_short like "%物流%" or summary_short like "%物流%" ;
  update  dm_industry_reports set industry_id = 14 where summary_short like "%房产%" or summary_short like "%房产%" ;
   update  dm_industry_reports set industry_id = 15 where summary_short like "%电子商务%" or summary_short like "%商务%" ;
update  dm_industry_reports set industry_id = 16 where summary_short like "%游戏	%" or summary_short like "%游戏%" ;
 update  dm_industry_reports set industry_id = 17 where summary_short like "%软件%" or summary_short like "%工具%" ;
  update  dm_industry_reports set industry_id = 18 where summary_short like "%云计算%" or summary_short like "%大数据%" ;
 
 select * from dm_industry_reports where industry_id != -1
 
 ALTER TABLE edw2.dm_industry_reports ADD industry_name varchar(10) NOT null default ""
 
 update dm_industry_reports dir left join dw_v_industry dvi on dir.industry_id = dvi.id set 
	dir.industry_name = dvi.title
	where dvi.parent_id = 0
	
	
 
 