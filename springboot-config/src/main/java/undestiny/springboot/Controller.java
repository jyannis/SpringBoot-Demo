package undestiny.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author undestiny
 * @date 2019-04-02
 * 获取bean配置信息
 */
@RestController
public class Controller {

    @Autowired
    ConfigBean configBean;

    //获取bean配置信息
    @GetMapping("/GET/bean")
    String getBean() throws InvocationTargetException, IllegalAccessException {

        String returnString = "";
        //调用反射获取各实例域和值
        Method[] methods = configBean.getClass().getMethods();
        for(Method method:methods){
            //调用get方法
            if((method.getName()+"").contains("get") && !(method.getName()+"").equals("getClass")){
                Type t = method.getAnnotatedReturnType().getType();
                if((t.toString()+"").contains("List<java.lang.Object>")){
                    returnString += "List：<br>";
                    System.out.println("List：");
                    List<Object> list = (List)method.invoke(configBean);
                    for(Object object:list){
                        returnString += "&nbsp&nbsp" + object.toString() + "<br>";
                        System.out.println("  " + object.toString());
                    }
                }
                else if((t.toString()+"").contains("Set")){
                    returnString += "Set：<br>";
                    System.out.println("Set：");
                    Set<Object> set = (Set)method.invoke(configBean);
                    for(Object object:set){
                        returnString += "&nbsp&nbsp" + object.toString() + "<br>";
                        System.out.println("  " + object.toString());
                    }
                }
                else if((t.toString()+"").contains("Map")){
                    returnString += "Map：<br>";
                    System.out.println("Map：");
                    Map<String,Object> set = (Map)method.invoke(configBean);
                    for(Object object:set.values()){
                        returnString += "&nbsp&nbsp" + object.toString() + "<br>";
                        System.out.println("  " + object.toString());
                    }
                }
                else if((t.toString()+"").contains("List<undestiny.springbootapplication.Student>")){
                    returnString += "List&lt;Student&gt;：<br>";
                    System.out.println("List<Student>：");
                    List<Student> list = (List)method.invoke(configBean);
                    for(Student student:list){
                        returnString += "&nbsp&nbsp-" + student.getName() + "<br>";
                        System.out.println("  -" + student.getName());
                        returnString += "&nbsp&nbsp&nbsp" + student.getAge() + "<br>";
                        System.out.println("   " + student.getAge());
                    }
                }else {
                    Object object = method.invoke(configBean);
                    returnString += t.toString() + "：" + object.toString() + "<br>";
                    System.out.println(t.toString() + "：" + object.toString());
                }
            }
        }

        return returnString;
    }

}
