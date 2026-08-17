package 종합예제.model.dao;

import java.util.ArrayList;

public class ProductDao implements IBaseDao {
    private ProductDao() {}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance() { return instance; }

    private ArrayList<Object> productList = new ArrayList<>();

    @Override
    public boolean save(Object obj){
        productList.add(obj);
        return true;
    }
    @Override
    public ArrayList<Object> findAll(){
    return productList;
    }
}