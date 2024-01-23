package tw.eeit178.jdbc.msproject;

import java.io.Serializable;

//JavaBean (寫建構子跟getset) //根據MemberDaoJdbcImpl中要用幾個欄位就用bean中的哪一個建構子
public class MsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String yearOfRoc;
	private String semester;
	private String className;
	private String teacherName;
	private String classTime;
	private String student;

	public MsBean() {
	}

	public MsBean(int id,String yearOfRoc, String semester, String className,
			      String teacherName,String classTime,String student) {
		this.id=id;
		this.yearOfRoc = yearOfRoc;
		this.semester = semester;
		this.className = className;
		this.teacherName=teacherName;
		this.classTime=classTime;
		this.student=student;
	}

	public MsBean(String classTime,int id) {
		this.classTime=classTime;
		this.id=id;
	}



	public String getYearOfRoc() {
		return yearOfRoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setYearOfRoc(String yearOfRoc) {
		this.yearOfRoc = yearOfRoc;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}
	
	
	@Override
	public String toString() {
		return "年度:" + yearOfRoc + "，" + "學期:" + semester + "，" + "班級名稱:" + className + "，" + "老師:" + teacherName + "，"
				+ "開課日期:" + classTime + "，" + "學生人數:" + student;
	}
}


