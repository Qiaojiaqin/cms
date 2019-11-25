package com.briup.cms.service;

import com.briup.cms.bean.Link;
import com.briup.cms.exception.CustomerException;

public interface ILinkService {
    void addLink(Link link) throws CustomerException;
}
