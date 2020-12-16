package banks;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Entity
@Table(name="staff")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "level")
	private String level;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DepositAccount> depositaccount;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SpendAccount> spendaccount;
}
