package dorm.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class info {
    private List<String> roles;
    private String introduction;
    private  String avatar;
    private  String name;
 }
