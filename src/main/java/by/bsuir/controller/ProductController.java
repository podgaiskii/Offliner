package by.bsuir.controller;

import by.bsuir.model.Product;
import by.bsuir.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private static List<Product> products;
    private static boolean isSorted = false;

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String getStats(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "/stats";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", productService.getAllProducts());
        return "/products";
    }

    @RequestMapping(value = "/products/{type}", method = RequestMethod.GET)
    public String getProducts(@PathVariable("type") String type, Model model) {
        if (!isSorted) {
            products = productService.getAllProductsOfType(type);
        }
        isSorted = false;
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        model.addAttribute("accountID", AccountController.currentUserID);
        return "/product/" + type;
    }

    @RequestMapping(value = "/products/{type}/sort", method = RequestMethod.GET)
    public String sortProducts(@PathVariable("type") String productType, @ModelAttribute("sortingType") String sortingType) {
        products = productService.sortProducts(productType, sortingType);
        isSorted = true;
        return "redirect:/products/" + productType;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if (product.getId() == 0) {
            productService.addProduct(product);
        } else {
            productService.updateProduct(product);
        }
        return "/product";
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "/products";
    }

    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("products", productService.getAllProducts());
        return "/products";
    }

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "/products";
    }

}
