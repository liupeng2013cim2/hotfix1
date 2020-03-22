Microsoft Windows [版本 10.0.17763.1098]
(c) 2018 Microsoft Corporation。保留所有权利。

D:\github\MultiDex\app>cd ..

D:\github\MultiDex>cd fixed

D:\github\MultiDex\fixed>javac com/andy/multidex/bean/Bean.java

D:\github\MultiDex\fixed>E:\android-sdk\android-sdk-windows\build-tools\29.0.3\dx.bat --dex --output=./fixed.dex com/andy/multidex
/bean/Bean.class

D:\github\MultiDex\fixed>adb push fixed.dex /storage/emulated/0/fixed.dex
fixed.dex: 1 file pushed. 0.0 MB/s (1016 bytes in 0.043s)


