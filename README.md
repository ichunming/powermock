# powermock

## 概要说明
    单体测试工具，优点是能mock静态、final、私有方法等其他mock工具不具备的特点
    1.重要注解一 @RunWith(PowerMockRunner.class)
    2.重要注解二 @PrepareForTest({YourClass})
    3.包括实例有普通Mock，Mock方法内部new出来的对象，Mock普通对象的final方法，Mock普通类的静态方法，Mock 私有方法

## 版本库地址
* HTTPS协议: `https://github.com/ichunming/powermock.git`
* SSH协议: `git@github.com:ichunming/powermock.git`

## 克隆版本库
    操作示例：`$ git clone git@github.com:ichunming/powermock.git`
	
##### PS：Maven工程，需要先配好Maven环境
