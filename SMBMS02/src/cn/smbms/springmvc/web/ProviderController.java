package cn.smbms.springmvc.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.Provider;
import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.provider.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;

	@RequestMapping("/show")
	public String showBillList2(Model model) {
		try {
			List<Provider> providerList = providerService.getList();
			model.addAttribute("providerList", providerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "providerlist";
	}

	@RequestMapping(value = "/provideradd", method = RequestMethod.GET)
	public String toadd(@ModelAttribute("provider") Provider provider) {
		return "provideradd";
	}

	@RequestMapping(value = "/provideradd", method = RequestMethod.POST)
	public String touseradd(Provider provider, HttpSession session)
			throws Exception {
		/*
		 * user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION))
		 * .getId());
		 */
		if (providerService.addProvider(provider) > 0) {
			return "redirect:/provider/show";
		}
		return "provideradd";
	}

	/*@ResponseBody
	@RequestMapping(value = "/showproviderList")
	public String getbill(Model model) {
		List<Provider> getproName = providerService.getproName();
		return JSON.toJSONString(getproName);
	}*/

	@ResponseBody
	@RequestMapping(value = "/providerdl")
	public String toproviderdl(Integer proid, HttpSession session) throws Exception {
		int deleteProviderById = providerService.deleteProviderById(proid);
		String providerdl = null;
		if (deleteProviderById > 0) {
			providerdl = "true";
		} else {
			providerdl = "false";
		}
		return JSON.toJSONString(providerdl);
	}

	@RequestMapping("showProviderview")
	public String showuserview(Model model, Integer proid) {
			try {
				Provider providerById = providerService.getProviderById(proid);
				model.addAttribute("provider", providerById);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "providerview";
	}
	
	
	@RequestMapping(value = "/providermodify", method = RequestMethod.GET)
	public String usermodify(Integer proid,Model model) {
		//²¹¸öÈ«²é
		try {
			Provider providerById = providerService.getProviderById(proid);
			model.addAttribute("provider", providerById);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "providermodify";
	}
	

	@RequestMapping(value = "/providermodify2", method = RequestMethod.POST)
	public String usermodify2(Provider provider, HttpSession session) throws Exception {
		int modify = providerService.modify(provider);
		if (modify>0) {
			return "redirect:/provider/show";
		}
		return "providermodify";
	}
	
	
	
}
