CREATE TABLE `dm_industry_reports` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `publish_date` varchar(20) DEFAULT NULL COMMENT '发布日期（源）',
  `source_type` int(1) DEFAULT NULL COMMENT '1. 艾瑞网 2.易观',
  `source_url` varchar(255) DEFAULT NULL COMMENT '源地址',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `industry_id` int(11) DEFAULT NULL COMMENT '一级行业分类id',
  `industry_sub_id` int(11) DEFAULT NULL COMMENT '二级行业分类id',
  `summary_short` text COMMENT '摘要',
  `summary` MEDIUMTEXT COMMENT '正文',
  `craw_summary` MEDIUMTEXT COMMENT '抓到的原始数据',
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `source_id` int(11) NOT NULL DEFAULT '0',
  `year` int(11) NOT NULL DEFAULT '2016',
  `doc_type` tinyint(4) NOT NULL DEFAULT '1',
  `source_type_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 COMMENT='行业报告'

