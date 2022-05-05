package com.tjw.demo;

import com.tjw.community.CommunityApplication;
import com.tjw.community.dao.DiscussPostMapper;
import com.tjw.community.dao.UserMapper;
import com.tjw.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class DemoApplicationTests {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post:list) {
            System.out.println(post);
        };
        int i = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(i);
    }

}
