package banks;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name="staff")
public class Staff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id") 
	private int id;
	@Column(name = "idstaff")
	private  String idstaff;
	@Column(name = "name")
	private  String name;
	@Column(name = "idcard")
	private  String idcard;
	@Column(name = "experience")
	private  int experience;
	@Column(name = "dob")
	private  String dob;
	@Column(name = "address")
	private  String address;
	@Column(name = "phonenumber")
	private  String phonenumber;
	@Column(name = "position")
	private  String position;
	@Column(name = "level")
	private String level;

}
