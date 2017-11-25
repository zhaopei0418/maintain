# 维护系统

用java 语言 + springboot + springmvc + mybatis + (maven/gradle) 搭成的框架

用thymeleaf模板 + bootstrap

此系统只为维护另一个项目快速查询问题而用,也是练习项目。

此系统使用了mybatis的通用分页插件

分页插件地址是：https://github.com/pagehelper/Mybatis-PageHelper

还使用的druid的连接池地址是：https://github.com/alibaba/druid

springboot 地址： https://github.com/spring-projects/spring-boot

thymeleaf 地址：https://github.com/thymeleaf/thymeleaf

bootstrap 地址：http://getbootstrap.com/css/

加上spring security安全模块

添加基于Jersey的RestfulAPI
```
文档地址: https://localhost:8443/apidocs/index.html
```

**maven**
```
	mvn spring-boot:run
```

**gradle**
```
	gradle bootRun
```

用druid配置连接三个数据库

**添加JNI方法**
## 生成头文件命令
```
    javah -jni -classpath  /Users/zhaopei/project/maintain/target/classes -d /Users/zhaopei/project/maintain/jni online.zhaopei.myproject.common.tool.ExportTool
```
## 生成mac os动态库命令
```
    gcc -I $JAVA_HOME/include -I $JAVA_HOME/include/darwin -dynamiclib -current_version 1.0 -o /Users/zhaopei/project/maintain/lib/libexport.dylib /Users/zhaopei/project/maintain/jni/ExportToolJNI.c
```
## 生成windows dll命令
```
    gcc -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o lib/export.dll jni/ExportToolJNI.c
```
