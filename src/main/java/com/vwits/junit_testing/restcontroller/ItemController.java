package com.vwits.junit_testing.restcontroller;

import com.vwits.junit_testing.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class ItemController {

    @GetMapping("/item")
    public Item dummyItem(){
        return new Item(1,"Masha",10,10);
    }
}
