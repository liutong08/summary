# summary
summary

spring

	1、IOC 依赖注入：
	
		bean作用域:
			singleton		每次返回相同的实例
			prototype		每次返回不同的实例
			request			请求
			session			会话
			global session 		全局会话
		
		与Java中的单例多例不相同，作用于仅为ioc范围内

	2、容器配置：xml 注解 Java
	
		1.xml:spring依赖注入的形式
			以setter注入 
			以构造器注入（不建议使用，在实例化是造成资源浪费）
			优先状态：构造器先执行，setter覆盖构造器
			
		2.注解：
			@AutoWire	@inject
			@Component 	@Service	@Controller
			@Qualifier("") 	@Resource(name="")
			
		3.java配置：
			@configuration配置类	
			@bean	注入bean
			@ComponentScan(basePackages="xx.xx")	指定加载时扫描哪个文件
			@Primary	在bean相同的情况下使用primary的属性
			
		4.加载配置：
			ClassPathXmlApplicationContext("xx.xml")
			FileSystemXmlApplicationContext("classpath:xx.xml")
			
		5.自动加载：
			AnnotationConfigApplicationContext()
			//扫描指定路径下的文件和子包
			anno.scan("com.example");
			//刷新
			anno.refresh();
			//关闭IOC容器
			anno.registerShutdownHook();
			
			//加载指定配置类
			AnnotationConfigApplicationContext(SampleConfig.class);
			
			
			
			
spring boot 约定大于配置

	1、配置对实体类属性赋值
	
		1.实体类添加@Configuration	@ConfigurationProperties(prefix = "前缀名")
		2.配置类中根据前缀名.属性=xx进行赋值
		3.在@Controller和@RestController的类中，@AutoWired实体类，使用实体类对象的方法进行输出。
		4.配置类的常用配置：以properties为例
			端口号：server.port=8088 
			项目名：server.context-path=/sample
			实体类属性：student.name=aaa 
				注意：
					1.该实体类必须有注解@Configuration	@ConfigurationProperties(prefix = "student")
					2.该实体类必须有属性的setting和getting方法
		5.配置类以application-环境.properties/yml命名，在指定的环境运行使用spring.profiles.active=环境名，有冲突则取优先级高的，没有则互补
		6.非application-环境.properties/yml的配置，可以在实体类中@PropertySource(value="classpath:xxx.properties")指定使用该配置中对实体类属性的赋值
		
	2、命令行参数运行
	
		1.普通运行
			run as -->mavenBuild-->goals:package-->run-->target文件加下成功生成项目jar包-->在jar包文件路径下运行cmd-->"java -jar 项目名.jar
		2.使用maven插件运行
			java -jar sample-0.0.1-SNAPSHOT.jar mvn plugin:run
		3.指定jar包config目录下默认名
		指定jar包同级目录下默认名配置application.properties
			java -jar sample-0.0.1-SNAPSHOT.jar
		4.指定jar包同级目录下非默认名配置test.properties
			java -jar sample-0.0.1-SNAPSHOT.jar --spring.config.location=test.properties

	3、@Controller和@RestController的区别？
	
		@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
		1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
		2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
			如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
				
	4、热部署
	
		<!-- 热部署，无需手动重启 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
				
	5、安装lombok
	
		常用注解
			@Data：注解在类上；提供类所有属性的getting和setting方法，此外还提供了equals、canEqual、hashCode、toString方法
			@Setter：注解在属性上；为属性提供setting方法
			@Getter：注解在属性上；为属性提供getting方法
			@Log4j：注解在类上；为类提供一个属性名为log的log4j日志对象
			@NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
			@AllArgsConstructor：注解在类上；为类提供一个全参的构造方法
		注入依赖
			<dependency>
				<groupId>org.projectlombok</groupId>
				<artifactId>lombok</artifactId>
				<version>1.16.20</version>
			</dependency>	
			
	6、CommandLineRunner接口 
	
		实现后@Order(num)指定加载顺序
		
	7、banner.txt文件可以对运行时的标志进行修改
	
	8、profile指定实现类的环境
	
		spring.profiles=xxx
		@profile({"xxx"})
	
	9、日志log4j slf4j logback
	
		日志级别：trace debug info warn error fatal 默认info
		
		private static Logger logger = LoggerFactory.getLogger(xx.class);
		logger.info("xxx");对xx类中的日志进行打印xxx信息
		
	10、监听器actuator
	
		management.port=8088 设定监听端口号
		management.context-path=/aaa	设定监听名
		info、beans、loggers、mappings、health等
		
		健康检查HealthIndicator 状态：down、up等
	
	11、server 
	
		1.在服务器端pom.xml文件引入依赖spring-boot-admin-server，spring-boot-admin-server-ui
		2.为项目运行类添加注解	@EnableAutoConfiguration//将符合条件的配置进行自动配置
								@EnableAdminServer//开启监控
		3.为服务器设定端口号
		4.在客户端pom.xml文件引入依赖spring-boot-admin-starter-client
		5.在配置文件中添加访问服务器端的url	spring.boot.admin.url=http://localhost:xxxx
			关闭安全管理					management.security.enabled=false
		
