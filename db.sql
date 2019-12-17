-- drop database if exists test;
--
-- create database test charset=utf8;
--
-- use test;
--
-- create table 'user'(
--   id int primary key auto_increment,
--   userName varchar (255),
--   passWord varchar (255)
-- );
--
-- insert into user(userName,passWord) value('admin1','admin1');
-- insert into user(userName,passWord) value('admin2','admin2');
-- insert into user(userName,passWord) value('admin3','admin3');
--
-- -- 1．列出至少有一个员工的所有部门。
 -- select DNAME from dept,emp group by dept.dName having count(*) >1
-- 2．列出薪金比“SMITH”多或者相等的所有员工。

-- 3．列出所有员工的姓名及其直接上级的姓名。

-- 4．列出受雇日期早于其直接上级的所有员工。

-- 5．列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门

-- 6．列出所有“CLERK”（办事员）的姓名及其部门名称。

-- 7．列出最低薪金大于1500的各种工作。

-- 8．列出在部门“SALES”（销售部）工作的员工的姓名，假定不知道销售部的部门编号。

-- 9．列出薪金高于公司平均薪金的所有员工。

-- 10．列出与“SCOTT”从事相同工作的所有员工。

-- 11．列出薪金等于部门30中员工的薪金的所有员工的姓名和薪金。

-- 12．列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金。

-- 13．列出在每个部门工作的部门名称,员工数量、平均工资。

-- 14．列出所有员工的姓名、部门名称和工资(含奖金)。

-- 15．列出所有部门的详细信息和部门人数。

-- 16．列出各种工作的最低工资。

-- 17．列出各个MANAGER（经理）的最低薪金。

-- 18．列出所有员工的年工资,按年薪从低到高排序。

create table student(
  id int primary key auto_increment,
  name varchar (255),
  stuNO varchar (255),
  sex varchar(10)
);

insert into student(name,stuNO,sex) value('小米','30','女');
insert into student(name,stuNO,sex) value('小米','30','女');
insert into student(name,stuNO,sex) value('小米','30','女');
insert into student(name,stuNO,sex) value('小米','30','女');
insert into student(name,stuNO,sex) value('小米','30','女');
