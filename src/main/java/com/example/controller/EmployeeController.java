package com.example.controller;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 従業員情報を操作するコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpForm() {
		return new UpdateEmployeeForm();
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員一覧を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員一覧画面を出力します.
	 * 
	 * @param model モデル
	 * @return 従業員一覧画面
	 */
	@GetMapping("/showList")
	public String showList(Employee employee,Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/List";
	}

	@GetMapping("/findName")
	public String showFind(String name, Model model) {
		List<Employee> employeeList = employeeService.findName(name);
		model.addAttribute("employeeList", employeeList);
		return "employee/List";
	}
	
	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細画面を出力します.
	 * 
	 * @param id    リクエストパラメータで送られてくる従業員ID
	 * @param model モデル
	 * @return 従業員詳細画面
	 */
	@GetMapping("/showDetail")
	public String showDetail(UpdateEmployeeForm form, Model model) {
		Employee employee = new Employee();
		employee = employeeService.showDetail(Integer.parseInt(form.getId()));
		
		if(form.getName() == null) {
			employee = employeeService.showDetail(Integer.parseInt(form.getId()));
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try{
				date = format.parse(form.getHireDate());
			} catch (Exception e) {
				return showDetail(form, model);
			}
			employee.setId(form.getIntId());
			employee.setName(form.getName());
			employee.setGender(form.getGender());
			employee.setHireDate(date);
			employee.setMailAddress(form.getMailAddress());
			employee.setZipCode(form.getZipCode());
			employee.setAddress(form.getAddress());
			employee.setTelephone(form.getTelephone());
			employee.setSalary(form.getIntSalary());
			employee.setCharacteristics(form.getCharacteristics());
			employee.setDependentsCount(form.getIntDependentsCount());

		}
		
		List<String> genderList = new ArrayList<>();
		genderList.add("男性");
		genderList.add("女性");
		
		model.addAttribute("genderList", genderList);
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を更新する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細(ここでは扶養人数のみ)を更新します.
	 * 
	 * @param form 従業員情報用フォーム
	 * @return 従業員一覧画面へリダクレクト
	 */
	@PostMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
		System.out.println("test");

		if (result.hasErrors()) {
			return showDetail(form, model);
		}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			try{
				date = format.parse(form.getHireDate());
			} catch (Exception e) {
				return showDetail(form, model);
			}

			Employee employee = new Employee();
			employee.setId(form.getIntId());
			employee.setName(form.getName());
			employee.setGender(form.getGender());
			employee.setHireDate(date);
			employee.setMailAddress(form.getMailAddress());
			employee.setZipCode(form.getZipCode());
			employee.setAddress(form.getAddress());
			employee.setTelephone(form.getTelephone());
			employee.setSalary(form.getIntSalary());
			employee.setCharacteristics(form.getCharacteristics());
			employee.setDependentsCount(form.getIntDependentsCount());

		return "redirect:/employee/showList";
	}
}
