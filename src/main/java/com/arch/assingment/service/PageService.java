package com.arch.assingment.service;

import com.arch.assingment.instance.PageNotFound;
import com.arch.assingment.model.Data;
import com.arch.assingment.model.Page;
import com.arch.assingment.model.Support;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    public static int id = 0;

    public static int pageSize = 3;

    public static Page page = new Page();
    public static ArrayList<Data> dataList = new ArrayList<>();

    public static Support support=new Support("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");

    @PostConstruct
    public void setUserData() {
        dataList.add(new Data(++id, "niyaz@gmail.com", "Mohamed", "niyaz", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "mohamed@gmail.com", "Mohamed", "mohamed", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "mansoor@gmail.com", "Mohamed", "Niyaz", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "syed@gmail.com", "Mohamed", "syed", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "abdullah@gmail.com", "Mohamed", "abdullah", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "fazil@gmail.com", "Mohamed", "fazil", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "hakkim@gmail.com", "Mohamed", "hakkim", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "yasir@gmail.com", "Mohamed", "yasir", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "nowfal@gmail.com", "Mohamed", "nowfal", "https://reqres.in/img/faces/7-image.jpg"));
        dataList.add(new Data(++id, "tanveer@gmail.com", "Mohamed", "tanveer", "https://reqres.in/img/faces/7-image.jpg"));
    }


    public List<Data> retrieveAllUsers() {
        return dataList;
    }

    public Page retrieveAllUsers(String page) throws PageNotFound {
        return calculateUserPageRequest(page);
    }

    private Page calculateUserPageRequest(String page) throws PageNotFound {
        int totalPage = dataList.size() / pageSize;
        int remainder = dataList.size() % pageSize;
        if (remainder > 0)
            totalPage = totalPage + 1;
        if(Integer.parseInt(page)>totalPage)
            throw new PageNotFound("invalid.pagenumber");
        Page pageObject = new Page();
        pageObject.setTotal_pages(totalPage);
        pageObject.setPer_page(pageSize);
        pageObject.setTotal(dataList.size());
        pageObject.setPage(Integer.parseInt(page));
        pageObject.setData(dataList);
        pageObject.setSupport(support);
        return pageObject;
    }

}
