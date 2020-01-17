package mvchbn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
@Autowired
CustomerDao dao;
@RequestMapping(value="/addcustomer",method=RequestMethod.GET)
public String ShowAddCustomerForm(){
	return "AddCustomer";
}
@RequestMapping(value="/addcustomer",method=RequestMethod.POST)
public ModelAndView addCustomer(@ModelAttribute("customer") Customer cust) {
	ModelAndView mav=new ModelAndView();
	dao.addCustomer(cust);
	//mav.setViewName("ViewCustomers");
	return mav;
}
@RequestMapping(value="/viewcustomers")
public ModelAndView getCustomers()
{
	ModelAndView mav=new ModelAndView();
	List<Customer> list=dao.getCustomers();
	mav.addObject("customers",list);
	mav.setViewName("ViewCustomers");
	return mav;
}








}
