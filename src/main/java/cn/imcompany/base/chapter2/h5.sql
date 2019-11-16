use asg;

-- 1、创建临时表
CREATE TABLE `b_h5_sign_temp` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) DEFAULT NULL COMMENT 'uid',
  `sign_time` timestamp NULL DEFAULT NULL COMMENT '签到时间',
  `pline` varchar(10) DEFAULT NULL COMMENT '产品线',
  `ctime` timestamp NULL DEFAULT NULL,
  `utime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sign_time_uid_pline` (`uid`,`sign_time`,`pline`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

-- 2、导出数据
select * from b_h5_sign where sign_time>=date_sub(NOW(), interval 2 MONTH) into outfile '/var/lib/mysql-files/b_h5_sign.sql' fields terminated by '#$' LINES TERMINATED BY '\r\n';

-- 3、导入
load data infile '/var/lib/mysql-files/b_h5_sign.sql' ignore into table b_h5_sign_temp fields terminated by '#$' LINES TERMINATED BY '\r\n';

-- 4、导增量
insert into b_h5_sign_temp select * from b_h5_sign where id>(select max(id) from b_h5_sign_temp);

-- 5、重命名表
alter table b_h5_sign rename to  `b_h5_sign_1111` ;
alter table b_h5_sign_temp rename to b_h5_sign;

-- 以下语句增加到每天定时任务
delete from b_h5_sign where ctime<(select date_sub(curdate(), interval 2 MONTH));
