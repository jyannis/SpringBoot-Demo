package undestiny.springbootmybatispagehelper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

//参考https://www.cnblogs.com/MQTimor/p/10604433.html
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
