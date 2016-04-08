# internship
启动项目后，进入mysql数据库，需要向t_user表插入一条数据，t_user表是用来验证登陆的
insert into t_user(username,password,rights) values('S2014250','S2014250',1)

t_user表中的rights表示权限，用来控制用户的类别，现在设置的学生的权限为1,所以插入数据的时候权限的之为1
