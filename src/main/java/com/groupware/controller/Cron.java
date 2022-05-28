package com.groupware.controller;

import com.groupware.service.CronService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@RequiredArgsConstructor
public class Cron {


    private final CronService croneService;

}
