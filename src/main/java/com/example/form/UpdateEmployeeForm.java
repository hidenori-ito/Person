package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 従業員情報更新時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class UpdateEmployeeForm {
	/** id */
	private String id;
	/** 従業員名 */
	@NotBlank(message = "必須項目です。")
	@Size(max = 20, message = "20文字以下で入力してください")
	private String name;
	/** 画像 */
	private String image;
	/** 性別 */
	@NotEmpty(message = "必須項目です。")
	private String gender;
	/** 入社日 */
	@NotNull(message = "必須項目です。")
	private String hireDate;
	/** メールアドレス */
	@NotBlank(message = "必須項目です。")
	@Email(message = "メールアドレスの形式で入力してください")
	@Size(max = 50, message = "50文字以下で入力してください")
	private String mailAddress;
	/** 郵便番号 */
	@NotBlank(message = "必須項目です。")
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}", message = "郵便番号の形式で入力してください")
	private String zipCode;
	/** 住所 */
	@NotBlank(message = "必須項目です。")
	@Size(max = 100, message = "100文字以下で入力してください")
	private String address;
	/** 電話番号 */
	@NotBlank(message = "必須項目です。")
	@Pattern(regexp = "[0-9]{3}-[0-9¥-]{4}-[0-9]{4}", message = "正しい電話番号を入力してください")
	private String telephone;
	/** 給料 */
	@NotBlank(message = "必須項目です。")
	@Size(min = 0, max = 100, message = "0以上100万以下で入力してください")
	private String salary;
	/** 特性 */
	@NotBlank(message = "必須項目です。")
	@Size(max = 500, message = "500文字以下で入力してください")
	private String characteristics;
	/** 扶養人数 */
	@Size(min=0, max=10, message = "扶養人数は0人以上10人以下で入力してください")
	private String dependentsCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSalary() {
		return salary;
	}
	public Integer getIntSalary() {
		return Integer.parseInt(salary);
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	/**
	 * IDを数値として返します.
	 * 
	 * @return 数値のID
	 */
	public Integer getIntId() {
		return Integer.parseInt(id);
	}

	/**
	 * 扶養人数を数値として返します.
	 * 
	 * @return 数値の扶養人数
	 */
	public Integer getIntDependentsCount() {
		return Integer.parseInt(dependentsCount);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

}
