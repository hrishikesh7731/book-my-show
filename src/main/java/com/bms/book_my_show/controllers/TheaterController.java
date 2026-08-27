package com.bms.book_my_show.controllers;

import com.bms.book_my_show.constants.LoggerConstant;
import com.bms.book_my_show.dtos.RegisterCompanyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    @PostMapping("/company/register")
    public ResponseEntity registerTheaterCompany(@RequestBody RegisterCompanyDto registerCompanyDto){
        log.info(String.format(LoggerConstant.REQUEST_RECEIVED_MESSAGE,"register company",registerCompanyDto.toString()));
    }
}
