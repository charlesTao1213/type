package dorm.demo.controller;

import com.alibaba.fastjson.JSON;
import dorm.demo.entity.*;
import dorm.demo.service.PropertyServiceI;
import dorm.demo.vo.Cons;
import dorm.demo.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyServiceI propertyServiceI;

    @GetMapping("/list")
    @CrossOrigin
    public ResultResponse  getList(@RequestParam("id") String id, @RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String sort){
        ResultResponse resultResponse =new ResultResponse();
        List<Property> properties=new ArrayList<>();
        resData resData =new resData();
         if(id.equals("0")){
            Page page=new Page();
            page.setTotal(propertyServiceI.total());
            page.setStart((pageNo - 1) * limit);
            page.setCount(limit);
            properties = propertyServiceI.list(page);
            resData.setTotal(page.getTotal());
        } else {
            Property property=  propertyServiceI.getById(id);
            if(property==null){
               resultResponse= getList("0",pageNo,limit,sort);
               return resultResponse;
            }
            properties.add(property);
            resData.setTotal(1);
        }
        resData.setList(properties);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        resultResponse.setData(resData);
        return resultResponse;
    }

    @PostMapping("/update")
    @CrossOrigin
    public  ResultResponse update(@RequestBody String body){
        ResultResponse resultResponse =new ResultResponse();
        System.out.println(body);
        Property property=new Property();
        property= JSON.parseObject(body,Property.class);
        propertyServiceI.update(property);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }

    @PostMapping("/create")
    @CrossOrigin
    public  ResultResponse create(@RequestBody String body){
        ResultResponse resultResponse =new ResultResponse();
        System.out.println(body);
        Property property=new Property();
        property= JSON.parseObject(body,Property.class);
        propertyServiceI.insert(property);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
    @GetMapping("/delete")
    @CrossOrigin
    public ResultResponse delete(@RequestParam(name = "dormno") String id){
        propertyServiceI.deleteById(id);
        ResultResponse resultResponse  = new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
}
