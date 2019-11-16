//package com.iyihua.sample;
//
//
//import javax.jms.ConnectionFactory;
//import org.apache.activemq.ActiveMQXAConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import com.atomikos.jms.AtomikosConnectionFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.core.JmsTemplate;
//
//
//@Configuration
//@DependsOn("transactionManager")
//@EnableJms
//public class JMSConfig {
//	
//	@Value("${activemq.broker-url}")
//    private String brokerUrl;
//
//    
//    @Bean(name = "connectionFactory", initMethod = "init", destroyMethod = "close")
//	public ConnectionFactory connectionFactory() {
//    	ActiveMQXAConnectionFactory activeMQXAConnectionFactory =new ActiveMQXAConnectionFactory();
//    	activeMQXAConnectionFactory.setBrokerURL(brokerUrl);
//		// activeMQConnectionFactory.setPassword(orderDatasourceProperties.getPassword());
//		// activeMQConnectionFactory.setUser(orderDatasourceProperties.getUsername());
//    	// activeMQConnectionFactory.setPinGlobalTxToPhysicalConnection(true);
//		 AtomikosConnectionFactoryBean xaConnectionFactory = new AtomikosConnectionFactoryBean();
//		 xaConnectionFactory.setXaConnectionFactory(activeMQXAConnectionFactory);
//		 xaConnectionFactory.setUniqueResourceName("xads2jms");
//		 return xaConnectionFactory;
//	}
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(connectionFactory());
//    }
//
//}

package com.iyihua.sample;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import org.springframework.beans.factory.annotation.Value;
import com.atomikos.jms.AtomikosConnectionFactoryBean;
import com.ibm.mq.jms.MQXAConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@DependsOn("transactionManager")
@EnableJms
public class JMSConfig {

	@Value("${ibm.queueManagerName}")
	private String queueManagerName;
	@Value("${ibm.channelName}")
	private String channelName;
	@Value("${ibm.hosts}")
	private String hosts;
	@Value("${ibm.userid}")
	private String userid;
	@Value("${ibm.password}")
	private String password;

	@Bean(name = "connectionFactory", initMethod = "init", destroyMethod = "close")
	public ConnectionFactory connectionFactory() throws JMSException {
		MQXAConnectionFactory ibmMQXAConnectionFactory = new MQXAConnectionFactory();
		ibmMQXAConnectionFactory.setQueueManager(queueManagerName);
		ibmMQXAConnectionFactory.setChannel(channelName);
		ibmMQXAConnectionFactory.setConnectionNameList(hosts);
		ibmMQXAConnectionFactory.setTransportType(1);
		ibmMQXAConnectionFactory.createXAConnection(userid, password);
		AtomikosConnectionFactoryBean xaConnectionFactory = new AtomikosConnectionFactoryBean();
		xaConnectionFactory.setXaConnectionFactory(ibmMQXAConnectionFactory);
		xaConnectionFactory.setUniqueResourceName("xads2jms");
		return xaConnectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate() throws JMSException {
		return new JmsTemplate(connectionFactory());
	}

}
