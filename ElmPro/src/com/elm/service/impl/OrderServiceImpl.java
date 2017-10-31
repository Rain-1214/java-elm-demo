package com.elm.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elm.dao.OrderDao;
import com.elm.dao.ShopDao;
import com.elm.entity.Food;
import com.elm.entity.Hongbao;
import com.elm.entity.Order;
import com.elm.entity.OrderProduct;
import com.elm.entity.Shop;
import com.elm.entity.ShopFillMinus;
import com.elm.service.OrderService;
import com.elm.util.DecimalCompute;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
                                     
	@Resource                        
	public OrderDao orderDao;        
	                                 
	@Resource                        
	public ShopDao shopDao;          
                                     
	@Override                        
	public Map creatOrder(List<Map> orderProductList,Integer shopId) {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		double totalPrice = 0.00;    
		for(Map op:orderProductList){
			Integer foodId = (Integer) op.get("foodId");
			Integer foodNum = (Integer) op.get("foodNum");
			Food food = shopDao.findFoodById(foodId);
			Integer foodInventory = food.getInventory();
			if(foodInventory != -1 && foodInventory < foodNum) {
				resultMap.put("message", "您选的商品" + op.get("foodName") + "库存不够了");
				return resultMap;    
			}                        
			double price = food.getPrice();
			double foodNumDouble = foodNum;
			double tempPrice = DecimalCompute.multiply(foodNumDouble, price);
			totalPrice =  DecimalCompute.add(totalPrice, tempPrice);
		}
		double discounts = computedDiscounts(shopId, totalPrice);
		Shop shop = shopDao.findShopById(shopId);
		resultMap.put("totalPrice", totalPrice);
		resultMap.put("discounts", discounts);
		resultMap.put("orderProductList", orderProductList);
		resultMap.put("deliveryCost", shop.getDeliveryCost());
		return resultMap;
	}
	
	private double computedDiscounts(Integer shopId,double totalPrice){
		double discounts = 0.00;
		ShopFillMinus temp = new ShopFillMinus();
		temp.setFull(totalPrice);
		List<ShopFillMinus> shopFillMinusList = orderDao.findShopFillMinusByshopId(shopId);
		shopFillMinusList.add(temp);
		Collections.sort(shopFillMinusList, new Comparator<ShopFillMinus>() {
            public int compare(ShopFillMinus o1, ShopFillMinus o2) {
                return new Double(o2.getFull()).compareTo(new Double(o1.getFull()));
            }
        });
		
		for(int i = 0; i < shopFillMinusList.size();i++){
			if(shopFillMinusList.get(i).getFull() == totalPrice){
				try {
					discounts = shopFillMinusList.get(i + 1).getMinus();
				} catch (Exception e) {
					discounts = 0.00;
				} finally {
					shopFillMinusList.remove(i);
				}
			}
		}
		
		return discounts;
	}

	@Override
	public Boolean saveOrder(Order order, List<Map> orderProductList,Integer redPacketId) {
		Integer result = orderDao.insertOrder(order);
		Integer resultNum = 0;
		if (result == 1){
			Integer orderId = order.getId();
			for(Map map:orderProductList) {
				Integer foodId = (Integer) map.get("foodId");
				Integer num = (Integer) map.get("foodNum");
				String name = (String) map.get("foodName");
				String foodType = (String) map.get("foodType");
				double price;
				if (map.get("price") instanceof Double){
					price = (double) map.get("price");
				} else {
					Integer priceInt = (Integer) map.get("price");
					price = priceInt;
				}
				OrderProduct orderProduct = new OrderProduct(foodId, name, num, foodType, price, orderId);
				resultNum += orderDao.insertOrderProduct(orderProduct);
			}
		}
		if (redPacketId != -1) {
			Integer redPacketResult = updateHonbaoState(redPacketId, Hongbao.ALREADY_USE);
			if (redPacketResult != 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Integer updateHonbaoState(Integer id, Integer hongbaoState) {
		return orderDao.updateHongbaoStateById(id, hongbaoState);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
