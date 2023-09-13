package com.ibm.mockito.tests;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.captor.DeliveryPlatform;
import com.ibm.captor.Email;
import com.ibm.captor.EmailService;
import com.ibm.captor.Format;
import com.ibm.captor.ServiceStatus;

@ExtendWith(MockitoExtension.class)
class EmailServiceCaptorTest08 {

	@Mock
	DeliveryPlatform platform; 
	
	@InjectMocks
	EmailService emailService; 
	
	@Captor
	ArgumentCaptor<Email> emailCaptor; 
	
	@Test
	void testEmailServiceForTextBasedMessage_ValidCase() {
		String to ="naveen@naveenks.com"; 
		String subject = "testing for testing mockito captor"; 
		String body = "Testing for argument captor"; 
		
		emailService.send(to, subject, body, false);
		
		verify(platform).deliver(emailCaptor.capture());
		Email emailCaptorValue = emailCaptor.getValue();
		
		assertEquals(emailCaptorValue.getFormat(), Format.TEXT_ONLY);
		
	}
	
	@Test
	void whenServiceStatusIsUp_validCase() {
		when(platform.getServiceStatus()).thenReturn("OK"); 
		ServiceStatus serviceStatus =emailService.checkServiceStatus() ; 
		
		assertEquals(serviceStatus, ServiceStatus.UP);
		
	}

	@Test
	void whenServiceStatusIsDown_validCase() {
		when(platform.getServiceStatus()).thenReturn("DOWN"); 
		ServiceStatus serviceStatus =emailService.checkServiceStatus() ; 
		
		assertEquals(serviceStatus, ServiceStatus.DOWN);
	}

}











