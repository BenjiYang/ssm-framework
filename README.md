# Create mysql in docker

* docker-compose infra/docker/mysql-docker-compose.yml

# Connects to mysql

``` proper
jdbc:mysql://localhost:3306/ssmbuild
root/123456
```

## create table

``` sql
CREATE DATABASE ssmbuild;
USE ssmbuild;
CREATE TABLE `books`
(
    `bookID`     INT          NOT NULL AUTO_INCREMENT COMMENT '书id',
    `bookName`   VARCHAR(100) NOT NULL COMMENT '书名',
    `bookCounts` INT          NOT NULL COMMENT '数量',
    `detail`     VARCHAR(200) NOT NULL COMMENT '描述',
    KEY `bookID` (`bookID`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;

INSERT INTO `books`(`bookID`, `bookName`, `bookCounts`, `detail`)
VALUES (1, 'Java', 1, '从入门到放弃'),
       (2, 'MySQL', 10, '从删库到跑路'),
       (3, 'Linux', 5, '从进门到进牢');                       
```
 Ref: 
 * [P3 - Tomcat setup](https://www.bilibili.com/video/BV1aE41167Tu?p=3&spm_id_from=pageDriver) (Tomcat setup: https://www.jianshu.com/p/8b49a110d878, chmod a+x /path/to/tomcat/bin/catalina.sh)
 * [P18 - Mybatis](https://www.bilibili.com/video/BV1aE41167Tu?p=18&spm_id_from=pageDriver)
 * [P19 - Spring](https://www.bilibili.com/video/BV1aE41167Tu?p=19&spm_id_from=pageDriver)
 * [P20 - SpringMVC](https://www.bilibili.com/video/BV1aE41167Tu?p=20&spm_id_from=pageDriver)   ([org.apache.catalina.core.StandardContext.filterStart 启动过滤器异常](https://blog.csdn.net/qq_41132565/article/details/111415274))
 * [bootstrap 官网](https://v3.bootcss.com/css/#forms)