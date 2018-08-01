package cn.dao;

import cn.entity.Product;
import cn.entity.Takeout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 18221 on 2018/6/12.
 */
public interface IProductDAO {
    public int getCount(@Param("proudctid") int proudctid);
    public List<Product> getAllproduct();
    public int insertProduct(Takeout takeout);
}
