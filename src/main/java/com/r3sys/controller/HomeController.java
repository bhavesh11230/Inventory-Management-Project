package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.r3sys.management.IssueProcess;
import com.r3sys.management.IssueRaw;
import com.r3sys.management.Management;
import com.r3sys.management.ProcessMaterial;
import com.r3sys.management.RawMaterial;
import com.r3sys.managementdao.IssueProcessDao;
import com.r3sys.managementdao.IssueRawDao;
import com.r3sys.managementdao.ManagementDao;
import com.r3sys.managementdao.ProcessMaterialDao;
import com.r3sys.managementdao.RawMaterialDao;

@Controller
public class HomeController {
	@Autowired
	Management management;
	
	@Autowired
	ManagementDao managementdao;
	
	@Autowired
	RawMaterialDao rawmaterialdao;
	
	@Autowired
	ProcessMaterialDao processmaterialdao;
	
	@Autowired
	IssueRawDao issuerawdao;
	
	@Autowired
	IssueProcessDao issueprocessdao;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Index file is running...");
		return "index";
	}
	
	@RequestMapping(path="/submitlogin", method=RequestMethod.POST)
	public String loginData(HttpServletRequest request, Model model)
	{
		String memail = request.getParameter("memail");
		String mpassword = request.getParameter("mpassword");
		System.out.println(memail);
		System.out.println(mpassword);
		
		if(memail.equals("manager@gmail.com") && mpassword.equals("manager"))
		{
			model.addAttribute("em",memail);
			return "managerTask";
		}
		else
		{
			return "index";
		}
	}
	
	@RequestMapping("/addRaw")
	public String addRawMaterial()
	{
		System.out.println("Adding Raw Material...");
		return "addRawMaterial";
	}
	
	@RequestMapping(path="/addingRaw", method=RequestMethod.POST)
	public String addingRaw(HttpServletRequest request,@ModelAttribute RawMaterial rawmaterial)
	{
		int rid=0;
		String rname = request.getParameter("rname");
		int rquantity = Integer.parseInt(request.getParameter("rquantity"));
		String runit = request.getParameter("runit");
		float rcost = Float.parseFloat(request.getParameter("rcost"));
		
		rawmaterial.setRname(rname);
		rawmaterial.setRquantity(rquantity);
		rawmaterial.setRunit(runit);
		rawmaterial.setRcost(rcost);
		
		int a = rawmaterialdao.insert(rawmaterial);
			return "redirect:/viewRaw";
			
			
	}
	
	@RequestMapping("/viewRaw")
	public String viewAccount(Model model)
	{
		System.out.println("Opening view Page");
		List<RawMaterial> rawmaterial = rawmaterialdao.getAllRawMaterial();
		model.addAttribute("rawlist", rawmaterial);
		return "viewRawMaterial";
	}
	
	@RequestMapping("/deleteRaw")
	public String deleteRawMaterial(Model model)
	{
		System.out.println("deleting Raw Material...");
		List<RawMaterial> rawmaterial = rawmaterialdao.getAllRawMaterial();
		model.addAttribute("rawlist", rawmaterial);
		return "deleteRawMaterial";
	}
	
	@RequestMapping(path="/deleteRawMaterial",method=RequestMethod.GET)
	public String deleteRawM(HttpServletRequest request)
	{
		int rid = Integer.parseInt(request.getParameter("rid"));
		rawmaterialdao.deleteRawMaterial(rid);
		return "redirect:/viewRaw";
	}
	
	@RequestMapping("/updateRawQty")
	public String updateRawMaterialQty()
	{
		System.out.println("update Raw Material...");
		return "updateRawMaterialQty";
	}
	
	@RequestMapping(path="/updateRawQuantity",method=RequestMethod.POST)
	public String depositMoney(HttpServletRequest request,@ModelAttribute RawMaterial rawmaterial)
	{
		int rid = Integer.parseInt(request.getParameter("rid"));
		int rquantity = Integer.parseInt(request.getParameter("rqty"));
		rawmaterial = rawmaterialdao.getRawMaterial(rid);
		if(rquantity>0)
		{
			if(rid==rawmaterial.getRid())
			{
				rawmaterial.setRquantity(rquantity);
				rawmaterialdao.update(rawmaterial);
				return "managerTask";
			}
			else
			{
				return "updateRawQty";
			}
		}
		else
		{
			return "updateRawQty";
		}
	}
	
	@RequestMapping("/addProcessed")
	public String addProcessedItem()
	{
		System.out.println("Adding processed Material...");
		return "addProcessedItem";
	}
	
	@RequestMapping(path="/addingProcess", method=RequestMethod.POST)
	public String addingProcess(HttpServletRequest request,@ModelAttribute ProcessMaterial processmaterial)
	{
		int pid=0;
		String pname = request.getParameter("pname");
		int pquantity = Integer.parseInt(request.getParameter("pquantity"));
		String punit = request.getParameter("punit");
		float pcost = Float.parseFloat(request.getParameter("pcost"));
		
		processmaterial.setPname(pname);
		processmaterial.setPquantity(pquantity);
		processmaterial.setPunit(punit);
		processmaterial.setPcost(pcost);
		
		int a = processmaterialdao.insert(processmaterial);
			return "redirect:/viewProcessed";
			
			
	}
	
	@RequestMapping("/viewProcessed")
	public String viewProcessedItem(Model model)
	{
		System.out.println("viewing processed Material...");
		List<ProcessMaterial> processmaterial = processmaterialdao.getAllProcessMaterial();
		model.addAttribute("processlist", processmaterial);
		return "viewProcessedItem";
	}
	
	@RequestMapping("/deleteProcessed")
	public String deleteProcessedItem(Model model)
	{
		List<ProcessMaterial> processmaterial = processmaterialdao.getAllProcessMaterial();
		model.addAttribute("processlist", processmaterial);
		System.out.println("deleting processed Material...");
		return "deleteProcessedItem";
	}
	
	@RequestMapping(path="/deleteProcessMaterial",method=RequestMethod.GET)
	public String deleteProcessM(HttpServletRequest request)
	{
		int pid = Integer.parseInt(request.getParameter("pid"));
		processmaterialdao.deleteProcessMaterial(pid);
		return "redirect:/viewProcessed";
	}
	
	@RequestMapping("/updateProcessQty")
	public String updateProcessedItemQty()
	{
		System.out.println("update processed item...");
		return "updateProcessedItemQty";
	}
	
	@RequestMapping(path="/updateProcessedQuantity",method=RequestMethod.POST)
	public String updatePQty(HttpServletRequest request,@ModelAttribute ProcessMaterial processmaterial)
	{
		int pid = Integer.parseInt(request.getParameter("pid"));
		int pquantity = Integer.parseInt(request.getParameter("pqty"));
		processmaterial = processmaterialdao.getProcessMaterial(pid);
		if(pquantity>0)
		{
			if(pid==processmaterial.getPid())
			{
				processmaterial.setPquantity(pquantity);
				processmaterialdao.update(processmaterial);
				return "managerTask";
			}
			else
			{
				return "updateProcessedQuantity";
			}
		}
		else
		{
			return "updateProcessedQuantity";
		}
	}
	
	@RequestMapping("/issueRaw")
	public String issueRawMaterial(Model model)
	{
		System.out.println("issuing raw material...");
		List<RawMaterial> rawmaterial = rawmaterialdao.getAllRawMaterial();
		model.addAttribute("rawlist", rawmaterial);
		return "issueRawMaterial";
	}
	
	@RequestMapping("/showIssueRaw")
	public String issueRawMaterial1(Model model)
	{
				return "showIssueRaw";
	}
	
	
	@RequestMapping(path="/issueRawM",method=RequestMethod.POST)
	public String issueRawM(HttpServletRequest request,@ModelAttribute IssueRaw issueraw)
	{
		int irid=1; 
		int rid = Integer.parseInt(request.getParameter("rid"));
		String rname = request.getParameter("rname");
		String irname = request.getParameter("irname");
		int irquantity = Integer.parseInt(request.getParameter("irquantity"));
		String irdate = request.getParameter("irdate");
		String irtime = request.getParameter("irtime");
		
		issueraw.setIrid(irid);
		issueraw.setRid(rid);
		issueraw.setRname(rname);
		issueraw.setIrname(irname);
		issueraw.setIrquantity(irquantity);
		issueraw.setIrdate(irdate);
		issueraw.setIrtime(irtime);
		
		int i = issuerawdao.insert(issueraw);
		if(rid==issueraw.getRid())
		{
			
			RawMaterial rawmaterial = rawmaterialdao.getRawMaterial(rid);
			if((rawmaterial.getRquantity()-irquantity)>0)
			{
				int rquantity = rawmaterial.getRquantity()- irquantity; 
				rawmaterial.setRquantity(rquantity);
				rawmaterialdao.update(rawmaterial);
				return "managerTask";
			}
			else
			{
				return "showIssueRaw";
			}
		}
		else
		{
			return "showIssueRaw";
		}
	}
	
	@RequestMapping("/viewIssueRawLogs")
	public String viewIssueRawMaterialLogs(Model model)
	{
		System.out.println("view issue raw material logs...");
		List<IssueRaw> issueraw = issuerawdao.getAllIssueProcessMaterial();
		model.addAttribute("issuerawlist", issueraw);
		return "viewIssueRawMaterialLogs";
	}
	
	@RequestMapping("/issueProcessed")
	public String issueProcessedItem(Model model)
	{
		System.out.println("issue processed item...");
		List<ProcessMaterial> processmaterial = processmaterialdao.getAllProcessMaterial();
		model.addAttribute("processlist", processmaterial);
		return "issueProcessedItem";
	}
	
	@RequestMapping("/showIssueProcess")
	public String issueProcessMaterial1(Model model)
	{
				return "showIssueProcess";
	}
	
	
	@RequestMapping(path="/issueProcessM",method=RequestMethod.POST)
	public String issueProcessM(HttpServletRequest request,@ModelAttribute IssueProcess issueprocess)
	{
		int ipid=1; 
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String ipname = request.getParameter("ipname");
		int ipquantity = Integer.parseInt(request.getParameter("ipquantity"));
		String ipdate = request.getParameter("ipdate");
		String iptime = request.getParameter("iptime");
		
		issueprocess.setIpid(ipid);
		issueprocess.setPid(pid);
		issueprocess.setIpname(ipname);
		issueprocess.setPname(pname);
		issueprocess.setIpquantity(ipquantity);
		issueprocess.setIpdate(ipdate);
		issueprocess.setIptime(iptime);
		
		int i = issueprocessdao.insert(issueprocess);
			if(pid==issueprocess.getPid())
			{
				
				ProcessMaterial processmaterial = processmaterialdao.getProcessMaterial(pid);
				if((processmaterial.getPquantity()-ipquantity)>0)
				{
					int pquantity = processmaterial.getPquantity()- ipquantity; 
					processmaterial.setPquantity(pquantity);
					processmaterialdao.update(processmaterial);
					return "managerTask";
				}
				else
				{
					return "showIssueProcess";
				}
			}
			else
			{
				return "showIssueProcess";
			}
		
	}
	
	@RequestMapping("/viewIssueProcessedLogs")
	public String viewIssueProcessedItemsLogs(Model model)
	{
		System.out.println("view issue processed items logs...");
		List<IssueProcess> issueprocesses = issueprocessdao.getAllIssueProcessMaterial();
		model.addAttribute("issueprocesslist", issueprocesses);
		return "viewIssueProcessedItemsLogs";
	}
	
	@RequestMapping("/unavailableRawMaterials")
	public String showUnavailableRawMaterials(Model model)
	{
		List<RawMaterial> rawmaterial = rawmaterialdao.getAllRawMaterial();
		model.addAttribute("RawMaterialList",rawmaterial);
		return "showUnavailableRawMaterials";
	}
	
	@RequestMapping("/unavailableProcessedItems")
	public String showUnavailableProcessedItems(Model model)
	{
		System.out.println("show unavailable processed items...");
		List<ProcessMaterial> processmaterial = processmaterialdao.getAllProcessMaterial();
		model.addAttribute("ProcessMaterialList",processmaterial);
		return "showUnavailableProcessedItems";
	}
	
	@RequestMapping("/changePassword")
	public String changePassword()
	{
		System.out.println("changing Password...");
		return "changePassword";
	}

}
