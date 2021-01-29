package cn.smbms.springmvc.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.smbms.pojo.Bill;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;


@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	@RequestMapping("/show")
	public String showBillList2(Model model){
		try {
			List<Bill> billList = billService.getBillList2();
			model.addAttribute("billList", billList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "billlist";
	}
	
	
	@RequestMapping(value="/billadd",method=RequestMethod.GET)
	public String toadd(@ModelAttribute("bill")Bill bill){
		return "billadd";
	}
	
	@RequestMapping(value="/billadd",method=RequestMethod.POST)
	public String touseradd(Bill bill,HttpSession session) throws Exception{
		/*user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());*/
		if(billService.add(bill)>0){
			return "redirect:/bill/show";
		}
		return "billadd";	
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/billdl")
	public String touserdl(Integer billid, HttpSession session) throws Exception {
		 int deleteBillById = billService.deleteBillById(billid);
		String billdl = null;
		if (deleteBillById > 0) {
			billdl = "true";
		} else {
			billdl = "false";
		}
		return JSON.toJSONString(billdl);
	}
	
	@RequestMapping("showbillview")
	public String showbillview(Model model, Integer billid) {
			try {
				 Bill billById = billService.getBillById(billid);
				model.addAttribute("bill", billById);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "billview";
	}
	
	@RequestMapping(value = "/billmodify", method = RequestMethod.GET)
	public String usermodify(Integer billid,Model model) {
		//²¹¸öÈ«²é
		try {
			Bill billById = billService.getBillById(billid);
			model.addAttribute("bill", billById);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "billmodify";
	}
	

	@RequestMapping(value = "/billmodify2", method = RequestMethod.POST)
	public String usermodify2(Bill bill, HttpSession session) throws Exception {
		int modify = billService.modify(bill);
		if (modify>0) {
			return "redirect:/bill/show";
		}
		return "usermodify";
	}
	
	
}
