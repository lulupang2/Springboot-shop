package springshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@DynamicInsert // Insert시 Null인 필드 제외
@DynamicUpdate // Update시 Null인 필드 제외
@Table(name = "users")
@Entity
@Getter
@Setter
public class Users {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usernum;
	private String userid;
	private String username;
	private String useremail;
	private String userpasswd;
	private String addr1;
	private String addr2;
	private String addr3;
	@Column(name = "createdate")
	private String usercreatedate;
}
