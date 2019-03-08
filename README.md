该模块在与对mybatis的一个简单的应用；  
主要文件为sqlMapConfig.xml,*mapper.xml,还有一个bean类，最后用一个类通过引入sqlMapConfig.xml文件去实现数据库的基本操作；  
sqlMapConfig.xml用于连接数据库，引用用mapper.xml文件，所有的sql语句都写在mpper.xml文件中;  

整个实现过程大致为：  
读取配置文件    
使用sqlSessionFactoryBuilder创建sqlSessionfactory     
生产一个sqlSession  
操作数据库  
