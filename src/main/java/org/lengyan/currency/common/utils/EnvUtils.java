package org.lengyan.currency.common.utils;

import java.util.Properties;

/**
 * 环境工具类
 * @author ktc
 * 2016年10月19日 下午1:38:42
 */
public class EnvUtils {

    private static Properties props=System.getProperties();

    /**
     *
     * @return Java的运行环境版本
     */
    public static String getJavaVersion(){
        return  props.getProperty("java.version");
    }

    /**
     *
     * @return Java的运行环境供应商
     */
    public static String getJavaVendor(){
        return  props.getProperty("java.vendor");
    }

    /**
     *
     * @return Java供应商的URL
     */
    public static String getJavaVendorUrl(){
        return  props.getProperty("java.vendor.url");
    }

    /**
     *
     * @return Java的安装路径
     */
    public static String getJavaHome(){
        return  props.getProperty("java.home");
    }

    /**
     *
     * @return Java的虚拟机规范版本
     */
    public static String getJvmSpecVersion(){
        return  props.getProperty("java.vm.specification.version");
    }

    /**
     *
     * @return Java的虚拟机规范供应商
     */
    public static String getJvmSpecVendor(){
        return  props.getProperty("java.vm.specification.vendor");
    }

    /**
     *
     * @return Java的虚拟机规范名称
     */
    public static String getJvmSpecName(){
        return  props.getProperty("java.vm.specification.name");
    }

    /**
     *
     * @return Java的虚拟机实现版本
     */
    public static String getJvmVersion(){
        return  props.getProperty("java.vm.version");
    }

    /**
     *
     * @return Java的虚拟机实现供应商
     */
    public static String getJvmVendor(){
        return  props.getProperty("java.vm.vendor");
    }

    /**
     *
     * @return Java的虚拟机实现名称
     */
    public static String getJvmName(){
        return  props.getProperty("java.vm.name");
    }

    /**
     *
     * @return Java运行时环境规范版本
     */
    public static String getJavaSpecVersion(){
        return  props.getProperty("java.specification.version");
    }

    /**
     *
     * @return Java运行时环境规范供应商
     */
    public static String getJavaSpecVender(){
        return  props.getProperty("java.specification.vender");
    }

    /**
     *
     * @return Java运行时环境规范名称
     */
    public static String getJavaSpecName(){
        return  props.getProperty("java.specification.name");
    }

    /**
     *
     * @return Java的类格式版本号
     */
    public static String getJavaClassVersion(){
        return  props.getProperty("java.class.version");
    }

    /**
     *
     * @return Java的类路径
     */
    public static String getJavaClassPath(){
        return  props.getProperty("java.class.path");
    }

    /**
     *
     * @return 加载库时搜索的路径列表
     */
    public static String getJavaLibraryPath(){
        return  props.getProperty("java.library.path");
    }

    /**
     *
     * @return 默认的临时文件路径
     */
    public static String getJavaIoTempDir(){
        return  props.getProperty("java.io.tmpdir");
    }

    /**
     *
     * @return 一个或多个扩展目录的路径
     */
    public static String getJavaExtDir(){
        return  props.getProperty("java.ext.dirs");
    }

    /**
     *
     * @return 操作系统的名称
     */
    public static String getOsName(){
        return  props.getProperty("os.name");
    }


    /**
     *
     * @return 操作系统的名称
     */
    public static String getOsArch(){
        return  props.getProperty("os.arch");
    }

    /**
     *
     * @return 是否unix 系统
     */
    public static boolean isUnix(){
      return  !getOsName().toLowerCase().contains("win");
    }

    /**
     *
     * @return 操作系统的版本
     */
    public static String getOsVersion(){
        return  props.getProperty("os.version");
    }

    /**
     *unix 系统中是”/”
     * @return 文件分隔符
     */
    public static String getFileSeparator(){
        return  props.getProperty("file.separator");
    }

    /**
     *unix 系统中是”:”
     * @return 路径分隔符
     */
    public static String getPathSeparator(){
        return  props.getProperty("path.separator");
    }

    /**
     *unix 系统中是”/n”
     * @return 路径分隔符
     */
    public static String getLineSeparator(){
        return  props.getProperty("line.separator");
    }

    /**
     *
     * @return 用户的账户名称
     */
    public static String getUserName(){
        return  props.getProperty("user.name");
    }

    /**
     *
     * @return 用户的主目录
     */
    public static String getUserHome(){
        return  props.getProperty("user.home");
    }

    /**
     *
     * @return 用户的当前工作目录
     */
    public static String getUserDir(){
        return  props.getProperty("user.dir");
    }

    /**
     *
     * @return 获得当前工作的Lib目录
     */
    public static String getWorkDir(){
        String url=EnvUtils.class.getResource("").toString().substring(9);
        return getLibPath(url);
    }

    private static String getLibPath(String url) {
        if(url.contains("/lib/")){
            url=url.substring(0,url.indexOf("/lib/"));
        }
        return url;
    }

}
