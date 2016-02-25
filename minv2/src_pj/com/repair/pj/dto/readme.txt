配件简单对象包，相当于实体类，只不过，类中的成员属性是组合根据功能定义，不一定对应数据库表字段。

1、PjSDInfoRecordSearchDto.java       配件出入库记录多条件查询所需要使用的数据传输对象
2、PjStoreDynamicInfoSearchDto.java   查询动态配件时需要使用的dto，为方便使用分页组件，继承SearchDto类
3、PjStoreStaticInfoSearchDto.java    查询静态配件时需要使用的dto，为方便使用分页组件，继承SearchDto类