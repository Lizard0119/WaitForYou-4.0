package com.qy.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class AlipayController {

    @RequestMapping("/pay")
    @ResponseBody
    public String pay(HttpServletRequest httpRequest,
                           HttpServletResponse httpResponse)   throws ServletException, IOException {
        AlipayClient alipayClient =  new DefaultAlipayClient( "https://openapi.alipaydev.com/gateway.do" , "2021000116668562", "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCaXY6f+UYf0riWhcGPo420HO+EBqIJAv5TV8xktVydxodqhY43kkhRp9kVnXbSL1cECTGgz/lHximcxyDKxZZVQpn8BgajrGJhIJJfar2V5zDZaE3nWLjaABzAS+RI86VzZbKPav+BNegTCx6VTA3kfH+f1KhyTUMOk0tMx4LD/erHP16w0Ji84vG9MqItkU/i8GloN63WHyQn6MtpSrMoJ8ot0QsdIu1fUXbo/1lhGatlV8BnCH5sHqREyQWFwYbkfFPfGaYl2JpWV+t3Px6BNBu3wn/beNhXO9GKIq3PY73Bzr7MwN2wP71HRl56A/ORrb8iOUJYrNgrE0TSXaenAgMBAAECggEAU0Iq7zXwELIDRYyXPfYlNAR3W2qIcvveWO1+HMOFVMQDvfyTHH4V65TwjawErpFCCbc7wVTrSz8iqqDsmvG/h/UIQNqvMhCEb4a17CkSYIv12Q1dF27PJSXyW/WTB5YCox8zFA/OB88fgUX6FOSUiaxs2bRFtoDdrjrb3mmtqi+vXEuxVUcc64mjTc43IlpRsbARGAY2dunjAwJUho8ZcXQ7lxS83gTTXRFk8DHsESo78QnsnLL3ZHb+ce7/VDUciep0FIO83Fc+qtcUDWQnE2bO3a77YvyUiBfQ+8sLbac6cvCuF7+Dav5IASlUsersXv9E8/zF6bGgbBWBXXulYQKBgQDTclUJyYwAybCi31o/IZQo3ROlCBEu4F4R3HHzqWS2YISLtCl3jUpgaFS1rceDny39u7XhzOlp2PpdtJPOf9ZhOUR61G+0QoQLkNvvhlJO9sTbRhqDl8lswdGyA8WIA3/F5X452CwyvvNHYaSWQXId2Qxk0wzivn9AKxgbQiff0wKBgQC65DQTQJr+E2us4BgGdRt0Kuau8BLse+hW8fCh3FHeTOIoSjNpIZPEmcnIm1/0jusXSgy5gKkeFKyctfG1MHiRpMtYFCNYLWdO0k4TfVY51OaHtFRm20B42Lx5eg1BqOBnfekXmAqxpS886zacqClTotGz27Ch896qpMW7mppIXQKBgBA3OnJPtJ7y2MsE2gTxbE1d9v23CqpPpqc0AsEvAnxCFqgoHu3+NfAC0ExGkYB0mrBUzvQMJPJrI3hAOv2hLC20mJ3a4N4wI7RHXbaW1IUdw6cVTz88SsQ+cPh39ZQiwI/Ks8132JvjrQCSam7jgf7sAFlTHi/dcCDZrTWZ8zjlAoGAY4+okk0LhKkR5pGnGuGOE4+7PpyUaDkGKDNRTtkRIAzzOiV1R99kWgrXbTAgqSbt5IVFTBlXfrfi0MU4k57TzDrvPOfVgGcHrvzoLQfLRJm/ibGuePD6YqaLmWdE4qK1kUyJPVF4+PQXuytO95u6EF0fu+IgMda520xWLkAJSt0CgYBtRMacg5pOeMaTo6iS8e7siKvAe0m0FAzRBSU68eqIeiPQO34wRt4/tgnw1cVK8+gGZ81aqElTSk/ulAf0S5vUM912qOO3jkKTGmSIhAw0O9jYaDgYVEDC73GbojIDOZf1RToErDQjr/DjArCuZxfGboL/HPAh8h4+TnDbrLrsiw==", "json", "UTF-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiZXfzdXZA/7+JUbhFXupq6hZU6NGSNZZMWklQQbXmU1e0eIAXKO4lJoUGydvurwZ30JcdhdpkxOjIoU26lRw0D3Mgd4FAvr3sQqrCEjG3zFoxhrsrEbOXk2KD0j8zerksuXbOZhtHSnR6xPzoCMSKiXUaJjVESheL7022pxiQXDIZnXEUAHSxsFjUQJCI4KsHLE5HxhCx9AMwX0B5p7Vf8lp1jO4Z6FJkkE1Qe50d13WkN4vfHaxQf4SLvsC2DCHpGF9E16B+IzH/sWLVWGMDGnIez0k1uv5GHwGHVlK6aHuiqy5j9r0OzhXF9staLAK9Se3X36QrzL4EqbHtChUzwIDAQAB", "RSA2");  //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request

        //alipayRequest.setReturnUrl( "http://331t2j2729.zicp.vip/returlCallBack" );
        //支付宝的回调地址,支付结果异步通知
        alipayRequest.setNotifyUrl( "http://331t2j2729.zicp.vip/returlCallBack" ); //在公共参数中设置回跳和通知地址
        //alipayRequest.putOtherTextParam("app_auth_token", "201611BB8xxxxxxxxxxxxxxxxxxxedcecde6");//如果 ISV 代商家接入电脑网站支付能力，则需要传入 app_auth_token，使用第三方应用授权；自研开发模式请忽略
        alipayRequest.setBizContent( "{"  +
                "    \"out_trade_no\":\"12345678\","  +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\","  +
                "    \"total_amount\":8848.88,"  +
                "    \"subject\":\"李黑子\","  +
                "    \"body\":\"李黑子\","  +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","  +
                "    \"extend_params\":{"  +
                "    \"sys_service_provider_id\":\"2088511833207846\""  +
                "    }" +
                "  }" ); //填充业务参数
        String form= "" ;
        try  {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
        }  catch  (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    /*    httpResponse.setContentType( "text/html;charset="  + "utf-8");
        httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();*/
    }


    @RequestMapping("/returlCallBack")
    public String returlCallBack(HttpServletRequest request , HttpResponse httpResp) throws AlipayApiException {
        Map<String, String> paramsMap = convertRequestParamsToMap(request);
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAol4SrTwjB6RqSYQKWGiGopysy9KoHluqrsasGqDZWBm8Q4WlDYXpRpV7C53fqbChz/p/VwdGpb+bDSZU9pLEaSCzZTX6JqEeFo2fQav4mRVIY1FPgqOJ5Mn4AN/dB7j45Qy9wrIKh6+nP3dvDiN4wrHiobj4cl8Xb4vxbI3bvbj2SFYeL6u8iO49Hi4oXHvNaNzoKw8tl2hkI8N5sWU4LZAdT8odCSdpWwoMRvAapN+Doa4ceRgBmSc9D6l2qfz8Y0DIjd9wrs2fAc0XUUxb+JG1p5wGnzDagaNxFO8YkfeKlnaLtQ2ELQ2cy25db6sdNihIvXs6J3RzaU9kB4lHZwIDAQAB", "utf-8", "RSA2"); //调用SDK验证签名
        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            System.out.println(paramsMap);
            return "success";
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            return "fail";
        }
    }

    // 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }

        return retMap;
    }
}
