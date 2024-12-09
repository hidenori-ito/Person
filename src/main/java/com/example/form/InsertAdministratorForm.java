package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "必須項目です。")
	@Size(min=1,max=100, message = "100文字以下で入力してください")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "必須項目です。")
	@Email(message = "Emailの形式で入力してください")
	@Size(max=100, message = "100文字以下で入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "必須項目です。")
	@Size(max=100, message = "100文字以下で入力してください")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

}
