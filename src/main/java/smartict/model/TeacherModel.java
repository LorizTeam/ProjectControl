package smartict.model;

import java.sql.Date;

import org.joda.time.DateTime;

public class TeacherModel extends PersonModel {
	int teacher_id;

	public TeacherModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherModel(String firstname, String lastname, String identification, String addr_no, String addr_bloc,
			String addr_village, String addr_alley, String addr_road, String addr_provinceid, String addr_aumphurid,
			String addr_districtid, String addr_zipcode, String tel_number, String email, String line_id,
			String username, String password, String identification_type_name, String prename_name_short,
			String province_name, String amphur_name, String district_name, Date startdate, Date createdatetime,
			int prename_id, int identification_type_id, int teacher_id) {
		
		super(firstname, lastname, identification, addr_no, addr_bloc, addr_village, addr_alley, addr_road, addr_provinceid,
				addr_aumphurid, addr_districtid, addr_zipcode, tel_number, email, line_id, username, password,
				identification_type_name, prename_name_short, province_name, amphur_name, district_name, startdate,
				createdatetime, prename_id, identification_type_id);
		this.teacher_id = teacher_id;
	}

	public TeacherModel(int teacher_id) {
		super();
		this.teacher_id = teacher_id;
	}


	public int getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	
}
