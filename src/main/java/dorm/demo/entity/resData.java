package dorm.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class resData<T> {
    private  int total;
    private List<T> list;
}
