package dorm.demo.controller;
/**
 * @program: type
 * @description:
 * @packagename: dorm.demo.controller
 * @author: TaoZeNan
 * @date: 2021-01-02 17:21
 **/

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import dorm.demo.entity.User;
import dorm.demo.entity.Utl;
import dorm.demo.service.UserService;
import dorm.demo.vo.Cons;
import dorm.demo.vo.ResultResponse;
import dorm.demo.vo.Token;
import dorm.demo.vo.info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.UTF_32LE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TaoZeNan
 * @description
 * @date 2021-01-02 17:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/index")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin
    public ResultResponse Index(@RequestBody String body) {
        System.out.println(body);
        User user = JSON.parseObject(body, User.class);
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(Cons.STATUS_FAIL);
        resultResponse.setMessage(Cons.MESSAGE_FAIL);
        resultResponse.setData(new Token("fail"));
        if (userService.queryByUserName(user.getUsername(), user.getPassword()).equals("true")) {
            resultResponse.setCode(Cons.STATUS_OK);
            resultResponse.setMessage(Cons.MESSAGE_OK);
            resultResponse.setData(new Token("token_admin"));
        }
        return resultResponse;
    }


    @PostMapping("/logout")
    @CrossOrigin
public ResultResponse logout(@RequestHeader("X-Token") String token){
        ResultResponse resultResponse =new ResultResponse();
        resultResponse.setCode(Cons.STATUS_OK);
        resultResponse.setMessage(Cons.MESSAGE_OK);
        resultResponse.setData("ok");
        return resultResponse;


    }



    @GetMapping("/info")
    @CrossOrigin
    public ResultResponse info(@RequestParam("token") String token) {
        ResultResponse resultResponse = new ResultResponse();
        //token_admin
        resultResponse.setCode(Cons.STATUS_OK);
        info info1 = new info();
        List list = new ArrayList<>();
        list.add("admin");
        info1.setRoles(list);
        info1.setIntroduction("i am a super admin");
        info1.setAvatar("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa0.att.hudong.com%2F30%2F29%2F01300000201438121627296084016.jpg&refer=http%3A%2F%2Fa0.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617345690&t=601bca104f31be44575b75b5da764394");
        info1.setName("Super Ad");
        resultResponse.setData(info1);
        return resultResponse;
    }

    @RequestMapping("/changepass")
    public String ChangPass(@RequestBody String body) {
        Utl u = JSON.parseObject(body, Utl.class);
        User user = new User();
        user.setUsername(u.getUsername());
        ;
        user.setPassword(u.getPassword());
        if (Index(JSON.toJSONString(user)).equals("ok")) {
            User u1 = new User();
            u1.setUsername(u.getUsername());
            u1.setPassword(u.getNewpassword());
            userService.update(u1);
            return "ok";
        }
        return "fall";

    }

    @RequestMapping("/pot")
    public String pot() {
        return "pot";
    }

    @RequestMapping("/elevtor")
    public String elevtor() {
        return "elevtor";
    }

    @RequestMapping("/door")
    public String door() {
        return "door";
    }

    @RequestMapping("/wuye")
    public String wuye() {
        return "wuye";
    }
}