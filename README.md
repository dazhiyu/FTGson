# FTGson
gson 带有解析容错版

## 使用方法
```
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
 	dependencies {
	        implementation 'com.github.dazhiyu:FTGson:v2.9.1'
	}
```
版本和gson保持一致，比较方便记录

## 参考了 IKGson 的容错
链接：https://github.com/YangLang116/IKGson

IKGson 的容错机制已经很全面了，但是缺少关于对象的容错，
尤其是在后台特别爱返回有数据时是对象，没有数据时是数组的情况，很可能是用map返回的吧

## 容错介绍
1. 在 JsonReader 中对基本类型进行数据容错，比如 nextString()、nextBoolean() 等
2. chat 的解析容错，放到了 TypeAdapters 中，因为他也是解析成string，但只取第一位，超出一位报错
3. 数组 的解析容错，在 ArrayTypeAdapter 中，判断数据类型是否为集合，不是跳过
4. 集合 的解析容错，在 CollectionTypeAdapterFactory 下的 Adapter 中，判断数据类型是否为集合，不是跳过
5. 对象 的解析容错，在 ReflectiveTypeAdapterFactory 下的 Adapter 中，判断数据类型是否为对象，不是跳过

注：后三个和IKGson的处理方式不一致，IKGson是使用 try catch 来处理的。
返回也不一致：这里返回null，IKGson返回空数组


