package dorm.demo.controller;

import com.alibaba.fastjson.JSON;
import dorm.demo.entity.Page;
import dorm.demo.entity.Password;
import dorm.demo.entity.Property;
import dorm.demo.entity.resData;
import dorm.demo.service.PasswordServiceI;
import dorm.demo.vo.Cons;
import dorm.demo.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/password")
public class PassWordController {
    @Autowired
    private PasswordServiceI passwordServiceI;


    @GetMapping("/list")
    @CrossOrigin
    public ResultResponse getPassWord(@RequestParam("id") String id, @RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String sort) {
        ResultResponse resultResponse = new ResultResponse();
        List<Password> passwords = new ArrayList<>();
        resData resdata = new resData();
        Page page = new Page();
        if (!id.equals("0")) {
            resdata.setTotal(1);
            Password password = passwordServiceI.getById(id);
            if(password==null){
                resultResponse= getPassWord("0",pageNo,limit,sort);
                return resultResponse;
            }
            passwords.add(password);
        } else {
            page.setTotal(passwordServiceI.total());
            page.setStart((pageNo - 1) * limit);
            page.setCount(limit);
            passwords = passwordServiceI.list(page);
            System.out.println(passwords);
            resdata.setTotal(page.getTotal());
        }
        resdata.setList(passwords);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        resultResponse.setData(resdata);

        return resultResponse;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResultResponse create(@RequestBody String body) {
        ResultResponse resultResponse = new ResultResponse();
        Password password = new Password();
        password = JSON.parseObject(body, Password.class);
        password.setPassword(DigestUtils.md5DigestAsHex(password.getPassword().getBytes()));
        passwordServiceI.insert(password);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
    @PostMapping("/update")
    @CrossOrigin
    public  ResultResponse update(@RequestBody String body){
        ResultResponse resultResponse =new ResultResponse();
        Password password =new Password();
        password=JSON.parseObject(body,Password.class);
        password.setPassword(DigestUtils.md5DigestAsHex(password.getPassword().getBytes()));
        passwordServiceI.update(password);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
    @GetMapping("/delete")
    @CrossOrigin
    public ResultResponse delete(@RequestParam(name = "dormno") String id){
        passwordServiceI.deleteById(id);
        ResultResponse resultResponse  = new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }


}
