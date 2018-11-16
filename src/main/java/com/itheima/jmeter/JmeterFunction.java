package com.itheima.jmeter;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import java.util.*;

/**
 * 自定义jmeter函数（输入一个数字a，随机[0-a) 内的值）
 *
 *  参考地址 https://www.jianshu.com/p/a88e5cb1d6cb
 */
//jmeter自定义函数一定要在functions的包名下！        切记！切记！切记！切记！
public class JmeterFunction extends AbstractFunction {
    //自定义function的描述
    private static final List<String> desc = new LinkedList<String>();

    static {
        desc.add("Get a random int within specified parameter value.");
    }

    //function名称
    private static final String KEY = "__MyRandomFunc";

    private static final int MAX_PARA_COUNT = 1;
    private static final int MIN_PARA_COUNT = 1;

    //传入参数的值
    private Object[] values;

    private Random r = new Random();
    /*
        告诉JMeter关于你实现的function的描述。
     */
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }

    /**
     * JMeter会将上次运行的SampleResult和当前的Sampler作为参数传入到该方法里，
     * 返回值就是在运行该function后得到的值，
     * 以String类型返回。
     * 该方法如果操作了非线程安全的对象（比如文件），
     * 则需要将对该方法进行线程同步保护。
     */
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        try {
            int max = new Integer(((CompoundVariable) values[0]).execute().trim());
            int val = r.nextInt(max);
            return String.valueOf(val);
        } catch (Exception ex) {
            throw new InvalidVariableException(ex);
        }
    }

    /*
    这个就是function的名字。JMeter的命名规则是在方法名前面加入双下划线"__"。
    比如"__GetEven"，function的名字跟实现该类的类名应该一致，
    而且该名字应该以static final的方式在实现类中定义好，避免在运行的时候更改它
     */
    @Override
    public String getReferenceKey() {
        return KEY;
    }

    /*
         这个方法在用于传递用户在执行过程当中传入的实际参数值。
        该方法在function没有参数情况下也会被调用。
        一般该方法传入的参数会被保存在类内全局变量里，
        并被后面调用的execute方法中使用到。
     */
    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        checkParameterCount(parameters, MIN_PARA_COUNT, MAX_PARA_COUNT); //检查参数的个数是否正确
        values = parameters.toArray(); //将值存入类变量中
    }
}
