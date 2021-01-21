package juc.function;

import java.util.function.Function;

/**
 * @program: Juc
 * @description:
 * @author: Saxon
 * @create: 2021-01-21 15:59
 */
public class FunctionDemo {

    public static void main(String[] args) {


        Function function = new Function< String, Integer>(){
            @Override
            public Integer apply (String s){
                return Integer.parseInt(s);
            }
        };


        System.out.println(function.apply("123"));
    }
}
