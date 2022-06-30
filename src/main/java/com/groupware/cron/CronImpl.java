package com.groupware.cron;

import com.groupware.mapper.CronMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@RequiredArgsConstructor
public class CronImpl implements Cron{

    private final CronMapper mapper;

    @Override
    public int deleteNotice() {
        return mapper.deleteNotice();
    }

    @Override
    public int deleteBoard() {
        return mapper.deleteBoard();
    }

}
