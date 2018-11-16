package com.itheima.jmeter;

import com.itheima.http.HttpRequest;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jmeter自定义java请求（
 */
public class JmeterJavaRequest implements JavaSamplerClient {

    private static final Logger logger = LoggerFactory.getLogger(JmeterJavaRequest.class);

    /*
     * 请求前置方法
     * */
    @Override
    public void setupTest(JavaSamplerContext context) {
    }

    /*
     请求执行方法
     */
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        result.sampleStart();
        HttpRequest.post("http://localhost:8080/getMobile").form("mobile", "185").send();
        JMeterVariables jMeterVariables = context.getJMeterVariables();
//        jMeterVariables.put("name", "zhangsan");
        logger.info("执行成功");
        result.sampleEnd();
        result.isSuccessful();
        return result;
    }

    /*
     * 请求后置方法
     * */
    @Override
    public void teardownTest(JavaSamplerContext context) {

    }

    /*
     * 获得默认参数
     * */
    @Override
    public Arguments getDefaultParameters() {
        return null;
    }

    public static void main(String[] args) {
        JavaSamplerContext context = new JavaSamplerContext(new Arguments());
        JmeterJavaRequest request = new JmeterJavaRequest();
        //前置
        request.setupTest(context);
        //运行
        SampleResult sampleResult = request.runTest(context);
        //String responseData = sampleResult.getResponseData().toString();
        //后置
        request.teardownTest(context);
        //System.out.println(responseData);
    }
}
