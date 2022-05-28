package com.groupware.service;

import com.groupware.mapper.CronMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CronServiceImpl implements CronService {

    private final CronMapper cronMapper;

    @Override
    public int deleteNotice() {
        return 0;
    }

    @Override
    public int deleteBoard() {
        return 0;
    }
}
