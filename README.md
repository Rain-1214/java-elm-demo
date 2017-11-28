# elm
## 声明
写着玩的 不要当真哈 不用于各种商业用途

## 简介
elm 是模仿饿了么的一个demo java-elm-deom是java对应开发的后台应用 

技术栈 => spring springMVC MyBatis MySql 
数据库MySql 我用的是5.5版本的 .sql文件 在SQL文件夹里

目前还在制作当中 前台对应 elm-demo-vue

目前实现的接口 我还在用本地(穷逼没钱租服务器) 所以我的前缀是localhost:8080/ElmPro/..... 前端那边用webpack启另外端口的开发然后 用proxy代理转发 然后java这边配置了跨域 就这样。。。

PS：我Java实力 比较一般。。较一般。。一般。。般。。 所以还希望各路大神指点。  
PPS：QQ ==> 453430651 微信 ==> as453430651 

<a href="#title1">1、验证用户名是否存在</a><br>
<a href="#title2">2、获取图片验证码</a><br>
<a href="#title3">3、注册</a><br>
<a href="#title4">4、登录</a><br>
<a href="#title5">5、获取全部店铺类型</a><br>
<a href="#title6">6、获取所有店铺</a><br>
<a href="#title7">7、获取店铺所有商品</a><br>
<a href="#title8">8、根据经纬度获取地址</a><br>
<a href="#title9">9、获取热门城市</a><br>
<a href="#title10">10、根据输入文本搜索地址</a><br>
<a href="#title11">11、向一个用户添加一个地址</a><br>
<a href="#title12">12、查找一个用户的所有地址</a><br>
<a href="#title13">13、删除一个地址</a><br>
<a href="#title14">14、修改一个用户的地址</a><br>
<a href="#title15">15、查找一个用户所有的红包</a><br>
<a href="#title16">16、获取一个用户的安全问题</a><br>
<a href="#title17">17、检测用户回答的安全问题是否正确</a><br>
<a href="#title18">18、设置用户新密码</a><br>
<a href="#title19">19、获取用户积分</a><br>
<a href="#title20">20、给一个用户添加一个红包</a><br>
<a href="#title21">21、给一个用户添加积分</a><br>
<a href="#title22">22、创建一个订单</a><br>
<a href="#title23">23、检测订单是否符合支付条件</a><br>
<a href="#title24">24、获取一个用户的所有订单</a><br>
<a href="#title25">25、完成一个订单</a><br>


### <a name="title1">1、验证用户名是否存在 </a>
#### 请求地址
 /User/checkUserName.do
#### 请求方式
POST
#### 参数

参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
userName | Y            | String|用户名

#### 返回示例
<pre>
  <code>
    {
      stateCode:0, // 1 成功 0 失败
      message:"用户名可用", // "用户名不可用" .....
    }
  </code>
</pre>

### <a name="title2">2、获取图片验证码</a>
#### 请求地址
 /User/getCode.do
#### 请求方式
GET
#### 参数
无
#### 返回示例
返回一张图片


### <a name="title3">3、注册</a>
#### 请求地址
 /User/register.do
#### 请求方式
POST
#### 参数

参数名称      | 是否是必须的 | 类型  | 说明
--------------|--------------|-------|----- 
userName      | Y            | String|用户名
password      | Y            | String|密码 
code          | Y            | String|验证码(图片)
safetyQuestion| Y            | String|安全问题
safetyAnswer  | Y            | String|安全问题答案

#### 返回示例
<pre>
  <code>
    {
      stateCode:1, // 1 成功 0 失败
      message:"注册成功", // "验证码错误" .....
      data:{
        userName:...,
        userImg:..., //头像
        phoneNumber:..., 
        activityPoints:..., //活动积分
        address:[], //该用户的地址
        hongbao:[]  //该用户红包
      }
    }
  </code>
</pre>



### <a name="title4">4、登录</a>
#### 请求地址
 /User/Login.do
#### 请求方式
POST
#### 参数

参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
userName | Y            | String|用户名
password | Y            | String|密码 
code     | Y            | String|验证码(图片)

