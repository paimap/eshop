package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.CarService;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController implements ControllerInterface {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model) {
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute Product product, Model model) {
        System.out.println(product.getProductId());
        service.edit(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String ListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id){
        Product product = service.findById(id);
        service.delete(product);
        return "redirect:/product/list";
    }
}

@Controller
@RequestMapping("/car")
class CarController implements ControllerInterface {
    @Autowired
    private CarService carservice; //implement DIP

    @GetMapping("/createCar")
    public String create(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "CreateCar";
    }

    @PostMapping("/createCar")
    public String createPost(@ModelAttribute Car car, Model model) {
        carservice.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String ListPage(Model model) {
        List<Car> allCars = carservice.findAll();
        model.addAttribute("cars", allCars);
        return "CarList";
    }

    @GetMapping("/editCar/{carId}")
    public String edit(@PathVariable("carId") String id, Model model) {
        Car car = carservice.findById(id);
        model.addAttribute("car", car);
        return "EditCar";
    }

    @PostMapping("/editCar")
    public String editPost(@ModelAttribute Car car, Model model) {
        System.out.println(car.getCarId());
        carservice.update(car.getCarId(),car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String delete(@RequestParam("id") String id){
        carservice.deleteCarById(id);
        return "redirect:listCar";
    }
}
