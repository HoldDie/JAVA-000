# 学习笔记

## 不同 GC 记录

### 使用串行 GC

```shell script
java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis 
```

执行结果：
<img src="https://cdn.jsdelivr.net/gh/HoldDie/img/20201028224859.png" style="zoom:50%;" />

### 使用并行 GC

```shell script
java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

<img src="https://cdn.jsdelivr.net/gh/HoldDie/img/20201028224753.png" style="zoom:50%;" />

### 使用 CMS GC

```shell script
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

<img src="https://cdn.jsdelivr.net/gh/HoldDie/img/20201028224701.png" style="zoom:50%;" />


### 使用 G1 GC

```shell script
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

<img src="https://cdn.jsdelivr.net/gh/HoldDie/img/20201028225126.png" style="zoom:50%;" />

### GC总结：

- 串行 GC
  - 年轻代使用拷贝-复制，老年代使用标记-清除-整理
  - 发生GC时，会暂停
  - 内存越小，GC次数越多
- 并行 GC
  - 年轻代使用拷贝-复制，老年代使用标记-清除-整理
  - GC处理时，暂停业务处理，所有线程处理GC垃圾回收。平常运行时，所以线程都去处理业务。因此，吞吐量比较高。
  - 内存越小，GC次数越多
- CMS GC
  - 年轻代使用拷贝-复制，老年代使用标记-清除
  - CMS默认GC线程数是1/4，并且老年代只清除，无整理。所以当GC发生时，吞吐量不如并行 GC
    - CMS GC 6个阶段
    - 初始化标记 - 暂停GC
    - 并行标记
    - 并行预清理
    - 最终标记 - 暂停GC
    - 并行清理
    - 并行重置
  - 因为无整理，并且CMS GC 6阶段 暂停时间短，所以延迟比较低
  - 内存越小，GC次数越多
- G1 GC
  - 不分代,使用 region(2048) 存储数据，分为：
    - Eden区 （标记-复制 算法）
    - 存活区
    - 老年区 (标记-复制-整理 算法)
  - GC 3个阶段
    - (G1 Evacuation Pause) (young)
    - 类似 CMS GC 的 并发标记
      - initial-mark
      - concurrent-root-region-scan
      - concurrent-mark
      - remark
      - concurrent-cleanup
    - (G1 Evacuation Pause) (mix)
  - 使用 -XX:MaxGCPauseMills 参数可以控制 GC暂停时间
- ParNewGC + CMS 适用于 低延迟

- ParallelGC + ParllelGC Old 适用于 高吞吐量

- G1 适用于 内存大于4G，并且GC时间可控制


## 压测（wrk）


### 512m 跑一趟
```shell script
java -jar -Xms512m -Xmx512m gateway-server-0.0.1-SNAPSHOT.jar

wrk -t8 -c40 -d60s http://localhost:8088/api/hello

wrk -t8 -c40 -d60s --latency http://localhost:8088/api/hello
```

运行截图

![](https://cdn.jsdelivr.net/gh/HoldDie/img/20201028225547.png)

加参数 --latency ,运行截图

![](https://cdn.jsdelivr.net/gh/HoldDie/img/20201028225844.png)


### 2g 跑一趟

```shell script
java -jar -Xms2g -Xmx2g gateway-server-0.0.1-SNAPSHOT.jar

wrk -t8 -c40 -d60s http://localhost:8088/api/hello

wrk -t8 -c40 -d60s --latency http://localhost:8088/api/hello
```

运行截图

![](https://cdn.jsdelivr.net/gh/HoldDie/img/20201028225844.png)