#### 返回示例
<pre>
  <code>
    {
      stateCode:0, // 1 成功 0 失败
      message:"登录成功", // "验证码错误" .....
      data:{
        userName:...,
        userImg:..., //头像
        phoneNumber:..., 
        activityPoints:..., //活动积分
        address:[], //该用户的地址
        hongbao:[]  //该用户红包
      }
    }
  </code>
</pre>

### <a name="title5">5、获取全部店铺类型</a>
#### 请求地址
 /shop/shopTypeList.do
#### 请求方式
POST
#### 参数
无
#### 返回示例
<pre>
  <code>
    {
      stateCode:0, // 1 成功 0 失败
      message:"success", // "网络问题" .....
        data:[
          {
            id:..,
            typeName:..., //店铺类型名称
            typeLogo:..., //店铺类型LOGO
             },  
          ...  
        ]  
    }  
  </code>
</pre>

### <a name="title6">6、获取所有店铺</a>
#### 请求地址
 /shop/shopList.do
#### 请求方式
POST
#### 参数
无
#### 返回示例
<pre>
  <code>
    {
      stateCode:0, // 1 成功 0 失败
      message:"success", // "网络问题" .....
      data:[
        averageEvaluate: 4.7
        averageUserCost: 30
        countOrder: 201
        deliveryCost: 5
        distance: 11404.5767
        foodEvaluate: 4.8
        id: 1
        isBrand: 1
        latitude: 31.240448
        longitude: 121.49717
        serveEvaluate: 4.6
        shopLogo: "//fuss10.elemecdn.com/8/bb/dee0380909002eb1a646aa5f9de0cjpeg.jpeg?"
        shopName: "乐凯撒比萨（正大广场店）"
        shopNptice: "欢迎光临，用餐高峰期请提前下单，谢谢。"
        startCost: 20
        shopProperty: {
          hummingbird: 1
          id: 1
          invoice: 1
          newUserFavorable: 1
          safeguard: 1
          shopId: 1	
        }
      ]  
    }
  </code>
</pre>

### <a name="title7">7、获取店铺所有商品</a>
#### 请求地址
 /shop/shopFoodTypeList.do
#### 请求方式
POST
#### 参数
参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
id       | Y            | int   |当前店铺ID
#### 返回示例
<pre>
  <code>
    {
      stateCode:0, // 1 成功 0 失败
      message:"success", // "网络问题" .....
      data:[
        {
          description:"好吃的早餐",
          id:1,
          listName:"早餐",
          shopId:1,
          foodList:[
            countMonth:58,
            foodInfo:"好吃的水饺",
            foodName:"水饺",
            foodNum:0,
            foodPic:"https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?",
            foodTypeId:1,
            goodEvaluate:0.98,
            id:1,
            inventory:-1,
            price:20,
            type:1,
            foodPropertyList:[
              {
                foodId:1,
                id:1,
                typeName:"辣度",
                foodPropertyDetail:[
                  {
                    foodTypeId:1,
                    id:1,
                    name:"不辣",
                    price:0
                  },
                  ...
                ]
              },
              ...
            ]
          ]
            },  
        ...  
      ]  
    }
  </code>
</pre>


### <a name="title8">8、根据经纬度获取地址</a>
#### 请求地址
 /location/getLocation.do
#### 请求方式
POST
#### 参数
参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
latitude | Y            | int   |纬度
longitude| Y            | int   |经度

#### 返回示例
<pre>
  <code>
    {
      status:0,
      addressComponent: {
        adcode: "0",
        city: "Nakano",
        country: "Japan",
        country_code: 26000,
        direction: "",
        distance: "",
        district: "",
        province: "Tokyo",
        street: "都庁通り",
        street_number: "",
        town: "",
      }
      business: "",
      cityCode: 26041,
      formatted_address: "都庁通り, Nakano, Tokyo, Japan", (挂了VPN - -！)
      location: {
        lng: 139.69170639999987,
        lat: 35.68948739705731
      }
      poiRegions: [],
      pois: [],
      roads: [],
      sematic_description: "",
    }
  </code>
</pre>


### <a name="title9">9、获取热门城市</a>
#### 请求地址
 /location/getHotCity.do
