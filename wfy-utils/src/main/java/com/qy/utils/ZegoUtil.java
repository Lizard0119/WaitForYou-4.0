package com.qy.utils;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class ZegoUtil {
//    public static void main(String[] args) {
//        String appid = "3692162418";  //即构分配的appId
//        String appSign = "0x41,0x90,0x45,0x59,0x66,0x83,0x63,0xab,0x53,0xaf,0x9c,0xa5,0x1d,0x9c,0xd4,0xed,0xe6,0xb5,0xe2,0xf9,0x30,0x1a,0x1b,0xf6,0x37,0xb9,0x86,0x71,0x9c,0x66,0x76,0x9d";  //即构分配的appSign
//        String userID = "20090010"; //这里的userID需要和web sdk前端传入的userID一致，
//        //否则校验失败(因为这里的userID是为了校验和前端传进来的userID是否一致)。
//        String Token = getZeGouToken(appid,appSign,userID);
//        System.out.println("--Token--:"+Token);
//    }

    /**
     * 拉流端获取登录token
     * @param appId  即构分配的appId
     * @param appSign 即构分配的appSign
     * @param userID //这里的userID需要和web sdk前端传入的userID一致，
    //否则校验失败(因为这里的userID是为了校验和前端传进来的userID是否一致)。
     * @return
     */
    public static String getZeGouToken(String appId,String appSign,String userID){

        String nonce= UUID.randomUUID().toString().replaceAll("-", "");
        long time=new Date().getTime()/1000+30*60;
        String appSign32=new String(appSign.replace("0x", "").replace(",", "").substring(0, 32));
        System.out.println("appSign:"+time+"    "+appSign32+"    "+nonce);

        if(appSign32.length()<32){
            System.out.println("private sign erro!!!!");
            return null;
        }

        String sourece= getPwd(appId+appSign32+userID+nonce+time);
        System.out.println("hash:"+sourece);

        JSONObject json=new JSONObject();
        json.put("ver", 1);
        json.put("hash", sourece);
        json.put("nonce", nonce);
        json.put("expired",time); //unix时间戳，单位为秒
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        System.out.println("json"+json.toString());
        return base64.encodeAsString(json.toString().getBytes());
    }


    /**
     * 获取MD5加密
     * @param pwd 需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    public static String getPwd(String pwd) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(pwd.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bs) {
                // 第一步，将数据全部转换成正数：
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
