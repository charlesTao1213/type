package dorm.demo.controller;

import com.alibaba.fastjson.JSON;
import dorm.demo.entity.Carport;
import dorm.demo.entity.Elv;
import dorm.demo.entity.Page;
import dorm.demo.entity.resData;
import dorm.demo.service.CarportServiceI;
import dorm.demo.vo.Cons;
import dorm.demo.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carport")
public class CarportController {

    @Autowired
    private CarportServiceI carportServiceI;


    @GetMapping("/list")
    @CrossOrigin
    public ResultResponse getlist(@RequestParam("id") String id, @RequestParam("page") int pageNo, @RequestParam("limit") int limit, @RequestParam("sort") String sort) {
        ResultResponse resultResponse = new ResultResponse();
        List<Carport> carports = new ArrayList<>();
        resData resData = new resData();
        if (!id.equals("0")) {
            Carport carport = carportServiceI.getById(id);
            if (carport == null) {
                resultResponse = getlist("0", pageNo, limit, sort);
                return resultResponse;
            }
            carports.add(carport);
            resData.setTotal(1);
            resData.setList(carports);
        } else {
            Page page = new Page();
            page.setTotal(carportServiceI.total());
            page.setStart((pageNo - 1) * limit);
            page.setCount(limit);
            carports = carportServiceI.list(page);
            resData.setTotal(page.getTotal());
            resData.setList(carports);
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
        Carport carport = JSON.parseObject(body, Carport.class);
        carportServiceI.insert(carport);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }

    @PostMapping("/update")
    @CrossOrigin
    public ResultResponse update(@RequestBody String body) {
        ResultResponse resultResponse = new ResultResponse();
        Carport carport = JSON.parseObject(body, Carport.class);
        carportServiceI.update(carport);
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }

    @GetMapping("/delete")
    @CrossOrigin
    public ResultResponse delete(@RequestParam(name = "id") String id) {
        carportServiceI.deleteById(id);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        return resultResponse;
    }


}