#### 请求方式
POST
#### 参数
无
#### 返回示例
<pre>
  <code>
    {
      stateCode:0, // 1 成功 0 失败
      message:"success", // "网络问题" .....
      data:["上海", "北京", "杭州"...]
    }
  </code>
</pre>

### <a name="title10">10、根据输入文本搜索地址</a>
#### 请求地址
 /location/searchAddress.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
searchText     | Y            |String |搜索文本
currentLocation| Y            |String |在哪个城市搜索

#### 返回示例
<pre>
  <code>
    {
      message: "ok",
      result:[
        {
          business: "",
          city: "上海市",
          cityid: "289",
          district: "浦东新区",
          location: {
            lat: 31.245105,
            lng: 121.506377
          }
          name: "东方明珠",
          uid: "b643224025414952f4e73b2f	
        },
        ...
      ],
      status: 0	
    }
  </code>
</pre>

### <a name="title11">11、向一个用户添加一个地址</a>
#### 请求地址
 /User/addAddress.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
sex            | Y            |Integer|性别（1=>男 2=>女）
userName       | Y            |String |姓名     
phoneNumber    | Y            |String |电话     
addressName    | Y            |String |地址名称   
addressDetail  | Y            |String |地址详情  
userId         | Y            |Integer|输入哪个用户
lat            | Y            |double |经度     
lng            | Y            |double |纬度     
tag            | N            |String |地址标签   

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"添加成功"
    }
  </code>
</pre>

### <a name="title12">12、查找一个用户的所有地址</a>
#### 请求地址
 /User/findAddressByUserId.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
userId         | Y            |Integer|查找的用户的ID

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:[
        {
          sex:...,
          userName:...,
          phoneNumber:...,
          ...
        },
        ...
      ]
      message:"success"
    }
  </code>
</pre>

### <a name="title13">13、删除一个地址</a>
#### 请求地址
 /User/deleteAddressById.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
addressId      | Y            |Integer|地址的ID        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"删除成功"
    }
  </code>
</pre>

### <a name="title14">14、修改一个用户的地址</a>
#### 请求地址
 /User/editAddressById.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
id             | Y            |Integer|地址ID
sex            | Y            |Integer|性别（1=>男 2=>女）
userName       | Y            |String |姓名     
phoneNumber    | Y            |String |电话     
addressName    | Y            |String |地址名称   
addressDetail  | Y            |String |地址详情  
userId         | Y            |Integer|输入哪个用户
lat            | Y            |double |经度     
lng            | Y            |double |纬度     
tag            | N            |String |地址标签   
#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"修改成功"
    }
  </code>
</pre>

### <a name="title15">15、查找一个用户所有的红包</a>
#### 请求地址
 /User/findHongbaoByUserId.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
userID         | Y            |Integer|用户的ID        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:[
        {
          endTime: 1509465599000,
          fillMoney: 30,
          hongbaoName: "超级会员专享",
          hongbaoState: 0,
          id: 1,
          minusMoney: 20,
          phoneNumber: "13012345678",
          shopTypeList: Array(3),
          startTime: 1506846764000,
          userId: 2,
        }
        ...
      ]
      message:"success"
    }
  </code>
</pre>

### <a name="title16">16、获取一个用户的安全问题</a>
#### 请求地址
 /User/getUserSafetyQuestion.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
userName       | Y            |String |用户名        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:{
        id:userId,
        safetyQuestion:"aaa",
      },
      message:"success"
    }
  </code>
</pre>

### <a name="title17">17、检测用户回答的安全问题是否正确</a>
#### 请求地址
 /User/checkUserSafetyQuestion.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
safetyAnswer   | Y            |String |用户回答的答案        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"success"
    }
  </code>
</pre>


### <a name="title18">18、设置新密码</a>
#### 请求地址
 /User/setNewPassword.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
password       | Y            |String |用户的新密码
id             | Y            |Integer|userid        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"success"
    }
  </code>
</pre>  


### <a name="title19">19、获取用户的活动积分</a>
#### 请求地址
 /User/getUserActivityScore.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
