为一个小型录象带出租店设计一个简单的库存控制系统。

定义两个类:Video和VideoStore。

Video对象至少具有以下属性（其他属性可以按需扩展）:
- 片名
- 是否被出租的标识
- 用户的平均评分

此外，需要定义一些方法操作这些属性。

VideoStore类
将包含一个Video数组。

VideoStore中定义方法
addVideo(String): 添加一个新的电影
checkOut(String): 根据片名借出电影
returnVideo(String): 归还电影
receiveRating(String, int) : 设置用户对电影的评分(1~5)，收到评分之后，计算该电影的平均评分，然后保存到Video的评分属性中
listInventory(): 列出整个库存的电影。

创建VideoStoreLauncher类，作为程序入口，main方法将测试其他两个类的功能。

新增《黑客帝国》、《教父》、《星球大战》3部影片。
给每个视频打分。
每个视频出租一次，然后归还。
列出《教父》租出去后的库存。

打印商店的库存，列出每个影片的:
- 片名
- 平均评分,
- 是否借出