### Android MVP 搭建流程 
+ #### 首先在定义View层接口（显示进度条，隐藏进度条，成功提示，失败提示）

+ #### Activity实现View接口，负责页面刷新

+ #### 定义Model接口（登录，登录成功、成败的监听）

+ #### 实现Model接口，模拟进行登录耗时操作，结果通过传入的listener回调

+ #### 定义Present接口（执行登录）

+ #### 实现Present接口，调用Model登录接口以及通过实现登录成功和失败接口，通知Activity刷新页面

+ #### Activity中实例化Present，通过Present控制Model进行网络请求、数据存储等操作