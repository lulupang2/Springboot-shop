package springshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long p_num;
	private String p_name;
	private String p_price;
	private String p_category;
	private String p_details;
	private String p_img1;
	private String p_img2;
	private String p_createdate;

}
