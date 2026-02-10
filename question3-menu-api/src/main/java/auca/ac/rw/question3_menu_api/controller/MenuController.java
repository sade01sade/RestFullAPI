package auca.ac.rw.question3_menu_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.question3_menu_api.model.MenuItem;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private List<MenuItem> menuItems = new ArrayList<>();

    
    public MenuController() {
        menuItems.add(new MenuItem(1L, "Spring Rolls", "Crispy vegetable rolls", 5.99, "Appetizer", true));
        menuItems.add(new MenuItem(2L, "Chicken Wings", "Spicy grilled wings", 7.49, "Appetizer", true));
        menuItems.add(new MenuItem(3L, "Beef Burger", "Grilled beef burger with cheese", 9.99, "Main Course", true));
        menuItems.add(new MenuItem(4L, "Pasta Alfredo", "Creamy alfredo pasta", 10.99, "Main Course", false));
        menuItems.add(new MenuItem(5L, "Chocolate Cake", "Rich chocolate dessert", 4.99, "Dessert", true));
        menuItems.add(new MenuItem(6L, "Ice Cream", "Vanilla ice cream scoop", 3.49, "Dessert", true));
        menuItems.add(new MenuItem(7L, "Coca-Cola", "Chilled soft drink", 1.99, "Beverage", true));
        menuItems.add(new MenuItem(8L, "Orange Juice", "Fresh orange juice", 2.99, "Beverage", false));
    }

    
    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItems;
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @GetMapping("/category/{category}")
    public List<MenuItem> getItemsByCategory(@PathVariable String category) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        return result;
    }

    
    @GetMapping("/available")
    public List<MenuItem> getAvailableItems(@RequestParam boolean available) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.isAvailable() == available) {
                result.add(item);
            }
        }
        return result;
    }

    
    @GetMapping("/search")
    public List<MenuItem> searchByName(@RequestParam String name) {
        List<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    
    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        menuItems.add(menuItem);
        return new ResponseEntity<>(menuItem, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        for (MenuItem item : menuItems) {
            if (item.getId().equals(id)) {
                menuItems.remove(item);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
