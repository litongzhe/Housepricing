//package utils;
//
//import com.google.common.collect.Maps;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FSDataOutputStream;
//import org.apache.hadoop.fs.FileStatus;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IOUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URI;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//import java.util.Random;
//
///**
// * 上传文件至HDFS工具类
// *
// * @author LiHaoShan
// * @date 2018-03-01 11:19:43
// * @version 1.0
// */
//public class UploadFileToHdfsUtils {
//
//    static Configuration conf = new Configuration();
//
//    static {
////        SysConfigUtil.getConfigValueByKey("HDFS_URL","")
//       conf.set("fs.defaultFS", "111.231.75.164:9000");
//        conf.set("dfs.client.use.datanode.hostname","true");
// //       conf.set("fs.defaultFS", "172.17.10.233:9000");
////        conf.set("dfs.nameservices", "nameservice1");
////        conf.set("dfs.ha.namenodes.nameservice1", "nn1,nn2");
////        conf.set("dfs.namenode.rpc-address.nameservice1.nn1", "xxx:8020");
////        conf.set("dfs.namenode.rpc-address.nameservice1.nn2", "xxx:8020");
////        conf.set("dfs.client.failover.proxy.provider.nameservice1"
////                ,"org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
//
//
////        conf.addResource("classpath:/hadoop/core-site.xml");
////        conf.addResource("classpath:/hadoop/hdfs-site.xml");
////        conf.addResource("classpath:/hadoop/mapred-site.xml");
//    }
//
//    /**
//     * 创建新文件
//     * @author LiHaoShan
//     * @param dst
//     * @param contents
//     * */
//    public static Map<String,Object> createFile(String dst , byte[] contents) throws IOException{
//        FileSystem fs = FileSystem.get(conf);
//        //目标路径
//        Path dstPath = new Path(dst);
//        URI uri=dstPath.toUri();
//        String path=uri.getPath();
//        //打开一个输出流
//        FSDataOutputStream outputStream = fs.create(dstPath);
//        outputStream.write(contents);
//        Map<String,Object> map= Maps.newHashMap();
//        map.put("savePath",path);
//        outputStream.close();
//        fs.close();
//        System.out.println("文件创建成功！");
//        return map;
//    }
//
//    /**
//     * 上传本地文件
//     * @author LiHaoShan
//     * @param src
//     * @param dst
//     */
//    public static void uploadFile(String src,String dst) throws IOException{
//        //Configuration conf = new Configuration();
//        FileSystem fs = FileSystem.get(conf);
//        //本地上传文件路径
//        Path srcPath = new Path(src);
//        //HDFS目标路径
//        Path dstPath = new Path(dst);
//        if(!fs.exists(dstPath)){
//            fs.mkdirs(dstPath);
//        }
//        //调用文件系统的文件复制函数,前面参数是指是否删除原文件，true为删除，默认为false
//        fs.copyFromLocalFile(srcPath, dstPath);
//
//        //打印文件路径
//        System.out.println("Upload to "+conf.get("fs.default.name"));
//        System.out.println("------------list files------------"+"\n");
//        FileStatus [] fileStatus = fs.listStatus(dstPath);
//        for (FileStatus file : fileStatus)
//        {
//            System.out.println(file.getPath());
//        }
//        fs.close();
//    }
//
//    /**
//     * 文件重命名
//     * @author LiHaoShan
//     * @param oldName
//     * @param newName
//     */
//    public static void rename(String oldName,String newName) throws IOException{
//        //Configuration conf = new Configuration();
//        FileSystem fs = FileSystem.get(conf);
//        Path oldPath = new Path(oldName);
//        Path newPath = new Path(newName);
//        boolean isok = fs.rename(oldPath, newPath);
//        if(isok){
//            System.out.println("rename ok!");
//        }else{
//            System.out.println("rename failure");
//        }
//        fs.close();
//    }
//    /**
//     * 删除文件
//     * @author LiHaoShan
//     * @param filePath
//     * */
//    public static void delete(String filePath){
//        try{
//            //Configuration conf = new Configuration();
//            FileSystem fs = FileSystem.get(conf);
//            Path path = new Path(filePath);
//            boolean isok = fs.deleteOnExit(path);
//            if(isok){
//                System.out.println("delete ok!");
//            }else{
//                System.out.println("delete failure");
//            }
//            fs.close();
//        }catch (Exception e){
//
//        }
//
//    }
//
//    /**
//     * 将MultipartFile上传到hdfs
//     * @author chenem
//     * @date 2018/05/20
//     * @param file
//     * @return
//     * @throws IOException
//     */
//    public static String uploadToHdfs(MultipartFile file)throws IOException{
//        String fileName = file.getOriginalFilename();
//    //文件名随机生成
//            String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
//            StringBuffer sb=new StringBuffer();
//            for(int i=0;i<20;i++)
//                sb.append(str.charAt(new Random().nextInt(62)));
//        if("blob".equals(fileName)) {
//            fileName += sb+ ".jpg";
//        }
//        byte[] buffer = file.getBytes();
//        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        String hdfsFilePath = "/hdfsFile/"+ today.substring(0,7) +"/"+today+"/" ;
//        createFile(hdfsFilePath+fileName,buffer);
//        return hdfsFilePath+fileName;
//    }
//
//    /**
//     * 创建目录
//     * @author LiLaoShan
//     * @param path
//     * */
//    public static void mkdir(String path) throws IOException{
//        //Configuration conf = new Configuration();
//        FileSystem fs = FileSystem.get(conf);
//        Path srcPath = new Path(path);
//        boolean isok = fs.mkdirs(srcPath);
//        if(isok){
//            System.out.println("create " + path + " dir ok!");
//        }else{
//            System.out.println("create " + path + " dir failure");
//        }
//        fs.close();
//    }
//
//    /**
//     * 读取文件的内容
//     * @author LiHaoShan
//     * @param filePath
//     * */
//    public static void readFile(String filePath, HttpServletResponse response) throws IOException{
//        //Configuration conf = new Configuration();
//        FileSystem fs = FileSystem.get(conf);
//        Path srcPath = new Path(filePath);
//        InputStream in = null;
//        try {
//            in = fs.open(srcPath);
//            //复制到标准输出流
//            IOUtils.copyBytes(in, System.out, 4096, false);
//        } finally {
//            IOUtils.closeStream(in);
//        }
//    }
//
//    /**
//     * 遍历指定目录(direPath)下的所有文件
//     * @author LiHaoShan
//     * @param direPath
//     */
//    public static void  getDirectoryFromHdfs(String direPath){
//        try {
//            FileSystem fs = FileSystem.get(URI.create(direPath),conf);
//            FileStatus[] filelist = fs.listStatus(new Path(direPath));
//            for (int i = 0; i < filelist.length; i++) {
//                System.out.println("_________" + direPath + "目录下所有文件______________");
//                FileStatus fileStatus = filelist[i];
//                System.out.println("Name:"+fileStatus.getPath().getName());
//                System.out.println("Size:"+fileStatus.getLen());
//                System.out.println("Path:"+fileStatus.getPath());
//            }
//            fs.close();
//        } catch (Exception e){
//
//        }
//    }
//
//
//    /**
//     * 下载文件至本地
//     * @author LiHaoShan
//     * @param dst
//     * @param src
//     * */
//    public static void downloadFromHdfs(String dst,String src) throws IOException{
//        FileSystem fs = FileSystem.get(conf);
//        Path path=new Path(dst);
//        System.out.println("*************path:"+path);
//        InputStream in = fs.open(path);
//        OutputStream out = new FileOutputStream(src);
//        IOUtils.copyBytes(in, out, 4096, true);
//    }
//
//    public static void main(String[] args)throws IOException{
////        System.setProperty("hadoop.home.dir", "/Library/hadoop-2.8.2");
////        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
////        String localFilePath = "C://Users/HP/Pictures/test.txt";
////        String hdfsFilePath = "/hdfsFile/"+ today.substring(0,7) +"/"+today+"/" ;
////        System.out.println(localFilePath);
////        System.out.println(hdfsFilePath);
////          MultipartFile  multipartFile = new CommonsMultipartFile();
//
//        //"/user/rec/maimaimai/upload_month=2016-11/upload_date=2016-11-09/"
//        //1、遍历指定目录(direPath)下的所有文件
//        //getDirectoryFromHdfs("/hdfsDoc");
//
//        //2、新建目录
////        mkdir(hdfsFilePath);
//
//        //3、上传文件
////        uploadFile(localFilePath, hdfsFilePath);
//        //获取该路径下的文件
////        getDirectoryFromHdfs(hdfsFilePath);
//
//        //4、读取文件
////        readFile("/hdfsFile/2018-03/2018-03-22/test.txt");
//
//        //5、重命名
////        rename("/user/rec/maimaimai/2016-11/2016-11-09/quan-2016-11-09", "/user/rec/maimaimai/2016-11/2016-11-09/quan-2016-11-08.txt");
////        getDirectoryFromHdfs("/user/rec/maimaimai/2016-11/2016-11-09");
//
//        //6、创建文件，并向文件写入内容
//        byte[] contents =  "hello world 世界你好\n".getBytes();
//       createFile("/doc/2018-06/2018-06-19/test.txt",contents);
//       // readFile("/doc/2018-05/2018-05-17/test.txt");
//
//        //7、删除文件
////        delete("/hdfsFile/2018-03/2018-03-01/六量统计表.xlsx"); //使用相对路径
//        //删除目录
////        delete("/Users");
//
//        //8、下载文件至本地
////        downloadFromHdfs("/doc/2018-05/2018-05-17/test.txt","c://Users/HP/Pictures/helloWorld.txt");
//    }
//
//    //上传本地文件至HDFS
////    public static void main(String[] args) throws URISyntaxException, IOException {
////        System.setProperty("hadoop.home.dir", "/Library/hadoop-2.8.2");
////        Configuration conf = new Configuration();
////        URI uri = new URI("hdfs://localhost:9000");
////        FileSystem fs = FileSystem.get(uri,conf);
////        Path localP = new Path("/Users/lihaoshan/Documents/微信二维码.jpg");
////        Path hdfsP = new Path("/hdfsDoc");
////        if(!fs.exists(hdfsP)){
////            fs.mkdirs(hdfsP);
////        }
////        String name = "/Users/lihaoshan/Documents/微信二维码.jpg".substring("/Users/lihaoshan/Documents/微信二维码.jpg".lastIndexOf("/")+1, "/Users/lihaoshan/Documents/微信二维码.jpg".length());
////        fs.copyFromLocalFile(localP, hdfsP);
////        System.out.println("name is " + name);
////        fs.close();
////
////    }
//
//}
