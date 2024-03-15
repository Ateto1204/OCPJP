# Advaned Class Design

### Abstract

- abstract class
    - 可以被繼承
    - 不可被 instance
- abstract method
    - 不能有內容
    - class 也必須加上 abstract
    - subclass 不是 abstract 就必須 override 這個 abstract method

### Static
- 直接以類別名稱呼叫，不需要產生五件，也不需要物件參考
- 用於解決不須物件的狀況，如常數、公式
- 使用於共享資料
- 不符合OO精神，除非有好理由，否則不該過度使用