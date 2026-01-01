# 苍穹外卖问题记录

## 1. nginx无法打开
nginx的目录需要全部英文，之后双击打开，浏览器输入localhost，跳转到登录页面
## 2. 运行后端代码后点击登录没有反应
Mysql数据库未连接，`sky-take-out/sky-server/src/main/resources/application-dev.yml`中的数据库密码修改为自己的密码
## 3. yapi网址无法打开
可以使用apifox代替`https://app.apifox.com/` 在导入界面选择yapi格式来源导入
## 4. 输入insert语句没有相关提示
点击IDEA右侧的database标志，将本地的数据库配置到IDEA中，下载相关driver文件，就可以在IDEA中访问数据库。在`employeeMapper.java`中点击鼠标右键选择`attach data source`，就可以在输入代码时显示数据库中的信息。
## 5. 增加员工功能实现后进行调试，发现返回500
大概率`employeeMapper.java`中的insert语句出现问题。insert中#{}内的变量名需要与`employee entity`中一一对应，例如`id_number-idNumber create_time-createTime`
## 6. 关于employee表中id列
1. id列被设置为自增，在insert时不需要为其赋值，因此在`empolyeeMapper.java`中没有添加这列。
2. 若此时表中最后一行id为1，如果插入id值为10，则id被设置为10，且后续自动从11开始增长。而2-9的id不会再出现， 除非手动插入。
3. MySQL的插入数据操作即使失败（如：数据格式没有通过校验）id也会自增，所以下次成功插入id可能与上一行的id不连续。
## 7. 接口文档调试查询显示401
token过期，需要重新登录获取新的token。jwt设置的token过期时间为2小时。
## 8. `controller\service\serviceImpl\mapper\mapper.xml`
  * `controller`：接受前端请求，调用`service`中的方法处理，返回处理结果
  * `service`：定义类中的方法
  * `serviceImpl`：具体实现`service`中的方法，调用`mapper`中的CRUD处理数据
  * `mapper`：实现简单的SQL语句
  * `mapper.xml`：实现复杂的SQL语句
## 9. `controller`中接受的请求中`RequestBody`和`PathVariable`
   * `RequestBody`：如果前端发送的消息中含有json格式的数据，需要使用`RequestBody`将json数据反序列化。多用于`PUT POST`请求中。
   * `PathVariable`：前端的请求路径中含有参数，可以用`PathVariable`将参数取出。
## 10. 不知道为什么会定义按类型查询分类的方法，这个在前端好像没有按钮可以触发。在分类管理页面的分类名称和分类类型查询都是分页查询方法。