userId         | Y            |Integer|userid        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:2000,
      message:"success"
    }
  </code>
</pre>


### <a name="title20">20、给一个用户添加一个红包</a>
#### 请求地址
 /User/creatHongbao.do
#### 请求方式
POST
#### 参数
参数名称           | 是否是必须的 | 类型  | 说明
-------------------|--------------|-------------|----- 
userId             | Y            |Integer      |userid        
expendActivityPoint| Y            |Integer      |本次用户消耗的积分        
redPacketName      | Y            |String       |红包名称        
fillMoney          | Y            |double       |满多少        
minusMoney         | Y            |double       |减多少        
startTime          | Y            |Integer      |红包起始时间        
endTime            | Y            |Integer      |红包结束时间        
phoneNumber        | Y            |String       |限那个手机号使用        
shopTypeIdList     | Y            |Array<String>|限哪些类型店铺使用

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:[ // 添加成功后用户的红包列表
        { 
          fillMoney:20,
          ...
        }
      ],
      message:"success"
    }
  </code>
</pre>

### <a name="title21">21、给一个用户添加积分</a>
#### 请求地址
 /User/addActivityPoint.do
#### 请求方式
POST
#### 参数
参数名称           | 是否是必须的 | 类型  | 说明
-------------------|--------------|-------------|----- 
userId             | Y            |Integer      |userid        
activityPoint      | Y            |Integer      |本次添加的的积分        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:2000,// 添加完成之后的用户积分
      message:"success"
    }
  </code>
</pre>

### <a name="title22">22、创建一个订单</a>
#### 请求地址
 /order/createOrder.do
#### 请求方式
POST
#### 参数
参数名称             | 是否是必须的 | 类型                                            | 说明
---------------------|--------------|-------------------------------------------------|----- 
shopId               | Y            |Integer                                          |shopid        
shoppingCartProducts | Y            |Array<Object> object -> {foodId,foodNum,foodType}|购物车中的商品        

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"success", // 您还有未支付订单，请先去支付或取消，再添加新订单 || 购买的商品库存不足 ..
    }
  </code>
</pre>

### <a name="title23">23、检测订单是否符合支付条件</a>
#### 请求地址
 /order/checkOrder.do
#### 请求方式
POST
#### 参数
参数名称             | 是否是必须的 | 类型        | 说明
---------------------|--------------|-------------|----- 
pickerValue          | Y            |String       |选择的配送时间        
deliveryMethod       | Y            |String       |选择的配送方法        
time                 | Y            |String       |下单时间        
remarkString         | Y            |String       |备注        
deliveryTime         | Y            |Integer      |配送时间        
shopId               | Y            |Integer      |店铺ID        
userId               | Y            |Integer      |用户ID       
redPacketId          | Y            |Integer      |红包ID（如果使用了红包 否则为-1） 
address              | Y            |Object       |配送的地址        
payPrice             | Y            |double       |支付了多少钱        
needInvoice          | Y            |Boolean      |是否需要发票        
companyName          | Y            |String       |如果需要发票 发票公司名        
code                 | Y            |String       |如果需要发票 纳税人识别码     

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:{
        payPrice:22.22, 支付金额
        orderId: 1, 订单ID
      } 
      message:"success", // 订单出错请重试4
    }
  </code>
</pre>

### <a name="title24">24、获取一个用户的所有订单</a>
#### 请求地址
 /order/getOrder.do
#### 请求方式
POST
#### 参数
参数名称             | 是否是必须的 | 类型        | 说明
---------------------|--------------|-------------|----- 
userID               | Y            |Integer      |用户ID

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      data:[
        {
          orderId:1,
          ...
        }
      ]
      message:"success", // 订单出错请重试4
    }
  </code>
</pre>


### <a name="title25">25、完成一个订单</a>
#### 请求地址
 /order/orderCompleted.do
#### 请求方式
POST
#### 参数
参数名称             | 是否是必须的 | 类型        | 说明
---------------------|--------------|-------------|----- 
orderId              | Y            |Integer      |订单ID

#### 返回示例
<pre>
  <code>
    {
      stateCode:1,
      message:"success", 
    }
  </code>
</pre>