package store.product.pojo.vo;

import store.common.base.BaseVO;
import store.product.entity.Category;
import store.product.service.ICategoryService;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
public class CategoryVO implements BaseVO {
    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 页面标题
     */
    private String pageTitle;

    /**
     * 页面描述
     */
    private String pageDescription;

    /**
     * 页面关键词
     */
    private String pageKeyword;

    /**
     * 商品列表
     */
    private List<ProductVO> products;

    /**
     * 类目广告列表
     */
    private List<CategoryAdvertVO> categoryAdverts;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getPageKeyword() {
        return pageKeyword;
    }

    public void setPageKeyword(String pageKeyword) {
        this.pageKeyword = pageKeyword;
    }

    public List<ProductVO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductVO> products) {
        this.products = products;
    }

    public List<CategoryAdvertVO> getCategoryAdverts() {
        return categoryAdverts;
    }

    public void setCategoryAdverts(List<CategoryAdvertVO> categoryAdverts) {
        this.categoryAdverts = categoryAdverts;
    }
}
