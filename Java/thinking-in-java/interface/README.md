#### 第9章 接口

**接口和内部类为我们提供了一种将接口与实现分离的更加结构化的方法**

- 抽象类和抽象方法

    包含抽象方法的类叫做抽象类
    
- 接口

    interface创建一个完全抽象的类，它不提供任何具体实现。
    
    接口的域隐式的为static和final，方法都是public的
    
    接口可以向上被转型为不同的基类型
    
    在组合的不同接口时，如果使用了相同的方法名，通常会造成代码可读性
    的混乱，应尽量避免这种情况。
    
- 嵌套接口

    接口可以嵌套在类或其他接口中