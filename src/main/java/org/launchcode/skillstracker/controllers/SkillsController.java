package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping
    public String skills(){
        return "<html>" +
                    "<body>" +
                        "<h1>Skills Tracker</h1>" +
                        "<h2>We have a few skills we would like to learn.  Here is the list!</h2>" +
                            "<ol>" +
                                "<li>Java</li>" +
                                "<li>JavaScript</li>" +
                                "<li>Python</li>" +
                            "</ol>" +
                    "</body>" +
                "</html>";
    }

    @GetMapping("form")
    public String skillsForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='/results' method='post'>" +
                            "<label for=\"name-input\">Name:</label><br>" + // submit a request to /form
                                "<input type='text' name='name'><br>" +
                            "<label for=\"language-select\">My favorite language:</label><br>" +
                                "<select name='firstLanguageChoice' id='language-select'>" +
                                    "<option value='Java'>Java</option>" +
                                    "<option value='JavaScript'>JavaScript</option>" +
                                    "<option value='python'>Python</option>" +
                                "</select><br>" +
                            "<label for=\"language-select\">My second favorite language:</label><br>" +
                                "<select name='secondLanguageChoice' id='language-select'>" +
                                    "<option value='Java'>Java</option>" +
                                    "<option value='JavaScript'>JavaScript</option>" +
                                    "<option value='python'>Python</option>" +
                                "</select><br>" +
                            "<label for=\"language-select\">My third favorite language:</label><br>" +
                                "<select name='thirdLanguageChoice' id='language-select'>" +
                                    "<option value='Java'>Java</option>" +
                                    "<option value='JavaScript'>JavaScript</option>" +
                                    "<option value='Python'>Python</option>" +
                                "</select><br>" +
                            "<input type='submit' value='Submit'><br>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "results")
    public String skillsWithQueryParam(@RequestParam String name, @RequestParam String firstLanguageChoice, @RequestParam String secondLanguageChoice, @RequestParam String thirdLanguageChoice) {
        //return createResults(name, firstLanguageChoice, secondLanguageChoice, thirdLanguageChoice);
        return createTableResults(name, firstLanguageChoice, secondLanguageChoice, thirdLanguageChoice);
    }

    public String createResults(String name, String firstLanguageChoice, String secondLanguageChoice, String thirdLanguageChoice){
        return "<html>" +
                    "<body>" +
                        "<h1>"+ name + "</h1>" +
                           "<ol>" +
                                "<li>"+ firstLanguageChoice +"</li>" +
                                "<li>"+ secondLanguageChoice +"</li>" +
                                "<li>"+ thirdLanguageChoice +"</li>" +
                            "</ol>" +
                    "</body>" +
                "</html>";
    }

    public String createTableResults(String name, String firstLanguageChoice, String secondLanguageChoice, String thirdLanguageChoice){
        return "<html>" +
                    "<body>" +
                        "<table>" +
                            "<caption><h3><b>Favorite Coding Languages</b></h3></caption>" +
                                "<tr>" +
                                "<td><b>"+ name +"</b></td>" +
                                "</tr>" +
                                "<tr>" +
                                    "<td>Favorite Language: </td>" +
                                    "<td>" + firstLanguageChoice+ "</td>" +
                                "</tr>" +
                                "<tr>" +
                                    "<td> Second Favorite Language:   </td>" +
                                    "<td>" + secondLanguageChoice+ "</td>" +
                                "</tr>" +
                                "<tr>" +
                                    "<td>Third Favorite Language: </td>" +
                                    "<td>" + thirdLanguageChoice+ "</td>" +
                                "<tr>" +
                        "</table>" +
                    "</body>" +
                "</html>";
    }
}
