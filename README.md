## 前提条件
- Java 17+
- MySQL 8.0+ 
- Maven 3.9.10
- MinIO
- Redis 8.0.3

## 必要依赖

- spring-boot-starter-parent

- mybatis-plus

- lombok

- mysql-connector-j

- spring-boot-starter-web

- spring-boot-starter-data-redis

- knife4j

- jjwt-api

- jjwt-impl

- jjwt-jackson

- easy-captcha

- minio

- dysmsapi20170525

具体版本号在pom.xml中

## 描述
项目结构和初始代码均使用了尚硅谷的尚庭公寓，实际上是尚硅谷项目的手搓复刻版。

名字LightHome由deepseek生成，就是纯粹的为了起名而起名。

deepseek给的翻译是“烛火租房”，说是听起来很温馨，但是我觉得这玩意似乎能翻译成“光之居”（什么暗芝居）

如果直接用尚硅谷提供的前端代码来进行对接，所有社区相关的接口都会失效，需要自己根据提供的接口手动修改前端代码。

我这里虽然有魔改后的前端代码，但是并没有严谨验证过是否存在问题，所以暂不公开。

其中太多代码写的时候没有参考视频教学，纯是用自己的本能在写，所以有些早期不熟练时写的代码抽象到除了结果对的上，过程很离谱。

练手项目，更多的是为了熟悉Spring Boot、ssm框架



尚硅谷-尚庭公寓https://www.bilibili.com/video/BV1At421K7gP/?spm_id_from=333.1387.favlist.content.click&vd_source=2a55f67ad9a5161fa12fe283ecb5c2e0

### 温馨提示
记得起Redis！
记得起Redis！
