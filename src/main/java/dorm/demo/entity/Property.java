package dorm.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * (Property)实体类
 *
 * @author xiaoG
 * @since 2021-03-08 11:58:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Property {
    
        private String dormno;
    
        private String waterbill;
    
        private String elcbill;
    
        private String gassbill;
    
        private String property;
    
        private String status;

}