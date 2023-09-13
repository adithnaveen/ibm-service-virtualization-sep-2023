package com.ibm.captor;
public class EmailService {

    private DeliveryPlatform platform;

    public EmailService(DeliveryPlatform platform) {
        this.platform = platform;
    }

    public void send(String to, String subject, String body, boolean html) {
        Format format = Format.TEXT_ONLY;
        if (html) {
            format = Format.HTML;
        }
        Email email = new Email(to, subject, body);
        email.setFormat(format);
        platform.deliver(email);
    }

    public ServiceStatus checkServiceStatus() {
      return 
        platform.getServiceStatus().equals("OK") ? ServiceStatus.UP : ServiceStatus.DOWN; 
        
    }

    public boolean authenticatedSuccessfully(Credentials credentials) {
        return platform.authenticate(credentials).equals(AuthenticationStatus.AUTHENTICATED); 
       
    }
}