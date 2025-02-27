package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ControllerInterface {
    public String create(Model model);
    public String edit(@PathVariable("id") String id, Model model);
    public String ListPage(Model model);
    public String delete(@RequestParam("id") String id);
}