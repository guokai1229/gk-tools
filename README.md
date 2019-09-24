# gk-tools

[![License](https://img.shields.io/badge/License-Apache--2.0-blue.svg)](LICENSE)

#### 项目说明

常用的工具类的封装

#### 结构描述

- handler 常用的处理对象，需要创建使用
    - ConfigHandler 配置工具类，包装properties文件及操作
- utils 工具类，可以直接通过调用静态方法使用
    - ClassUtils 对于class的一般操作
    - DateUtils 对于日期的一般操作
    - FileUtils 对于文件的一般操作
    - FormatUtils 格式化的一般操作包括类型转换
    - IOUtils 对于流与数据方面的一些转换
    - JSONUtils 对于json的通用方法操作
    - SystemUtils 获取系统信息的一般操作
    - UUIDUtils 关于uuid的方法
    
#### 使用说明

该项目为多个工具类的集合，项目使用的maven依赖都为provided，当该项目被其他项目使用的时候，需要去自己引用第三方包，以免依赖混乱