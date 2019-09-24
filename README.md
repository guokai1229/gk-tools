# gk-tools

## 说明

常用的工具类的封装

## 结构描述

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