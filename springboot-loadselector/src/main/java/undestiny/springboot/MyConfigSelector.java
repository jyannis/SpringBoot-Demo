package undestiny.springboot;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import undestiny.springboot.annotation.EnableMyConfigSelector;

import java.util.Map;

public class MyConfigSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //获取EnableMyConfigSelector下的所有属性
        Map<String,Object> attributes = annotationMetadata.getAnnotationAttributes(
                EnableMyConfigSelector.class.getName());
        boolean flag = (boolean)attributes.get("flag");
        if(flag){
            return new String[]{MyConfig.class.getName()};
        }else {
            return new String[]{MyConfig2.class.getName()};
        }
    }
}
