package  com.gi.xm.platform.pojo;
import com.galaxyinternet.framework.core.model.BaseEntity;
import com.galaxyinternet.framework.core.model.BaseUser;
import com.galaxyinternet.framework.core.utils.DateUtil;
import com.galaxyinternet.framework.core.utils.GSONUtil;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

public class User extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@NotBlank(
			message = "真实姓名不能为空"
	)
	private String realName;
	@NotBlank(
			message = "登陆名称不能为空"
	)
	private String nickName;
	@NotBlank(
			message = "邮箱不能为空"
	)
	private String email;
	private String mobile;
	private String telephone;
	private String status;
	private Long departmentId;
	private String password;
	private long id;
	private Long roleCode;
	public User() {
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public Long getId() {
		return (Long)this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(Long roleCode) {
		this.roleCode = roleCode;
	}
}
