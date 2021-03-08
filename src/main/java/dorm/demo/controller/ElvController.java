package dorm.demo.controller;

import com.alibaba.fastjson.JSON;
import dorm.demo.entity.Elv;
import dorm.demo.entity.Page;
import dorm.demo.entity.Password;
import dorm.demo.entity.resData;
import dorm.demo.service.ElvServiceI;
import dorm.demo.vo.Cons;
import dorm.demo.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/elv")
public class ElvController {


    @Autowired
    private ElvServiceI elvServiceI;

    @GetMapping("/list")
    @CrossOrigin
    public ResultResponse getElv(@RequestParam("id") String id, @RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String sort) {
        ResultResponse resultResponse = new ResultResponse();
        List<Elv> elvs = new ArrayList<>();
        resData resData = new resData();
        if (!id.equals("0")) {
            Elv elv = elvServiceI.getById(id);
            if (elv == null) {
                resultResponse = getElv("0", pageNo, limit, sort);
                return resultResponse;
            }
            elvs.add(elv);
            resData.setTotal(1);
            resData.setList(elvs);
        } else {
            Page page = new Page();
            page.setTotal(elvServiceI.total());
            page.setStart((pageNo - 1) * limit);
            page.setCount(limit);
            elvs = elvServiceI.list(page);
            resData.setTotal(page.getTotal());
            resData.setList(elvs);
        }
        System.out.println(resData);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        resultResponse.setData(resData);
        return resultResponse;
    }

    @PostMapping("/create")
    @CrossOrigin
    public ResultResponse create(@RequestBody String body) {
        ResultResponse resultResponse = new ResultResponse();
         body  =body.replaceAll("stauts","status");
        Elv elv =    JSON.parseObject(body,Elv.class);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        elvServiceI.insert(elv);
        return resultResponse;
    }

    @PostMapping("/update")
    @CrossOrigin
    public  ResultResponse update(@RequestBody String body)
    {
        ResultResponse resultResponse =new ResultResponse();
        Elv elv=JSON.parseObject(body,Elv.class);
        elvServiceI.update(elv);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
    @GetMapping("/delete")
    @CrossOrigin
    public ResultResponse delete(@RequestParam(name = "id") String id){
        elvServiceI.deleteById(id);
        ResultResponse resultResponse  = new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }

}
