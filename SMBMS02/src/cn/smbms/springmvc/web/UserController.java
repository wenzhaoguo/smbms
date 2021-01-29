package cn.smbms.springmvc.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.util.Constants;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public String login(Model model, @RequestParam("userCode") String userName,
			@RequestParam("userPassword") String password) throws Exception {
		User user = userService.login(userName, password);
		if (user != null) {
			return "redirect:showUserList";
		} else {
			throw new RuntimeException("有错");
		}

	}

	@RequestMapping("showUserList")
	public String showUserList(Model model, String userName, Integer userRole) {
		List<User> userList;
		try {
			userList = userService.getUserList(userName, userRole);
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userlist";
	}

	@RequestMapping("/")
	public String toIndex() {
		return "login";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toadd(@ModelAttribute("user") User user) {
		return "useradd";
	}

	@RequestMapping(value = "/useradd", method = RequestMethod.POST)
	public String touseradd(@Valid User user,BindingResult bindingResult,HttpSession session) throws Exception {
		if(bindingResult.hasErrors()){
			return "useradd";
		}
		/*
		 * user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION))
		 * .getId());
		 */
		user.setCreationDate(new Date());
		if (userService.add(user) > 0) {
			return "redirect:showUserList";
		}
		return "add";
	}

	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String topassword(@ModelAttribute("user") User user) {
		return "pwdmodify";
	}
	@ResponseBody
	@RequestMapping(value = "/userdl")
	public String touserdl(Integer id, HttpSession session) throws Exception {
		int deleteUserById = userService.deleteUserById(id);
		String userdl = null;
		if (deleteUserById > 0) {
			userdl = "true";
		} else {
			userdl = "false";
		}
		return JSON.toJSONString(userdl);
	}

	
	@RequestMapping("showuserview")
	public String showuserview(Model model, Integer uid) {
			try {
				 User user = userService.getUserById(uid);
				model.addAttribute("user", user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "userview";
	}
	
	@RequestMapping(value = "/usermodify", method = RequestMethod.GET)
	public String usermodify(Integer uid,Model model) {
		//补个全查
		try {
			User userById = userService.getUserById(uid);
			model.addAttribute("user", userById);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usermodify";
	}
	

	@RequestMapping(value = "/usermodify2", method = RequestMethod.POST)
	public String usermodify2(User user, HttpSession session) throws Exception {
		int modify = userService.modify(user);
		if (modify>0) {
			return "redirect:showUserList";
		}
		return "usermodify";
	}
	
	
	
}
