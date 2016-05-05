package cn.internship.service;

import cn.internship.entity.Teacher;

/**
 * 教师业务层接口
 * @author MengHan
 */
public interface TeacherService {

	public Teacher login(String tno,String password);
	
	public void logout();
	
	public Teacher get(Integer teacherId);

	//修改密码
	public void updatePwd(Teacher teacher);
<<<<<<< HEAD
}
=======
}
>>>>>>> a1d593e20dfeeeab36222b998c8526a435ad4e31
