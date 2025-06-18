package com.shivam.productserivce.Springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/say/{name}/{times}")
  public String sayHello(@PathVariable("name") String abc,@PathVariable("times") int t)
  {
      String ans= "";
      for(int i=0;i<t;i++)
      {
          ans=ans+" "+abc;
      }
      return ans;
  }
}
