package springshop.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "products")
@DynamicInsert // Insert시 Null인 필드 제외
@DynamicUpdate // Update시 Null인 필드 제외
@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pnum;
	private String pname;
	private String pprice;
	private String pcategory;
	private String pdetails;
	private String pmanu;
	private String pimg1;
	private String pimg2;
	private String psubtitle;
	private String pquantity;	
	private LocalDateTime p_createdate;
	public long getPnum() {
		return pnum;
	}
	public void setPnum(long pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPdetails() {
		return pdetails;
	}
	public void setPdetails(String pdetails) {
		this.pdetails = pdetails;
	}
	public String getPmanu() {
		return pmanu;
	}
	public void setPmanu(String pmanu) {
		this.pmanu = pmanu;
	}
	public String getPimg1() {
		return pimg1;
	}
	public void setPimg1(String pimg1) {
		this.pimg1 = pimg1;
	}
	public String getPimg2() {
		return pimg2;
	}
	public void setPimg2(String pimg2) {
		this.pimg2 = pimg2;
	}
	public String getPsubtitle() {
		return psubtitle;
	}
	public void setPsubtitle(String psubtitle) {
		this.psubtitle = psubtitle;
	}
	public String getPquantity() {
		return pquantity;
	}
	public void setPquantity(String pquantity) {
		this.pquantity = pquantity;
	}
	public LocalDateTime getP_createdate() {
		return p_createdate;
	}
	public void setP_createdate(LocalDateTime p_createdate) {
		this.p_createdate = p_createdate;
	}
}
