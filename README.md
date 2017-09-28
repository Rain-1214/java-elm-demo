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

## 验证用户名是否存在
### 请求地址
 /User/checkUserName.do
### 请求方式
POST
### 参数

参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
userName | Y            | String|用户名

### 返回示例
    {
      stateCode:0, // 1 成功 0 失败
      message:"用户名可用", // "用户名不可用" .....
    }

## 获取图片验证码
### 请求地址
 /User/getCode.do
### 请求方式
GET
### 参数
无
### 返回示例
返回一张图片


## 注册
### 请求地址
 /User/register.do
### 请求方式
POST
### 参数

参数名称      | 是否是必须的 | 类型  | 说明
--------------|--------------|-------|----- 
userName      | Y            | String|用户名
password      | Y            | String|密码 
code          | Y            | String|验证码(图片)
safetyQuestion| Y            | String|安全问题
safetyAnswer  | Y            | String|安全问题答案

### 返回示例
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



## 登录
### 请求地址
 /User/Login.do
### 请求方式
POST
### 参数

参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
userName | Y            | String|用户名
password | Y            | String|密码 
code     | Y            | String|验证码(图片)

### 返回示例
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

## 获取全部店铺类型
### 请求地址
 /shop/shopTypeList.do
### 请求方式
POST
### 参数
无
### 返回示例
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
    

