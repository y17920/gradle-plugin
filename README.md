# 功能
    在window下通过curl命令将apk上传到蒲公英
# 使用说明
## 在project目录下的build.gradle添加
        (```)
        buildscript {
             repositories {
               maven {
                 url "https://plugins.gradle.org/m2/"//或者使用https://maven.aliyun.com/repository/gradle-plugin
               }
             }
             dependencies {
               classpath "com.tomorrow:jaigu:1.0"
             }
           }
         (```)
## 在app目录下的build.grdle添加
    (```)
    apply plugin: "com.tomorrow.plugin"

    jiaguExt {
        userName 'lingjianglin'
        jiaGuPluginPath 'C:\\Users\\admin\\Desktop\\360jiagubao_windows_64\\jiagu\\jiagu.jar' //  加固保安装的路劲
        storeFilePath file("../plugin.jks").absolutePath                                                // 签名文件位置
        storePassword '123456'                                                             //  密码
        keyAlias '123456'                                                                            // 别名
        keyPassword '123456'
        jiaGuUserName '****'       //这里配置的是 你的360加固的用户名   替换****
        jiaGuPwd '****'    //360加固的密码  用自己的密码替换****
    }

    pgyerExt {
        pgyerApiKey '****'
    }
    (```)
# 参数说明
    (```)
         uploadBuildType    //String类型，(必填)值为debug、release等buildTypes
         pgyerApiKey    //String类型，(必填)API Key，从https://www.pgyer.com/account/api获取
         buildInstallType   //int类型，(选填)应用安装方式，值为(1,2,3，4)。1：公开，2：密码安装，3：邀请安装，4：回答问题安装。默认为1公开
         buildPassword  //(选填) 设置App安装密码，如果不想设置密码，请传空字符串，或不传。
         buildUpdateDescription   //String类型，(选填) 版本更新描述，请传空字符串，或不传。
         buildName    //String类型，(选填) 应用名称
         buildInstallQuestoin     //String类型，(选填)如果安装方式为回答问题安装，填写安装问题
         buildInstallAnswer   //String类型，(选填)如果安装方式为回答问题安装，填写安装问题的答案。
         buildInstallDate    //int类型，(选填)是否设置安装有效期，值为：1 设置有效时间， 2 长期有效，如果不填写不修改上一次的设置
         buildInstallStartDate    //String类型，(选填)安装有效期开始时间，字符串型，如：2018-01-01
         buildInstallEndDate  //String类型，(选填)安装有效期结束时间，字符串型，如：2018-12-31
         isOpenWeb   //boolean类型，上传完成后，是否打开app下载页面，默认打开
    (```)