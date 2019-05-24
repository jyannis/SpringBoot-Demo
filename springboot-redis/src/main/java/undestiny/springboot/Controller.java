package undestiny.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/GET")
    void get(){
        redisUtil.zSet("set1","stu1",1);
        redisUtil.zSet("set1","stu3",3);
        redisUtil.zSet("set1","stu2",2);
        Set<TypedTuple> zSetRank = redisUtil.getZSetRank("set1",0,2);
        for(TypedTuple typedTuple : zSetRank){
            System.out.println("value = " + typedTuple.getValue() + ",score = " + typedTuple.getScore());
        }

        redisUtil.zSet("set2","stu1",1);
        redisUtil.zSet("set2","stu3",3);
        redisUtil.zSet("set2","stu2",2);
        redisUtil.zUnionAndStore("set1", Arrays.asList(new String[]{"set2"}),"key2");

        zSetRank = redisUtil.getZSetRank("key2",0,2);
        for(TypedTuple typedTuple : zSetRank){
            System.out.println("value = " + typedTuple.getValue() + ",score = " + typedTuple.getScore());
        }

    }

}
