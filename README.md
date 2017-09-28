# elm
## 声明
写着玩的 不要当真哈 不用于各种商业用途

## 简介
elm 是模仿饿了么的一个demo java-elm-deom是java对应开发的后台应用 

技术栈 => spring springMVC MyBatis MySql 

目前还在制作当中 前台对应 elm-demo-vue

目前实现的接口 我还在用本地(穷逼没钱租服务器) 所以我的前缀是localhost:8080/ElmPro/..... 前端那边用webpack启一个9000的开发然后 用proxy代理转发 然后java这边配置了跨域 就这样。。。

## 登录
### 请求地址
 /Login.do
### 请求方式
POST
### 参数
参数名称 | 是否是必须的 | 类型  | 说明
---------|--------------|-------|----- 
userName | Y            | String|用户名
password | Y            | String|密码 
code     | Y            | String|验证码(图片)
