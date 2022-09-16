
기존프로젝트의 url pattern이 아래와 같이 .do 로 끝나는 url만이 
dispatcher 이라는 이름의 dispatcher servlet으로 요청을 받게 설정이 되어 있었다.

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>

그래서 확장자를 사용안하기위해서는 url pattern을 /* 또는 / 으로 매핑하면된다. 
그런데 이렇게하면 .html .css .js .jpg 같은 정적인 파일들에 대하여 404 not found error가 뜨게된다.
    
	<servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
 

이유는 다음과 같다.

실제로 WEB-INF 외부에 있는 jsp 파일을 요청하더라도, 직접 접근하는게 아니라 
 tomcat was라는 미들웨어를 통해  브라우저가 알아볼 수 없는 jsp 파일을 html로 변형해서 
 서버로 내려준뒤 브라우저로 내려준다.
 (was는 동적 파일 처리(jsp 같은 파일) web server는 정적 파일 처리)

위와 같은 내용는 tomcat web.xml에 다음과 같은 설정을 통해 알 수 있다.

	<servlet-mapping>
		<servlet-name>jspServlet</servlet-name>
		<url-pattern>*.jsp</url-pattern>
	</servlet-mapping>
 

url pattern을 /* 또는 / 으로 매핑했을때의 문제에 대해 알아보자.

'/*' 은 요청받는 모든 URL을 처리한다는 의미이다. 
	모든 요청을 처리하게 되면 .jsp라는 view에 대한 요청도 dispatcher 이라는 
	이름의 Dispatcher Servlet이 처리하겠다는 것이다. 
	이렇게 되면 .jsp 파일은 tomcat web.xml 에서 정의된 jsp Servlet으로 처리되어지지 않고 
	.jsp 요청에 대한 view를 내려줄 수 없다. (dispatcher servlet설정에 의해 마스킹)

'/' 로 해준다면 default servlet 타게되는 요청들이 dispatcher servlet을 타게 되는데  
	*.jsp은 톰캣에 설정에 의해 dispatcher servlet에서 처리되지 않고 
	WAS내 jsp servlet으로 처리되므로 제대로 view를 리턴해줄 수 있으나. 
	여기서 문제는 톰캣 설정에서 default servlet 은 .html .css .js 같은 정적인 파일들을 처리 해주었으나
	 이제 처리해 줄 수 없으므로, 정적인 파일들에 대하여 404 not found error가 뜨게된다. 
	 (dispatcher servlet이 그것을 마스킹 하게 되어버린다.)

이제 여기서 필요한 설정이 mvc-config.xml 내에 아래와 같은 설정이다.

 1.<mvc:resources location="/resources/" mapping="/resources/**"/>
 혹은
 2.<mvc:default-servlet-handler />

위와  xml을 설정하게 된다면, 정적파일을 호출하게 되는 Request URL에 대하여 
default servlet으로 위임 하는 것이다.