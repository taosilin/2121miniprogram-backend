package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Product;
import com.example.backend.model.User;
import com.example.backend.service.ProductService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.ProductDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result productDetail(@RequestBody Product product){
        ProductDetail p = productService.productDetail(product.getProductID());
        return ResultGenerator.genSuccessResult(p);
    }

    @PostMapping("/update")
    public Result updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result productList(@RequestBody MyRequestBody myRequestBody){
        List<Product> list = productService.productList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }
}
