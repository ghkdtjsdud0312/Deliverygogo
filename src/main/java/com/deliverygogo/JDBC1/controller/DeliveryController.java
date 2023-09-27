package com.deliverygogo.JDBC1.controller;

import com.deliverygogo.JDBC1.dao.CustomerDAO;
import com.deliverygogo.JDBC1.dao.MasterDAO;
import com.deliverygogo.JDBC1.dao.MenuDAO;
import com.deliverygogo.JDBC1.dao.ReviewDAO;
import com.deliverygogo.JDBC1.vo.CustomerVO;
import com.deliverygogo.JDBC1.vo.MasterVO;
import com.deliverygogo.JDBC1.vo.MenuVO;
import com.deliverygogo.JDBC1.vo.ReviewVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
    @RequestMapping("/customer")
    public class DeliveryController {
        @GetMapping("/select")
        public String selectMenu(Model model) { // view로 모델을 넘겨주는 객체
            // 디비 연결
            MenuDAO dao = new MenuDAO();
            List<MenuVO> food = dao.menuSelect();
            model.addAttribute("food",food); // db정보 가져와서 채움
            return "thymeleafEx/selectfood";
            }

        @GetMapping("/insert")
        public String insertViewCustomer(Model model) {// view로 모델을 넘겨주는 객체
            model.addAttribute("customers", new CustomerVO()); // 빈 객체를 만들어서 model-view에 넣어줌, 입력을 받아야해서
            return "thymeleafEx/customerInsert";
        }
        @PostMapping("/insert")
        public String insertDBCustomer(@ModelAttribute("customers")CustomerVO customerVO) throws Exception {
            CustomerDAO dao = new CustomerDAO();
            dao.customerInsert(customerVO);
            return "thymeleafEx/customerInsertRst";
        }

        @GetMapping("/INSERTREVIEW")
        public String reviewInsert(Model model) {// view로 모델을 넘겨주는 객체
            model.addAttribute("INSERTREVIEW", new ReviewVO()); // 빈 객체를 만들어서 model-view에 넣어줌, 입력을 받아야해서
            return "thymeleafEx/reviewinsert";
        }
        @PostMapping("/INSERTREVIEW")
        public String reviewInsertDM(@ModelAttribute("INSERTREVIEW")ReviewVO reviewVO) throws Exception {
            ReviewDAO dao = new ReviewDAO();
            dao.writeReview(reviewVO);
            return "thymeleafEx/reviewinsertRst";
        }

        @GetMapping("/customerLogin")
        public String cuslog(Model model) {// view로 모델을 넘겨주는 객체
            model.addAttribute("CUSLOGIN", new CustomerVO()); // 빈 객체를 만들어서 model-view에 넣어줌, 입력을 받아야해서
            return "thymeleafEx/cuslogin";
        }
        @PostMapping("/customerLogin")
        public String cuslogtDB(@ModelAttribute("CUSLOGIN")CustomerVO customerVO) throws Exception {
            CustomerDAO dao = new CustomerDAO();
            dao.cuslogin(customerVO);
            return "thymeleafEx/cusloginRst";
        }

        @GetMapping("/masterLogin")
        public String maslog(Model model) {// view로 모델을 넘겨주는 객체
            model.addAttribute("MASLOGIN", new MasterVO()); // 빈 객체를 만들어서 model-view에 넣어줌, 입력을 받아야해서
            return "thymeleafEx/maslogin";
        }
        @PostMapping("/masterLogin")
        public String maslogtDB(@ModelAttribute("MASLOGIN") MasterVO masterVO) throws Exception {
            System.out.println("masterLogin post call~~~~~~~");
            MasterDAO dao = new MasterDAO();
            dao.maslogin(masterVO);
            return "thymeleafEx/masloginRst";
    }
}

