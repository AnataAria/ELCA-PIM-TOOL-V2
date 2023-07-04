package com.anataarisa.pimtool.controller;

import com.anataarisa.pimtool.utils.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractApplicationController {
    @Autowired
    ApplicationMapper mapper;
}
