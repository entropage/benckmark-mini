package com.entropool.benchmark.Deserialize.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@Controller
@RequestMapping("/fastjson")
public class Fastjson {
    @RequestMapping(value = "/deserialize1", method = {RequestMethod.POST})
    @ResponseBody
    public static String Deserialize1(@RequestBody String params) {
        try {
            JSONObject ob = (JSONObject) JSON.parse(params);
            // 获取json中的值
            return ob.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }


    @RequestMapping(value = "/deserialize2", method = {RequestMethod.POST})
    @ResponseBody
    public static String Deserialize2(@RequestBody String params) {
        try {
            JSONObject ob = JSON.parseObject(params);
            // 获取json中的值
            return ob.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/deserialize3", method = {RequestMethod.POST})
    @ResponseBody
    public static String Deserialize3(@RequestParam String name, @RequestParam String age, @RequestParam String address, @RequestParam String phone) {
        try {
            if (name.isEmpty() || age.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                return "参数不能为空";
            }
            JSONObject ob = (JSONObject) JSON.parse(name);
            // 获取json中的值
            return ob.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/deserialize4", method = {RequestMethod.POST})
    @ResponseBody
    public static String Deserialize4(@RequestParam String params) {
        try {
            JSONArray ob = JSON.parseArray(params);
            return ob.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @PostMapping("/deserializeBypass")
    @ResponseBody
    public static String DeserializeBypass(@RequestBody String params) {

        if (params.contains("@type")) {
            return "包含@type";
        }
        JSONObject ob = JSON.parseObject(params);
        return "success";

    }

    @RequestMapping(value = "/deserialize5", method = RequestMethod.POST)
    @ResponseBody
    public String deserialize5(
            @RequestParam String name,
            @RequestParam String age,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String occupation,
            @RequestParam(required = false) String salary)
    {

        // Check if required parameters are empty
        if (name.isEmpty() || age.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            return "Parameters cannot be empty";
        }

        // Validate that age is a number and within a reasonable range
        int ageInt;
        try {
            ageInt = Integer.parseInt(age);
            if (ageInt < 0 || ageInt > 150) {
                return "Age must be between 0 and 150";
            }
        } catch (NumberFormatException e) {
            return "Age format is incorrect, must be a number";
        }

        // Validate phone format
        String phoneRegex = "^\\+?[0-9]{10,15}$"; // Allowed phone format
        if (!Pattern.matches(phoneRegex, phone)) {
            return "Phone format is incorrect, must be 10 to 15 digits, can have a + prefix";
        }

        // Validate email format (if provided)
        if (email != null && !email.isEmpty()) {
            String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            if (!Pattern.matches(emailRegex, email)) {
                return "Email format is incorrect";
            }
        }

        // Validate gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
                return "Gender must be 'male' or 'female'";
            }
        }

        // Validate occupation (if provided), only check if age is greater than 18
        if (ageInt > 18) {
            if (occupation != null && !occupation.isEmpty()) {
                if (occupation.length() < 3 || occupation.length() > 50) {
                    return "Occupation length must be between 3 and 50 characters";
                }
            }
            // Validate salary (if provided), only check if occupation is not empty
            if (occupation != null && !occupation.isEmpty()) {
                if (salary != null && !salary.isEmpty()) {
                    double salaryDouble;
                    try {
                        salaryDouble = Double.parseDouble(salary);
                        if (salaryDouble < 0) {
                            return "Salary cannot be negative";
                        }
                    } catch (NumberFormatException e) {
                        return "Salary format is incorrect, must be a number";
                    }

                    // Combination logic: when occupation is "developer" and salary is over 100000, return a specific message
                    if ("developer".equalsIgnoreCase(occupation) && salaryDouble > 100000) {
                        return "High-paying developer, welcome to our team!";
                    }
                }
            }
        }

        // Combination logic: when age is less than 18 and occupation is "student", return a specific message
        if (ageInt < 18 && "student".equalsIgnoreCase(occupation)) {
            return "Underage student, keep working hard in your studies!";
        }

        // Handle JSON deserialization
        try {
            JSONObject ob = (JSONObject) JSON.parse(name);
            // Get values from the JSON
            return ob.toString();
        } catch (Exception e) {
            return "JSON parsing error: " + e.getMessage();
        }
    }
}


