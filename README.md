# gk-tools

[![License](https://img.shields.io/badge/License-Apache--2.0-blue.svg)](LICENSE)

#### 项目说明

常用的工具类的封装

#### 结构描述
- common
    - ResultCode 通用的返回结果Bean
- handler 常用的处理对象，需要创建使用
    - ConfigHandler 配置工具类，包装properties文件及操作
- lang 基础数据类型工具类
    - tree
        - Tree 树形基本对象
        - TreeNode 树形对象接口
        - TreeList 树形对象的根数据列表
- security 安全相关的工具类
    - DESUtils des算法加解密的工具类
    - MD5Utils md5算法加解密的工具类
    - AESUtils aes算法加解密的工具类
- utils 工具类，可以直接通过调用静态方法使用
    - ClassUtils 对于class的一般操作
    - DateUtils 对于日期的一般操作
    - FileUtils 对于文件的一般操作
    - FormatUtils 格式化的一般操作包括类型转换
    - JSONUtils 对于json的通用方法操作
    - XMLUtils 对于xml的通用方法操作
    - SystemUtils 获取系统信息的一般操作
    - UUIDUtils 关于uuid的方法
    - ZipUtils 关于zip操作的方法
    - HttpUtils 关于http操作的方法
    - AssertUtils 关于断言的简单判定
    - BeanUtils 关于bean转换的一些简单操作
    - SnowIdUtils 关于雪花id算法的方法

#### maven依赖

```
<dependency>
  <groupId>top.guokaicn</groupId>
  <artifactId>gk-tools</artifactId>
  <version>1.0.8</version>
</dependency>
```

#### 使用说明

该项目为多个工具类的集合，项目使用的maven依赖除基础使用的包外，都为provided，当该项目被其他项目使用的时候，需要去自己引用第三方包，以免依赖混乱