package dorm.demo.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import dorm.demo.entity.*;
import dorm.demo.service.HouseholdServiceI;
import dorm.demo.vo.Cons;
import dorm.demo.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/household")
public class HouseHoldController {


    @Autowired
    private HouseholdServiceI householdServiceI;

    @GetMapping("/list")
    @CrossOrigin
    public ResultResponse getList(@RequestParam("id") String id,@RequestParam("page") int pageNo,@RequestParam("limit") int limit,@RequestParam("sort") String sort){
        ResultResponse resultResponse = new ResultResponse();
        if(!id.equals("0")){
            Household household= householdServiceI.getById(id);
            if(household==null){
                resultResponse= getList("0",pageNo,limit,sort);
                return resultResponse;
            }
            HoustHoldRes houstHoldRes= new HoustHoldRes();
            houstHoldRes.setTotal(1);
            List<House> list = new ArrayList();
            House h1=new House();
            h1.setDorm(household.getDormno());
            h1.setPeoples(JSON.parseArray(household.getPeople(), People.class));
            list.add(h1);
            houstHoldRes.setHouses(list);
            resultResponse.setData(houstHoldRes);
            System.out.println(houstHoldRes);
            resultResponse.setCode(Cons.STATUS_OK);
        }
        else {
            Page page = new Page();
            page.setStart((pageNo - 1) * limit);
            page.setCount(limit);
            page.setTotal(householdServiceI.total());
            List<Household> households = householdServiceI.list(page);

            HoustHoldRes houstHoldRes = new HoustHoldRes();
            houstHoldRes.setTotal(page.getTotal());
            List<House> houses = new ArrayList<>();
            for (Household hou : households
            ) {
                House house = new House();
                house.setDorm(hou.getDormno());
                house.setPeoples(JSON.parseArray(hou.getPeople(), People.class));
                houses.add(house);
            }

            houstHoldRes.setHouses(houses);

            resultResponse.setCode(Cons.STATUS_OK);
            resultResponse.setData(houstHoldRes);
        }

        return resultResponse;
    }
    @PostMapping("/create")
    @CrossOrigin
    public  ResultResponse creat(@RequestBody String body){
        peoples p =     JSON.parseObject(body,peoples.class);
        List<People> lp=new ArrayList<>();
        if(!p.getName1().equals("")  ){lp.add(new People(p.getName1()));}
        if(!p.getName2().equals("")){lp.add(new People(p.getName2()));}
        if(!p.getName3().equals("")){lp.add(new People(p.getName3()));}
        if(!p.getName4().equals("")){lp.add(new People(p.getName4()));}
        Household house = new Household();
        house.setPeople( JSON.toJSON(lp).toString());
        System.out.println(house.getPeople());
        householdServiceI.insert(house);
        ResultResponse resultResponse =new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
    @PostMapping("/update")
    @CrossOrigin
    public  ResultResponse update(@RequestBody String body){
        Peoples1 p =     JSON.parseObject(body,Peoples1.class);
        System.out.println(body);
        List<People> lp=new ArrayList<>();
        if(!p.getName1().equals("")  ){lp.add(new People(p.getName1()));}
        if(!p.getName2().equals("")){lp.add(new People(p.getName2()));}
        if(!p.getName3().equals("")){lp.add(new People(p.getName3()));}
        if(!p.getName4().equals("")){lp.add(new People(p.getName4()));}
        Household house = new Household();
        house.setDormno(Integer.parseInt(p.getId()));
        house.setPeople( JSON.toJSON(lp).toString());
        System.out.println(house);
        householdServiceI.update(house);
        ResultResponse resultResponse =new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
    @GetMapping("/delete")
    @CrossOrigin
    public ResultResponse delete(@RequestParam(name = "id") int id){
        householdServiceI.deleteById(id);
        ResultResponse resultResponse  = new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }
}
