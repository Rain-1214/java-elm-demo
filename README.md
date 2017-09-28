# elm
## 声明
写着玩的 不要当真哈 不用于各种商业用途

## 简介
elm 是模仿饿了么的一个demo java-elm-deom是java对应开发的后台应用 

技术栈 => spring springMVC MyBatis MySql 

目前还在制作当中 前台对应 elm-demo-vue

目前实现的接口 我还在用本地(穷逼没钱租服务器) 所以我的前缀是localhost:8080/ElmPro/..... 前端那边用webpack启另外端口的开发然后 用proxy代理转发 然后java这边配置了跨域 就这样。。。

PS：我Java实力 比较一般。。较一般。。一般。。般。。 所以还希望各路大神指点。  
PPS：QQ ==> 453430651 微信 ==> as453430651 

<a href="#title1">验证用户名是否存在</a><br>
<a href="#title2">获取图片验证码</a><br>
<a href="#title3">注册</a><br>
<a href="#title4">登录</a><br>
<a href="#title5">获取全部店铺类型</a><br>
<a href="#title6">获取所有店铺</a><br>
<a href="#title7">获取店铺所有商品</a><br>
<a href="#title8">根据经纬度获取地址</a><br>
<a href="#title9">获取热门城市</a><br>
<a href="#title10">获取热门城市</a><br>

### <a name="title1">验证用户名是否存在 </a>
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

### <a name="title2">获取图片验证码</a>
#### 请求地址
 /User/getCode.do
#### 请求方式
GET
#### 参数
无
#### 返回示例
返回一张图片


### <a name="title3">注册</a>
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



### <a name="title4">登录</a>
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

### <a name="title5">获取全部店铺类型</a>
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

### <a name="title6">获取所有店铺</a>
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

### <a name="title7">获取店铺所有商品</a>
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


### <a name="title8">根据经纬度获取地址</a>
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


### <a name="title9">获取热门城市</a>
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

### <a name="title10">获取热门城市</a>
#### 请求地址
 /location/searchAddress.do
#### 请求方式
POST
#### 参数
参数名称       | 是否是必须的 | 类型  | 说明
---------------|--------------|-------|----- 
searchText     | Y            |String |搜索文本
currentLocation| Y            |String |当前城市

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