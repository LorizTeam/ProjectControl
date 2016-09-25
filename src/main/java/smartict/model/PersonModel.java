package smartict.model;

import java.sql.Date;

import org.joda.time.DateTime;

public class PersonModel {
	String firstname, lastname, identification,	addr_no, 
			addr_bloc, addr_village, addr_alley, addr_road, 
			addr_provinceid, addr_aumphurid, addr_districtid, addr_zipcode, 
			tel_number, email, line_id, username,
			password;
	Date startdate;
	DateTime createdatetime;
	int prename_id, identification_type_id;
	
	
	public PersonModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getAddr_no() {
		return addr_no;
	}
	public void setAddr_no(String addr_no) {
		this.addr_no = addr_no;
	}
	public String getAddr_bloc() {
		return addr_bloc;
	}
	public void setAddr_bloc(String addr_bloc) {
		this.addr_bloc = addr_bloc;
	}
	public String getAddr_village() {
		return addr_village;
	}
	public void setAddr_village(String addr_village) {
		this.addr_village = addr_village;
	}
	public String getAddr_alley() {
		return addr_alley;
	}
	public void setAddr_alley(String addr_alley) {
		this.addr_alley = addr_alley;
	}
	public String getAddr_road() {
		return addr_road;
	}
	public void setAddr_road(String addr_road) {
		this.addr_road = addr_road;
	}
	public String getAddr_provinceid() {
		return addr_provinceid;
	}
	public void setAddr_provinceid(String addr_provinceid) {
		this.addr_provinceid = addr_provinceid;
	}
	public String getAddr_aumphurid() {
		return addr_aumphurid;
	}
	public void setAddr_aumphurid(String addr_aumphurid) {
		this.addr_aumphurid = addr_aumphurid;
	}
	public String getAddr_districtid() {
		return addr_districtid;
	}
	public void setAddr_districtid(String addr_districtid) {
		this.addr_districtid = addr_districtid;
	}
	public String getAddr_zipcode() {
		return addr_zipcode;
	}
	public void setAddr_zipcode(String addr_zipcode) {
		this.addr_zipcode = addr_zipcode;
	}
	public String getTel_number() {
		return tel_number;
	}
	public void setTel_number(String tel_number) {
		this.tel_number = tel_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLine_id() {
		return line_id;
	}
	public void setLine_id(String line_id) {
		this.line_id = line_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public DateTime getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(DateTime createdatetime) {
		this.createdatetime = createdatetime;
	}
	public int getPrename_id() {
		return prename_id;
	}
	public void setPrename_id(int prename_id) {
		this.prename_id = prename_id;
	}
	public int getIdentification_type_id() {
		return identification_type_id;
	}
	public void setIdentification_type_id(int identification_type_id) {
		this.identification_type_id = identification_type_id;
	}
	
	
			
}
