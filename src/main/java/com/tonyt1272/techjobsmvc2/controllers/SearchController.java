package com.tonyt1272.techjobsmvc2.controllers;

import com.tonyt1272.techjobsmvc2.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

   @RequestMapping(value = "results", method = RequestMethod.GET)
   public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm ){

            if(searchType.equals("all")){

                ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
                System.out.println(jobs);
                Integer total=jobs.size();

                if(jobs.size()<1){
                    total=0 ;
                }
                model.addAttribute("previousSearch",searchTerm);
                model.addAttribute("jobs", jobs);
                model.addAttribute("total",Integer.toString(total));
                model.addAttribute("columns", ListController.columnChoices);
                return "search";
            }



            else{
           ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
           System.out.println(jobs);
           Integer total=jobs.size();

           if(jobs.size()<1){
               total=0 ;
           }
           model.addAttribute("previousSearch",searchTerm);
           model.addAttribute("jobs", jobs);
           model.addAttribute("total",Integer.toString(total));
           model.addAttribute("columns", ListController.columnChoices);
           return "search";
        }
           //

       //model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);

       //return "search";
   }


    // TODO #1 - Create handler to process search request and display results

}

//@Controller
//@RequestMapping("search/results")
//public class ResultController {
//
//}





