package com.groupware.service;

import org.springframework.stereotype.Service;

@Service
public interface CronService {

    int deleteNotice();
    int deleteBoard();
}
