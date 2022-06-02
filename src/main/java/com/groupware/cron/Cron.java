package com.groupware.cron;

import org.springframework.stereotype.Service;

@Service
public interface Cron {

    int deleteNotice();
    int deleteBoard();
}
