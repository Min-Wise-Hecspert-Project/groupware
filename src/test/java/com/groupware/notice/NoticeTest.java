package com.groupware.notice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.groupware.config.RootConfig;
import com.groupware.config.ServletConfig;
import com.groupware.mapper.NoticeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class NoticeTest {

	@Autowired
	NoticeMapper mapper;
	
	@Test
	public void testGetList() {
		log.info(mapper.getNoticeList());
	}
	
}
