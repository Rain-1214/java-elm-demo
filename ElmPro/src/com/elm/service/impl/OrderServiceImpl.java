package com.elm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.elm.dao.OrderDao;
import com.elm.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	public OrderDao orderDao;
	
}
