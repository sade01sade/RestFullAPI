package auca.ac.rw.question4_ecommerce_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.question4_ecommerce_api.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    
    public ProductController() {
        products.add(new Product(1L, "Laptop", "Gaming laptop", 1200.0, "Electronics", 5, "Dell"));
        products.add(new Product(2L, "Smartphone", "Android phone", 800.0, "Electronics", 10, "Samsung"));
        products.add(new Product(3L, "Headphones", "Noise cancelling", 150.0, "Accessories", 0, "Sony"));
        products.add(new Product(4L, "Shoes", "Running shoes", 90.0, "Fashion", 20, "Nike"));
        products.add(new Product(5L, "T-Shirt", "Cotton t-shirt", 25.0, "Fashion", 50, "Adidas"));
        products.add(new Product(6L, "Blender", "Kitchen blender", 60.0, "Home", 7, "Philips"));
        products.add(new Product(7L, "TV", "Smart TV 55 inch", 600.0, "Electronics", 3, "LG"));
        products.add(new Product(8L, "Watch", "Digital watch", 120.0, "Accessories", 15, "Casio"));
        products.add(new Product(9L, "Backpack", "Laptop backpack", 45.0, "Accessories", 0, "HP"));
        products.add(new Product(10L, "Keyboard", "Mechanical keyboard", 110.0, "Electronics", 12, "Logitech"));
    }

    
    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit) {

        if (page == null || limit == null) {
            return products;
        }

        int start = page * limit;
        int end = Math.min(start + limit, products.size());

        if (start >= products.size()) {
            return new ArrayList<>();
        }

        return products.subList(start, end);
    }

    
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }

    
    @GetMapping("/brand/{brand}")
    public List<Product> getByBrand(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(brand)) {
                result.add(product);
            }
        }
        return result;
    }

    
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())
                    || product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    
    @GetMapping("/price-range")
    public List<Product> getByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
        return result;
    }

    
    @GetMapping("/in-stock")
    public List<Product> getInStockProducts() {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getStockQuantity() > 0) {
                result.add(product);
            }
        }
        return result;
    }

    
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long productId,
            @RequestBody Product updatedProduct) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                product.setCategory(updatedProduct.getCategory());
                product.setBrand(updatedProduct.getBrand());
                product.setStockQuantity(updatedProduct.getStockQuantity());
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(
            @PathVariable Long productId,
            @RequestParam int quantity) {

        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setStockQuantity(quantity);
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}

