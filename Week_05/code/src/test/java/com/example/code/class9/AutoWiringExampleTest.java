package com.example.code.class9;

import com.example.code.class9.auto.AutoWiringExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AutoWiringExample.class)
public class AutoWiringExampleTest {

    @Autowired
    private AutoWiringExample example;

    @Test
    public void test() {
        example.info();
    }
}
